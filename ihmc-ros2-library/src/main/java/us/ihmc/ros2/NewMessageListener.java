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

import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

@FunctionalInterface
public interface NewMessageListener<T> extends SubscriberListener<T>
{
   /**
    * Virtual function to be implemented by the user containing the actions to be performed when a new data message is received.
    *
    * @param subscriber
    */
   void onNewDataMessage(Subscriber<T> subscriber);

   default void onSubscriptionMatched(Subscriber<T> subscriber, MatchingInfo info)
   {
      // do nothing
   }
}
