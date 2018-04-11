package us.ihmc;

import org.junit.Test;
import ros_msgs.msg.dds.TwoNum;
import ros_msgs.msg.dds.TwoNumPubSubType;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;
import us.ihmc.ros2.IntraProcessRos2Node;
import us.ihmc.ros2.Ros2Node;
import us.ihmc.ros2.Ros2Publisher;
import us.ihmc.ros2.Ros2Subscription;

import java.io.IOException;

import static org.junit.Assert.*;

public class CommunicationTest
{
   int messagesReceived = 0;

   @Test(timeout = 30000)
   public void testSimpleIntraProcessCommunication()
   {
      try
      {
         Ros2Node node = new IntraProcessRos2Node("Ros2CommunicationTest");
         TwoNumPubSubType topicDataType = TwoNum.getPubSubType().get();
         Ros2Publisher<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

         SubscriberListener listener = new SubscriberListener()
         {
            TwoNum message = new TwoNum();

            @Override
            public void onNewDataMessage(Subscriber subscriber)
            {
               try
               {
                  System.out.println("Incoming message...");
                  if (subscriber.takeNextData(message, null))
                  {
                     System.out.println("Received: " + message.getStr1());
                     messagesReceived++;
                  }
               }
               catch (IOException e)
               {
                  e.printStackTrace();
               }
            }

            @Override
            public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
            {

            }
         };
         Ros2Subscription<TwoNum> subscription = node.createSubscription(topicDataType, listener, "/chatter");

         for (int i = 0; i < 11; i++)
         {
            TwoNum message = new TwoNum();
            message.getStr1().append("Hello world: " + i);
            System.out.println("Publishing: " + message.getStr1());
            publisher.publish(message);
            System.out.println("Published: " + message.getStr1());
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      assertEquals("10 messages not received", 10, messagesReceived);
   }
}
