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
 * Realtime-safe implementation of a ROS2 subscriber.
 * 
 * Incoming messages are stored in a queue and can be polled in a non-blocking manner.
 * 
 * @author Jesper Smith
 *
 * @param <T> data type
 */
public class RealtimeROS2Subscription<T> extends QueuedROS2Subscription<T>
{
   RealtimeROS2Subscription(RealtimeROS2SubscriptionListener<T> listener)
   {
      super(listener);
   }

   @Override
   public void remove()
   {
      // It might not make sense to do anything here. Just here to comply with the interface
   }
}
