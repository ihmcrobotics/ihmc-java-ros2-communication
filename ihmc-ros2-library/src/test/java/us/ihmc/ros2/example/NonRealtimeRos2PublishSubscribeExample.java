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
package us.ihmc.ros2.example;

import std_msgs.msg.dds.Int64;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.ros2.Ros2Node;
import us.ihmc.ros2.Ros2Publisher;

import java.io.IOException;

/**
 * Java version of the ROS2 demo listener.
 * 
 * To test, start a ROS2 talker using 
 * 
 *    ros2 run demo_nodes_cpp talker -- -t chatter
 * 
 * @author Jesper Smith
 *
 */
public class NonRealtimeRos2PublishSubscribeExample
{
   public static void main(String[] args) throws IOException, InterruptedException
   {
      Ros2Node node = new Ros2Node(PubSubImplementation.FAST_RTPS, "NonRealtimeRos2PublishSubscribeExample");
      node.createSubscription(Int64.getPubSubType().get(), subscriber -> {
         Int64 message = new Int64();
         try
         {
            if (subscriber.takeNextData(message, null))
            {
               System.out.println(message.getData());
            }
         }
         catch (IOException e)
         {
            // something bad happened
         }
      }, "/example");

      Ros2Publisher<Int64> publisher = node.createPublisher(Int64.getPubSubType().get(), "/example");
      Int64 message = new Int64();
      for (int i = 0; i < 10; i++)
      {
         message.setData(i);
         publisher.publish(message);
         Thread.sleep(1000);
      }

      Thread.currentThread().join(); // keep thread alive to receive more messages
   }
}
