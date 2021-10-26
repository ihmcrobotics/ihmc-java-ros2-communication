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

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.util.PeriodicThreadScheduler;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

/**
 * A Realtime-safe implementation of ROS2Node. Lock-free publishing and subscribing is provided
 * using lock-free buffers.
 * 
 * @author Jesper Smith
 */
public class RealtimeROS2Node implements ROS2NodeInterface
{
   public static int THREAD_PERIOD_MICROSECONDS = 1000;

   private final ROS2NodeBasics node;

   private final ArrayList<QueuedROS2Publisher<?>> publishers = new ArrayList<>();

   private final ReentrantLock startupLock = new ReentrantLock();
   private final PeriodicThreadScheduler scheduler;
   private boolean spinning = false;

   /**
    * Create a new realtime node
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param threadFactory        Thread factory for the publisher. Either
    *                             PeriodicRealtimeThreadSchedulerFactory or
    *                             PeriodicNonRealtimeThreadSchedulerFactory depending on the
    *                             application
    * @param name                 Name of this ROS2Node
    * @param namespace            Namespace of this ROS2Node
    * @throws IOException if the participant cannot be made
    */
   @Deprecated
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace)
         throws IOException
   {
      this(pubSubImplementation, threadFactory, name, namespace, ROS2NodeInterface.domainFromEnvironment());
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
    * @param name                 Name of this ROS2Node
    * @param namespace            Namespace of this ROS2Node
    * @throws IOException if the participant cannot be made
    */
   @Deprecated
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro, PeriodicThreadSchedulerFactory threadFactory, String name,
                           String namespace)
         throws IOException
   {
      this(pubSubImplementation, (ROS2Distro) null, threadFactory, name, namespace, ROS2NodeInterface.domainFromEnvironment());
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
    * @param name                 Name of this ROS2Node
    * @param namespace            Namespace of this ROS2Node
    * @param domainId             Desired ROS domain ID
    * @throws IOException if the participant cannot be made
    */
   @Deprecated
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace, int domainId)
         throws IOException
   {
      this(pubSubImplementation, (ROS2Distro) null, threadFactory, name, namespace, domainId);
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
    * @param name                 Name of this ROS2Node
    * @param namespace            Namespace of this ROS2Node
    * @param domainId             Desired ROS domain ID
    * @throws IOException if the participant cannot be made
    */
   @Deprecated
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro, PeriodicThreadSchedulerFactory threadFactory, String name,
                           String namespace, int domainId)
         throws IOException
   {
      this(pubSubImplementation, (ROS2Distro) null, threadFactory, name, namespace, domainId, null);
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
    * @param name                 Name of this ROS2Node
    * @param namespace            Namespace of this ROS2Node
    * @param domainId             Desired ROS domain ID
    * @param addressRestriction   Restrict network traffic to the given address. When provided, it
    *                             should describe one of the addresses of the computer hosting this
    *                             node. Optional, ignored when {@code null}.
    * @throws IOException if the participant cannot be made
    */
   @Deprecated
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro, PeriodicThreadSchedulerFactory threadFactory, String name,
                           String namespace, int domainId, InetAddress addressRestriction)
         throws IOException
   {
      this(DomainFactory.getDomain(pubSubImplementation), threadFactory, name, namespace, domainId, addressRestriction);
   }

   /**
    * Create a new realtime node
    *
    * @param Domain             DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param threadFactory      Thread factory for the publisher. Either
    *                           PeriodicRealtimeThreadSchedulerFactory or
    *                           PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name               Name of this ROS2Node
    * @param namespace          Namespace of this ROS2Node
    * @param domainId           Desired ROS domain ID
    * @param addressRestriction Restrict network traffic to the given addresses. When provided, it
    *                           should describe one of the addresses of the computer hosting this node.
    *                           Optional.
    * @throws IOException if the participant cannot be made
    */
   public RealtimeROS2Node(Domain domain, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace) throws IOException
   {
      this(domain, threadFactory, name, namespace, ROS2NodeInterface.domainFromEnvironment());
   }

   /**
    * Create a new realtime node
    *
    * @param Domain             DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param threadFactory      Thread factory for the publisher. Either
    *                           PeriodicRealtimeThreadSchedulerFactory or
    *                           PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name               Name of this ROS2Node
    * @param namespace          Namespace of this ROS2Node
    * @param domainId           Desired ROS domain ID
    * @param addressRestriction Restrict network traffic to the given addresses. When provided, it
    *                           should describe one of the addresses of the computer hosting this node.
    *                           Optional.
    * @throws IOException if the participant cannot be made
    */

   public RealtimeROS2Node(Domain domain, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace, int domainId,
                           InetAddress... addressRestriction)
         throws IOException
   {
      this(domain, threadFactory, name, namespace, ROS2NodeBasics.createParticipantAttributes(domain, domainId, addressRestriction));
   }

   /**
    * Create a new realtime node
    *
    * @param Domain        DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param threadFactory Thread factory for the publisher. Either
    *                      PeriodicRealtimeThreadSchedulerFactory or
    *                      PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name          Name of this ROS2Node
    * @param namespace     Namespace of this ROS2Node
    * @param attributes    ParticipantAttributes for this domain
    * @throws IOException if the participant cannot be made
    */

   public RealtimeROS2Node(Domain domain, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace, ParticipantAttributes attributes)
         throws IOException
   {

      this.node = new ROS2NodeBasics(domain, name, namespace, attributes);
      this.scheduler = threadFactory.createPeriodicThreadScheduler("RealtimeNode_" + namespace + "/" + name);
   }

   /**
    * Create a new realtime node using an existing ROS2 node
    * 
    * @param ros2Node      existing ROS2Node to use for this realtime node
    * @param threadFactory Thread factory for the publisher. Either
    *                      PeriodicRealtimeThreadSchedulerFactory or
    *                      PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    */
   public RealtimeROS2Node(ROS2Node ros2Node, PeriodicThreadSchedulerFactory threadFactory)
   {
      this.node = ros2Node;
      this.scheduler = threadFactory.createPeriodicThreadScheduler("RealtimeNode_" + this.node.getName() + "/" + this.node.getNamespace());
   }

   /**
    * Create a new realtime publisher with default queue depth. This publisher will publish data in a
    * separate thread and will never block the calling thread. No memory will be allocated when
    * publishing. This function will allocate a queue of depth 10
    *
    * @param topicDataType Data type to publish
    * @param topicName     Topic name
    * @param qosProfile    Desired ros profile
    * @return A realtime-safe ROS2 publisher
    * @throws IOException
    */
   @Override
   public <T> QueuedROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, PublisherAttributes publisherAttributes) throws IOException
   {
      return createPublisher(topicDataType, publisherAttributes, DEFAULT_QUEUE_SIZE);
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
   public <T> QueuedROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile, int queueSize) throws IOException
   {
      return createPublisher(topicDataType, createPublisherAttributes(topicDataType, topicName, qosProfile), queueSize);
   }

   /**
    * Create a new realtime publisher. This publisher will publish data in a separate thread and will
    * never block the calling thread. No memory will be allocated when publishing. The queueSize should
    * weight memory requirements of the message vs the change to lose outgoing messages because the
    * queue is full.
    * 
    * @param topicDataType       Data type to publish
    * @param publisherAttributes Publisher attriutes for this topic, created with
    *                            createPublisherAttributes()
    * @return A realtime-safe ROS2 publisher
    * @throws IOException
    */
   public <T> QueuedROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, PublisherAttributes publisherAttributes, int queueSize) throws IOException
   {
      startupLock.lock();
      try
      {
         if (spinning)
         {
            throw new RuntimeException("Cannot add publishers to a RealtimeROS2Node that is already spinning");
         }
         ROS2Publisher<T> rosPublisher = node.createPublisher(topicDataType, publisherAttributes);
         QueuedROS2Publisher<T> realtimePublisher = new QueuedROS2Publisher<>(topicDataType, rosPublisher, queueSize);
         publishers.add(realtimePublisher);
         return realtimePublisher;
      }
      finally
      {
         startupLock.unlock();
      }
   }

   /** {@inheritDoc} */
   @Override
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, SubscriberAttributes subscriberAttributes, int queueSize)
         throws IOException
   {
      return node.createQueuedSubscription(topicDataType, subscriberAttributes, queueSize);
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
      startupLock.unlock();
   }

   /**
    * Stop the realtime periodic if spinning and then destroys the internal ROS node.
    * 
    * @see ROS2NodeBasics#destroy()
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

   @Override
   public <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> subscriberListener,
                                                     SubscriberAttributes subscriberAttributes)
         throws IOException
   {
      return node.createSubscription(topicDataType, subscriberListener, getName());
   }

   @Override
   public <T> SubscriberAttributes createSubscriberAttributes(String topicName, TopicDataType<T> topicDataType, ROS2QosProfile qosProfile)
   {
      return node.createSubscriberAttributes(topicName, topicDataType, qosProfile);
   }

   @Override
   public <T> PublisherAttributes createPublisherAttributes(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile)
   {
      return node.createPublisherAttributes(topicDataType, topicName, qosProfile);
   }

   /**
    * @see{createSubscription(topicDataType, newMessageListener, topicName)
    */
   @Deprecated
   public <T> void createCallbackSubscription(TopicDataType<T> topicDataType, String topicName, NewMessageListener<T> newMessageListener) throws IOException
   {
      createSubscription(topicDataType, newMessageListener, topicName);
   }

   
   /**
    * @see{createSubscription(topicDataType, newMessageListener, topicName, qosProfile)
    */
   @Deprecated
   public <T> void createCallbackSubscription(TopicDataType<T> topicDataType, String topicName, NewMessageListener<T> newMessageListener,
                                              ROS2QosProfile qosProfile)
         throws IOException
   {
      createSubscription(topicDataType, newMessageListener, topicName, qosProfile);
   }

}
