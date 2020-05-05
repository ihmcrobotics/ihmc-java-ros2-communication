package us.ihmc.ros2;

import java.util.ArrayList;

public class ROS2TopicName
{
   public static final String OUTPUT_ROS_TOPIC_PREFIX = "/output";
   public static final String INPUT_ROS_TOPIC_PREFIX = "/input";

   private enum InputOrOutput
   {
      INPUT, OUTPUT;
   }

   private final ArrayList<String> prefixes = new ArrayList<>();
   private String robotName;
   private String moduleName;
   private InputOrOutput inputOrOutput;
   private Class<?> messageType;
   private String name;
   private Boolean isRemote = null; // can be used by pub/sub creators to set input/output

   private String topicNameInBuildOrder = "";

   public ROS2TopicName()
   {

   }

   public ROS2TopicName(ROS2TopicName topicNameToCopy)
   {
      this.prefixes.addAll(topicNameToCopy.prefixes);
      this.robotName = topicNameToCopy.robotName;
      this.moduleName = topicNameToCopy.moduleName;
      this.inputOrOutput = topicNameToCopy.inputOrOutput;
      this.messageType = topicNameToCopy.messageType;
      this.name = topicNameToCopy.name;
   }

   public ROS2TopicName prefix(String prefix)
   {
      prefixes.add(prefix);

      topicNameInBuildOrder += processTopicNamePart(prefix);

      return copyOfThis();
   }

   public ROS2TopicName robot(String robotName)
   {
      this.robotName = robotName;

      topicNameInBuildOrder += processTopicNamePart(robotName);

      return copyOfThis();
   }

   public ROS2TopicName module(String moduleName)
   {
      this.moduleName = moduleName;

      topicNameInBuildOrder += processTopicNamePart(moduleName);

      return copyOfThis();
   }

   public ROS2TopicName input()
   {
      inputOrOutput = InputOrOutput.INPUT;

      topicNameInBuildOrder += processTopicNamePart(inputOrOutput.name());

      return copyOfThis();
   }

   public ROS2TopicName output()
   {
      inputOrOutput = InputOrOutput.OUTPUT;

      topicNameInBuildOrder += processTopicNamePart(inputOrOutput.name());

      return copyOfThis();
   }

   public ROS2TopicName setInputOrOutputForPublisher()
   {
      if (isRemote != null)
      {
         if (isRemote)
         {
            return input();
         }
         else
         {
            return output();
         }
      }

      return copyOfThis();
   }

   public ROS2TopicName setInputOrOutputForSubscriber()
   {
      if (isRemote != null)
      {
         if (isRemote)
         {
            return output();
         }
         else
         {
            return input();
         }
      }

      return copyOfThis();
   }

   public ROS2TopicName setRemote(boolean isRemote)
   {
      this.isRemote = isRemote;

      return copyOfThis();
   }

   public ROS2TopicName type(Class<?> messageType)
   {
      this.messageType = messageType;

      topicNameInBuildOrder += messageTypeToTopicNamePart(messageType);

      return copyOfThis();
   }

   public ROS2TopicName name(String name)
   {
      this.name = name;

      topicNameInBuildOrder += processTopicNamePart(name);

      return copyOfThis();
   }

   public Boolean isRemote()
   {
      return isRemote;
   }

   public String toStringInBuildOrder()
   {
      return topicNameInBuildOrder;
   }

   @Override
   public String toString()
   {
      String topicName = "";

      for (String prefix : prefixes)
      {
         topicName += processTopicNamePart(prefix);
      }

      topicName += processTopicNamePart(robotName);
      topicName += processTopicNamePart(moduleName);
      topicName += processTopicNamePart(inputOrOutput == null ? null : inputOrOutput.name());

      topicName += messageTypeToTopicNamePart(messageType);

      topicName += processTopicNamePart(name);

      return topicName;
   }

   private String messageTypeToTopicNamePart(Class<?> messageType)
   {
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
