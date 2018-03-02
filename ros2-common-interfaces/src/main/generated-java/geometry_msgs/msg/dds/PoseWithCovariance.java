package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This represents a pose in free space with uncertainty.
 */
public class PoseWithCovariance implements Settable<PoseWithCovariance>, EpsilonComparable<PoseWithCovariance>
{
   private us.ihmc.euclid.geometry.Pose3D pose_;
   /**
    * Row-major representation of the 6x6 covariance matrix
    * The orientation parameters use a fixed-axis representation.
    * In order, the parameters are:
    * (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)
    */
   private double[] covariance_;

   public PoseWithCovariance()
   {
      pose_ = new us.ihmc.euclid.geometry.Pose3D();
      covariance_ = new double[36];
   }

   public PoseWithCovariance(PoseWithCovariance other)
   {
      set(other);
   }

   public void set(PoseWithCovariance other)
   {
      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.pose_, pose_);
      for (int b = 0; b < covariance_.length; ++b)
      {
         covariance_[b] = other.covariance_[b];
      }
   }

   public us.ihmc.euclid.geometry.Pose3D getPose()
   {
      return pose_;
   }

   /**
    * Row-major representation of the 6x6 covariance matrix
    * The orientation parameters use a fixed-axis representation.
    * In order, the parameters are:
    * (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)
    */
   public double[] getCovariance()
   {
      return covariance_;
   }

   @Override
   public boolean epsilonEquals(PoseWithCovariance other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.pose_.epsilonEquals(other.pose_, epsilon))
         return false;

      for (int d = 0; d < covariance_.length; ++d)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.covariance_[d], other.covariance_[d], epsilon))
            return false;
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
      if (!(other instanceof PoseWithCovariance))
         return false;

      PoseWithCovariance otherMyClass = (PoseWithCovariance) other;

      if (!this.pose_.equals(otherMyClass.pose_))
         return false;

      for (int f = 0; f < covariance_.length; ++f)
      {
         if (this.covariance_[f] != otherMyClass.covariance_[f])
            return false;
      }

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PoseWithCovariance {");
      builder.append("pose=");
      builder.append(this.pose_);

      builder.append(", ");
      builder.append("covariance=");
      builder.append(java.util.Arrays.toString(this.covariance_));

      builder.append("}");
      return builder.toString();
   }
}