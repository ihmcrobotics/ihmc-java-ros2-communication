package us.ihmc.ros2;

@Deprecated
public enum ROS2TopicQualifier
{
   @Deprecated
   INPUT(ROS2TopicName.INPUT_ROS_TOPIC_PREFIX),
   @Deprecated
   OUTPUT(ROS2TopicName.OUTPUT_ROS_TOPIC_PREFIX);

   private final String name;

   @Deprecated
   ROS2TopicQualifier(String name)
   {
      this.name = name;
   }

   @Override
   public String toString()
   {
      return name;
   }
}
