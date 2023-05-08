/*
 * Copyright 2023 Florida Institute for Human and Machine Cognition (IHMC)
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

import com.eprosima.xmlschemas.fastrtps_profiles.TopicKindType;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;

import java.io.IOException;

/**
 * Internal class to share implementation between intra and inter process ROS2 nodes.
 *
 * @author Jesper Smith
 * @author Duncan Calvert
 */
class ROS2NodeBasics implements ROS2NodeInterface
{
   private Domain domain;
   private Participant participant;

   private final String nodeName;
   private final String namespace;

   /**
    * Create a new ROS 2 node.
    *
    * @param domain     DDS domain to use
    * @param name       Name for the node
    * @param namespace  Namespace for the ros node i.e. DDS partition
    * @param attributes Participant attributes to configure the node
    * @throws IOException if no participant can be made
    */
   ROS2NodeBasics(Domain domain, String name, String namespace, ParticipantAttributes attributes) throws IOException
   {
      this.domain = domain;

      ROS2TopicNameTools.checkNodename(name);
      ROS2TopicNameTools.checkNamespace(namespace);

      this.nodeName = name;
      this.namespace = namespace;

      attributes.name(name);
      participant = domain.createParticipant(attributes);
   }

   /**
    * Create a new ROS 2 compatible publisher in this Node
    *
    * @param topicDataType       The topic data type of the message
    * @param publisherAttributes Publisher attributes created with @see{createPublisherAttributes}
    * @return a ROS 2 publisher
    * @throws IOException if no publisher can be made
    */
   @Override
   public <T> ROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, PublisherAttributes publisherAttributes) throws IOException
   {
      TopicDataType<?> registeredType = domain.getRegisteredType(participant, topicDataType.getName());
      if (registeredType == null)
      {
         domain.registerType(participant, topicDataType);
      }

      return new ROS2Publisher<>(domain, domain.createPublisher(participant, publisherAttributes));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public <T> PublisherAttributes createPublisherAttributes(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile)
   {

      PublisherAttributes publisherAttributes = PublisherAttributes.create()
                                                                   .topicKind(topicDataType.isGetKeyDefined() ? TopicKindType.WITH_KEY : TopicKindType.NO_KEY)
                                                                   .topicDataType(topicDataType)
                                                                   .reliabilityKind(qosProfile.getReliability())
                                                                   .heartBeatPeriod(new Time(0, (long) (0.1 * 1e9))) // Approximately 100ms
                                                                   .durabilityKind(qosProfile.getDurability().toKind())
                                                                   .historyDepth(qosProfile.getSize())
                                                                   .historyQosPolicyKind(qosProfile.getHistory());

      ROS2TopicNameTools.assignNameAndPartitionsToAttributes(publisherAttributes, namespace, nodeName, topicName, qosProfile.isAvoidRosNamespaceConventions());
      return publisherAttributes;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, SubscriberAttributes subscriberAttributes, int queueSize)
         throws IOException
   {
      RealtimeROS2SubscriptionListener<T> listener = new RealtimeROS2SubscriptionListener<>(topicDataType, queueSize);
      ROS2Subscription<T> subscriber = createSubscription(topicDataType, listener, subscriberAttributes);
      return new QueuedROS2Subscription<T>(subscriber, listener);
   }

   /**
    * Create subscriber attributes for a topic
    *
    * @param topicName     Topic Name
    * @param <T>           Data type of the topic
    * @param topicDataType Data type serializer of the topic
    * @param qosProfile    Initial ROS 2 qos profile
    * @return PublisherAttributes for createPublisher
    */
   @Override
   public <T> SubscriberAttributes createSubscriberAttributes(String topicName, TopicDataType<T> topicDataType, ROS2QosProfile qosProfile)
   {
      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
                                                                      .topicKind(topicDataType.isGetKeyDefined() ?
                                                                                       TopicKindType.WITH_KEY :
                                                                                       TopicKindType.NO_KEY)
                                                                      .topicDataType(topicDataType)
                                                                      .topicName(topicName)
                                                                      .reliabilityKind(qosProfile.getReliability())
                                                                      .durabilityKind(qosProfile.getDurability().toKind())
                                                                      .historyDepth(qosProfile.getSize())
                                                                      .historyQosPolicyKind(qosProfile.getHistory());

      ROS2TopicNameTools.assignNameAndPartitionsToAttributes(subscriberAttributes, namespace, nodeName, topicName, qosProfile.isAvoidRosNamespaceConventions());

      return subscriberAttributes;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType,
                                                     NewMessageListener<T> subscriberListener,
                                                     SubscriberAttributes subscriberAttributes) throws IOException
   {
      TopicDataType<?> registeredType = domain.getRegisteredType(participant, topicDataType.getName());
      if (registeredType == null)
      {
         domain.registerType(participant, topicDataType);
      }

      return new ROS2Subscription<T>(domain, domain.createSubscriber(participant, subscriberAttributes, subscriberListener));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getName()
   {
      return nodeName;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getNamespace()
   {
      return namespace;
   }

   /**
    * Destroys this node. This effectively removes this node's {@code Participant} from the domain and clears the internal
    * references to these two. After calling this method, this node becomes unusable, i.e. publisher or subscriber can no longer
    * be created.
    */
   public void destroy()
   {
      if (domain != null)
      {
         LogTools.info("Shutting down ROS2 node " + nodeName);

         try
         {
            domain.removeParticipant(participant);
         }
         catch (IllegalArgumentException e)
         {
            if (!e.getMessage().contains("This participant is not registered with this domain")) // just means a race condition that is okay
            {
               throw e;
            }
         }
         domain = null;
      }

      participant = null;
   }
}
