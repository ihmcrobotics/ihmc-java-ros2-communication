package us.ihmc.ros2;

import java.util.function.Function;

import static us.ihmc.ros2.ROS2TopicNameTools.messageTypeToTopicNamePart;

public class ROS2Topic<T extends Class<?>>
{
   private final T messageType;
   private final Function<String, String> typeToNameFunction;
   private final ROS2TopicName topicName;

   public ROS2Topic(T messageType, Function<String, String> typeNameToTopicName)
   {
      this(messageType, typeNameToTopicName, null);
   }

   private ROS2Topic(T messageType, Function<String, String> typeNameToTopicName, ROS2TopicName topicName)
   {
      this.messageType = messageType;
      this.typeToNameFunction = typeNameToTopicName;
      this.topicName = topicName;
   }

   public ROS2Topic withTopicName(ROS2TopicName ros2TopicName)
   {
      return new ROS2Topic(messageType,
                           typeToNameFunction,
                           ros2TopicName.withSuffix(typeToNameFunction.apply(messageTypeToTopicNamePart(messageType))));
   }

   public T getMessageType()
   {
      return messageType;
   }

   public ROS2TopicName getTopicName()
   {
      return topicName;
   }
}
