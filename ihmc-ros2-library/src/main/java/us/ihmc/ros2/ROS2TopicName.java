package us.ihmc.ros2;

import java.util.ArrayList;
import java.util.Objects;

import static us.ihmc.ros2.ROS2TopicQualifier.INPUT;
import static us.ihmc.ros2.ROS2TopicQualifier.OUTPUT;

public class ROS2TopicName
{
   private final ArrayList<String> prefixes = new ArrayList<>();
   private String robotName;
   private String moduleName;
   private ROS2TopicQualifier inputOrOutput;
   private Class<?> messageType;
   private String name;
   private Boolean isRemote = null; // can be used by pub/sub creators to set input/output

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
      this.isRemote = topicNameToCopy.isRemote;
   }

   public ROS2TopicName prefix(String prefix)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.prefixes.add(prefix);
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

   public ROS2TopicName input()
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.inputOrOutput = INPUT;
      return copiedTopicName;
   }

   public ROS2TopicName output()
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.inputOrOutput = OUTPUT;
      return copiedTopicName;
   }

   public ROS2TopicName qualifier(ROS2TopicQualifier qualifier)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      if (qualifier == null)
      {
         copiedTopicName.inputOrOutput = null;
      }
      else if (qualifier.equals(INPUT))
      {
         copiedTopicName.inputOrOutput = INPUT;
      }
      else // OUTPUT
      {
         copiedTopicName.inputOrOutput = OUTPUT;
      }
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

   /**
    * This method allows the {@link #setInputOrOutputForPublisher} and {@link #setInputOrOutputForSubscriber}
    * methods to work. When either of those two methods are called, "/input" or "/output" will be added
    * to this topic name accordingly.
    *
    * This framework allows for createSubscriber and createPublisher tools to call
    * {@link #setInputOrOutputForPublisher} and {@link #setInputOrOutputForSubscriber}
    * thus reducing the chance of error in setting {@link #input} or {@link #output} manually.
    *
    * TODO Rename?
    *
    * @param isRemote
    * @return
    */
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
      return copiedTopicName;
   }

   public ROS2TopicName name(String name)
   {
      ROS2TopicName copiedTopicName = copyOfThis();
      copiedTopicName.name = name;
      return copiedTopicName;
   }

   public String generateTopicName(Class<?> messageType)
   {
      return type(messageType).toString();
   }

   public Boolean isRemote()
   {
      return isRemote;
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

   @Override
   public boolean equals(Object other)
   {
      if (this == other)
         return true;
      if (other == null || getClass() != other.getClass())
         return false;
      ROS2TopicName topicName = (ROS2TopicName) other;
      return prefixes.equals(topicName.prefixes)
             && Objects.equals(robotName, topicName.robotName)
             && Objects.equals(moduleName, topicName.moduleName)
             && inputOrOutput == topicName.inputOrOutput
             && Objects.equals(messageType, topicName.messageType)
             && Objects.equals(name, topicName.name)
             && Objects.equals(isRemote, topicName.isRemote);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(prefixes, robotName, moduleName, inputOrOutput, messageType, name, isRemote);
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
