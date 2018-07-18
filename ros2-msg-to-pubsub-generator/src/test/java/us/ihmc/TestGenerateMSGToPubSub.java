package us.ihmc;

import us.ihmc.commons.nio.FileTools;
import us.ihmc.ros2.rosidl.RosInterfaceGenerator;

import java.io.IOException;
import java.nio.file.Paths;

public class TestGenerateMSGToPubSub
{
   public static void main(String[] args) throws IOException
   {
      FileTools.deleteQuietly(Paths.get("generated-java"));
      FileTools.deleteQuietly(Paths.get("generated-idl"));

      RosInterfaceGenerator generator = new RosInterfaceGenerator();

      generator.addPackageRoot(Paths.get("ros_msgs"));

      generator.addCustomIDLFiles(Paths.get("custom-idl"));

      generator.generate(Paths.get("generated-idl"), Paths.get("generated-ros1"), Paths.get("generated-java"));
   }
}
