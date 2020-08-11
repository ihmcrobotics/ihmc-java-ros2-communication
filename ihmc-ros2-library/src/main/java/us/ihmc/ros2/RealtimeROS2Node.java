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
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.util.PeriodicThreadScheduler;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

/**
 * A Realtime-safe implementation of Ros2Node. Lock-free publishing and subscribing is provided
 * using lock-free buffers.
 * 
 * @author Jesper Smith
 */
public class RealtimeROS2Node
{
   public static int THREAD_PERIOD_MICROSECONDS = 1000;
   public static final int DEFAULT_QUEUE_SIZE = 10;

   private final Ros2NodeBasics node;

   private final ArrayList<RealtimeROS2Publisher<?>> publishers = new ArrayList<>();

   private final ReentrantLock startupLock = new ReentrantLock();
   private final PeriodicThreadScheduler scheduler;
   private boolean spinning = false;

   /**
    * Create a new realtime node with the default ROS2 domain ID ROS2Distro is set to ROS_DISTRO
    * environment variable (or BOUNCY if unset)
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param threadFactory        Thread factory for the publisher. Either
    *                             PeriodicRealtimeThreadSchedulerFactory or
    *                             PeriodicNonRealtimeThreadSchedulerFactory depending on the
    *                             application
    * @param name                 Name of this Ros2Node
    * @param namespace            Namespace of this Ros2Node
    * @throws IOException if the participant cannot be made
    */
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace)
         throws IOException
   {
      this(pubSubImplementation, threadFactory, name, namespace, Ros2NodeBasics.ROS_DEFAULT_DOMAIN_ID);
   }

   /**
    * Create a new realtime node with the default ROS2 domain ID
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param ros2Distro           Version of ROS2 to use.
    * @param threadFactory        Thread factory for the publisher. Either
    *                             PeriodicRealtimeThreadSchedulerFactory or
    *                             PeriodicNonRealtimeThreadSchedulerFactory depending on the
    *                             application
    * @param name                 Name of this Ros2Node
    * @param namespace            Namespace of this Ros2Node
    * @throws IOException if the participant cannot be made
    */
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro, PeriodicThreadSchedulerFactory threadFactory, String name,
                           String namespace)
         throws IOException
   {
      this(pubSubImplementation, ros2Distro, threadFactory, name, namespace, Ros2NodeBasics.ROS_DEFAULT_DOMAIN_ID);
   }

   /**
    * Create a new realtime node ROS2Distro is set to ROS_DISTRO environment variable (or BOUNCY if
    * unset)
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param threadFactory        Thread factory for the publisher. Either
    *                             PeriodicRealtimeThreadSchedulerFactory or
    *                             PeriodicNonRealtimeThreadSchedulerFactory depending on the
    *                             application
    * @param name                 Name of this Ros2Node
    * @param namespace            Namespace of this Ros2Node
    * @param domainId             Desired ROS domain ID
    * @throws IOException if the participant cannot be made
    */
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace, int domainId)
         throws IOException
   {
      this(pubSubImplementation, ROS2Distro.fromEnvironment(), threadFactory, name, namespace, domainId);
   }

   /**
    * Create a new realtime node
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param ros2Distro           Version of ROS2 to use.
    * @param threadFactory        Thread factory for the publisher. Either
    *                             PeriodicRealtimeThreadSchedulerFactory or
    *                             PeriodicNonRealtimeThreadSchedulerFactory depending on the
    *                             application
    * @param name                 Name of this Ros2Node
    * @param namespace            Namespace of this Ros2Node
    * @param domainId             Desired ROS domain ID
    * @throws IOException if the participant cannot be made
    */
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro, PeriodicThreadSchedulerFactory threadFactory, String name,
                           String namespace, int domainId)
         throws IOException
   {
      this(pubSubImplementation, ros2Distro, threadFactory, name, namespace, domainId, null);
   }

   /**
    * Create a new realtime node
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param ros2Distro           Version of ROS2 to use.
    * @param threadFactory        Thread factory for the publisher. Either
    *                             PeriodicRealtimeThreadSchedulerFactory or
    *                             PeriodicNonRealtimeThreadSchedulerFactory depending on the
    *                             application
    * @param name                 Name of this Ros2Node
    * @param namespace            Namespace of this Ros2Node
    * @param domainId             Desired ROS domain ID
    * @param addressRestriction   Restrict network traffic to the given address. When provided, it
    *                             should describe one of the addresses of the computer hosting this
    *                             node. Optional, ignored when {@code null}.
    * @throws IOException if the participant cannot be made
    */
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro, PeriodicThreadSchedulerFactory threadFactory, String name,
                           String namespace, int domainId, InetAddress addressRestriction)
         throws IOException
   {
      this.node = new Ros2NodeBasics(pubSubImplementation, ros2Distro, name, namespace, domainId, addressRestriction);
      this.scheduler = threadFactory.createPeriodicThreadScheduler("RealtimeNode_" + namespace + "/" + name);
   }

   /**
    * Create a new realtime node using an existing ROS2 node
    * 
    * @param ros2Node      existing Ros2Node to use for this realtime node
    * @param threadFactory Thread factory for the publisher. Either
    *                      PeriodicRealtimeThreadSchedulerFactory or
    *                      PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    */
   public RealtimeROS2Node(Ros2Node ros2Node, PeriodicThreadSchedulerFactory threadFactory)
   {
      this.node = ros2Node;
      this.scheduler = threadFactory.createPeriodicThreadScheduler("RealtimeNode_" + this.node.getName() + "/" + this.node.getNamespace());
   }

   /**
    * Create a new realtime publisher with default qos profile and queue depth. This publisher will
    * publish data in a separate thread and will never block the calling thread. No memory will be
    * allocated when publishing. This function will allocate a queue of depth 10
    * 
    * @param topicDataType Data type to publish
    * @param topicName     Topic name
    * @return A realtime-safe ROS2 publisher
    * @throws IOException
    */
   public <T> RealtimeROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createPublisher(topicDataType, topicName, Ros2QosProfile.DEFAULT(), DEFAULT_QUEUE_SIZE);
   }

   /**
    * Create a new realtime publisher. This publisher will publish data in a separate thread and will
    * never block the calling thread. No memory will be allocated when publishing. The queueSize should
    * weight memory requirements of the message vs the change to lose outgoing messages because the
    * queue is full.
    * 
    * @param topicDataType Data type to publish
    * @param topicName     Topic name
    * @param qosProfile    Desired ros profile
    * @param queueSize     Depth of the publish queue (10 would be a good size for small messages).
    * @return A realtime-safe ROS2 publisher
    * @throws IOException
    */
   public <T> RealtimeROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, Ros2QosProfile qosProfile, int queueSize)
         throws IOException
   {
      startupLock.lock();
      try
      {
         if (spinning)
         {
            throw new RuntimeException("Cannot add publishers to a RealtimeROS2Node that is already spinning");
         }
         Ros2Publisher<T> rosPublisher = node.createPublisher(topicDataType, topicName, qosProfile);
         RealtimeROS2Publisher<T> realtimePublisher = new RealtimeROS2Publisher<>(topicDataType, rosPublisher, queueSize);
         publishers.add(realtimePublisher);
         return realtimePublisher;
      }
      finally
      {
         startupLock.unlock();
      }
   }

   /**
    * Create a new realtime subscription with default qos profile and queue depth. Incoming messages
    * are stored in a queue of depth queueSize and can be polled by the realtime therad. This function
    * will allocate a queue of depth 10
    * 
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @return A realtime-safe ROS2 subscriber
    * @throws IOException
    */
   public <T> RealtimeROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createQueuedSubscription(topicDataType, topicName, Ros2QosProfile.DEFAULT(), DEFAULT_QUEUE_SIZE);
   }

   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime therad. The queueSize should weight memory requirements of the
    * message vs the change to lose incoming messages because the queue is full.
    * 
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @param qosProfile    Desired ros qos profile
    * @param queueSize     Depth of the subscribtion queue (10 would be a good size for small messages)
    * @return A realtime-safe ROS2 subscriber
    * @throws IOException
    */
   public <T> RealtimeROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName, Ros2QosProfile qosProfile, int queueSize)
         throws IOException
   {
      RealtimeROS2SubscriptionListener<T> listener = new RealtimeROS2SubscriptionListener<>(topicDataType, queueSize);
      node.createSubscription(topicDataType, listener, topicName, qosProfile);
      RealtimeROS2Subscription<T> subscription = new RealtimeROS2Subscription<>(listener);
      return subscription;
   }

   /**
    * Create a new realtime subscription with default qos profile and your own callback. Incoming
    * messages on the RTPS thread are passed to new message listener.
    *
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @return A realtime-safe ROS2 subscriber
    * @throws IOException
    */
   public <T> void createCallbackSubscription(TopicDataType<T> topicDataType, String topicName, NewMessageListener<T> newMessageListener) throws IOException
   {
      createCallbackSubscription(topicDataType, topicName, newMessageListener, Ros2QosProfile.DEFAULT());
   }

   /**
    * Create a new realtime subscription with default qos profile and your own callback. Incoming
    * messages on the RTPS thread are passed to new message listener.
    *
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @param qosProfile    Desired ros qos profile
    * @return A realtime-safe ROS2 subscriber
    * @throws IOException
    */
   public <T> void createCallbackSubscription(TopicDataType<T> topicDataType, String topicName, NewMessageListener<T> newMessageListener,
                                              Ros2QosProfile qosProfile)
         throws IOException
   {
      node.createSubscription(topicDataType, newMessageListener, topicName, qosProfile);
   }

   /**
    * Start publishing data for this RealtimeROS2Node A periodic thread is spawned that will publish
    * all data every millisecond.
    */
   public void spin()
   {
      startupLock.lock();
      if (spinning)
      {
         startupLock.unlock();
         throw new RuntimeException("This RealtimeROS2Node is already spinning");
      }
      spinning = true;
      scheduler.schedule(this::realtimeNodeThread, THREAD_PERIOD_MICROSECONDS, TimeUnit.MICROSECONDS);
      startupLock.unlock();
   }

   private void realtimeNodeThread()
   {
      for (int i = 0; i < publishers.size(); i++)
      {
         publishers.get(i).spin();
      }
   }

   /**
    * Stop the realtime periodic thread.
    */
   public void stopSpinning()
   {
      scheduler.shutdown();
      startupLock.lock();
      spinning = false;
   }

   /**
    * Stop the realtime periodic if spinning and then destroys the internal ROS node.
    * 
    * @see Ros2NodeBasics#destroy()
    */
   public void destroy()
   {
      if (spinning)
         stopSpinning();
      node.destroy();
   }

   /**
    * @return the name of this node
    */
   public String getName()
   {
      return node.getName();
   }

   /**
    * @return the namespace of this node
    */
   public String getNamespace()
   {
      return node.getNamespace();
   }
}
