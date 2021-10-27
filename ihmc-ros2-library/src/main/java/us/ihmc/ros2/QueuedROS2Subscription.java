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

/**
 * Incoming messages are stored in a queue and can be polled in a non-blocking manner.
 *
 * @param <T> data type
 */
public class QueuedROS2Subscription<T> extends ROS2Subscription<T> implements RealtimeROS2Subscription<T>
{
   private final RealtimeROS2SubscriptionListener<T> listener;
   private final ROS2Subscription<T> subscriber;

   QueuedROS2Subscription(RealtimeROS2SubscriptionListener<T> listener)
   {
      this(null, listener);
   }

   QueuedROS2Subscription(ROS2Subscription<T> subscriber, RealtimeROS2SubscriptionListener<T> listener)
   {
      super(null, null);
      this.subscriber = subscriber;
      this.listener = listener;
   }

   /**
    * Get the next message in the queue. After calling this function the message is removed from the
    * queue. This function does not block and is realtime-safe.
    * 
    * @param data Object to store the data in if data is available. If no data is available this object
    *             does not get modified
    * @return True if a new message was available, false otherwise
    */
   public boolean poll(T data)
   {
      return listener.poll(data);
   }

   /**
    * Get the latest message in the queue and discard all others. After calling this function the queue
    * is empty. This function does not block and is realtime-safe.
    * 
    * @param data Object to store the data in if data is available. If no data is available this object
    *             does not get modified
    * @return True if a new message was available, false otherwise
    */
   public boolean flushAndGetLatest(T data)
   {
      return listener.flushAndGetLatest(data);
   }

   /**
    * Remove this subscription from the domain
    */
   @Override
   public void remove()
   {
      subscriber.remove();
   }
}
