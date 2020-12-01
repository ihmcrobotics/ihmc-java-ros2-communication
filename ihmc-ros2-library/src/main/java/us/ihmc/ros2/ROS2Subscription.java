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

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.subscriber.Subscriber;

/**
 * Simple ROS2 compatible subscription
 * 
 * @author Jesper Smith
 *
 * @param <T> Data type of this subscriber
 */
public class ROS2Subscription<T>
{
   private final Domain domain;
   private final Subscriber<T> subscriber;
   
   ROS2Subscription(Domain domain, Subscriber<T> subscriber)
   {
      this.domain = domain;
      this.subscriber = subscriber;
   }
   
   /**
    * Remove this subscription from the domain
    */
   public void remove()
   {
      domain.removeSubscriber(subscriber);
   }

   /**
    * Get the pub sub subscriber.
    *
    * @return low level subscriber
    */
   public Subscriber<T> getSubscriber()
   {
      return subscriber;
   }
}
