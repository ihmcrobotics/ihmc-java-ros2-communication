/*
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
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

import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;

/**
 * Helper class to convert from namespace and topic name to the correct DDS partition and topic for ROS2 interoperbility
 * 
 * @author Jesper Smith
 *
 */
class Ros2TopicNameMangler
{
   public static final String ros_topic_prefix = "rt";
   public static final String ros_service_request_prefix = "rq";
   public static final String ros_service_response_prefix = "rq";

   static void assignNameAndPartitionsToAttributes(PublisherAttributes attributes, String namespace, String nodeName, String topic, boolean avoidRosNamespace)
   {
      if(avoidRosNamespace)
      {
         attributes.getTopic().setTopicName(topic);
         if(namespace != null && !namespace.isEmpty())
         {
            attributes.getQos().addPartition(namespace);
         }
      }
      else
      {
         String fqn = getFQN(namespace, nodeName, topic);
         attributes.getTopic().setTopicName(fqn);
      }
   }

   static void assignNameAndPartitionsToAttributes(SubscriberAttributes attributes, String namespace, String nodeName, String topic, boolean avoidRosNamespace)
   {
      if(avoidRosNamespace)
      {
         attributes.getTopic().setTopicName(topic);
         if(namespace != null && !namespace.isEmpty())
         {
            attributes.getQos().addPartition(namespace);
         }
      }
      else
      {
         String fqn = getFQN(namespace, nodeName, topic);
         attributes.getTopic().setTopicName(fqn);
      }
   }

   private static String getFQN(String namespace, String nodeName, String topic)
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

      String fqn;
      if (topic.startsWith("/")) // Absolute path
      {
         fqn = ros_topic_prefix + topic;
      }
      else
      {
         fqn = ros_topic_prefix + namespace + "/" + topic;
      }

      return fqn;
   }

   static void checkNodename(String nodename)
   {
      if (nodename.isEmpty())
      {
         throw new RuntimeException("Invalid node name: node name must not be empty string");
      }
      if (nodename.matches("^.*[^a-zA-Z0-9_].*$"))
      {
         throw new RuntimeException("Invalid node name: node name must not contain characters other than alphanumericsand '_': " + nodename);
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
         throw new RuntimeException("Invalid topic name: topic name must not have tilde '~' unless it is the first character and followed by a slash '/': "
               + topic);
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

}
