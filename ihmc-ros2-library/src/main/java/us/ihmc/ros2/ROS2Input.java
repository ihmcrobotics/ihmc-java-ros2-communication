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

import us.ihmc.commons.thread.TypedNotification;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/**
 * An atomic reference to the latest received message through an optional filter.
 *
 * @param <T> messageType
 */
public class ROS2Input<T>
{
   private final AtomicReference<T> atomicReference;
   private final MessageFilter<T> messageFilter;
   private boolean hasReceivedFirstMessage = false;
   private final ROS2Callback<T> ros2Callback;
   private final TypedNotification<T> messageNotification = new TypedNotification<>();
   private final List<Consumer<T>> userCallbacks = new ArrayList<>();

   public ROS2Input(ROS2NodeInterface ros2Node, ROS2Topic<T> topic)
   {
      this(ros2Node, topic, ROS2TopicNameTools.newMessageInstance(topic.getType()), message -> true);
   }

   public ROS2Input(ROS2NodeInterface ros2Node, Class<T> messageType, ROS2Topic topicName)
   {
      this(ros2Node, messageType, topicName.withTypeName(messageType).toString());
   }

   public ROS2Input(ROS2NodeInterface ros2Node, Class<T> messageType, String topicName)
   {
      this(ros2Node, messageType, topicName, ROS2TopicNameTools.newMessageInstance(messageType), message -> true);
   }

   public ROS2Input(ROS2NodeInterface ros2Node, Class<T> messageType, ROS2Topic topicName, T initialValue, MessageFilter<T> messageFilter)
   {
      this(ros2Node, messageType, topicName.withTypeName(messageType).toString(), initialValue, messageFilter);
   }

   public ROS2Input(ROS2NodeInterface ros2Node, ROS2Topic<T> topic, T initialValue, MessageFilter<T> messageFilter)
   {
      this(ros2Node, topic.getType(), topic.getName(), initialValue, messageFilter);
   }

   public ROS2Input(ROS2NodeInterface ros2Node, Class<T> messageType, String topicName, T initialValue, MessageFilter<T> messageFilter)
   {
      atomicReference = new AtomicReference<>(initialValue);
      this.messageFilter = messageFilter;
      ros2Callback = new ROS2Callback<>(ros2Node, messageType, topicName, this::messageReceivedCallback);
   }

   public interface MessageFilter<T>
   {
      boolean accept(T message);
   }

   private void messageReceivedCallback(T incomingData)
   {
      if (messageFilter.accept(incomingData))
      {
         atomicReference.set(incomingData);
         messageNotification.set(incomingData);
         for (Consumer<T> userCallback : userCallbacks)
         {
            userCallback.accept(incomingData);
         }
         hasReceivedFirstMessage = true;
      }
   }

   public T getLatest()
   {
      return atomicReference.get();
   }

   public TypedNotification<T> getMessageNotification()
   {
      return messageNotification;
   }

   public boolean hasReceivedFirstMessage()
   {
      return hasReceivedFirstMessage;
   }

   public void setEnabled(boolean enabled)
   {
      ros2Callback.setEnabled(enabled);
   }

   public void addCallback(Consumer<T> messageReceivedCallback)
   {
      userCallbacks.add(messageReceivedCallback);
   }

   public void destroy()
   {
      ros2Callback.destroy();
   }
}
