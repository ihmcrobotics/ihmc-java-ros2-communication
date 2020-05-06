package us.ihmc.ros2;

import com.google.common.base.CaseFormat;
import org.junit.jupiter.api.Test;
import std_msgs.msg.dds.Int8;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ROS2TopicNameTest
{
   class ExampleTypePacket
   {

   }

   class ExampleTypeMessage
   {

   }

   @Test
   public void testEqualsAndHash()
   {
      ROS2TopicName topicName1 = new ROS2TopicName().prefix("ihmc");
      ROS2TopicName topicName2 = new ROS2TopicName().prefix("ihmc");

      assertEquals(topicName1, topicName2);

      HashMap<ROS2TopicName, Object> map = new HashMap<>();
      map.put(topicName1, null);
      map.put(topicName2, null);

      assertEquals(1, map.size());
   }

   @Test
   public void testROS2TopicName()
   {
      ROS2TopicName topicName = new ROS2TopicName().prefix("ihmc").robot("atlas").module("rea").input().type(ExampleTypeMessage.class).name("one");
      assertEquals("/ihmc/atlas/rea/input/example_type/one", topicName.toString());

      ROS2TopicName ihmcPrefixed = new ROS2TopicName().prefix("ihmc");
      assertEquals("/ihmc", ihmcPrefixed.toString());
      ihmcPrefixed.module("hello");
      ihmcPrefixed.robot("robot_one");
      ihmcPrefixed.type(Int8.class);
      ihmcPrefixed.name("meow");
      ihmcPrefixed.input();
      ihmcPrefixed.output();
      assertEquals("/ihmc", ihmcPrefixed.toString());

      ROS2TopicName ihmcPrefixed2 = new ROS2TopicName().prefix("ihmc");
      assertEquals("/ihmc", ihmcPrefixed2.toString());
      ROS2TopicName hello = ihmcPrefixed2.module("hello");
      ROS2TopicName robotOne = hello.robot("robot_one");
      ROS2TopicName remote = robotOne.setRemote(true);
      ROS2TopicName int8 = remote.type(Int8.class);
      ROS2TopicName meow = int8.name("meow");
      ROS2TopicName input = meow.input();
      ROS2TopicName output = input.output();

      assertEquals("/ihmc/hello", hello.toString());
      assertNull(hello.isRemote());
      assertEquals("/ihmc/robot_one/hello", robotOne.toString());
      assertNull(robotOne.isRemote());
      assertEquals("/ihmc/robot_one/hello", remote.toString());
      assertTrue(remote.isRemote());
      assertEquals("/ihmc/robot_one/hello/int8", int8.toString());
      assertTrue(int8.isRemote());
      assertEquals("/ihmc/robot_one/hello/int8/meow", meow.toString());
      assertEquals("/ihmc/robot_one/hello/input/int8/meow", input.toString());
      assertEquals("/ihmc/robot_one/hello/output/int8/meow", output.toString());
      assertEquals("/ihmc/robot_one/hello/input/int8/meow", input.qualifier(ROS2TopicQualifier.INPUT).toString());
      assertEquals("/ihmc/robot_one/hello/output/int8/meow", input.qualifier(ROS2TopicQualifier.OUTPUT).toString());
      assertEquals("/ihmc/robot_one/hello/int8/meow", input.qualifier(null).toString());

      assertEquals("/ihmc", output.module(null).robot(null).type(null).name(null).qualifier(null).toString());
   }

   @Test
   void testToROSTopicFormat()
   {
      compareAgainstGuava("", "");
      compareAgainstGuava("a", "a");
      compareAgainstGuava("a", "A");
      compareAgainstGuava("arm_trajectory", "ArmTrajectory");
      compareAgainstGuava("behavior_control_mode", "BehaviorControlMode");
      compareAgainstGuava("there_is_a_pine_tree", "ThereIsAPineTree");
      compareAgainstGuava("you_are_dah_best", "youAreDahBest");
      compareAgainstGuava("v2_forge", "V2Forge");
      compareAgainstGuava("v578_forge", "V578Forge");
      compareAgainstGuava("forge_v578", "ForgeV578");
      compareAgainstGuava("forge578", "Forge578");
      compareAgainstGuava("578_forge", "578Forge");

      String troublingString = "REAIsAnAcronymAndIsNotHandledByGuava";
      String guavaExpectedAnswer = "r_e_a_is_an_acronym_and_is_not_handled_by_guava";
      String rosTopicExpectedName = "rea_is_an_acronym_and_is_not_handled_by_guava";

      assertEquals(guavaExpectedAnswer, CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, troublingString));
      assertEquals(rosTopicExpectedName, ROS2TopicNameTools.toROSTopicFormat(troublingString));

      troublingString = "TheAcronymIsAtTheEndREA";
      guavaExpectedAnswer = "the_acronym_is_at_the_end_r_e_a";
      rosTopicExpectedName = "the_acronym_is_at_the_end_rea";
      assertEquals(guavaExpectedAnswer, CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, troublingString));
      assertEquals(rosTopicExpectedName, ROS2TopicNameTools.toROSTopicFormat(troublingString));
   }

   private static void compareAgainstGuava(String expectedOutput, String stringToEvaluate)
   {
      String guavaOutput = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, stringToEvaluate);
      String ros2ToolsOutput = ROS2TopicNameTools.toROSTopicFormat(stringToEvaluate);
      assertEquals(guavaOutput, ros2ToolsOutput);
      assertEquals(expectedOutput, ros2ToolsOutput);
   }
}
