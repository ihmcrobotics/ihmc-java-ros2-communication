package us.ihmc.ros2;

import org.codehaus.groovy.runtime.MethodClosure;
import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import us.ihmc.ros2.rosidl.RosInterfaceGenerator;

import java.io.IOException;
import java.nio.file.Path;

public class ROS2PubSubGeneratorPlugin implements Plugin<Project>
{
   public static final String ROS_2_COMMON_INTERFACES = "ros2-common-interfaces";
   private final String TEMPORARY_DIRECTORY = "build/tmp/generateMessages/";

   private Project project;
   private Path projectPath;
   private ROS2PubSubGeneratorSettings settings = new ROS2PubSubGeneratorSettings();
   private boolean foundDependency = false;

   @Override
   public void apply(Project project)
   {
      this.project = project;
      projectPath = project.getProjectDir().toPath();

      try
      {
         createExtension("messageGenerator", new RosInterfaceGenerator(TEMPORARY_DIRECTORY + ROS_2_COMMON_INTERFACES));
      }
      catch (IOException e)
      {
         throw new GradleException("Failed to configure generator.");
      }

      //      createExtension("messageGenerator", settings);
//      createTask(project, "generateMessages");
   }

   public void generateMessages()
   {
      try
      {
//         extractDependency(ROS_2_COMMON_INTERFACES);
         RosInterfaceGenerator generator = new RosInterfaceGenerator(TEMPORARY_DIRECTORY + ROS_2_COMMON_INTERFACES);
         settings.directoriesToClean.forEach(d -> project.delete(d));
         settings.dependenciesToExtract.forEach(dependencyToExtract -> {
            if (!dependencyToExtract.equals(ROS_2_COMMON_INTERFACES))
            {
               extractDependency(dependencyToExtract);
            }
         });
         settings.extractedDependencies.forEach(extractedDependency -> {
            try
            {
               generator.addPackageRootToIDLGenerator(path(TEMPORARY_DIRECTORY + extractedDependency));
            }
            catch (IOException e)
            {
               throw new GradleException("Failed to generate messages.", e);
            }
         });
         settings.sourceDependencies.forEach(sourceDependency -> {
            try
            {
               generator.addPackageRootToIDLGenerator(path(sourceDependency));
            }
            catch (IOException e)
            {
               throw new GradleException("Failed to generate messages.", e);
            }
         });
         settings.ros1SourceDependencies.forEach(ros1SourceDependency -> {
            try
            {
               generator.addPackageRootToROS1Generator(path(ros1SourceDependency));
            }
            catch (IOException e)
            {
               throw new GradleException("Failed to generate messages.", e);
            }
         });
         settings.customIDLDependencies.forEach(customIDLDependency -> {
            try
            {
               generator.addCustomIDLFiles(path(customIDLDependency));
            }
            catch (IOException e)
            {
               throw new GradleException("Failed to generate messages.", e);
            }
         });

         try
         {
            generator.generate(path(TEMPORARY_DIRECTORY + settings.idlOutputDirectory), path(TEMPORARY_DIRECTORY + settings.ros1OutputDirectory), path(TEMPORARY_DIRECTORY + settings.javaOutputDirectory));
         }
         catch (IOException e)
         {
            throw new GradleException("Failed to generate messages.", e);
         }

         copyTmpDirToFinalDir(settings.idlOutputDirectory);
         copyTmpDirToFinalDir(settings.javaOutputDirectory);
         copyTmpDirToFinalDir(settings.ros1OutputDirectory);

         generator.convertDirectoryToUnixEOL(path(settings.idlOutputDirectory));
         generator.convertDirectoryToUnixEOL(path(settings.javaOutputDirectory));
         generator.convertDirectoryToUnixEOL(path(settings.ros1OutputDirectory));
      }
      catch (IOException e)
      {
         throw new GradleException("Failed to generate messages.", e);
      }
   }

   private void extractDependency(String dependencyToExtract)
   {
      foundDependency = false;
      project.getConfigurations().getByName("compile").getDependencies().forEach(dependency -> {
         if (dependency.getName().contains(dependencyToExtract))
         {
            foundDependency = true;
            project.copy(copySpec -> {
               copySpec.from(project.zipTree(dependency));
               copySpec.into(project.file(TEMPORARY_DIRECTORY + dependency.getName()));
            });
         }
      });
      if (!foundDependency)
      {
         if (dependencyToExtract.equals(ROS_2_COMMON_INTERFACES))
         {
            throw new GradleException("For now, group: \"us.ihmc\" name: \"ros2-common-interfaces\" must be a dependency. Add it to your main source set.");
         }
         else
         {
            throw new GradleException("Could not find " + dependencyToExtract + " in configurations.compile!");
         }
      }
   }

   private void copyTmpDirToFinalDir(String directory)
   {
      project.copy(copySpec -> {
         copySpec.from(TEMPORARY_DIRECTORY + directory);
         copySpec.into(directory);
      });
   }

   private Path path(String pathName)
   {
      return project.file(pathName).toPath();
   }

   @SuppressWarnings("unchecked")
   private <T> T createExtension(String name, T pojo)
   {
      project.getExtensions().create(name, pojo.getClass());
      return ((T) project.getExtensions().getByName(name));
   }

   private void createTask(Project project, String taskName)
   {
      project.task(taskName).doLast(new MethodClosure(this, taskName));
   }
}
