package us.ihmc.ros2;

import java.util.Objects;

public class ROS2TopicName
{
   public static final String INPUT = "input";
   public static final String OUTPUT = "output";

   private String prefix;
   private String suffix;
   private String robotName;
   private String moduleName;
   private ROS2TopicQualifier inputOrOutput;
   private Class<?> messageType;
   private Boolean isRemote = null; // can be used by pub/sub creators to set input/output

   public ROS2TopicName()
   {

   }

   public ROS2TopicName(ROS2TopicName topicNameToCopy)
   {
      this.prefix = topicNameToCopy.prefix;
      this.suffix = topicNameToCopy.suffix;
      this.robotName = topicNameToCopy.robotName;
      this.moduleName = topicNameToCopy.moduleName;
      this.inputOrOutput = topicNameToCopy.inputOrOutput;
      this.messageType = topicNameToCopy.messageType;
      this.isRemote = topicNameToCopy.isRemote;
   }

   public ROS2TopicName prefix(String prefix)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.prefix = prefix;
      return copiedTopicName;
   }

   /**
    *
    * TODO Consider suffix instead, or additionally
    *
    * @param suffix
    * @return
    */
   public ROS2TopicName suffix(String suffix)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.suffix = suffix;
      return copiedTopicName;
   }

   public ROS2TopicName robot(String robotName)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.robotName = robotName;
      return copiedTopicName;
   }

   public ROS2TopicName module(String moduleName)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.moduleName = moduleName;
      return copiedTopicName;
   }

   public ROS2TopicName qualifier(ROS2TopicQualifier qualifier)
   {
      return suffix(qualifier == null ? "" : qualifier.name().toLowerCase());
   }

   public ROS2TopicName type(Class<?> messageType)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.messageType = messageType;
      return copiedTopicName;
   }

   @Override
   public String toString()
   {
      String topicName = "";
      topicName += processTopicNamePart(prefix);
      topicName += processTopicNamePart(robotName);
      topicName += processTopicNamePart(moduleName);
      topicName += processTopicNamePart(inputOrOutput == null ? null : inputOrOutput.name());
      topicName += messageTypeToTopicNamePart(messageType);
      topicName += processTopicNamePart(suffix);
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
             && inputOrOutput == topicName.inputOrOutput
             && Objects.equals(messageType, topicName.messageType)
             && Objects.equals(suffix, topicName.suffix)
             && Objects.equals(isRemote, topicName.isRemote);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(prefix, robotName, moduleName, inputOrOutput, messageType, suffix, isRemote);
   }

   private String messageTypeToTopicNamePart(Class<?> messageType)
   {
      if (messageType == null)
      {
         return "";
      }

      String messageTypePart = ROS2TopicNameTools.removeMessageOrPacketSuffixFromTypeName(messageType);
      // This makes ArmTrajectory => arm_trajectory & handle acronyms as follows: REAStateRequest => rea_state_request
      return processTopicNamePart(ROS2TopicNameTools.toROSTopicFormat(messageTypePart));
   }

   private String titleCasedToUnderscoreCased(String titleCased)
   {
      return titleCased.trim().toLowerCase().replaceAll("\\s+", "_");
   }

   private String processTopicNamePart(String string)
   {
      if (string == null)
      {
         return "";
      }

      string = string.trim().toLowerCase();

      if (string.isEmpty())
      {
         return "";
      }

      if (!string.startsWith("/"))
      {
         string =  "/" + string;
      }

      return string;
   }

   private ROS2TopicName copyOfThis()
   {
      return new ROS2TopicName(this);
   }
}
