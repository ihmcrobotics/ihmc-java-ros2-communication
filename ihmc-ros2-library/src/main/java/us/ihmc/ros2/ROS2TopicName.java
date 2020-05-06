package us.ihmc.ros2;

import java.util.ArrayList;

public class ROS2TopicName implements ROS2MessageTopicNameGenerator
{
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
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.prefixes.add(prefix);
      copiedTopicName.topicNameInBuildOrder += processTopicNamePart(prefix);
      return copiedTopicName;
   }

   public ROS2TopicName robot(String robotName)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.robotName = robotName;
      topicNameInBuildOrder += processTopicNamePart(robotName);
      return copiedTopicName;
   }

   public ROS2TopicName module(String moduleName)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.moduleName = moduleName;
      copiedTopicName.topicNameInBuildOrder += processTopicNamePart(moduleName);
      return copiedTopicName;
   }

   public ROS2TopicName input()
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.inputOrOutput = InputOrOutput.INPUT;
      copiedTopicName.topicNameInBuildOrder += processTopicNamePart(copiedTopicName.inputOrOutput.name());
      return copiedTopicName;
   }

   public ROS2TopicName output()
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.inputOrOutput = InputOrOutput.OUTPUT;
      copiedTopicName.topicNameInBuildOrder += processTopicNamePart(copiedTopicName.inputOrOutput.name());
      return copiedTopicName;
   }

   public ROS2TopicName setInputOrOutputForPublisher()
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      if (isRemote != null)
      {
         if (isRemote)
         {
            return copiedTopicName.input();
         }
         else
         {
            return copiedTopicName.output();
         }
      }

      return copiedTopicName;
   }

   public ROS2TopicName setInputOrOutputForSubscriber()
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      if (isRemote != null)
      {
         if (isRemote)
         {
            return copiedTopicName.output();
         }
         else
         {
            return copiedTopicName.input();
         }
      }

      return copiedTopicName;
   }

   // TODO Rename? Copy method?
   public ROS2TopicName setRemote(boolean isRemote)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.isRemote = isRemote;
      return copiedTopicName;
   }

   public ROS2TopicName type(Class<?> messageType)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.messageType = messageType;
      copiedTopicName.topicNameInBuildOrder += messageTypeToTopicNamePart(messageType);
      return copiedTopicName;
   }

   public ROS2TopicName name(String name)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.name = name;
      copiedTopicName.topicNameInBuildOrder += processTopicNamePart(name);
      return copiedTopicName;
   }

   @Override
   public String generateTopicName(Class<?> messageType)
   {
      return type(messageType).toString();
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
