package us.ihmc.ros2;

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.attributes.ParticipantAttributes;

import java.io.IOException;
import java.net.InetAddress;

/**
 * An implementation of a ROS2 compatible node. This node can be used to create ROS2
 * compatible publishers and subscribers.
 *
 * @author Jesper Smith
 */
public class ROS2Node extends ROS2NodeBasics
{
   /**
    * Create a new ROS 2 node.
    *
    * @param domain DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name   Name of the ROS 2 node
    * @throws IOException
    */
   public ROS2Node(Domain domain, String name) throws IOException
   {
      this(domain, name, "", ROS2NodeInterface.domainFromEnvironment(), ROS2NodeInterface.useSHMFromEnvironment());
   }
   
   /**
    * Create a new ROS 2 node.
    *
    * @param domain             DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name               Name of the ROS 2 node
    * @param namespace          Namespace of the ROS 2 node
    * @param domainId           Desired ROS domain ID
    * @param addressRestriction Restrict network traffic to the given addresses. When provided, it
    *                           should describe one of the addresses of the computer hosting this node.
    *                           Optional.
    * @throws IOException
    */
   public ROS2Node(Domain domain, String name, String namespace, int domainId, InetAddress... addressRestriction) throws IOException
   {
      this(domain, name, namespace, domainId, ROS2NodeInterface.useSHMFromEnvironment(), addressRestriction);
   }
   
   /**
    * Create a new ROS 2 node.
    *
    * @param domain             DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name               Name of the ROS 2 node
    * @param namespace          Namespace of the ROS 2 node
    * @param domainId           Desired ROS domain ID
    * @param useSharedMemory    Enable shared memory transport
    * @param addressRestriction Restrict network traffic to the given addresses. When provided, it
    *                           should describe one of the addresses of the computer hosting this node.
    *                           Optional.
    * @throws IOException
    */
   public ROS2Node(Domain domain, String name, String namespace, int domainId, boolean useSharedMemory, InetAddress... addressRestriction) throws IOException
   {
      this(domain, name, namespace, ROS2NodeInterface.createParticipantAttributes(domainId, useSharedMemory, addressRestriction));
   }

   /**
    * Create a new ROS 2 node.
    *
    * @param domain     DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name       Name of the ROS 2 node
    * @param namespace  Namespace of the ROS 2 node
    * @param attributes ParticipantAttributes for the domain
    * @throws IOException
    */
   public ROS2Node(Domain domain, String name, String namespace, ParticipantAttributes attributes) throws IOException
   {
      super(domain, name, namespace, attributes);
   }
}
