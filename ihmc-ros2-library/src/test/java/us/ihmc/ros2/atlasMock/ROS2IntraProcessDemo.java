package us.ihmc.ros2.atlasMock;

import controller_msgs.msg.dds.RobotConfigurationData;
import controller_msgs.msg.dds.RobotConfigurationDataPubSubType;
import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.ros2.IntraProcessNode;
import us.ihmc.ros2.RosPublisher;

import java.io.IOException;

public class ROS2IntraProcessDemo
{
   public static void publishUsingIntraProcessNode()
   {
      try
      {
         IntraProcessNode node = new IntraProcessNode("MockAtlasController");
         //      RosPublisher<AtlasRobotConfigurationData> publisher = node.createPublisher(new AtlasRobotConfigurationDataPubSubType(), "/robot_configuration_data");
         RosPublisher<RobotConfigurationData> publisher = node.createPublisher(new RobotConfigurationDataPubSubType(), "/robot_configuration_data");

         for (int i = 0; true; i++)
         {
            //         AtlasRobotConfigurationData robotConfigurationData = new AtlasRobotConfigurationData();
            RobotConfigurationData robotConfigurationData = new RobotConfigurationData();

            robotConfigurationData.getHeader().getStamp().setNanosec(i);
            //         robotConfigurationData.setTimestamp(i);
            System.out.println("Publishing: " + i);
            publisher.publish(robotConfigurationData);
            Thread.sleep(1000);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public static void subscribeUsingIntraProcessNode() throws IOException, InterruptedException
   {

      IntraProcessNode node = new IntraProcessNode("MockNetworkProcessor");
      //      node.createSubscription(new AtlasRobotConfigurationDataPubSubType(), new Callback(), "/robot_configuration_data");
      node.createSubscription(new RobotConfigurationDataPubSubType(), new MockNetworkProcessor.Callback(), "/robot_configuration_data");
      Thread.currentThread().join();
   }

   public static void main(String[] args) throws IOException, InterruptedException
   {
      ThreadTools.startAThread(() -> publishUsingIntraProcessNode(), "publisher");
      subscribeUsingIntraProcessNode();
   }
}
