package us.ihmc.ros2;

import java.util.Objects;
import java.util.function.Function;

import static us.ihmc.ros2.ROS2TopicNameTools.messageTypeToTopicNamePart;

public class ROS2Topic<T>
{
   private final Class<T> messageType;
   private final Function<String, String> typeToNameFunction;
   private final ROS2TopicName topicName;

   public ROS2Topic()
   {
      this(null, null, null);
   }

   public ROS2Topic(Class<T> messageType)
   {
      this(messageType, null, null);
   }

   public ROS2Topic(Function<String, String> typeNameToTopicName)
   {
      this(null, typeNameToTopicName, null);
   }

   public ROS2Topic(Class<T> messageType, Function<String, String> typeNameToTopicName)
   {
      this(messageType, typeNameToTopicName, null);
   }

   private ROS2Topic(Class<T> messageType, Function<String, String> typeNameToTopicName, ROS2TopicName topicName)
   {
      this.messageType = messageType;
      this.typeToNameFunction = typeNameToTopicName;
      this.topicName = topicName;
   }

   public ROS2Topic<T> withNaming(Function<String, String> typeToNameFunction)
   {
      ROS2TopicName possibleTopicName = topicName;
      if (typeToNameFunction != null && topicName != null)
      {
         possibleTopicName = topicName.withSuffix(typeToNameFunction.apply(messageTypeToTopicNamePart(messageType)));
      }
      return new ROS2Topic<T>(messageType, typeToNameFunction, possibleTopicName);
   }

   public ROS2Topic<T> withType(Class<T> messageType)
   {
      ROS2TopicName possibleTopicName = topicName;
      if (typeToNameFunction != null && topicName != null)
      {
         possibleTopicName = topicName.withSuffix(typeToNameFunction.apply(messageTypeToTopicNamePart(messageType)));
      }
      return new ROS2Topic<T>(messageType, typeToNameFunction, possibleTopicName);
   }

   public ROS2Topic<T> withTopicName(ROS2TopicName ros2TopicName)
   {
      return new ROS2Topic<T>(messageType,
                              typeToNameFunction,
                              ros2TopicName.withSuffix(typeToNameFunction.apply(messageTypeToTopicNamePart(messageType))));
   }

   public Class<T> getMessageType()
   {
      return messageType;
   }

   public ROS2TopicName getTopicName()
   {
      return topicName;
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      ROS2Topic<?> ros2Topic = (ROS2Topic<?>) o;
      return messageType.equals(ros2Topic.messageType)
             && typeToNameFunction.equals(ros2Topic.typeToNameFunction)
             && Objects.equals(topicName, ros2Topic.topicName);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(messageType, typeToNameFunction, topicName);
   }
}
