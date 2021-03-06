package us.ihmc.ros2;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ros_msgs.msg.dds.TwoNum;
import ros_msgs.msg.dds.TwoNumPubSubType;
import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.util.PeriodicNonRealtimeThreadScheduler;

import java.time.Duration;

public class CommunicationTest
{
   @Test// timeout = 5000
   public void testSimpleIntraProcessCommunication()
   {
      testSimpleCommunication(PubSubImplementation.INTRAPROCESS, null);
   }

   @Test// timeout = 5000
   public void testSimpleRealRTPSCommunicationDefaultRosVersion()
   {
      testSimpleCommunication(PubSubImplementation.FAST_RTPS, null);
   }

   @Test// timeout = 5000
   public void testSimpleRealRTPSCommunicationArdent()
   {
      testSimpleCommunication(PubSubImplementation.FAST_RTPS, ROS2Distro.ARDENT);
   }

   @Test// timeout = 5000
   public void testSimpleRealRTPSCommunicationBouncy()
   {
      testSimpleCommunication(PubSubImplementation.FAST_RTPS, ROS2Distro.BOUNCY);
   }

   private void testSimpleCommunication(PubSubImplementation pubSubImplementation, ROS2Distro ros2Distro)
   {
      Assertions.assertTimeoutPreemptively(Duration.ofSeconds(5), () ->
      {
         Pair<Integer, Integer> messagesReceived = new MutablePair<>();
         try
         {
            String name = "ROS2CommunicationTest";
            ROS2Node node = ros2Distro == null ? new ROS2Node(pubSubImplementation, name) : new ROS2Node(pubSubImplementation, ros2Distro, name);
            TwoNumPubSubType topicDataType = new TwoNumPubSubType();
            ROS2Publisher<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

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
      });
   }

   @Test// timeout = 5000
   public void testSimpleRealRTPSCommunicationAndDestroy()
   {
      Assertions.assertTimeoutPreemptively(Duration.ofSeconds(5), ()->
      {
         Pair<Integer, Integer> messagesReceived = new MutablePair<>();
         try
         {
            ROS2Node node = new ROS2Node(PubSubImplementation.FAST_RTPS, "ROS2CommunicationTest");
            TwoNumPubSubType topicDataType = new TwoNumPubSubType();
            ROS2Publisher<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

            messagesReceived.setValue(0);

            node.createSubscription(topicDataType, subscriber ->
            {
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

            ThreadTools.sleepSeconds(1.0);

            node.destroy();
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }

         while (messagesReceived.getValue() < 5)
            Thread.yield();
      });
   }

   @Test// timeout = 5000
   public void testSimpleIntraProcessCommunicationRealtime()
   {
      Assertions.assertTimeoutPreemptively(Duration.ofSeconds(5), ()->
      {
         Pair<Integer, Integer> messagesReceived = new MutablePair<>();
         try
         {
            RealtimeROS2Node node = new RealtimeROS2Node(PubSubImplementation.INTRAPROCESS, PeriodicNonRealtimeThreadScheduler::new, "ROS2CommunicationTest",
                                                         "/us/ihmc");
            TwoNumPubSubType topicDataType = new TwoNumPubSubType();
            RealtimeROS2Publisher<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

            messagesReceived.setValue(0);

            RealtimeROS2Subscription<TwoNum> subscription = node.createQueuedSubscription(topicDataType, "/chatter");

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
      });
   }
}
