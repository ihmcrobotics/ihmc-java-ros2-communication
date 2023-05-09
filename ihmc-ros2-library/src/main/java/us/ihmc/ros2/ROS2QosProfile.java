package us.ihmc.ros2;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

/**
 * ROS2 QoS profile settings Provides a quick way to set the ROS2 QoS settings. Provided options are
 * - History KEEP_LAST or KEEP_ALL (default KEEP_LAST)
 * - Size default history size (default 1)
 * - Reliability RELIABLE or BEST EFFORT (default RELIABLE)
 * - Durability (default VOLATILE)
 * - avoidRosNamespaceConventions Use the Node name directly for communication with pure RTPS/DDS nodes
 *
 * @author Jesper Smith
 */
public class ROS2QosProfile
{
   public static ROS2QosProfile DEFAULT()
   {
      return new ROS2QosProfile();
   }

   public static ROS2QosProfile KEEP_HISTORY(int depth)
   {
      return new ROS2QosProfile(HistoryQosKindType.KEEP_LAST, depth, ReliabilityQosKindType.RELIABLE, ROS2Durability.TRANSIENT_LOCAL, false);
   }

   public static ROS2QosProfile BEST_EFFORT()
   {
      return new ROS2QosProfile(HistoryQosKindType.KEEP_LAST, 1, ReliabilityQosKindType.BEST_EFFORT, ROS2Durability.VOLATILE, false);
   }

   public enum ROS2Durability
   {
      VOLATILE, TRANSIENT_LOCAL;

      public DurabilityQosKindType toKind()
      {
         return switch (this)
         {
            case VOLATILE -> DurabilityQosKindType.VOLATILE;
            case TRANSIENT_LOCAL -> DurabilityQosKindType.TRANSIENT_LOCAL;
         };
      }
   }

   private HistoryQosKindType history = HistoryQosKindType.KEEP_LAST;
   private int depth = 1;
   private ReliabilityQosKindType reliability = ReliabilityQosKindType.RELIABLE;
   private ROS2Durability durability = ROS2Durability.VOLATILE;
   private boolean avoidRosNamespaceConventions = false;

   public ROS2QosProfile()
   {
   }

   public ROS2QosProfile(HistoryQosKindType history,
                         int depth,
                         ReliabilityQosKindType reliability,
                         ROS2Durability durability,
                         boolean avoidRosNamespaceConventions)
   {
      this();
      this.history = history;
      this.depth = depth;
      this.reliability = reliability;
      this.durability = durability;
      this.avoidRosNamespaceConventions = avoidRosNamespaceConventions;
   }

   public HistoryQosKindType getHistory()
   {
      return history;
   }

   public void setHistory(HistoryQosKindType history)
   {
      this.history = history;
   }

   public int getSize()
   {
      return depth;
   }

   public void setSize(int depth)
   {
      this.depth = depth;
   }

   public ReliabilityQosKindType getReliability()
   {
      return reliability;
   }

   public void setReliability(ReliabilityQosKindType reliability)
   {
      this.reliability = reliability;
   }

   public ROS2Durability getDurability()
   {
      return durability;
   }

   public void setDurability(ROS2Durability durability)
   {
      this.durability = durability;
   }

   public boolean isAvoidRosNamespaceConventions()
   {
      return avoidRosNamespaceConventions;
   }

   public void setAvoidRosNamespaceConventions(boolean avoidRosNamespaceConventions)
   {
      this.avoidRosNamespaceConventions = avoidRosNamespaceConventions;
   }
}
