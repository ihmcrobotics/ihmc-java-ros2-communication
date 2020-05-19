package us.ihmc.ros2;

import java.util.Objects;
import java.util.function.Function;

import static us.ihmc.ros2.ROS2TopicNameTools.messageTypeToTopicNamePart;
import static us.ihmc.ros2.ROS2TopicNameTools.processTopicNamePart;

public class ROS2Topic<T>
{
   public static final String INPUT = "input";
   public static final String OUTPUT = "output";

   private final String prefix;
   private final String robotName;
   private final String moduleName;
   private final String ioQualifier;
   private final String suffix;

   private final Class<T> messageType;
   private final Function<String, String> typeToNameFunction;

   public ROS2Topic() // TODO make private and provide static root name method?
   {
      prefix = "";
      robotName = "";
      moduleName = "";
      ioQualifier = "";
      suffix = "";
      messageType = null;
      typeToNameFunction = null;
   }

   public ROS2Topic(Class<T> messageType, Function<String, String> typeToNameFunction)
   {
      this("", "", "", "", processTopicNamePart(typeToNameFunction.apply(messageTypeToTopicNamePart(messageType))), messageType, typeToNameFunction);
   }

   private ROS2Topic(String prefix,
                     String robotName,
                     String moduleName,
                     String ioQualifier,
                     String suffix,
                     Class<T> messageType,
                     Function<String, String> typeToNameFunction)
   {
      this.prefix = prefix;
      this.robotName = robotName;
      this.moduleName = moduleName;
      this.ioQualifier = ioQualifier;
      this.suffix = suffix;
      this.messageType = messageType;
      this.typeToNameFunction = typeToNameFunction;
   }

   public ROS2Topic<T> withPrefix(String prefix)
   {
      return new ROS2Topic<>(processTopicNamePart(prefix), robotName, moduleName, ioQualifier, suffix, messageType, typeToNameFunction);
   }

   public ROS2Topic<T> withRobot(String robotName)
   {
      return new ROS2Topic<>(prefix, processTopicNamePart(robotName), moduleName, ioQualifier, suffix, messageType, typeToNameFunction);
   }

   public ROS2Topic<T> withModule(String moduleName)
   {
      return new ROS2Topic<>(prefix, robotName, processTopicNamePart(moduleName), ioQualifier, suffix, messageType, typeToNameFunction);
   }

   public ROS2Topic<T> withInput()
   {
      return withIOQualifier(INPUT);
   }

   public ROS2Topic<T> withOutput()
   {
      return withIOQualifier(OUTPUT);
   }

   public ROS2Topic<T> withIOQualifier(String ioQualifier)
   {
      return new ROS2Topic<T>(prefix, robotName, moduleName, processTopicNamePart(ioQualifier), suffix, messageType, typeToNameFunction);
   }

   public ROS2Topic<T> withSuffix(String suffix)
   {
      return new ROS2Topic<>(prefix, robotName, moduleName, ioQualifier, processTopicNamePart(suffix), messageType, typeToNameFunction);
   }

   public ROS2Topic<T> withNaming(Function<String, String> typeToNameFunction)
   {
      String newSuffix = suffix;
      if (typeToNameFunction != null && messageType != null)
      {
         newSuffix = processTopicNamePart(typeToNameFunction.apply(messageTypeToTopicNamePart(messageType)));
      }
      return new ROS2Topic<>(prefix, robotName, moduleName, ioQualifier, newSuffix, messageType, typeToNameFunction);
   }

   public <K> ROS2Topic<K> withType(Class<K> messageType)
   {
      String newSuffix = suffix;
      if (messageType != null)
      {
         if (typeToNameFunction != null)
         {
            newSuffix = processTopicNamePart(typeToNameFunction.apply(messageTypeToTopicNamePart(messageType)));
         }
         else
         {
            newSuffix = messageTypeToTopicNamePart(messageType);
         }
      }
      return new ROS2Topic<>(prefix, robotName, moduleName, ioQualifier, newSuffix, messageType, typeToNameFunction);
   }

   public ROS2Topic<T> withTopic(ROS2Topic<?> topic)
   {
      String newPrefix = takeNonNullOrSecond(prefix, topic.prefix);
      String newRobotName = takeNonNullOrSecond(robotName, topic.robotName);
      String newModuleName = takeNonNullOrSecond(moduleName, topic.moduleName);
      String newIOQualifier = takeNonNullOrSecond(ioQualifier, topic.ioQualifier);
      String newSuffix = takeNonNullOrSecond(suffix, topic.suffix);
      Function<String, String> newTypeToNameFunction = takeNonNullOrSecond(typeToNameFunction, topic.typeToNameFunction);
      if (topic.messageType != null && !topic.messageType.equals(messageType))
      {
         throw new RuntimeException("Cannot change the type of a Topic with the withTopic method");
      }
      return new ROS2Topic<>(newPrefix, newRobotName, newModuleName, newIOQualifier, newSuffix, messageType, newTypeToNameFunction);
   }

   private <K> K takeNonNullOrSecond(K first, K second)
   {
      if (first != null && second == null)
      {
         return first;
      }
      else if (first == null && second != null)
      {
         return second;
      }
      else if (first instanceof String && !((String) first).isEmpty()
               && second instanceof String && ((String) second).isEmpty())
      {
         return first;
      }
      else
      {
         return second;
      }
   }

   public Class<T> getType()
   {
      return messageType;
   }

   public String getName()
   {
      return toString();
   }

   @Override
   public String toString()
   {
      String topicName = "";
      topicName += prefix;
      topicName += robotName;
      topicName += moduleName;
      topicName += ioQualifier;
      topicName += suffix;
      return topicName;
   }

   @Override
   public boolean equals(Object other)
   {
      if (this == other)
         return true;
      if (other == null || getClass() != other.getClass())
         return false;
      ROS2Topic<?> topicName = (ROS2Topic<?>) other;
      return Objects.equals(prefix, topicName.prefix)
             && Objects.equals(robotName, topicName.robotName)
             && Objects.equals(moduleName, topicName.moduleName)
             && Objects.equals(ioQualifier, topicName.ioQualifier)
             && Objects.equals(suffix, topicName.suffix)
             && Objects.equals(messageType, topicName.messageType)
             && Objects.equals(typeToNameFunction, topicName.typeToNameFunction);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(prefix, robotName, moduleName, ioQualifier, suffix, messageType, typeToNameFunction);
   }
}
