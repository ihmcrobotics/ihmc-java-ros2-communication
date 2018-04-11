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

import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.util.PeriodicThreadScheduler;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A Realtime-safe implementation of NonRealtimeRos2Node.
 *
 * Lock-free publishing and subscribing is provided using lock-free buffers.
 *
 * @author Jesper Smith
 */
public class RealtimeRos2Node
{
   public static int THREAD_PERIOD_MICROSECONDS = 1000;

   private final Ros2NodeBasics node;

   private final ArrayList<RealtimeRos2Publisher<?>> publishers = new ArrayList<>();

   private final RealtimeNodeThread realtimeNodeThread = new RealtimeNodeThread();
   private final ReentrantLock startupLock = new ReentrantLock();
   private final PeriodicThreadScheduler scheduler;
   private boolean spinning = false;

   /**
    * Create a new realtime node with the default ROS2 domain ID
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation PubSubImplementation}
    * @param threadFactory Thread factory for the publisher. Either PeriodicRealtimeThreadSchedulerFactory or PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name Name of this NonRealtimeRos2Node
    * @param namespace Namespace of this NonRealtimeRos2Node
    * @throws IOException if the participant cannot be made
    */
   public RealtimeRos2Node(PubSubImplementation pubSubImplementation, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace)
         throws IOException
   {
      this(pubSubImplementation, threadFactory, name, namespace, Ros2NodeBasics.ROS_DEFAULT_DOMAIN_ID);
   }

   /**
    * Create a new realtime node
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation PubSubImplementation}
    * @param threadFactory Thread factory for the publisher. Either PeriodicRealtimeThreadSchedulerFactory or PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name Name of this NonRealtimeRos2Node
    * @param namespace Namespace of this NonRealtimeRos2Node
    * @param domainId Desired ROS domain ID
    * @throws IOException if the participant cannot be made
    */
   public RealtimeRos2Node(PubSubImplementation pubSubImplementation, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace, int domainId)
         throws IOException
   {
      this.node = new Ros2NodeBasics(pubSubImplementation, name, namespace, domainId);
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
   public <T> RealtimeRos2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createPublisher(topicDataType, topicName, Ros2QosProfile.DEFAULT(), 10);
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
   public <T> RealtimeRos2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, Ros2QosProfile qosProfile, int queueSize)
         throws IOException
   {
      startupLock.lock();
      try
      {
         if (spinning)
         {
            throw new RuntimeException("Cannot add publishers to a RealtimeRos2Node that is already spinning");
         }
         Ros2Publisher<T> rosPublisher = node.createPublisher(topicDataType, topicName, qosProfile);
         RealtimeRos2Publisher<T> realtimePublisher = new RealtimeRos2Publisher<>(topicDataType, rosPublisher, queueSize);
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
   public <T> RealtimeRos2Subscription<T> createSubscription(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createSubscription(topicDataType, topicName, Ros2QosProfile.DEFAULT(), 10);
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
   public <T> RealtimeRos2Subscription<T> createSubscription(TopicDataType<T> topicDataType, String topicName, Ros2QosProfile qosProfile, int queueSize)
         throws IOException
   {
      RealtimeRos2SubscriptionListener<T> listener = new RealtimeRos2SubscriptionListener<>(topicDataType, queueSize);
      node.createSubscription(topicDataType, listener, topicName, qosProfile);
      RealtimeRos2Subscription<T> subscription = new RealtimeRos2Subscription<>(listener);
      return subscription;
   }

   /**
    * Start publishing data for this RealtimeRos2Node
    *
    * A periodic thread is spawned that will publish all data every millisecond.
    */
   public void spin()
   {
      startupLock.lock();
      if (spinning)
      {
         throw new RuntimeException("This RealtimeRos2Node is already spinning");
      }
      spinning = true;
      scheduler.schedule(realtimeNodeThread, THREAD_PERIOD_MICROSECONDS, TimeUnit.MICROSECONDS);
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
