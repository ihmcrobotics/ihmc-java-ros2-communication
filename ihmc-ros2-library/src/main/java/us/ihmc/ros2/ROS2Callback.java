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

import us.ihmc.commons.exception.DefaultExceptionHandler;
import us.ihmc.commons.exception.ExceptionTools;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.util.function.Consumer;

/**
 * Callback listener to non-null reception of a message on a ROS 2 topic.
 *
 * @param <T> messageType
 */
public class ROS2Callback<T>
{
   private final Consumer<T> messageCallback;
   private ROS2Subscription<T> subscription;
   private volatile boolean enabled = true;

   public ROS2Callback(ROS2NodeInterface ros2Node, ROS2Topic<T> topicName, Consumer<T> messageCallback)
   {
      this(ros2Node, topicName.getType(), topicName, messageCallback);
   }

   public ROS2Callback(ROS2NodeInterface ros2Node, Class<T> messageType, ROS2Topic topicName, Consumer<T> messageCallback)
   {
      this(ros2Node, messageType, topicName.withTypeName(messageType).toString(), messageCallback);
   }

   public ROS2Callback(ROS2NodeInterface ros2Node, Class<T> messageType, String topicName, Consumer<T> messageCallback)
   {
      this.messageCallback = messageCallback;
      ExceptionTools.handle(() ->
      {
       subscription = ros2Node.createSubscription(ROS2TopicNameTools.newMessageTopicDataTypeInstance(messageType), this::nullOmissionCallback, topicName);
      }, DefaultExceptionHandler.RUNTIME_EXCEPTION);
   }

   private void nullOmissionCallback(Subscriber<T> subscriber)
   {
      if (enabled)
      {
         T incomingData = subscriber.takeNextData();
         if (incomingData != null)
         {
            messageCallback.accept(incomingData);
         }
         else
         {
            LogTools.warn("Received null from takeNextData()");
         }
      }
   }

   public void setEnabled(boolean enabled)
   {
      this.enabled = enabled;
   }

   public void destroy()
   {
      setEnabled(false);

      if (subscription != null)
      {
         subscription.remove();
      }
   }
}
