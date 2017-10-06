/*
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package us.ihmc.ros2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.util.PeriodicThreadScheduler;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

/**
 * A Realtime-safe implementation of RosNode. 
 * 
 * Lock-free publishing and subscribing is provided using lock-free buffers.
 * 
 * @author Jesper Smith
 *
 */
public class RealtimeNode
{
   private final RosNode node;

   private final ArrayList<RealtimePublisher<?>> publishers = new ArrayList<>();

   private final RealtimeNodeThread realtimeNodeThread = new RealtimeNodeThread();
   private final ReentrantLock startupLock = new ReentrantLock();
   private final PeriodicThreadScheduler scheduler;
   private boolean spinning = false;

   /**
    * Create a new realtime node with the default ROS2 domain ID
    * 
    * @param threadFactory Thread factory for the publisher. Either PeriodicRealtimeThreadSchedulerFactory or PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name Name of this RosNode
    * @param namespace Namespace of this RosNode
    * @throws IOException if the participant cannot be made
    */
   public RealtimeNode(PeriodicThreadSchedulerFactory threadFactory, String name, String namespace) throws IOException
   {
      this(threadFactory, name, namespace, RosNode.ROS_DEFAULT_DOMAIN_ID);
   }

   /**
    * Create a new realtime node
    * 
    * @param threadFactory Thread factory for the publisher. Either PeriodicRealtimeThreadSchedulerFactory or PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name Name of this RosNode
    * @param namespace Namespace of this RosNode
    * @param domainId Desired ROS domain ID
    * @throws IOException if the participant cannot be made
    */
   public RealtimeNode(PeriodicThreadSchedulerFactory threadFactory, String name, String namespace, int domainId) throws IOException
   {
      this.node = new RosNode(name, namespace, domainId);
      this.scheduler = threadFactory.createPeriodicThreadScheduler("RealtimeNode_" + namespace + "/" + name);
   }

   /**
    * Create a new realtime publisher with default qos profile and queue depth. 
    * 
    * This publisher will publish data in a separate thread and will never block the calling thread. No memory will be allocated when publishing.
    * 
    * This function will allocate a queue of depth 10
    * 
    * @param topicDataType Data type to publish
    * @param topicName Topic name
    * @return A realtime-safe ROS2 publisher
    * @throws IOException
    */
   public <T> RealtimePublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createPublisher(topicDataType, topicName, RosQosProfile.DEFAULT(), 10);
   }

   /**
    * Create a new realtime publisher. 
    * 
    * This publisher will publish data in a separate thread and will never block the calling thread. No memory will be allocated when publishing.
    * 
    * The queueSize should weight memory requirements of the message vs the change to lose outgoing messages because the queue is full.
    * 
    * @param topicDataType Data type to publish
    * @param topicName Topic name
    * @param qosProfile Desired ros profile
    * @param queueSize Depth of the publish queue (10 would be a good size for small messages). 
    * @return A realtime-safe ROS2 publisher
    * @throws IOException
    */
   public <T> RealtimePublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, RosQosProfile qosProfile, int queueSize) throws IOException
   {
      startupLock.lock();
      try
      {
         if (spinning)
         {
            throw new RuntimeException("Cannot add publishers to a RealtimeNode that is already spinning");
         }
         RosPublisher<T> rosPublisher = node.createPublisher(topicDataType, topicName, qosProfile);
         RealtimePublisher<T> realtimePublisher = new RealtimePublisher<>(topicDataType, rosPublisher, queueSize);
         publishers.add(realtimePublisher);
         return realtimePublisher;
      } finally
      {
         startupLock.unlock();
      }

   }

   /**
    * Create a new realtime subscription with default qos profile and queue depth.
    * 
    * Incoming messages are stored in a queue of depth queueSize and can be polled by the realtime therad.
    *  
    * This function will allocate a queue of depth 10
    *  
    * @param topicDataType Data type to subscribe to
    * @param topicName Topic name
    * @return A realtime-safe ROS2 subscriber
    * @throws IOException
    */
   public <T> RealtimeSubscription<T> createSubscription(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createSubscription(topicDataType, topicName, RosQosProfile.DEFAULT(), 10);
   }

   /**
    * Create a new realtime subscription.
    * 
    * Incoming messages are stored in a queue of depth queueSize and can be polled by the realtime therad.
    * 
    * The queueSize should weight memory requirements of the message vs the change to lose incoming messages because the queue is full.
    * 
    * @param topicDataType Data type to subscribe to
    * @param topicName Topic name
    * @param qosProfile Desired ros qos profile
    * @param queueSize Depth of the subscribtion queue (10 would be a good size for small messages)
    * @return A realtime-safe ROS2 subscriber
    * @throws IOException
    */
   public <T> RealtimeSubscription<T> createSubscription(TopicDataType<T> topicDataType, String topicName, RosQosProfile qosProfile, int queueSize)
         throws IOException
   {
      RealtimeSubscriptionListener<T> listener = new RealtimeSubscriptionListener<>(topicDataType, queueSize);
      node.createSubscription(topicDataType, listener, topicName, qosProfile);
      RealtimeSubscription<T> subscription = new RealtimeSubscription<>(listener);
      return subscription;
   }

   /**
    * Start publishing data for this RealtimeNode
    * 
    * A periodic thread is spawned that will publish all data every millisecond. 
    * 
    */
   public void spin()
   {
      startupLock.lock();
      if (spinning)
      {
         throw new RuntimeException("This RealtimeNode is already spinning");
      }
      spinning = true;
      scheduler.schedule(realtimeNodeThread, 1, TimeUnit.MILLISECONDS);
      startupLock.unlock();
   }

   private class RealtimeNodeThread implements Runnable
   {

      @Override
      public void run()
      {
         for (int i = 0; i < publishers.size(); i++)
         {
            publishers.get(i).spin();
         }
      }

   }
}
