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

import org.gradle.api.DefaultTask;
import org.gradle.api.file.FileCollection;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;

public class Ros2MessageGenerator extends DefaultTask
{
   /**
    * [Required] List of directories containing ros packages
    */
   public FileCollection rosPackages;

   /**
    * [Required] Generated Java output directory
    */
   public File javaOutputDirectory;

   /**
    * [Required] Generated IDL output directory
    */
   public File idlOutputDirectory;

   /**
    * [Optional] List of directories containing custom .idl files that override the generated ones
    */
   public FileCollection customIDLDirectory;

   @TaskAction
   public void compile() throws IOException
   {
      if (rosPackages == null)
      {
         throw new IOException("Please set rosPackages = files(\"path/to/package\")");
      }

      if (javaOutputDirectory == null)
      {
         throw new IOException("Please set javaOutputDirectory = files(\"path/to/java/output\")");
      }

      if (javaOutputDirectory.exists() && !javaOutputDirectory.isDirectory())
      {
         throw new IOException("Output directory exists but is not a directory");
      }

      if (idlOutputDirectory == null)
      {
         idlOutputDirectory = new File(getTemporaryDir(), "idl");
      }

      getProject().delete(javaOutputDirectory);
      getProject().delete(idlOutputDirectory);

      RosInterfaceGenerator generator = new RosInterfaceGenerator();

      for (File rosPackage : rosPackages)
      {
         generator.addPackageRoot(rosPackage.toPath());
      }

      if (customIDLDirectory != null)
      {
         for (File custom : customIDLDirectory)
         {
            generator.addCustomIDLFiles(custom.toPath());
         }
      }

      generator.generate(idlOutputDirectory.toPath(), javaOutputDirectory.toPath());

      generator.convertDirectoryToUnixEOL(idlOutputDirectory.toPath());
      generator.convertDirectoryToUnixEOL(javaOutputDirectory.toPath());
   }
}
