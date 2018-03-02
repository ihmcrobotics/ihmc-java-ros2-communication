package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "AccelWithCovariance" defined in AccelWithCovariance_.idl.
 *
 * This file was automatically generated from AccelWithCovariance_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit AccelWithCovariance_.idl instead.
 */
public class AccelWithCovariance implements Settable<AccelWithCovariance>, EpsilonComparable<AccelWithCovariance>
{
   private geometry_msgs.msg.dds.Accel accel_;
   /**
    * Row-major representation of the 6x6 covariance matrix
    * The orientation parameters use a fixed-axis representation.
    * In order, the parameters are:
    * (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)
    */
   private double[] covariance_;

   public AccelWithCovariance()
   {
      accel_ = new geometry_msgs.msg.dds.Accel();
      covariance_ = new double[36];
   }

   public AccelWithCovariance(AccelWithCovariance other)
   {
      set(other);
   }

   /**
    * Row-major representation of the 6x6 covariance matrix
    * The orientation parameters use a fixed-axis representation.
    * In order, the parameters are:
    * (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)
    */

   public void set(AccelWithCovariance other)
   {
      geometry_msgs.msg.dds.AccelPubSubType.staticCopy(other.accel_, accel_);
      for (int b = 0; b < covariance_.length; ++b)
      {
         covariance_[b] = other.covariance_[b];
      }
   }

   public geometry_msgs.msg.dds.Accel getAccel()
   {
      return accel_;
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
   public boolean epsilonEquals(AccelWithCovariance other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.accel_.epsilonEquals(other.accel_, epsilon))
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
      if (!(other instanceof AccelWithCovariance))
         return false;

      AccelWithCovariance otherMyClass = (AccelWithCovariance) other;

      if (!this.accel_.equals(otherMyClass.accel_))
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

      builder.append("AccelWithCovariance {");
      builder.append("accel=");
      builder.append(this.accel_);

      builder.append(", ");
      builder.append("covariance=");
      builder.append(java.util.Arrays.toString(this.covariance_));

      builder.append("}");
      return builder.toString();
   }
}