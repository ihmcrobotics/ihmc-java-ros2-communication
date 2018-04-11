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

import std_msgs.msg.dds.String;
import std_msgs.msg.dds.StringPubSubType;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.ros2.NonRealtimeRos2Node;
import us.ihmc.ros2.Ros2Publisher;

/**
 * Java version of the ROS2 demo talker.
 * 
 * To test, start a ROS2 listener using 
 * 
 *    ros2 run demo_nodes_cpp listener -- -t chatter
 * 
 * @author Jesper Smith
 *
 */
public class Ros2TalkerExample
{
   public static void main(String[] args) throws IOException, InterruptedException
   {
      StringPubSubType type = new StringPubSubType();
      NonRealtimeRos2Node node = new NonRealtimeRos2Node(PubSubImplementation.FAST_RTPS, "Ros2TalkerExample");
      Ros2Publisher<String> publisher = node.createPublisher(type, "/chatter");
      
      for(int i = 0; true; i++)
      {
         std_msgs.msg.dds.String data = new std_msgs.msg.dds.String();
         data.getData().append("Hello world: " + i);
         System.out.println("Publishing: " +data.toString());
         publisher.publish(data);
         Thread.sleep(1000);
      }      
   }
}
