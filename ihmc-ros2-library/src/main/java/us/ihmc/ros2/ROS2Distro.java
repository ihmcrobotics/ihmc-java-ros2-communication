package us.ihmc.ros2;

/**
 * ROS 2 distro enum. Used to support multiple versions of ROS 2.
 * 
 * DEPRICATED: Since bouncy ROS2 has been the same. No need to keep this around.
 */
@Deprecated
public enum ROS2Distro
{
   ARDENT,
   BOUNCY;

   public static ROS2Distro fromEnvironment()
   {
      String ros2Distro = System.getenv("ROS_DISTRO");

      if (ros2Distro != null && (ros2Distro.trim().toLowerCase().contains("ardent") ||
                                ros2Distro.trim().toLowerCase().contains("kinetic")))
         return ARDENT;
      else
         return BOUNCY;
   }
}
