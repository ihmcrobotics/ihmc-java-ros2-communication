import org.python.core.Py;
import org.python.core.PyString;
import org.python.core.PySystemState;
import us.ihmc.rosidl.ROS2MsgToIdlGenerator;

import java.io.IOException;
import java.nio.file.Paths;

public class TestGenerateMSGToIDL
{
   public static void main(String[] args) throws IOException
   {
      // Import em.py
      PySystemState systemState = Py.getSystemState();
      systemState.path.append(new PyString("__pyclasspath__/Lib"));
      systemState.path.append(new PyString("src/main/python"));

      ROS2MsgToIdlGenerator ros2MsgToIdlGenerator = new ROS2MsgToIdlGenerator();

      ros2MsgToIdlGenerator.addPackageRoot(Paths.get("src/test/ros_msgs"));
      ros2MsgToIdlGenerator.convertToIDL(Paths.get("src/test/generated-idl"));


      //      if (args.length != 3 && args.length != 2)
      //      {
      //         System.out.println("Usage: ROS2MsgToIdlGenerator [argFile] [subFolders] [extension]");
      //         System.exit(-1);
      //      }
      //
      //      ROS2MsgToIdlGenerator gen = new ROS2MsgToIdlGenerator();
      //      if (args.length == 2)
      //      {
      //         gen.generate_dds_idl(args[0], Collections.singletonList(args[1]), null);
      //      }
      //      else
      //      {
      //         gen.generate_dds_idl(args[0], Collections.singletonList(args[1]), Collections.singletonList(args[2]));
      //      }
   }
}
