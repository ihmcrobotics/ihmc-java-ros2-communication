package us.ihmc.ros2;

import org.apache.commons.lang3.StringUtils;

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

      return new ROS2TopicName(this);
   }

   public ROS2TopicName robot(String robotName)
   {
      this.robotName = robotName;

      return new ROS2TopicName(this);
   }

   public ROS2TopicName module(String moduleName)
   {
      this.moduleName = moduleName;

      return new ROS2TopicName(this);
   }

   public ROS2TopicName input()
   {
      inputOrOutput = InputOrOutput.INPUT;

      return new ROS2TopicName(this);
   }

   public ROS2TopicName output()
   {
      inputOrOutput = InputOrOutput.OUTPUT;

      return new ROS2TopicName(this);
   }

   public ROS2TopicName type(Class<?> messageType)
   {
      this.messageType = messageType;

      return new ROS2TopicName(this);
   }

   public ROS2TopicName name(String titleCasedName)
   {
      this.name = titleCasedName;

      return new ROS2TopicName(this);
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

      String messageTypePart = messageType.getSimpleName();
      messageTypePart = StringUtils.removeEnd(messageTypePart, "Packet"); // This makes BehaviorControlModePacket => BehaviorControlMode
      messageTypePart = StringUtils.removeEnd(messageTypePart, "Message"); // This makes ArmTrajectoryMessage => ArmTrajectory
      // This makes ArmTrajectory => arm_trajectory & handle acronyms as follows: REAStateRequest => rea_state_request
      topicName += processTopicNamePart(ROS2TopicNameTools.toROSTopicFormat(messageTypePart));

      topicName += processTopicNamePart(name);

      return topicName;
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
}
