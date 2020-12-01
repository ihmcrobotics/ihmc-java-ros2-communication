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

import java.io.IOException;

import us.ihmc.concurrent.ConcurrentRingBuffer;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.publisher.Publisher;

/**
 * Publisher Node safe to use in a realtime thread
 * 
 * This publisher uses a queue to buffer messages till the next spin. Lockless synchronization is used for the queue.
 * 
 * @author Jesper Smith
 *
 * @param <T> Data type to publish
 */
public class RealtimeROS2Publisher<T> implements ROS2PublisherBasics<T>
{
   private final TopicDataType<T> topicDataType;
   private final ROS2Publisher<T> rosPublisher;
   
   private final ConcurrentRingBuffer<T> concurrentRingBuffer;
   
   RealtimeROS2Publisher(TopicDataType<T> topicDataType, ROS2Publisher<T> rosPublisher, int queueDepth)
   {
      this.topicDataType = topicDataType.newInstance();
      this.rosPublisher = rosPublisher;
      concurrentRingBuffer = new ConcurrentRingBuffer<>(topicDataType::createData, queueDepth);
   }
   
   /**
    * Put new data in the queue to be published on the next spin
    * 
    * This function does not block and is realtime-safe.
    * 
    * @param data Data to publish
    * @return true if there was space in the queue, false if no space is left.
    */
   @Override
   public boolean publish(T data)
   {
      T next = concurrentRingBuffer.next();
      if(next != null)
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
      if(concurrentRingBuffer.poll())
      {
         T next;
         while((next = concurrentRingBuffer.read()) != null)
         {
            try
            {
               rosPublisher.publish(next);
            }
            catch (IOException e)
            {
               e.printStackTrace();
            }
         }
         concurrentRingBuffer.flush();
      }
   }

   @Override
   public void remove()
   {
      // Remove not necessarily defined for a realtime node
   }

   /**
    * Get the pub sub publisher
    * @return publisher
    */
   public Publisher getPublisher()
   {
      return rosPublisher.getPublisher();
   }
}
