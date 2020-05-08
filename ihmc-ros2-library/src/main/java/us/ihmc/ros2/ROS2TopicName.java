package us.ihmc.ros2;

import java.util.Objects;

import static us.ihmc.ros2.ROS2TopicNameTools.messageTypeToTopicNamePart;
import static us.ihmc.ros2.ROS2TopicNameTools.processTopicNamePart;

public class ROS2TopicName
{
   public static final String INPUT = "input";
   public static final String OUTPUT = "output";

   private final String prefix;
   private final String robotName;
   private final String moduleName;
   private final String ioQualifier;
   private final String suffix;

   public ROS2TopicName() // TODO make private and provide static root name method?
   {
      prefix = "";
      robotName = "";
      moduleName = "";
      ioQualifier = "";
      suffix = "";
   }

   private ROS2TopicName(String prefix, String robotName, String moduleName, String ioQualifier, String suffix)
   {
      this.prefix = prefix;
      this.robotName = robotName;
      this.moduleName = moduleName;
      this.ioQualifier = ioQualifier;
      this.suffix = suffix;
   }

   public ROS2TopicName withPrefix(String prefix)
   {
      return new ROS2TopicName(processTopicNamePart(prefix), robotName, moduleName, ioQualifier, suffix);
   }

   public ROS2TopicName withRobot(String robotName)
   {
      return new ROS2TopicName(prefix, processTopicNamePart(robotName), moduleName, ioQualifier, suffix);
   }

   public ROS2TopicName withModule(String moduleName)
   {
      return new ROS2TopicName(prefix, robotName, processTopicNamePart(moduleName), ioQualifier, suffix);
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
      return new ROS2TopicName(prefix, robotName, moduleName, processTopicNamePart(ioQualifier), suffix);
   }

   public ROS2TopicName withType(Class<?> messageType)
   {
      return new ROS2TopicName(prefix, robotName, moduleName, ioQualifier, messageTypeToTopicNamePart(messageType));
   }

   public ROS2TopicName withSuffix(String suffix)
   {
      return new ROS2TopicName(prefix, robotName, moduleName, ioQualifier, processTopicNamePart(suffix));
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
             && Objects.equals(suffix, topicName.suffix);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(prefix, robotName, moduleName, ioQualifier, suffix);
   }
}
