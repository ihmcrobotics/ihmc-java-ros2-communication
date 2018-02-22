package us.ihmc.idl;

import us.ihmc.ros2.rosidl.RosInterfaceGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class ROS2MSGToIDLToPubSubGeneratorTest
{
   /**
    * Must be run from ros2-common-interfaces dir!!!
    */
   public static void main(String[] args) throws IOException
   {
      InputStream ihmcPubSubTemplate = Thread.currentThread().getContextClassLoader().getResourceAsStream("us/ihmc/idl/msg.idl.em");
      RosInterfaceGenerator generator = new RosInterfaceGenerator(ihmcPubSubTemplate);

      generator.addPackageRoot(Paths.get("src/main/vendor/rcl_interfaces"));
      generator.addPackageRoot(Paths.get("src/main/vendor/common_interfaces"));

      generator.addCustomIDLFiles(Paths.get("src/main/idl"));

      generator.generate(Paths.get("build/tmp/idl"), Paths.get("src/main/generated-java"));
   }
}
