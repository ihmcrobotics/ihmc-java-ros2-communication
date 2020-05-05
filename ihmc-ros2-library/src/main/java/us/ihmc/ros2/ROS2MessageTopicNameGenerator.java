package us.ihmc.ros2;

/**
 * Generator to automatically generate a topic name based on the type of message to send.
 */
@Deprecated
public interface ROS2MessageTopicNameGenerator
{
   @Deprecated
   String generateTopicName(Class<?> messageType);
}
