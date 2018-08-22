package us.ihmc.ros2;

public enum Ros2Version
{
   ARDENT,
   BOUNCY;

   public static Ros2Version getRos2DistroFromEnvironment()
   {
      String rosDistro = System.getenv("ROS_DISTRO");

      if (rosDistro == null || !rosDistro.trim().toLowerCase().contains("bouncy"))
         return ARDENT;
      else
         return BOUNCY;
   }
}
