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

import java.io.IOException;

import std_msgs.msg.dds.StringPubSubType;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;
import us.ihmc.ros2.NonRealtimeRos2Node;

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
public class Ros2ListenerExample
{
   public static void main(String[] args) throws IOException, InterruptedException
   {
      StringPubSubType type = new StringPubSubType();
      NonRealtimeRos2Node node = new NonRealtimeRos2Node(PubSubImplementation.FAST_RTPS, "Ros2ListenerExample");
      node.createSubscription(type, subscriber -> {
         std_msgs.msg.dds.String data = new std_msgs.msg.dds.String();
         try
         {
            if (subscriber.takeNextData(data, null))
            {
               System.out.println(data.getDataAsString());
            }
         }
         catch (IOException e)
         {
            e.printStackTrace();
         }
      }, "/chatter");

      Thread.currentThread().join();
   }
}
