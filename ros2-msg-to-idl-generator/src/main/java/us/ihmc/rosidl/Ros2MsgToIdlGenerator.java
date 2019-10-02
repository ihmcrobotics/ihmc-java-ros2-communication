package us.ihmc.rosidl;

import org.python.core.Py;
import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Ros2MsgToIdlGenerator
{
   private static final boolean compile_srv = false;

   // Template to use
   private static final String pub_sub_template_name = "msg.idl.em";
   private static final String pub_sub_template_resource = "src/main/resources/msg.idl.em";

   private Path template_dir;

   private final PythonInterpreter pythonInterpreter = new PythonInterpreter();
   private Path argumentFile;

   private final HashMap<String, PackageDescription> packages = new HashMap<>();

   public Ros2MsgToIdlGenerator()
   {
      try
      {
//         new File("build/tmp").mkdirs();
//         Path umentFolPath = Paths.get("build/tmp/arguments.json");
//         Files.deleteIfExists(umentFolPath);
//         argumentFile = Files.createFile(umentFolPath);
         argumentFile = Files.createTempFile("RosInterfaceArguments", "arguments.json");
         argumentFile.toFile().deleteOnExit();

//         Path templateDirPath = Paths.get("build/tmp/templates");
//         Files.deleteIfExists(templateDirPath);
//         template_dir = Files.createDirectory(templateDirPath);
         template_dir = Files.createTempDirectory("RosInterfaceCompilerTemplates");
         template_dir.toFile().deleteOnExit();

         InputStream template = Thread.currentThread().getContextClassLoader().getResourceAsStream(pub_sub_template_name);
         Path template_file = template_dir.resolve(pub_sub_template_name);
         Files.copy(template, template_file);

         template_file.toFile().deleteOnExit();
         template.close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }

      pythonInterpreter.exec("from rosidl_generator_dds_idl import generate_dds_idl");
   }

   /**
    * Add a directory with ros packages to the list of interfaces to be compiled.
    *
    * The expected directory structure is
    * - rootPath
    * - packageName
    * - package.xml
    *
    * A package xml with at least <name /> and optionally <build_depends />
    *
    * @param rootPath The root directory of packages to add
    * @param rclInterfacesToIgnore Optional array of packages to ignore
    * @throws IOException If the rootPath cannot be read
    */
   public void addPackageRoot(Path rootPath, String... rclInterfacesToIgnore) throws IOException
   {
      List<String> ignoredInterfaces; 
      if(rclInterfacesToIgnore != null)
      {
         ignoredInterfaces = Arrays.asList(rclInterfacesToIgnore);
      }
      else
      {
         ignoredInterfaces = Collections.emptyList();
      }
      
      // Find all subdirectories with a package.xml in them and call this.addPackage()
      Files.find(rootPath, 2, (path, attrs) -> attrs.isRegularFile() && path.getFileName().toString().equals("package.xml"))
         .filter((path) -> !ignoredInterfaces.contains(path.getParent().getFileName().toString()))
         .forEach(this::addPackage);
   }

   /**
    * Add a ROS2 package to the list of packages to compile
    *
    * This function reads the package.xml to get the package name and list of dependencies.
    *
    * The .msg and .srv files to compile are found with a search in the directory.
    *
    * @param file the package.xml description
    */
   private void addPackage(Path file)
   {
      try
      {
         // Read the XML file
         JAXBContext jaxbContext = JAXBContext.newInstance(RosPackage.class);
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         RosPackage pkg = (RosPackage) unmarshaller.unmarshal(file.toFile());

         // Create a package description
         PackageDescription pkgDesc = new PackageDescription();
         pkgDesc.packageName = pkg.getName();
         pkgDesc.root = file.getParent();
         if (pkg.getBuild_depend() != null)
         {
            pkgDesc.dependencies.addAll(pkg.getBuild_depend());
         }

         // Search for .msg and .srv files and add them to pkgDesc.msg and pkgDesc.srv respectivly
         try
         {
            Files.find(pkgDesc.root, 2, (path, attrs) -> attrs.isRegularFile() && path.getFileName().toString().endsWith(".msg")).forEach(pkgDesc.msg::add);
            if (compile_srv)
            {
               Files.find(pkgDesc.root, 2, (path, attrs) -> attrs.isRegularFile() && path.getFileName().toString().endsWith(".srv")).forEach(pkgDesc.srv::add);
            }
         }
         catch (IOException e)
         {
            throw new RuntimeException("Cannot search folder " + pkgDesc.root + " for package " + pkgDesc.packageName, e);
         }
         ;

         packages.put(pkgDesc.packageName, pkgDesc);
      }
      catch (JAXBException e)
      {
         throw new RuntimeException("Cannot parse package.xml: " + file, e);
      }
   }

   /**
    * Convert all ROS2 packages to .idl files
    *
    * @param outputDirectory Directory to put the generated files in
    */
   public void convertToIDL(Path outputDirectory)
   {
      packages.forEach((name, pkg) -> convertPackageToIDL(name, pkg, outputDirectory));
   }

   private void convertPackageToIDL(String name, PackageDescription pkg, Path outputDirectory)
   {
      HashSet<String> dependencies = new HashSet<>();
      addDependencies(pkg, dependencies);

      List<Path> dependencyFiles = new ArrayList<>();
      for (String dependency : dependencies)
      {
         PackageDescription desc = packages.get(dependency);
         dependencyFiles.addAll(desc.msg);
      }

      Path packageOutputDirectory = outputDirectory.resolve(name);
      createJSON(pkg, packageOutputDirectory, template_dir, dependencyFiles);

      List<String> subFolders = new ArrayList<>();
      subFolders.add(".");

      System.out.println("[ROS2 MSG -> IDL] Generating .idl files for " + name + " in " + packageOutputDirectory);
      generate_dds_idl(argumentFile.toAbsolutePath().toString(), subFolders, null);
   }

   /**
    * Recursive function to add all .msg files that are necessary to compile this package
    *
    * @param description package description
    * @param dependencies Output set of dependencies
    */
   private void addDependencies(PackageDescription description, HashSet<String> dependencies)
   {
      for (String dependency : description.dependencies)
      {
         dependencies.add(dependency);
         if (packages.containsKey(dependency))
         {
            addDependencies(packages.get(dependency), dependencies);
         }
         else
         {
            throw new RuntimeException("Cannot find dependency " + dependency + " for " + description.packageName);
         }
      }
   }

   /**
    * Helper function to generate the json format the ros2 idl compiler requires
    *
    * @param desc packageDescription
    * @param outputDirectory directory to put the generated idl files in
    * @param template_dir directory where the msg.idl.em template can be found
    * @param dependencies list of paths of .msg files that are required to generate this .msg file
    */
   private void createJSON(PackageDescription desc, Path outputDirectory, Path template_dir, List<Path> dependencies)
   {
      JsonObjectBuilder json = Json.createObjectBuilder();

      // package_name is the name of the package
      json.add("package_name", desc.packageName);
      // output_dir is the directory to write the files in. The ros2 idl compiler does not append the package name to this directory.
      json.add("output_dir", outputDirectory.toAbsolutePath().toString());
      // directory where msg.idl.em can be found
      json.add("template_dir", template_dir.toAbsolutePath().toString());

      JsonArrayBuilder ros_interface_files = Json.createArrayBuilder();
      for (Path msg : desc.msg)
         ros_interface_files.add(msg.toString());
      for (Path srv : desc.srv)
         ros_interface_files.add(srv.toString());

      // The ros interface files to compile
      json.add("ros_interface_files", ros_interface_files);

      JsonArrayBuilder ros_interface_dependencies = Json.createArrayBuilder();
      for (Path dep : dependencies)
         ros_interface_dependencies.add(dep.toString());

      // The ros interface files necessary to compile this interface
      json.add("ros_interface_dependencies", ros_interface_dependencies);

      // Don't know what this flag does
      json.add("target_dependencies", Json.createArrayBuilder());
      // Don't know what this flag does
      json.add("additional_files", Json.createArrayBuilder());

      OutputStream os;
      try
      {
         os = Files.newOutputStream(argumentFile);
      }
      catch (IOException e)
      {
         throw new RuntimeException(e);
      }
      JsonWriter writer = Json.createWriter(os);
      writer.writeObject(json.build());
      writer.close();
   }

   private void generate_dds_idl(String argFile, List<String> subFolders, List<String> extensions)
   {
      pythonInterpreter.set("argFile", new PyString(argFile));

      PyList subFolderList = new PyList();
      for (String subFolder : subFolders)
         subFolderList.add(new PyString(subFolder));

      pythonInterpreter.set("subFolders", subFolderList);

      if (extensions != null && extensions.size() > 0)
      {
         PyList extensionList = new PyList();
         for (String extension : extensions)
            extensionList.add(new PyString(extension));

         pythonInterpreter.set("extension", extensionList);
      }
      else
         pythonInterpreter.set("extension", Py.None);

      pythonInterpreter.exec("generate_dds_idl(argFile, subFolders, extension)");
   }
}
