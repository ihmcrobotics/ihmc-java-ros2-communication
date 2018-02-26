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

import org.gradle.api.DefaultTask;
import org.gradle.api.file.FileCollection;
import org.gradle.api.tasks.TaskAction;

public class RosInterfaceGeneratorTask extends DefaultTask
{
   /**
    * [Required] List of directories containing ros packages  
    */
   public FileCollection rosPackages;
   
   /**
    * [Required] Output directory
    */
   public File outputDirectory;
   
   /**
    * [Optional] List of directories containing custom .idl files that override the generated ones
    */
   public FileCollection customIDL;
   
   
   @TaskAction
   public void compile() throws IOException
   {
      if(rosPackages == null)
      {
         throw new IOException("ROS Packages must be set");
      }
    
      if(outputDirectory == null)
      {
         throw new IOException("Output directory must be set");
      }
      
      if(outputDirectory.exists() && !outputDirectory.isDirectory())
      {
         throw new IOException("Output directory exists but is not a directory");
      }
      
      
      RosInterfaceGenerator generator = new RosInterfaceGenerator();

      for(File packages : rosPackages)
      {
         generator.addPackageRoot(packages.toPath());
      }
      
      if(customIDL != null)
      {
         for(File custom : customIDL)
         {
            generator.addCustomIDLFiles(custom.toPath());
         }
      }
      
      

      File tempDir = new File(getTemporaryDir(), "idl");
      generator.generate(tempDir.toPath(), outputDirectory.toPath());
   }

}
