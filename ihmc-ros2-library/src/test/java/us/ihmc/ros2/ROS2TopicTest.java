package us.ihmc.ros2;

import com.google.common.base.CaseFormat;
import org.junit.jupiter.api.Test;
import std_msgs.msg.dds.Int32;
import std_msgs.msg.dds.Int8;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ROS2TopicTest
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
      ROS2Topic<?> topicName1 = new ROS2Topic<>().withPrefix("ihmc");
      ROS2Topic<?> topicName2 = new ROS2Topic<>().withPrefix("ihmc");

      assertEquals(topicName1, topicName2);

      HashMap<ROS2Topic<?>, Object> map = new HashMap<>();
      map.put(topicName1, null);
      map.put(topicName2, null);

      assertEquals(1, map.size());

      ROS2Topic<Int32> topicName3 = new ROS2Topic<>().withPrefix("ihmc").withType(Int32.class);
      ROS2Topic<Int32> topicName4 = new ROS2Topic<>().withPrefix("ihmc").withType(Int32.class);

      assertEquals(topicName1, topicName2);

      HashMap<ROS2Topic<?>, Object> map2 = new HashMap<>();
      map2.put(topicName3, null);
      map2.put(topicName4, null);

      assertEquals(1, map2.size());
   }

   @Test
   public void testROS2TopicName()
   {
      ROS2Topic<?> topicName = new ROS2Topic<>().withPrefix("ihmc").withRobot("atlas").withModule("rea")
                                           .withType(ExampleTypeMessage.class).withSuffix(typeName -> typeName + "/one");
      assertEquals("/ihmc/atlas/rea/example_type/one", topicName.toString());

      ROS2Topic<?> ihmcPrefixed = new ROS2Topic<>().withPrefix("ihmc");
      assertEquals("/ihmc", ihmcPrefixed.toString());
      ihmcPrefixed.withModule("hello");
      ihmcPrefixed.withRobot("robot_one");
      ihmcPrefixed.withType(Int8.class);
      ihmcPrefixed.withSuffix("meow");
      ihmcPrefixed.withInput();
      ihmcPrefixed.withOutput();
      ihmcPrefixed.withIOQualifier("client");
      ihmcPrefixed.withIOQualifier("server");
      assertEquals("/ihmc", ihmcPrefixed.toString());

      ROS2Topic<?> ihmcPrefixed2 = new ROS2Topic<>().withPrefix("ihmc");
      assertEquals("/ihmc", ihmcPrefixed2.toString());
      ROS2Topic<?> hello = ihmcPrefixed2.withModule("hello");
      ROS2Topic<?> robotOne = hello.withRobot("robot_one");
      ROS2Topic<Int8> int8 = robotOne.withType(Int8.class);
      ROS2Topic<Int8> meow = int8.withSuffix(typeName -> typeName + "/meow");
      ROS2Topic<?> input = meow.withInput();
      ROS2Topic<?> output = input.withOutput();

      assertEquals("/ihmc/hello", hello.toString());
      assertEquals("/ihmc/robot_one/hello", robotOne.toString());
      assertEquals("/ihmc/robot_one/hello/int8", int8.toString());
      assertEquals("/ihmc/robot_one/hello/int8/meow", meow.toString());
      assertEquals("/ihmc/robot_one/hello/input/int8/meow", input.toString());
      assertEquals("/ihmc/robot_one/hello/output/int8/meow", output.toString());

      assertEquals("/ihmc", output.withSuffix("").withIOQualifier(null).withModule(null).withRobot(null).withType(null).toString());
      assertEquals("", output.withPrefix(null).withIOQualifier(null).withSuffix("").withModule(null).withRobot(null).withType(null).toString());
   }

   @Test
   public void testTypeNaming()
   {
      ROS2Topic<?> emptyTopic = new ROS2Topic<>();
      assertEquals("", emptyTopic.getName());

      ROS2Topic<?> withEmptyTypeNamed = new ROS2Topic<>().withType(Int8.class).withSuffix(typeName -> "");
      assertEquals("", withEmptyTypeNamed.getName());

      ROS2Topic<?> typeNamed = new ROS2Topic<>().withType(Int8.class).withSuffix(typeName -> typeName);
      assertEquals("/int8", typeNamed.getName());

      ROS2Topic<?> usedTypeInName = new ROS2Topic<>().withType(Int8.class).withSuffix(typeName -> typeName + "_for_ui");
      assertEquals("/int8_for_ui", usedTypeInName.getName());

      ROS2Topic<?> withInput = typeNamed.withInput();
      assertEquals("/input/int8", withInput.getName());

      ROS2Topic<Object> atlas = new ROS2Topic<>().withRobot("atlas").withPrefix("/ihmc");
      assertEquals("/ihmc/atlas/input/int8", withInput.withTopic(atlas).getName());
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
