package us.ihmc.ros2;

import java.util.Objects;
import java.util.function.Function;

import static us.ihmc.ros2.ROS2TopicNameTools.messageTypeToTopicNamePart;
import static us.ihmc.ros2.ROS2TopicNameTools.processTopicNamePart;

public class ROS2TopicName<T>
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

   public ROS2TopicName() // TODO make private and provide static root name method?
   {
      prefix = "";
      robotName = "";
      moduleName = "";
      ioQualifier = "";
      suffix = "";
      messageType = null;
      typeToNameFunction = null;
   }

   public ROS2TopicName(Class<T> messageType, Function<String, String> typeNameToTopicName)
   {
      this("", "", "", "", "", messageType, typeNameToTopicName);
   }

   private ROS2TopicName(String prefix,
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

   public ROS2TopicName withPrefix(String prefix)
   {
      return new ROS2TopicName(processTopicNamePart(prefix), robotName, moduleName, ioQualifier, suffix, messageType, typeToNameFunction);
   }

   public ROS2TopicName withRobot(String robotName)
   {
      return new ROS2TopicName(prefix, processTopicNamePart(robotName), moduleName, ioQualifier, suffix, messageType, typeToNameFunction);
   }

   public ROS2TopicName withModule(String moduleName)
   {
      return new ROS2TopicName(prefix, robotName, processTopicNamePart(moduleName), ioQualifier, suffix, messageType, typeToNameFunction);
   }

   public ROS2TopicName withInput()
   {
      return withIOQualifier(INPUT);
   }

   public ROS2TopicName withOutput()
   {
      return withIOQualifier(OUTPUT);
   }

   public ROS2TopicName withIOQualifier(String ioQualifier)
   {
      return new ROS2TopicName(prefix, robotName, moduleName, processTopicNamePart(ioQualifier), suffix, messageType, typeToNameFunction);
   }

   public ROS2TopicName withSuffix(String suffix)
   {
      return new ROS2TopicName(prefix, robotName, moduleName, ioQualifier, processTopicNamePart(suffix), messageType, typeToNameFunction);
   }

   public ROS2TopicName<T> withNaming(Function<String, String> typeToNameFunction)
   {
      String newSuffix = suffix;
      if (typeToNameFunction != null && messageType != null)
      {
         newSuffix = processTopicNamePart(typeToNameFunction.apply(messageTypeToTopicNamePart(messageType)));
      }
      return new ROS2TopicName(prefix, robotName, moduleName, ioQualifier, newSuffix, messageType, typeToNameFunction);
   }

   public ROS2TopicName<T> withType(Class<T> messageType)
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
      return new ROS2TopicName(prefix, robotName, moduleName, ioQualifier, newSuffix, messageType, typeToNameFunction);
   }

   public ROS2TopicName<T> withTopicName(ROS2TopicName<T> topic)
   {
      String newPrefix = topic.prefix == null ? prefix : topic.prefix;
      String newRobotName = topic.robotName == null ? robotName : topic.robotName;
      String newModuleName = topic.moduleName == null ? moduleName : topic.moduleName;
      String newIOQualifier = topic.ioQualifier == null ? ioQualifier : topic.ioQualifier;
      String newSuffix = topic.suffix == null ? suffix : topic.suffix;
      Class<T> newMessageType = topic.messageType == null ? messageType : topic.messageType;
      Function<String, String> newTypeToNameFunction = topic.typeToNameFunction == null ? typeToNameFunction : topic.typeToNameFunction;
      return new ROS2TopicName<>(newPrefix, newRobotName, newModuleName, newIOQualifier, newSuffix, newMessageType, newTypeToNameFunction);
   }

   public Class<T> getMessageType() // TODO: Rename to getType
   {
      return messageType;
   }

   public String getTopicName() // TODO: Rename to getName
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
      ROS2TopicName topicName = (ROS2TopicName) other;
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
