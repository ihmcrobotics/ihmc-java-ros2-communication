package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "MagneticField" defined in MagneticField_.idl.
 *
 * This file was automatically generated from MagneticField_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit MagneticField_.idl instead.
 */
public class MagneticField implements Settable<MagneticField>, EpsilonComparable<MagneticField>
{
   private std_msgs.msg.dds.Header header_;
   private us.ihmc.euclid.tuple3D.Vector3D magnetic_field_;
   private double[] magnetic_field_covariance_;

   public MagneticField()
   {
      header_ = new std_msgs.msg.dds.Header();
      magnetic_field_ = new us.ihmc.euclid.tuple3D.Vector3D();
      magnetic_field_covariance_ = new double[9];
   }

   public MagneticField(MagneticField other)
   {
      set(other);
   }

   public void set(MagneticField other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.magnetic_field_, magnetic_field_);
      for (int b = 0; b < magnetic_field_covariance_.length; ++b)
      {
         magnetic_field_covariance_[b] = other.magnetic_field_covariance_[b];
      }
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.euclid.tuple3D.Vector3D getMagneticField()
   {
      return magnetic_field_;
   }

   public double[] getMagneticFieldCovariance()
   {
      return magnetic_field_covariance_;
   }

   @Override
   public boolean epsilonEquals(MagneticField other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.magnetic_field_.epsilonEquals(other.magnetic_field_, epsilon))
         return false;

      for (int d = 0; d < magnetic_field_covariance_.length; ++d)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.magnetic_field_covariance_[d], other.magnetic_field_covariance_[d], epsilon))
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
      if (!(other instanceof MagneticField))
         return false;

      MagneticField otherMyClass = (MagneticField) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.magnetic_field_.equals(otherMyClass.magnetic_field_))
         return false;

      for (int f = 0; f < magnetic_field_covariance_.length; ++f)
      {
         if (this.magnetic_field_covariance_[f] != otherMyClass.magnetic_field_covariance_[f])
            return false;
      }

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MagneticField {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("magnetic_field=");
      builder.append(this.magnetic_field_);

      builder.append(", ");
      builder.append("magnetic_field_covariance=");
      builder.append(java.util.Arrays.toString(this.magnetic_field_covariance_));

      builder.append("}");
      return builder.toString();
   }
}