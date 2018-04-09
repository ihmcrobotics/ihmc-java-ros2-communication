package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

/**
       * An array of poses with a header for global reference.
       */
public class PoseArray extends Packet<PoseArray> implements Settable<PoseArray>, EpsilonComparable<PoseArray>
{
   public std_msgs.msg.dds.Header header_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.geometry.Pose3D>  poses_;

   public PoseArray()
   {
      header_ = new std_msgs.msg.dds.Header();
      poses_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.geometry.Pose3D> (100, us.ihmc.euclid.geometry.Pose3D.class, new geometry_msgs.msg.dds.PosePubSubType());

   }

   public PoseArray(PoseArray other)
   {
      this();
      set(other);
   }

   public void set(PoseArray other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      poses_.set(other.poses_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.geometry.Pose3D>  getPoses()
   {
      return poses_;
   }


   @Override
   public boolean epsilonEquals(PoseArray other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (this.poses_.size() != other.poses_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.poses_.size(); i++)
         {  if (!this.poses_.get(i).epsilonEquals(other.poses_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof PoseArray)) return false;

      PoseArray otherMyClass = (PoseArray) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.poses_.equals(otherMyClass.poses_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PoseArray {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("poses=");
      builder.append(this.poses_);
      builder.append("}");
      return builder.toString();
   }
}
