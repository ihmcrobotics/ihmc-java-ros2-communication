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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class RosInterfaceCompiler
{
   
   private final Path template_dir = Paths.get("../rosidl-typesupport-jython/src/thirdparty/resources");
   private final Path outputDirectory = Paths.get("build-java");
   
   
   private final File argumentFile;

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
   
   
   private final HashMap<String, PackageDescription> packages = new HashMap<>();
   
   public RosInterfaceCompiler(Path rootPath) throws IOException
   {
      argumentFile = File.createTempFile("arguments", ".json");
      System.out.println("argument file " + argumentFile.getAbsolutePath());
      argumentFile.deleteOnExit();
      
      
      Files.find(rootPath, 2, (path,  attrs) -> attrs.isRegularFile() && 
                 path.getFileName().toString().equals("package.xml")).forEach(this::addPackage);
      
      packages.forEach(this::convertToIDL);
      
   
   }
   
   private void createJSON(PackageDescription desc, Path outputDirectory, Path templateDirectory, List<Path> dependencies)
   {
      JsonObjectBuilder json = Json.createObjectBuilder();
      
      json.add("package_name", desc.packageName);
      json.add("output_dir", outputDirectory.toString());
      json.add("template_dir", templateDirectory.toString());
      
      JsonArrayBuilder ros_interface_files = Json.createArrayBuilder();
      for(Path msg : desc.msg)
         ros_interface_files.add(msg.toString());
      for(Path srv: desc.srv)
         ros_interface_files.add(srv.toString());
      
      json.add("ros_interface_files", ros_interface_files);
      
      JsonArrayBuilder ros_interface_dependencies = Json.createArrayBuilder();
      for(Path dep : dependencies)
         ros_interface_dependencies.add(dep.toString());
      
      json.add("ros_interface_dependencies", ros_interface_dependencies);
      
      
      json.add("target_dependencies", Json.createArrayBuilder());
      json.add("additional_files", Json.createArrayBuilder());
      
      
      FileOutputStream os;
      try
      {
         os = new FileOutputStream(argumentFile);
      }
      catch (FileNotFoundException e)
      {
         throw new RuntimeException(e);
      }
      JsonWriter writer = Json.createWriter(os);
      writer.writeObject(json.build());
      writer.close();
      
   }
   
   
   private void convertToIDL(String name, PackageDescription pkg)
   {
      HashSet<String> dependencies = new HashSet<>();
      addDependencies(pkg, dependencies);
      
      List<Path> dependencyFiles = new ArrayList<>();
      for(String dependency : dependencies)
      {
         PackageDescription desc = packages.get(dependency);
         dependencyFiles.addAll(desc.msg);
      }
      
      createJSON(pkg, outputDirectory, template_dir, dependencyFiles);
      
      List<String> subFolders = new ArrayList<>();
      subFolders.add(".");

      GenerateDDSIDL dds = new GenerateDDSIDL();
      dds.generate_dds_idl(argumentFile.getAbsolutePath(), subFolders, null);
   }
   
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
   
   
   private void addPackage(Path file) 
   {
      JAXBContext jaxbContext;
      try
      {
         jaxbContext = JAXBContext.newInstance(Package.class);
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         Package pkg = (Package) unmarshaller.unmarshal(file.toFile());

         
         PackageDescription pkgDesc = new PackageDescription();
         pkgDesc.packageName = pkg.getName();
         pkgDesc.root = file.getParent();
         if(pkg.getBuild_depend() != null)
         {
            pkgDesc.dependencies.addAll(pkg.getBuild_depend());
         }
         
         
         try
         {
            Files.find(pkgDesc.root, 2, (path,  attrs) -> attrs.isRegularFile() && 
                       path.getFileName().toString().endsWith(".msg")).forEach(pkgDesc.msg::add);
            Files.find(pkgDesc.root, 2, (path,  attrs) -> attrs.isRegularFile() && 
                       path.getFileName().toString().endsWith(".srv")).forEach(pkgDesc.srv::add);
         }
         catch (IOException e)
         {
            throw new RuntimeException("Cannot serach folder " + pkgDesc.root + " for package " + pkgDesc.packageName, e);
         };
         
         System.out.println(pkgDesc);
         packages.put(pkgDesc.packageName, pkgDesc);

         
      }
      catch (JAXBException e)
      {
         throw new RuntimeException("Cannot parse package.xml for " + file.getFileName().toString(), e);
      }
      
      
   }
   
   
   public static void main(String[] args) throws IOException
   {
      new RosInterfaceCompiler(new File("../common_interfaces").toPath());
   }
}
