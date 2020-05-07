package us.ihmc.ros2;

import java.util.Objects;

public class ROS2TopicName
{
   public static final String INPUT = "input";
   public static final String OUTPUT = "output";

   private String prefix = "";
   private String robotName = "";
   private String moduleName = "";
   private String ioQualifier = "";
   private String messageType = "";
   private String suffix = "";

   public ROS2TopicName()
   {

   }

   public ROS2TopicName(ROS2TopicName topicNameToCopy)
   {
      this.prefix = topicNameToCopy.prefix;
      this.robotName = topicNameToCopy.robotName;
      this.moduleName = topicNameToCopy.moduleName;
      this.ioQualifier = topicNameToCopy.ioQualifier;
      this.messageType = topicNameToCopy.messageType;
      this.suffix = topicNameToCopy.suffix;
   }

   public ROS2TopicName withPrefix(String prefix)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.prefix = ROS2TopicNameTools.processTopicNamePart(prefix);
      return copiedTopicName;
   }

   public ROS2TopicName withRobot(String robotName)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.robotName = ROS2TopicNameTools.processTopicNamePart(robotName);
      return copiedTopicName;
   }

   public ROS2TopicName withModule(String moduleName)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.moduleName = ROS2TopicNameTools.processTopicNamePart(moduleName);
      return copiedTopicName;
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
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.ioQualifier = ROS2TopicNameTools.processTopicNamePart(ioQualifier);
      return copiedTopicName;
   }

   public ROS2TopicName withType(Class<?> messageType)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.messageType = ROS2TopicNameTools.messageTypeToTopicNamePart(messageType);
      return copiedTopicName;
   }

   public ROS2TopicName withSuffix(String suffix)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.suffix = ROS2TopicNameTools.processTopicNamePart(suffix);
      return copiedTopicName;
   }

   @Override
   public String toString()
   {
      String topicName = "";
      topicName += prefix;
      topicName += robotName;
      topicName += moduleName;
      topicName += ioQualifier;
      topicName += messageType;
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
             && Objects.equals(messageType, topicName.messageType)
             && Objects.equals(suffix, topicName.suffix);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(prefix, robotName, moduleName, ioQualifier, messageType, suffix);
   }

   private ROS2TopicName copyOfThis()
   {
      return new ROS2TopicName(this);
   }
}
