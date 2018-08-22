package us.ihmc.ros2.example;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import ros_msgs.msg.dds.TwoNum;
import ros_msgs.msg.dds.TwoNumPubSubType;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.ros2.*;
import us.ihmc.util.PeriodicNonRealtimeThreadScheduler;

public class CommunicationTest
{
   @Test(timeout = 5000)
   public void testSimpleIntraProcessCommunication()
   {
      testSimpleCommunication(PubSubImplementation.INTRAPROCESS, null);
   }

   @Test(timeout = 5000)
   public void testSimpleRealRTPSCommunicationDefaultRosVersion()
   {
      testSimpleCommunication(PubSubImplementation.FAST_RTPS, null);
   }

   @Test(timeout = 5000)
   public void testSimpleRealRTPSCommunicationArdent()
   {
      testSimpleCommunication(PubSubImplementation.FAST_RTPS, Ros2Distro.ARDENT);
   }

   @Test(timeout = 5000)
   public void testSimpleRealRTPSCommunicationBouncy()
   {
      testSimpleCommunication(PubSubImplementation.FAST_RTPS, Ros2Distro.BOUNCY);
   }

   private void testSimpleCommunication(PubSubImplementation pubSubImplementation, Ros2Distro ros2Distro)
   {
      Pair<Integer, Integer> messagesReceived = new MutablePair<>();
      try
      {
         String name = "Ros2CommunicationTest";
         Ros2Node node = ros2Distro == null ? new Ros2Node(pubSubImplementation, name) : new Ros2Node(pubSubImplementation, ros2Distro, name);
         TwoNumPubSubType topicDataType = new TwoNumPubSubType();
         Ros2Publisher<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

         messagesReceived.setValue(0);

         node.createSubscription(topicDataType, subscriber -> {
            TwoNum message = new TwoNum();
            System.out.println("Incoming message...");
            if (subscriber.takeNextData(message, null))
            {
               System.out.println("Received: " + message.getStr1());
               messagesReceived.setValue(messagesReceived.getValue() + 1);
            }
         }, "/chatter");

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

      while (messagesReceived.getValue() < 5)
         Thread.yield();
   }

   @Test(timeout = 5000)
   public void testSimpleRealRTPSCommunicationAndDestroy()
   {
      Pair<Integer, Integer> messagesReceived = new MutablePair<>();
      try
      {
         Ros2Node node = new Ros2Node(PubSubImplementation.FAST_RTPS, "Ros2CommunicationTest");
         TwoNumPubSubType topicDataType = new TwoNumPubSubType();
         Ros2Publisher<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

         messagesReceived.setValue(0);

         node.createSubscription(topicDataType, subscriber -> {
            TwoNum message = new TwoNum();
            System.out.println("Incoming message...");
            if (subscriber.takeNextData(message, null))
            {
               System.out.println("Received: " + message.getStr1());
               messagesReceived.setValue(messagesReceived.getValue() + 1);
            }
         }, "/chatter");

         for (int i = 0; i < 11; i++)
         {
            TwoNum message = new TwoNum();
            message.getStr1().append("Hello world: " + i);
            System.out.println("Publishing: " + message.getStr1());
            publisher.publish(message);
            System.out.println("Published: " + message.getStr1());
         }

         node.destroy();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      while (messagesReceived.getValue() < 5)
         Thread.yield();
   }

   @Test(timeout = 5000)
   public void testSimpleIntraProcessCommunicationRealtime()
   {
      Pair<Integer, Integer> messagesReceived = new MutablePair<>();
      try
      {
         RealtimeRos2Node node = new RealtimeRos2Node(PubSubImplementation.INTRAPROCESS, PeriodicNonRealtimeThreadScheduler::new, "Ros2CommunicationTest",
                                                      "/us/ihmc");
         TwoNumPubSubType topicDataType = new TwoNumPubSubType();
         RealtimeRos2Publisher<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

         messagesReceived.setValue(0);

         RealtimeRos2Subscription<TwoNum> subscription = node.createQueuedSubscription(topicDataType, "/chatter");

         node.spin();

         for (int i = 0; i < 11; i++)
         {
            TwoNum message = new TwoNum();
            message.getStr1().append("Hello world: " + i);
            System.out.println("Publishing: " + message.getStr1());
            boolean success = publisher.publish(message);
            System.out.println("Published: success: " + success + " content: " + message.getStr1());
         }

         TwoNum incomingMessage = new TwoNum();
         while (!subscription.poll(incomingMessage))
            ;
         System.out.println("Received: " + incomingMessage.getStr1());
         messagesReceived.setValue(messagesReceived.getValue() + 1);

         while (messagesReceived.getValue() < 10)
         {
            boolean pollSuccess = subscription.poll(incomingMessage);
            if (pollSuccess)
            {
               System.out.println("Received: " + incomingMessage.getStr1());
               messagesReceived.setValue(messagesReceived.getValue() + 1);
            }
            else
            {
               System.out.println("No messages in queue.");
            }
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
