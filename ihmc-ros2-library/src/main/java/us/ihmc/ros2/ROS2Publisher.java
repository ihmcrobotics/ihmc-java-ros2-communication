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

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.publisher.Publisher;

import java.io.IOException;

/**
 * A ROS 2 compatible publisher
 *
 * @param <T> the data type
 */
public class ROS2Publisher<T> implements ROS2PublisherBasics<T>
{
   private final Domain domain;
   private final Publisher publisher;

   ROS2Publisher(Domain domain, Publisher publisher)
   {
      this.domain = domain;
      this.publisher = publisher;
   }

   @Override
   public boolean publish(T data)
   {
      try
      {
         if (publisher.isAvailable())
         {
            publisher.write(data);
            return true;
         }
         else
         {
            return false;
         }
      }
      catch (IOException e)
      {
         return false;
      }
   }

   @Override
   public void remove()
   {
      domain.removePublisher(publisher);
   }

   Publisher getPublisher()
   {
      return publisher;
   }

   Domain getDomain()
   {
      return domain;
   }
}
