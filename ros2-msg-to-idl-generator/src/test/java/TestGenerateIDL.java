import org.python.core.Py;
import org.python.core.PyString;
import org.python.core.PySystemState;
import us.ihmc.rosidl.Ros2MsgToIdlGenerator;

import java.io.IOException;
import java.nio.file.Paths;

public class TestGenerateIDL
{
   public static void main(String[] args) throws IOException
   {
      // Import em.py
      PySystemState systemState = Py.getSystemState();
            systemState.path.append(new PyString("__pyclasspath__/Lib"));
      systemState.path.append(new PyString("src/main/python"));

      Ros2MsgToIdlGenerator ros2MsgToIdlGenerator = new Ros2MsgToIdlGenerator();

      ros2MsgToIdlGenerator.addPackageRoot(Paths.get("src/test/ros_msgs"));
      ros2MsgToIdlGenerator.convertToIDL(Paths.get("src/test/generated-idl"));


      //      if (args.length != 3 && args.length != 2)
      //      {
      //         System.out.println("Usage: Ros2MsgToIdlGenerator [argFile] [subFolders] [extension]");
      //         System.exit(-1);
      //      }
      //
      //      Ros2MsgToIdlGenerator gen = new Ros2MsgToIdlGenerator();
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
