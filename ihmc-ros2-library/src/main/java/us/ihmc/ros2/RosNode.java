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

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublishModeKind;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.subscriber.SubscriberListener;
import us.ihmc.ros2.RosQosPolicy.RosDurability;

public class RosNode
{
   private static final int ROS_DEFAULT_DOMAIN_ID = 0;

   private final Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
   private final Participant participant;

   private final String nodeName;
   private final String namespace;

   public RosNode(String name, String namespace) throws IOException
   {
      this(name, namespace, ROS_DEFAULT_DOMAIN_ID);
   }

   public RosNode(String name, String namespace, int domainId) throws IOException
   {
      RosTopicNameMangler.checkNodename(name);
      RosTopicNameMangler.checkNamespace(namespace);

      this.nodeName = name;
      this.namespace = namespace;

      ParticipantAttributes attr = domain.createParticipantAttributes(domainId, name);
      participant = domain.createParticipant(attr);
   }

   public <T> RosPublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      RosQosPolicy rosQosPolicy = new RosQosPolicy();
      return createPublisher(topicDataType, topicName, rosQosPolicy);
   }

   public <T> RosPublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, ReliabilityKind kind) throws IOException
   {
      RosQosPolicy rosQosPolicy = new RosQosPolicy();
      rosQosPolicy.setReliability(kind);
      return createPublisher(topicDataType, topicName, rosQosPolicy);
   }

   public <T> RosPublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, int historyDepth) throws IOException
   {
      RosQosPolicy rosQosPolicy = new RosQosPolicy();
      rosQosPolicy.setDurability(RosDurability.TRANSIENT_LOCAL_DURABILITY_QOS);
      rosQosPolicy.setSize(historyDepth);
      return createPublisher(topicDataType, topicName, rosQosPolicy);
   }

   public <T> RosPublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, RosQosPolicy qosPolicy) throws IOException
   {
      TopicDataType<?> registeredType = domain.getRegisteredType(participant, topicDataType.getName());
      if (registeredType == null)
      {
         domain.registerType(participant, topicDataType);
      }

      PublisherAttributes publisherAttributes = domain.createPublisherAttributes();
      publisherAttributes.getTopic().setTopicKind(topicDataType.isGetKeyDefined() ? TopicKind.WITH_KEY : TopicKind.NO_KEY);
      publisherAttributes.getTopic().setTopicDataType(topicDataType.getName());

      publisherAttributes.getQos().setReliabilityKind(qosPolicy.getReliability());

      switch (qosPolicy.getDurability())
      {
      case TRANSIENT_LOCAL_DURABILITY_QOS:
         publisherAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
         break;
      case VOLATILE_DURABILITY_QOS:
         publisherAttributes.getQos().setDurabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS);
         break;
      }

      publisherAttributes.getTopic().getHistoryQos().setDepth(qosPolicy.getSize());
      publisherAttributes.getTopic().getHistoryQos().setKind(qosPolicy.getHistory());

      RosTopicNameMangler.assignNameAndPartitionsToAttributes(publisherAttributes, namespace, nodeName, topicName);

      if (topicDataType.getTypeSize() > 65000)
      {
         publisherAttributes.getQos().setPublishMode(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE);
      }

      return new RosPublisher<>(domain, domain.createPublisher(participant, publisherAttributes));

   }

   public <T> RosSubscription<T> createSubscription(TopicDataType<T> topicDataType, SubscriberListener callback, String topicName) throws IOException
   {
      RosQosPolicy rosQosPolicy = new RosQosPolicy();
      return createSubscription(topicDataType, callback, topicName, rosQosPolicy);
   }

   public <T> RosSubscription<T> createSubscription(TopicDataType<T> topicDataType, SubscriberListener callback, String topicName, ReliabilityKind kind)
         throws IOException
   {
      RosQosPolicy rosQosPolicy = new RosQosPolicy();
      rosQosPolicy.setReliability(kind);
      return createSubscription(topicDataType, callback, topicName, rosQosPolicy);
   }

   public <T> RosSubscription<T> createSubscription(TopicDataType<T> topicDataType, SubscriberListener callback, String topicName, int historyDepth)
         throws IOException
   {
      RosQosPolicy rosQosPolicy = new RosQosPolicy();
      rosQosPolicy.setDurability(RosDurability.TRANSIENT_LOCAL_DURABILITY_QOS);
      rosQosPolicy.setSize(historyDepth);
      return createSubscription(topicDataType, callback, topicName, rosQosPolicy);
   }

   public <T> RosSubscription<T> createSubscription(TopicDataType<T> topicDataType, SubscriberListener callback, String topicName, RosQosPolicy qosPolicy)
         throws IOException
   {
      TopicDataType<?> registeredType = domain.getRegisteredType(participant, topicDataType.getName());
      if (registeredType == null)
      {
         domain.registerType(participant, topicDataType);
      }

      SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes();
      subscriberAttributes.getTopic().setTopicKind(topicDataType.isGetKeyDefined() ? TopicKind.WITH_KEY : TopicKind.NO_KEY);
      subscriberAttributes.getTopic().setTopicDataType(topicDataType.getName());
      subscriberAttributes.getTopic().setTopicName(topicName);
      subscriberAttributes.getQos().setReliabilityKind(qosPolicy.getReliability());

      switch (qosPolicy.getDurability())
      {
      case TRANSIENT_LOCAL_DURABILITY_QOS:
         subscriberAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
         break;
      case VOLATILE_DURABILITY_QOS:
         subscriberAttributes.getQos().setDurabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS);
         break;
      }

      subscriberAttributes.getTopic().getHistoryQos().setDepth(qosPolicy.getSize());
      subscriberAttributes.getTopic().getHistoryQos().setKind(qosPolicy.getHistory());

      RosTopicNameMangler.assignNameAndPartitionsToAttributes(subscriberAttributes, namespace, nodeName, topicName);

      return new RosSubscription<>(domain, domain.createSubscriber(participant, subscriberAttributes, callback));

   }

}
