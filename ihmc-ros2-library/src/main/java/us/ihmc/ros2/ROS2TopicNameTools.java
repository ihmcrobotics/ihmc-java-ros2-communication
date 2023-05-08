/*
 * Copyright 2023 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.ihmc.ros2;

import org.apache.commons.lang3.StringUtils;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.CommonAttributes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Helper class to convert from namespace and topic name to the correct DDS partition and topic for ROS 2 interoperability
 *
 * @author Jesper Smith
 */
public class ROS2TopicNameTools
{
   public static final String ROS_TOPIC_PREFIX = "rt";
   public static final String pubSubTypeGetterName = "getPubSubType";

   public static String removeMessageOrPacketSuffixFromTypeName(Class<?> messageType)
   {
      return removeMessageOrPacketSuffixFromTypeName(messageType.getSimpleName());
   }

   public static String removeMessageOrPacketSuffixFromTypeName(String simpleTypeName)
   {
      String suffixRemoved = simpleTypeName;
      suffixRemoved = StringUtils.removeEnd(suffixRemoved, "Packet"); // This makes BehaviorControlModePacket => BehaviorControlMode
      suffixRemoved = StringUtils.removeEnd(suffixRemoved, "Message"); // This makes ArmTrajectoryMessage => ArmTrajectory
      return suffixRemoved;
   }

   /**
    * Converts the given {@code String} from a camel-case convention to ROS topic name convention which
    * is lower-case with underscores.
    * <p>
    * This method in general behaves as from Guava:
    * {@code CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, camelCase)}. The only difference is
    * the handling of acronyms. For instance, given the {@code String} {@code "REAStatusMessage"}:
    * <ul>
    * <li>result from Guava: {@code "r_e_a_status_message"} which breaks the acronym 'REA'.
    * <li>result from this method: {@code "rea_status_message"} which conserves the acronym as one
    * word.
    * </p>
    *
    * @param pascalCased the camel-case {@code String} to be converted.
    * @return the converted {@code String} using lower-case with underscores.
    */
   public static String toROSTopicFormat(String pascalCased)
   {
      if (pascalCased == null)
      {
         return null;
      }

      pascalCased = pascalCased.trim();

      if (pascalCased.isEmpty())
      {
         return pascalCased;
      }

      if (pascalCased.length() == 1)
      {
         return pascalCased.toLowerCase();
      }

      StringBuilder stringBuilder = new StringBuilder();

      boolean isNewWord = true;
      boolean isPreviousUpper = false;

      for (int charIndex = 0; charIndex < pascalCased.length(); charIndex++)
      {
         boolean isCharUpper = Character.isUpperCase(pascalCased.charAt(charIndex));

         if (charIndex == 0 || !isCharUpper)
         {
            isNewWord = false;
         }
         else if (!isPreviousUpper)
         { // This is clearly the beginning of new word as the previous character is lower-case.
            isNewWord = true;
         }
         else
         { // This might still be an acronym.
            int nextIndex = charIndex + 1;
            boolean isNextUpper = nextIndex == pascalCased.length() || Character.isUpperCase(pascalCased.charAt(nextIndex));
            isNewWord = !isNextUpper; // If next is lower-case, this is clearly a new word, but otherwise we're going through an acronym.
         }

         isPreviousUpper = isCharUpper;

         if (isNewWord)
         {
            stringBuilder.append("_"); // Any new word but the first, starts with an underscore.
         }
         stringBuilder.append(Character.toLowerCase(pascalCased.charAt(charIndex)));
      }
      return stringBuilder.toString();
   }

   /* package-private */
   static void assignNameAndPartitionsToAttributes(CommonAttributes<?> attributes, String namespace, String nodeName, String topic, boolean avoidRosNamespace)
   {
      if (avoidRosNamespace)
      {
         attributes.topicName(topic);
         if (namespace != null && !namespace.isEmpty())
         {
            attributes.partitions(Arrays.asList(namespace));
         }
      }
      else
      {
         String fullyQualifiedName = getFullyQualifiedName(namespace, nodeName, topic);
         attributes.topicName(fullyQualifiedName);
      }
   }

