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

import java.io.IOException;
import java.net.InetAddress;

/**
 * A non-realtime implementation of a ROS2 compatible node. This node can be used to create ROS2
 * compatible publishers and subscribers.
 *
 * @author Jesper Smith
 */
public class ROS2Node extends ROS2NodeBasics
{
   /**
    * Create a new ROS2 node. Namespace is set to empty ("") Domain ID is set to the default ROS2
    * domain ID (0) ROS2Distro is set to ROS_DISTRO environment variable (or BOUNCY if unset)
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param name                 Name for the node
    * @throws IOException if no participant can be made
    */
   public ROS2Node(PubSubImplementation pubSubImplementation, String name) throws IOException
   {
      this(pubSubImplementation, name, "");
   }

   /**
    * Create a new ROS2 node. Domain ID is set to the default ROS2 domain ID (0) ROS2Distro is set to
    * ROS_DISTRO environment variable (or BOUNCY if unset)
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param name                 Name for the node
    * @param namespace            namespace for the ros node i.e. DDS partition
    * @throws IOException if no participant can be made
    */
   public ROS2Node(PubSubImplementation pubSubImplementation, String name, String namespace) throws IOException
   {
      this(pubSubImplementation, name, namespace, ROS_DEFAULT_DOMAIN_ID);
   }

   /**
    * Create a new ROS2 node. Namespace is set to empty ("") Domain ID is set to the default ROS2
    * domain ID (0)
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param name                 Name for the node
    * @throws IOException if no participant can be made
    */
   public ROS2Node(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro, String name) throws IOException
   {
      this(pubSubImplementation, ros2Distro, name, "");
   }

   /**
    * Create a new ROS2 node. Domain ID is set to the default ROS2 domain ID (0)
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param name                 Name for the node
    * @param namespace            namespace for the ros node i.e. DDS partition
    * @throws IOException if no participant can be made
    */
   public ROS2Node(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro, String name, String namespace) throws IOException
   {
      this(pubSubImplementation, ros2Distro, name, namespace, ROS_DEFAULT_DOMAIN_ID);
   }

   /**
    * Create a new ROS2 node. ROS2Distro is set to ROS_DISTRO environment variable (or BOUNCY if unset)
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param name                 Name for the node
    * @param namespace            namespace for the ros node i.e. DDS partition
    * @param domainId             Domain ID for the ros node
    * @throws IOException if no participant can be made
    */
   public ROS2Node(PubSubImplementation pubSubImplementation, String name, String namespace, int domainId) throws IOException
   {
      this(pubSubImplementation, ROS2Distro.fromEnvironment(), name, namespace, domainId);
   }

   /**
    * Create a new ROS2 node.
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param ros2Distro           Version of ROS2 to use.
    * @param name                 Name for the node
    * @param namespace            namespace for the ros node i.e. DDS partition
    * @param domainId             Domain ID for the ros node
    * @throws IOException if no participant can be made
    */
   public ROS2Node(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro, String name, String namespace, int domainId) throws IOException
   {
      this(pubSubImplementation, ros2Distro, name, namespace, domainId, null);
   }

   /**
    * Create a new ROS2 node.
    *
    * @param pubSubImplementation RTPS or INTRAPROCESS. See
    *                             {@link us.ihmc.pubsub.DomainFactory.PubSubImplementation
    *                             PubSubImplementation}
    * @param ros2Distro           Version of ROS2 to use.
    * @param name                 Name for the node
    * @param namespace            namespace for the ros node i.e. DDS partition
    * @param domainId             Domain ID for the ros node
    * @param addressRestriction   Restrict network traffic to the given address. When provided, it
    *                             should describe one of the addresses of the computer hosting this
    *                             node. Optional, ignored when {@code null}.
    * @throws IOException if no participant can be made
    */
   public ROS2Node(PubSubImplementation pubSubImplementation,
                   ROS2Distro ros2Distro,
                   String name,
                   String namespace,
                   int domainId,
                   InetAddress addressRestriction) throws IOException
   {
      super(pubSubImplementation, ros2Distro, name, namespace, domainId, addressRestriction);
   }
}
