package us.ihmc.ros2;

public enum ROS2Distro
{
   ARDENT,
   BOUNCY;

   public static ROS2Distro fromEnvironment()
   {
      String rosDistro = System.getenv("ROS_DISTRO");

      if (rosDistro != null && (rosDistro.trim().toLowerCase().contains("ardent") ||
                                rosDistro.trim().toLowerCase().contains("kinetic")))
         return ARDENT;
      else
         return BOUNCY;
   }
}
