package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "PoseArray" defined in PoseArray_.idl.
 *
 * This file was automatically generated from PoseArray_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit PoseArray_.idl instead.
 */
public class PoseArray implements Settable<PoseArray>, EpsilonComparable<PoseArray>
{
   private std_msgs.msg.dds.Header header_;
   private us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.geometry.Pose3D> poses_;

   public PoseArray()
   {
      header_ = new std_msgs.msg.dds.Header();
      poses_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.geometry.Pose3D>(100, us.ihmc.euclid.geometry.Pose3D.class,
                                                                                  new geometry_msgs.msg.dds.PosePubSubType());
   }

   public PoseArray(PoseArray other)
   {
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

   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.geometry.Pose3D> getPoses()
   {
      return poses_;
   }

   @Override
   public boolean epsilonEquals(PoseArray other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (this.poses_.isEnum())
      {
         if (!this.poses_.equals(other.poses_))
            return false;
      }
      else if (this.poses_.size() == other.poses_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.poses_.size(); i++)
         {
            if (!this.poses_.get(i).epsilonEquals(other.poses_.get(i), epsilon))
               return false;
         }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof PoseArray))
         return false;

      PoseArray otherMyClass = (PoseArray) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.poses_.equals(otherMyClass.poses_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PoseArray {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("poses=");
      builder.append(this.poses_);

      builder.append("}");
      return builder.toString();
   }
}