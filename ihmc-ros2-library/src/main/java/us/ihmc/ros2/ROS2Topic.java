package us.ihmc.ros2;

import java.util.function.Function;

public class ROS2Topic<T extends Class<?>>
{
   private final T messageType;
   private final Function<String, String> topicNameFunction;

   public ROS2Topic(T messageType, Function<String, String> typeNameToTopicName)
   {
      this.messageType = messageType;
      this.topicNameFunction = typeNameToTopicName;
   }

   public ROS2TopicName withTopicName(ROS2TopicName ros2TopicName)
   {
      return ros2TopicName.withSuffix(topicNameFunction.apply(ROS2TopicNameTools.messageTypeToTopicNamePart(messageType)));
   }

   public T getMessageType()
   {
      return messageType;
   }
}