   private static String getFullyQualifiedName(String namespace, String nodeName, String topic)
   {
      if (topic.startsWith("~/"))
      {
         topic = nodeName + topic.substring(1);
      }
      else if (topic.equals("~"))
      {
         topic = nodeName;
      }

      checkTopicName(topic);
      checkNamespace(namespace);
      checkNodename(nodeName);

      String fullyQualifiedName;
      if (topic.startsWith("/")) // Absolute path
      {
         fullyQualifiedName = ROS_TOPIC_PREFIX + topic;
      }
      else
      {
         fullyQualifiedName = ROS_TOPIC_PREFIX + namespace + "/" + topic;
      }

      return fullyQualifiedName;
   }

   static void checkNodename(String nodename)
   {
      if (nodename.isEmpty())
      {
         throw new RuntimeException("Invalid node name: node name must not be empty string");
      }
      if (nodename.matches("^.*[^a-zA-Z0-9_].*$"))
      {
         throw new RuntimeException("Invalid node name: node name must not contain characters other than alphanumerics and '_': " + nodename);
      }
   }

   static void checkNamespace(String namespace)
   {
      if (namespace.isEmpty())
      {
         return;
      }

      if (namespace.endsWith("/"))
      {
         throw new RuntimeException("Invalid namespace: namespace must not end with a forward slash: " + namespace);
      }

      if (!namespace.startsWith("/"))
      {
         throw new RuntimeException("Invalid namespace: namespace must start with a forward slash: " + namespace);
      }

      if (namespace.matches("^[0-9].*$"))
      {
         throw new RuntimeException("Invalid namespace: namespace token must not start with a number: " + namespace);
      }

      if (namespace.matches("^.*[^a-zA-Z0-9_/].*$"))
      {
         throw new RuntimeException("Invalid namespace: namespace must not contain characters other than alphanumerics, '_', '~': " + namespace);
      }
   }

   private static void checkTopicName(String topic)
   {
      if (topic.isEmpty())
      {
         throw new RuntimeException("Invalid topic name: topic name must not be empty string");
      }

      if (topic.contains("~"))
      {
         throw new RuntimeException(
               "Invalid topic name: topic name must not have tilde '~' unless it is the first character and followed by a slash '/': " + topic);
      }

      if (topic.endsWith("/"))
      {
         throw new RuntimeException("Invalid topic name: topic name must not end with a forward slash: " + topic);
      }

      if (topic.matches("^[0-9].*$"))
      {
         throw new RuntimeException("Invalid topic name: topic name token must not start with a number: " + topic);
      }

      if (topic.matches("^.*[^a-zA-Z0-9_/].*$"))
      {
         throw new RuntimeException("Invalid topic name: topic name must not contain characters other than alphanumerics, '_', '~': " + topic);
      }
   }

   public static <T> T newMessageInstance(Class<T> messageType)
   {
      try
      {
         return messageType.newInstance();
      }
      catch (InstantiationException | IllegalAccessException e)
      {
         throw new RuntimeException("Something went wrong when invoking " + messageType.getSimpleName() + "'s empty constructor.", e);
      }
   }

   @SuppressWarnings({"unchecked", "rawtypes"})
   public static <T> TopicDataType<T> newMessageTopicDataTypeInstance(Class<T> messageType)
   {
      Method pubSubTypeGetter;

      try
      {
         pubSubTypeGetter = messageType.getDeclaredMethod(pubSubTypeGetterName);
      }
      catch (NoSuchMethodException | SecurityException e)
      {
         throw new RuntimeException("Something went wrong when looking up for the method " + messageType.getSimpleName() + "." + pubSubTypeGetterName + "().",
                                    e);
      }

      TopicDataType<T> topicDataType;

      try
      {
         topicDataType = (TopicDataType<T>) ((Supplier) pubSubTypeGetter.invoke(newMessageInstance(messageType))).get();
      }
      catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
      {
         throw new RuntimeException("Something went wrong when invoking the method " + messageType.getSimpleName() + "." + pubSubTypeGetterName + "().", e);
      }
      return topicDataType;
   }

   public static String messageTypeToTopicNamePart(Class<?> messageType)
   {
      if (messageType == null)
      {
         return "";
      }

      String messageTypePart = removeMessageOrPacketSuffixFromTypeName(messageType);
      // This makes ArmTrajectory => arm_trajectory & handle acronyms as follows: REAStateRequest => rea_state_request
      return processTopicNamePart(toROSTopicFormat(messageTypePart));
   }

   public static String processTopicNamePart(String string)
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
         string = "/" + string;
      }

      return string;
   }

   public static String titleCasedToUnderscoreCased(String titleCased)
   {
      return titleCased.trim().toLowerCase().replaceAll("\\s+", "_");
   }
}
