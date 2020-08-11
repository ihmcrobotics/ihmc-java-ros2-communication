package us.ihmc;

import org.junit.jupiter.api.Test;
import us.ihmc.log.LogTools;
import us.ihmc.commons.nio.FileTools;
import us.ihmc.ros2.rosidl.ROS2InterfaceGenerator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MessageGenerationTest
{
   @Test
   public void testMessageGeneration() throws IOException
   {
      Path startingPath;
      LogTools.info("Working dir: " + Paths.get(".").toAbsolutePath());
      startingPath = Paths.get(".");

      FileTools.deleteQuietly(startingPath.resolve("generated-java"));
      FileTools.deleteQuietly(startingPath.resolve("generated-idl"));

      ROS2InterfaceGenerator generator = new ROS2InterfaceGenerator();
      generator.addPackageRootToIDLGenerator(startingPath.resolve("ros_msgs"));
      generator.addPackageRootToROS1Generator(startingPath.resolve("ros_msgs"));
      generator.addCustomIDLFiles(startingPath.resolve("custom-idl"));
      Path generatedIDLPath = startingPath.resolve("generated-idl");
      Path generatedROS1Path = Paths.get("generated-ros1");
      Path generatedJavaPath = startingPath.resolve("generated-java");
      generator.generate(generatedIDLPath, generatedROS1Path, generatedJavaPath);

      ROS2InterfaceGenerator.convertDirectoryToUnixEOL(generatedIDLPath);
      ROS2InterfaceGenerator.convertDirectoryToUnixEOL(generatedROS1Path);
      ROS2InterfaceGenerator.convertDirectoryToUnixEOL(generatedJavaPath);
   }
}
