package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "TwistWithCovariance" defined in TwistWithCovariance_.idl.
 *
 * This file was automatically generated from TwistWithCovariance_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit TwistWithCovariance_.idl instead.
 */
public class TwistWithCovariance implements Settable<TwistWithCovariance>, EpsilonComparable<TwistWithCovariance>
{
   private geometry_msgs.msg.dds.Twist twist_;
   /**
    * Row-major representation of the 6x6 covariance matrix
    * The orientation parameters use a fixed-axis representation.
    * In order, the parameters are:
    * (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)
    */
   private double[] covariance_;

   public TwistWithCovariance()
   {
      twist_ = new geometry_msgs.msg.dds.Twist();
      covariance_ = new double[36];
   }

   public TwistWithCovariance(TwistWithCovariance other)
   {
      set(other);
   }

   /**
    * Row-major representation of the 6x6 covariance matrix
    * The orientation parameters use a fixed-axis representation.
    * In order, the parameters are:
    * (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)
    */

   public void set(TwistWithCovariance other)
   {
      geometry_msgs.msg.dds.TwistPubSubType.staticCopy(other.twist_, twist_);
      for (int b = 0; b < covariance_.length; ++b)
      {
         covariance_[b] = other.covariance_[b];
      }
   }

   public geometry_msgs.msg.dds.Twist getTwist()
   {
      return twist_;
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
   public boolean epsilonEquals(TwistWithCovariance other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.twist_.epsilonEquals(other.twist_, epsilon))
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
      if (!(other instanceof TwistWithCovariance))
         return false;

      TwistWithCovariance otherMyClass = (TwistWithCovariance) other;

      if (!this.twist_.equals(otherMyClass.twist_))
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

      builder.append("TwistWithCovariance {");
      builder.append("twist=");
      builder.append(this.twist_);

      builder.append(", ");
      builder.append("covariance=");
      builder.append(java.util.Arrays.toString(this.covariance_));

      builder.append("}");
      return builder.toString();
   }
}