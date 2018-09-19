package us.ihmc.ros2;

import java.util.ArrayList;

public class ROS2PubSubGeneratorSettings
{
   public ArrayList<String> directoriesToClean = new ArrayList<>();
   public ArrayList<String> dependenciesToExtract = new ArrayList<>();
   public ArrayList<String> extractedDependencies = new ArrayList<>();
   public ArrayList<String> sourceDependencies = new ArrayList<>();
   public ArrayList<String> ros1SourceDependencies = new ArrayList<>();
   public ArrayList<String> customIDLDependencies = new ArrayList<>();
   public String idlOutputDirectory = "";
   public String ros1OutputDirectory = "";
   public String javaOutputDirectory = "";
}
