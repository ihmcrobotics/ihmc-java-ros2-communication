package us.ihmc.rosidl;

import org.python.core.Py;
import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class ROS2MsgToRos1MsgGenerator extends ROS2MsgToIdlGenerator
{
   // Template to use
   private static final String MSG_TO_ROS1_EM_TEMPLATE_NAME = "msg.ros1.em";

   private final PythonInterpreter pythonInterpreter = new PythonInterpreter();
   private Path argumentsJsonFile;
   private Path templateDirectory;

   private final HashMap<String, RosPackageDescription> packages = new HashMap<>();

   public ROS2MsgToRos1MsgGenerator()
   {
      argumentsJsonFile = createTempFile("rosInterfaceArguments", "arguments.json");
      templateDirectory = createTempDirectory("rosInterfaceCompilerTemplates");
      copyResourceToTempDirectory(templateDirectory, MSG_TO_ROS1_EM_TEMPLATE_NAME);

      pythonInterpreter.exec("from rosidl_generator_ros1 import generate_ros_msg");
   }

   public void addPackageRoot(Path rootPath) throws IOException
   {
      Path start = rootPath;
      int maxDepth = 2;
      Files.find(start, maxDepth, (path, attrs) -> attrs.isRegularFile() && path.getFileName().toString().equals("package.xml"))
           .forEach(packageXmlFilePath -> addPackage(packageXmlFilePath, packages));
   }

   public void convertToROS1(Path outputDirectory)
   {
      packages.forEach((name, pkg) -> convertPackageToROS1(name, pkg, outputDirectory));
   }

   private void convertPackageToROS1(String name, RosPackageDescription packageDescription, Path outputDirectory)
   {
      Path packageOutputDirectory = outputDirectory.resolve(name);

      setupAndWriteJythonJSONFile(packageDescription, new ArrayList<>(), packageOutputDirectory, templateDirectory, argumentsJsonFile);

      System.out.println("[ROS2 MSG -> ROS1 MSG] Generating .msg files for " + name + " in " + packageOutputDirectory);

      pythonInterpreter.set("argFile", new PyString(argumentsJsonFile.toAbsolutePath().toString()));
      PyList subFolderList = new PyList();
      subFolderList.add(new PyString("."));
      pythonInterpreter.set("subFolders", subFolderList);
      pythonInterpreter.set("extension", Py.None);
      pythonInterpreter.exec("generate_ros_msg(argFile, subFolders, extension)");
   }
}
