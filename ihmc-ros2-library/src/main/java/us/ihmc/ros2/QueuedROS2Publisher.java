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

import us.ihmc.concurrent.ConcurrentRingBuffer;
import us.ihmc.pubsub.TopicDataType;

/**
 * Publisher Node safe for use in a realtime thread. This publisher uses a queue to buffer messages
 * until the next spin. Lockless synchronization is used for the queue.
 *
 * @author Jesper Smith
 * @param <T> the data type to publish
 */
public class QueuedROS2Publisher<T> extends ROS2Publisher<T>
{
   private final TopicDataType<T> topicDataType;

   private final ConcurrentRingBuffer<T> concurrentRingBuffer;

   QueuedROS2Publisher(TopicDataType<T> topicDataType, ROS2Publisher<T> rosPublisher, int queueDepth)
   {
      super(rosPublisher.getDomain(), rosPublisher.getPublisher());

      this.topicDataType = topicDataType.newInstance();
      concurrentRingBuffer = new ConcurrentRingBuffer<>(topicDataType::createData, queueDepth);
   }

   /**
    * Put new data in the queue to be published on the next spin This function does not block and is
    * realtime-safe.
    *
    * @param data data to publish
    * @return true if there was space in the queue, false if no space is left
    */
   @Override
   public boolean publish(T data)
   {
      T next = concurrentRingBuffer.next();
      if (next != null)
      {
         topicDataType.copy(data, next);
         concurrentRingBuffer.commit();
         return true;
      }
      else
      {
         return false;
      }
   }

   void spin()
   {
      if (concurrentRingBuffer.poll())
      {
         T next;
         while ((next = concurrentRingBuffer.read()) != null)
         {
            super.publish(next);
         }
         concurrentRingBuffer.flush();
      }
   }

   @Override
   public void remove()
   {
      // Remove not necessarily defined for a realtime node
   }
}
