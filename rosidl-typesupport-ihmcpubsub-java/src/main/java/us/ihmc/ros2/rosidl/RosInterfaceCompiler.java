/*
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package us.ihmc.ros2.rosidl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import us.ihmc.ros2.rosidl.rosPackage.Package;
import us.ihmc.rosidl.GenerateDDSIDL;

/** 
 * Utility to convert ROS2 IDL files (.msg & .srv) to Java files compatible with IHMC Pub/Sub 
 * 
 * @author Jesper Smith
 *
 */
public class RosInterfaceCompiler
{
   // Template to use
   private static final String template_name = "msg.idl.em";

   
   private final Path template_dir;
   private final Path argumentFile;

   /**
    * Internal holder for information about the package 
    * 
    * @author Jesper Smith
    *
    */
   private class PackageDescription
   {
      private String packageName;
      private Path root;
      
      private List<Path> msg = new ArrayList<>();
      private List<Path> srv = new ArrayList<>();
      
      private List<String> dependencies = new ArrayList<>();

      @Override
      public String toString()
      {
         return "PackageDescription [packageName=" + packageName + ", root=" + root + ", msg=" + msg + ", srv=" + srv + ", dependencies=" + dependencies + "]";
      }
      
      
   }
   
   // Holder for all packages found
   private final HashMap<String, PackageDescription> packages = new HashMap<>();
   
   /**
    * Compile Ros interfaces to Java files for IHMC pub sub
    * 
    * @throws IOException if no temporary files and directories can be made
    */
   public RosInterfaceCompiler() throws IOException
   {
      
      argumentFile = Files.createTempFile("RosInterfaceArguments", "arguments.json");
      argumentFile.toFile().deleteOnExit();
      
      
      template_dir = Files.createTempDirectory("RosInterfaceCompilerTemplates");
      template_dir.toFile().deleteOnExit();
      
      InputStream template = getClass().getClassLoader().getResourceAsStream(template_name);
      Path template_file = template_dir.resolve(template_name);
      Files.copy(template, template_file);
      
      template_file.toFile().deleteOnExit();
      template.close();
   
   }
   
   
   /**
    * Add a directory with ros packages to the list of interfaces to be compiled.
    * 
    * The expected directory structure is
    *    - rootPath
    *       - packageName
    *          - package.xml
    *  
    *  A package xml with at least <name /> and optionally <build_depends />
    *  
    * 
    * @param rootPath The root directory of packages to add
    * @throws IOException If the rootPath cannot be read
    */
   public void addPackageRoot(Path rootPath) throws IOException
   {
      // Find all subdirectories with a package.xml in them and call this.addPackage()
      Files.find(rootPath, 2, (path,  attrs) -> attrs.isRegularFile() && 
                 path.getFileName().toString().equals("package.xml")).forEach(this::addPackage);
   }
   
   /**
    * Generate java files for all packages.
    * 
    * This function can ber called 
    * 
    * @param idlDirectory directory to put .idl files in
    */
   public void generate(Path idlDirectory)
   {
      packages.forEach((name, pkg) -> this.convertToIDL(name, pkg, idlDirectory));      
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
      for(Path msg : desc.msg)
         ros_interface_files.add(msg.toString());
      for(Path srv: desc.srv)
         ros_interface_files.add(srv.toString());
      
      // The ros interface files to compile
      json.add("ros_interface_files", ros_interface_files);
      
      JsonArrayBuilder ros_interface_dependencies = Json.createArrayBuilder();
      for(Path dep : dependencies)
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
   
   
   /**
    * Helper function to convert a single package to .idl files
    * 
    * @param name Name of the package to compile
    * @param pkg Description of the package to compile
    * @param outputDirectory Directory to put the generated files in
    */
   private void convertToIDL(String name, PackageDescription pkg, Path outputDirectory)
   {
      HashSet<String> dependencies = new HashSet<>();
      addDependencies(pkg, dependencies);
      
      List<Path> dependencyFiles = new ArrayList<>();
      for(String dependency : dependencies)
      {
         PackageDescription desc = packages.get(dependency);
         dependencyFiles.addAll(desc.msg);
      }
      
      Path packageOutputDirectory = outputDirectory.resolve(name);
      createJSON(pkg, packageOutputDirectory, template_dir, dependencyFiles);
      
      List<String> subFolders = new ArrayList<>();
      subFolders.add(".");

      System.out.println("Generating .idl files for " + name + " in " + packageOutputDirectory);
      GenerateDDSIDL dds = new GenerateDDSIDL();
      dds.generate_dds_idl(argumentFile.toAbsolutePath().toString(), subFolders, null);
   }
   
   /**
    * Recursive function to add all .msg files that are necessary to compile this package
    * 
    * 
    * @param description package description
    * @param dependencies Output set of dependencies
    */
   private void addDependencies(PackageDescription description, HashSet<String> dependencies)
   {
      for(String dependency : description.dependencies)
      {
         dependencies.add(dependency);
         if(packages.containsKey(dependency))
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
         JAXBContext jaxbContext = JAXBContext.newInstance(Package.class);
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         Package pkg = (Package) unmarshaller.unmarshal(file.toFile());

         
         // Create a package description
         PackageDescription pkgDesc = new PackageDescription();
         pkgDesc.packageName = pkg.getName();
         pkgDesc.root = file.getParent();
         if(pkg.getBuild_depend() != null)
         {
            pkgDesc.dependencies.addAll(pkg.getBuild_depend());
         }
         
         
         // Search for .msg and .srv files and add them to pkgDesc.msg and pkgDesc.srv respectivly
         try
         {
            Files.find(pkgDesc.root, 2, (path,  attrs) -> attrs.isRegularFile() && 
                       path.getFileName().toString().endsWith(".msg")).forEach(pkgDesc.msg::add);
            Files.find(pkgDesc.root, 2, (path,  attrs) -> attrs.isRegularFile() && 
                       path.getFileName().toString().endsWith(".srv")).forEach(pkgDesc.srv::add);
         }
         catch (IOException e)
         {
            throw new RuntimeException("Cannot search folder " + pkgDesc.root + " for package " + pkgDesc.packageName, e);
         };
         
         packages.put(pkgDesc.packageName, pkgDesc);

         
      }
      catch (JAXBException e)
      {
         throw new RuntimeException("Cannot parse package.xml for " + file.getFileName().toString(), e);
      }
      
      
   }
   
   
   public static void main(String[] args) throws IOException
   {
      RosInterfaceCompiler compiler = new RosInterfaceCompiler();
      compiler.addPackageRoot(new File("../common_interfaces").toPath());
      compiler.generate(Paths.get("generated-idl"));
      
   }
}
