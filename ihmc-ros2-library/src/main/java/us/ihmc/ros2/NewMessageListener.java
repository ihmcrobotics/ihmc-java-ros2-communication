package us.ihmc.ros2;

import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

@FunctionalInterface
public interface NewMessageListener extends SubscriberListener
{
   /**
    * Virtual function to be implemented by the user containing the actions to be performed when a new Data Message is received
    *
    * @param subscriber
    */
   public void onNewDataMessage(Subscriber subscriber);

   public default void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
   {
      // do nothing
   }
}
