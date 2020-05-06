package us.ihmc.ros2;

import com.google.common.base.CaseFormat;
import org.junit.jupiter.api.Test;
import std_msgs.msg.dds.Int8;

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
