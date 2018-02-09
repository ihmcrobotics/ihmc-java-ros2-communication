package us.ihmc.ros2;

import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.impl.intraprocess.IntraProcessDomain;

import java.io.IOException;

/**
 * An implementation of a ROS2 compatible node that uses intra-process RTPS
 * under the hood.
 *
 * This node can be used to create ROS2 compatible publishers and subscribers.
 *
 * @author Duncan Calvert
 *
 */
public class IntraProcessNode extends RosNodeBasics
{
   /**
    * Create a new intra-process ROS2 node.
    *
    * Namespace is set to empty ("")
    * Domain ID is set to the default ROS2 domain ID (0)
    *
    * @param name Name for the node
    * @throws IOException if no participant can be made
    */
   public IntraProcessNode(String name) throws IOException
   {
      this(name, "");
   }

   /**
    * Create a new intra-process ROS2 node.
    *
    * Domain ID is set to the default ROS2 domain ID (0)
    *
    * @param name Name for the node
    * @param namespace namespace for the ros node
    * @throws IOException if no participant can be made
    */
   public IntraProcessNode(String name, String namespace) throws IOException
   {
      this(name, namespace, ROS_DEFAULT_DOMAIN_ID);
   }

   /**
    * Create a new intra-process ROS2 node.
    *
    * @param name Name for the node
    * @param namespace namespace for the ros node
    * @param domainId Domain ID for the ros node
    * @throws IOException if no participant can be made
    */
   public IntraProcessNode(String name, String namespace, int domainId) throws IOException
   {
      super(DomainFactory.PubSubImplementation.INTRAPROCESS, name, namespace, domainId);
   }
}
