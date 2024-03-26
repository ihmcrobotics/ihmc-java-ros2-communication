package us.ihmc.ros2;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

/**
 * ROS2 QoS profile settings Provides a quick way to set the ROS2 QoS settings. Provided options are
 * - History KEEP_LAST or KEEP_ALL
 * - Size default history depth (aka size)
 * - Reliability RELIABLE or BEST EFFORT
 * - Durability VOLATILE or TRANSIENT_LOCAL
 * - avoidRosNamespaceConventions Use the Node name directly for communication with pure RTPS/DDS nodes
 *
 * @author Jesper Smith
 */
public class ROS2QosProfile
{
   public static ROS2QosProfile RELIABLE()
   {
      int depth = 1;
      return new ROS2QosProfile(HistoryQosKindType.KEEP_LAST, depth, ReliabilityQosKindType.RELIABLE, DurabilityQosKindType.VOLATILE, false);
   }

   public static ROS2QosProfile KEEP_HISTORY(int depth)
   {
      return new ROS2QosProfile(HistoryQosKindType.KEEP_LAST, depth, ReliabilityQosKindType.RELIABLE, DurabilityQosKindType.TRANSIENT_LOCAL, false);
   }

   public static ROS2QosProfile BEST_EFFORT()
   {
      int depth = 1;
      return new ROS2QosProfile(HistoryQosKindType.KEEP_LAST, depth, ReliabilityQosKindType.BEST_EFFORT, DurabilityQosKindType.VOLATILE, false);
   }

   private final HistoryQosKindType historyKind;
   private final int historyDepth;
   private final ReliabilityQosKindType reliabilityKind;
   private final DurabilityQosKindType durabilityKind;
   private final boolean avoidRosNamespaceConventions;

   public ROS2QosProfile(HistoryQosKindType historyKind,
                         int historyDepth,
                         ReliabilityQosKindType reliabilityKind,
                         DurabilityQosKindType durabilityKind,
                         boolean avoidRosNamespaceConventions)
   {
      this.historyKind = historyKind;
      this.historyDepth = historyDepth;
      this.reliabilityKind = reliabilityKind;
      this.durabilityKind = durabilityKind;
      this.avoidRosNamespaceConventions = avoidRosNamespaceConventions;
   }

   public HistoryQosKindType getHistoryKind()
   {
      return historyKind;
   }

   public int getHistoryDepth()
   {
      return historyDepth;
   }

   public ReliabilityQosKindType getReliabilityKind()
   {
      return reliabilityKind;
   }

   public DurabilityQosKindType getDurabilityKind()
   {
      return durabilityKind;
   }

   public boolean isAvoidRosNamespaceConventions()
   {
      return avoidRosNamespaceConventions;
   }
}
