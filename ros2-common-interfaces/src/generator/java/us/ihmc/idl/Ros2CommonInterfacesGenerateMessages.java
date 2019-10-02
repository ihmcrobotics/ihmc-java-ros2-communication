package us.ihmc.idl;

import us.ihmc.ros2.rosidl.RosInterfaceGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class Ros2CommonInterfacesGenerateMessages
{
   /**
    * Must be run from ros2-common-interfaces dir!!!
    * 
    * Recommendation is to run "gradle generateMessages" in the ros2-common-interfaces folder as that updates messages from git
    *
    * This is actually a replacement for the generateMessages Gradle task for now.
    */
   public static void main(String[] args) throws IOException
   {
      InputStream ihmcPubSubTemplate = Thread.currentThread().getContextClassLoader().getResourceAsStream("us/ihmc/idl/msg.idl.em");
      RosInterfaceGenerator generator = new RosInterfaceGenerator();

      String[] rclInterfacesToIgnore = { "test_msgs" };
      
      generator.addPackageRootToIDLGenerator(Paths.get("src/main/vendor/rcl_interfaces"), rclInterfacesToIgnore);
      generator.addPackageRootToIDLGenerator(Paths.get("src/main/vendor/common_interfaces"), rclInterfacesToIgnore);
      generator.addPackageRootToIDLGenerator(Paths.get("src/main/vendor/geometry2/tf2_msgs"), rclInterfacesToIgnore);
      generator.addPackageRootToIDLGenerator(Paths.get("src/main/vendor/unique_identifier_msgs"), rclInterfacesToIgnore);

      generator.addCustomIDLFiles(Paths.get("src/main/custom-idl"));

      generator.generate(Paths.get("src/main/generated-idl"), Paths.get("src/main/generated-ros1"), Paths.get("src/main/generated-java"));

      RosInterfaceGenerator.convertDirectoryToUnixEOL(Paths.get("src/main/generated-idl"));
      RosInterfaceGenerator.convertDirectoryToUnixEOL(Paths.get("src/main/generated-java"));
   }
}
