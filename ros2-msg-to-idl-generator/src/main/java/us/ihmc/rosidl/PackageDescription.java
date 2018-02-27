package us.ihmc.rosidl;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PackageDescription
{
   public String packageName;
   public Path root;

   public List<Path> msg = new ArrayList<>();
   public List<Path> srv = new ArrayList<>();

   public List<String> dependencies = new ArrayList<>();

   @Override
   public String toString()
   {
      return "PackageDescription [packageName=" + packageName + ", root=" + root + ", msg=" + msg + ", srv=" + srv + ", dependencies=" + dependencies + "]";
   }
}
