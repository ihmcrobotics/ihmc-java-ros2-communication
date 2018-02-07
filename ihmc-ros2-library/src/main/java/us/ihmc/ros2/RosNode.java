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

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.subscriber.SubscriberListener;

import java.io.IOException;

/**
 * A minimal implementation of a ROS2 compatible node.
 *
 * This node can be used to create ROS2 compatible publishers and subscribers.
 *
 * @author Jesper Smith
 *
 */
public class RosNode extends RosNodeBasics
{
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
    * @param domainId Domain ID for the ros node
    * @throws IOException if no participant can be made
    */
   public RosNode(String name, String namespace, int domainId) throws IOException
   {
      super(DomainFactory.getDomain(PubSubImplementation.FAST_RTPS), name, namespace, domainId);
   }
}
