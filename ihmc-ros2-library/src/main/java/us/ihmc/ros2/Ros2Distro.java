package us.ihmc.ros2;

/**
 * ROS 2 distro enum. Used to support multiple versions of ROS 2.
 */
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
