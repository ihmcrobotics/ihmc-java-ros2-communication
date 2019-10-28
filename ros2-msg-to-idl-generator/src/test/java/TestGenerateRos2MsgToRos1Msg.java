import org.python.core.Py;
import org.python.core.PyString;
import org.python.core.PySystemState;
import us.ihmc.rosidl.ROS2MsgToRos1MsgGenerator;

import java.io.IOException;
import java.nio.file.Paths;

public class TestGenerateROS2MsgToRos1Msg
{
   public static void main(String[] args) throws IOException
   {
      PySystemState systemState = Py.getSystemState();
      systemState.path.append(new PyString("__pyclasspath__/Lib"));
      systemState.path.append(new PyString("src/main/python"));

      ROS2MsgToRos1MsgGenerator converter = new ROS2MsgToRos1MsgGenerator();

      converter.addPackageRoot(Paths.get("src/test/ros_msgs"));
      converter.convertToROS1(Paths.get("src/test/generated-ros1"));
   }
}
