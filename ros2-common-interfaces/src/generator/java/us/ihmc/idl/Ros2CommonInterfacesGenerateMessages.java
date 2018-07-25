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
    * This is actually a replacement for the generateMessages Gradle task for now.
    */
   public static void main(String[] args) throws IOException
   {
      InputStream ihmcPubSubTemplate = Thread.currentThread().getContextClassLoader().getResourceAsStream("us/ihmc/idl/msg.idl.em");
      RosInterfaceGenerator generator = new RosInterfaceGenerator();

      generator.addPackageRootToIDLGenerator(Paths.get("src/main/vendor/rcl_interfaces"));
      generator.addPackageRootToIDLGenerator(Paths.get("src/main/vendor/common_interfaces"));

      generator.addCustomIDLFiles(Paths.get("src/main/custom-idl"));

      generator.generate(Paths.get("src/main/generated-idl"), Paths.get("src/main/generated-ros1"), Paths.get("src/main/generated-java"));
   }
}
