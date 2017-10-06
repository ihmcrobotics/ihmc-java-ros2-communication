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
import us.ihmc.ros2.RosQosProfile.RosDurability;

/**
 * A minimal implementation of a ROS2 compatible node.
 * 
 * This node can be used to create ROS2 compatible publishers and subscribers.
 * 
 * @author Jesper Smith
 *
 */
public class RosNode
{
   private static final int ROS_DEFAULT_DOMAIN_ID = 0;

   private final Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
   private final Participant participant;

   private final String nodeName;
   private final String namespace;

   
   /** 
    * Create a new ROS2 node.
    * 
    * Namespace is set to empty ("")
    * Domain ID is set to the default ROS2 domain ID (0)
    * 
    * @param name Name for the node
    * @throws IOException if no participant can be made
    */
   public RosNode(String name) throws IOException
   {
      this(name, "");
   }
   
   /** 
    * Create a new ROS2 node.
    * 
    * Domain ID is set to the default ROS2 domain ID (0)
    * 
    * @param name Name for the node
    * @param namespace namespace for the ros node
    * @throws IOException if no participant can be made
    */
   public RosNode(String name, String namespace) throws IOException
   {
      this(name, namespace, ROS_DEFAULT_DOMAIN_ID);
   }

   /** 
    * Create a new ROS2 node.
    * 
    * 
    * @param name Name for the node
    * @param namespace namespace for the ros node
    * @param domainID Domain ID for the ros node
    * @throws IOException if no participant can be made
    */
   public RosNode(String name, String namespace, int domainId) throws IOException
   {
      RosTopicNameMangler.checkNodename(name);
      RosTopicNameMangler.checkNamespace(namespace);

      this.nodeName = name;
      this.namespace = namespace;

      ParticipantAttributes attr = domain.createParticipantAttributes(domainId, name);
      participant = domain.createParticipant(attr);
   }

   /**
    * Create a new ROS2 compatible publisher in this Node
    * 
    * This call makes a publisher with the default settings 
    * 
    * @param topicDataType The topic data type of the message
    * @param topicName Name for the topic
    * @return A ROS publisher
    * 
    * @throws IOException if no publisher can be made
    */
   public <T> RosPublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      RosQosProfile rosQosPolicy = new RosQosProfile();
      return createPublisher(topicDataType, topicName, rosQosPolicy);
   }

   /**
    * Create a new ROS2 compatible publisher in this Node
    * 
    * This call can be used to make a ROS2 topic with a custom reliability setting 
    * 
    * @param topicDataType The topic data type of the message
    * @param topicName Name for the topic
    * @param reliability Desired reliability for this topic
    * @return A ROS publisher
    * 
    * @throws IOException if no publisher can be made
    */
   public <T> RosPublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, ReliabilityKind reliablity) throws IOException
   {
      RosQosProfile rosQosPolicy = new RosQosProfile();
      rosQosPolicy.setReliability(reliablity);
      return createPublisher(topicDataType, topicName, rosQosPolicy);
   }


   /**
    * Create a new ROS2 compatible publisher in this Node
    * 
    * This call can be used to make a ROS2 topic with a persistent history of depth historyDepth
    * The history will stay persistant as long as this node is active 
    * 
    * @param topicDataType The topic data type of the message
    * @param topicName Name for the topic
    * @param historyDepth Number of messages to keep in the history
    * @return A ROS publisher
    * 
    * @throws IOException if no publisher can be made
    */
   public <T> RosPublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, int historyDepth) throws IOException
   {
      RosQosProfile rosQosPolicy = new RosQosProfile();
      rosQosPolicy.setDurability(RosDurability.TRANSIENT_LOCAL);
      rosQosPolicy.setSize(historyDepth);
      return createPublisher(topicDataType, topicName, rosQosPolicy);
   }

   /**
    * Create a new ROS2 compatible publisher in this Node
    * 
    * @param topicDataType The topic data type of the message
    * @param topicName Name for the topic
    * @param qosProfile ROS Qos Profile
    * @return A ROS publisher
    * 
    * @throws IOException if no publisher can be made
    */
   public <T> RosPublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, RosQosProfile qosProfile) throws IOException
   {
      TopicDataType<?> registeredType = domain.getRegisteredType(participant, topicDataType.getName());
      if (registeredType == null)
      {
         domain.registerType(participant, topicDataType);
      }

      PublisherAttributes publisherAttributes = domain.createPublisherAttributes();
      publisherAttributes.getTopic().setTopicKind(topicDataType.isGetKeyDefined() ? TopicKind.WITH_KEY : TopicKind.NO_KEY);
      publisherAttributes.getTopic().setTopicDataType(topicDataType.getName());

      publisherAttributes.getQos().setReliabilityKind(qosProfile.getReliability());

      switch (qosProfile.getDurability())
      {
      case TRANSIENT_LOCAL:
         publisherAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
         break;
      case VOLATILE:
         publisherAttributes.getQos().setDurabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS);
         break;
      }

      publisherAttributes.getTopic().getHistoryQos().setDepth(qosProfile.getSize());
      publisherAttributes.getTopic().getHistoryQos().setKind(qosProfile.getHistory());

      RosTopicNameMangler.assignNameAndPartitionsToAttributes(publisherAttributes, namespace, nodeName, topicName, qosProfile.isAvoidRosNamespaceConventions());

      if (topicDataType.getTypeSize() > 65000)
      {
         publisherAttributes.getQos().setPublishMode(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE);
      }

      return new RosPublisher<>(domain, domain.createPublisher(participant, publisherAttributes));

   }

   public <T> RosSubscription<T> createSubscription(TopicDataType<T> topicDataType, SubscriberListener callback, String topicName) throws IOException
   {
      RosQosProfile rosQosPolicy = new RosQosProfile();
      return createSubscription(topicDataType, callback, topicName, rosQosPolicy);
   }

   public <T> RosSubscription<T> createSubscription(TopicDataType<T> topicDataType, SubscriberListener callback, String topicName, ReliabilityKind kind)
         throws IOException
   {
      RosQosProfile rosQosPolicy = new RosQosProfile();
      rosQosPolicy.setReliability(kind);
      return createSubscription(topicDataType, callback, topicName, rosQosPolicy);
   }

   public <T> RosSubscription<T> createSubscription(TopicDataType<T> topicDataType, SubscriberListener callback, String topicName, int historyDepth)
         throws IOException
   {
      RosQosProfile rosQosPolicy = new RosQosProfile();
      rosQosPolicy.setDurability(RosDurability.TRANSIENT_LOCAL);
      rosQosPolicy.setSize(historyDepth);
      return createSubscription(topicDataType, callback, topicName, rosQosPolicy);
   }

   public <T> RosSubscription<T> createSubscription(TopicDataType<T> topicDataType, SubscriberListener callback, String topicName, RosQosProfile qosPolicy)
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
      case TRANSIENT_LOCAL:
         subscriberAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
         break;
      case VOLATILE:
         subscriberAttributes.getQos().setDurabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS);
         break;
      }

      subscriberAttributes.getTopic().getHistoryQos().setDepth(qosPolicy.getSize());
      subscriberAttributes.getTopic().getHistoryQos().setKind(qosPolicy.getHistory());

      RosTopicNameMangler.assignNameAndPartitionsToAttributes(subscriberAttributes, namespace, nodeName, topicName, qosPolicy.isAvoidRosNamespaceConventions());

      return new RosSubscription<>(domain, domain.createSubscriber(participant, subscriberAttributes, callback));

   }

}
