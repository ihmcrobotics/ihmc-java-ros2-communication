package us.ihmc.ros2;

public interface ROS2NodeReadOnly
{
   /**
    * @return the name of this node
    */
   String getName();

   /**
    * @return the namespace of this node
    */
   String getNamespace();
}
