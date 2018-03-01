package us.ihmc;

import us.ihmc.ros2.rosidl.RosInterfaceGenerator;

import java.io.IOException;
import java.nio.file.Paths;

public class TestGenerateMSGToPubSub
{
   public static void main(String[] args) throws IOException
   {
      RosInterfaceGenerator generator = new RosInterfaceGenerator();

      generator.addPackageRoot(Paths.get("src/test/ros_msgs"));

      generator.addCustomIDLFiles(Paths.get("src/test/custom-idl"));

      generator.generate(Paths.get("src/test/generated-idl"), Paths.get("src/test/generated-java"));
   }
}
