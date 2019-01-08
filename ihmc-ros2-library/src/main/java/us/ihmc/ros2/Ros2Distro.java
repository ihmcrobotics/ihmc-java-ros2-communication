package us.ihmc.ros2;

public enum Ros2Distro
{
   ARDENT,
   BOUNCY;

   public static Ros2Distro fromEnvironment()
   {
      String rosDistro = System.getenv("ROS_DISTRO");

      if (rosDistro != null && (rosDistro.trim().toLowerCase().contains("ardent") ||
                                rosDistro.trim().toLowerCase().contains("kinetic")))
         return ARDENT;
      else
         return BOUNCY;
   }
}
