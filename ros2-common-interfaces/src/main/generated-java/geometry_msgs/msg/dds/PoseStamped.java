package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * A Pose with reference coordinate frame and timestamp
       */
public class PoseStamped extends Packet<PoseStamped> implements Settable<PoseStamped>, EpsilonComparable<PoseStamped>
{

   public std_msgs.msg.dds.Header header_;

   public us.ihmc.euclid.geometry.Pose3D pose_;

   public PoseStamped()
   {

      header_ = new std_msgs.msg.dds.Header();

      pose_ = new us.ihmc.euclid.geometry.Pose3D();

   }

   public PoseStamped(PoseStamped other)
   {
      this();
      set(other);
   }

   public void set(PoseStamped other)
   {

      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);

      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.pose_, pose_);
   }



   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }



   public us.ihmc.euclid.geometry.Pose3D getPose()
   {
      return pose_;
   }


   public static Supplier<PoseStampedPubSubType> getPubSubType()
   {
      return PoseStampedPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return PoseStampedPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(PoseStamped other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;


      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;

      if (!this.pose_.epsilonEquals(other.pose_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof PoseStamped)) return false;

      PoseStamped otherMyClass = (PoseStamped) other;


      if (!this.header_.equals(otherMyClass.header_)) return false;

      if (!this.pose_.equals(otherMyClass.pose_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PoseStamped {");

      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");

      builder.append("pose=");
      builder.append(this.pose_);
      builder.append("}");
      return builder.toString();
   }
}
