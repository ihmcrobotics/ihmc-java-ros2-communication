package us.ihmc.rosidl;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RosPackageDescription
{
   private final String packageName;
   private final Path packageDirectory;

   private List<Path> dotMsgFilePaths = new ArrayList<>();
   private List<Path> dotSrvFilePaths = new ArrayList<>();

   private List<String> dependencies = new ArrayList<>();

   public RosPackageDescription(String packageName, Path packageDirectory)
   {
      this.packageName = packageName;
      this.packageDirectory = packageDirectory;
   }

   public List<Path> getMsgFilePaths()
   {
      return dotMsgFilePaths;
   }

   public List<Path> getSrvFilePaths()
   {
      return dotSrvFilePaths;
   }

   public List<String> getDependencies()
   {
      return dependencies;
   }

   public Path getPackageDirectory()
   {
      return packageDirectory;
   }

   public String getPackageName()
   {
      return packageName;
   }

   @Override
   public String toString()
   {
      return "PackageDescription [packageName=" + packageName + ", root=" + packageDirectory + ", msg=" + dotMsgFilePaths + ", srv=" + dotSrvFilePaths
             + ", dependencies=" + dependencies + "]";
   }
}
