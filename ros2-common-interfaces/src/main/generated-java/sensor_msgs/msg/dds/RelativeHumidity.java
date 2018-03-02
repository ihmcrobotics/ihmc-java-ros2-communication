package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "RelativeHumidity" defined in RelativeHumidity_.idl.
 *
 * This file was automatically generated from RelativeHumidity_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit RelativeHumidity_.idl instead.
 */
public class RelativeHumidity implements Settable<RelativeHumidity>, EpsilonComparable<RelativeHumidity>
{
   /**
    * timestamp of the measurement
    */
   private std_msgs.msg.dds.Header header_;
   /**
    * Expression of the relative humidity
    */
   private double relative_humidity_;
   /**
    * 0 is interpreted as variance unknown
    */
   private double variance_;

   /**
    * timestamp of the measurement
    */

   public RelativeHumidity()
   {
      header_ = new std_msgs.msg.dds.Header();
   }

   public RelativeHumidity(RelativeHumidity other)
   {
      set(other);
   }

   public void set(RelativeHumidity other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      relative_humidity_ = other.relative_humidity_;

      variance_ = other.variance_;
   }

   /**
    * timestamp of the measurement
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * Expression of the relative humidity
    */
   public double getRelativeHumidity()
   {
      return relative_humidity_;
   }

   /**
    * Expression of the relative humidity
    */
   public void setRelativeHumidity(double relative_humidity)
   {
      relative_humidity_ = relative_humidity;
   }

   /**
    * 0 is interpreted as variance unknown
    */
   public double getVariance()
   {
      return variance_;
   }

   /**
    * 0 is interpreted as variance unknown
    */
   public void setVariance(double variance)
   {
      variance_ = variance;
   }

   @Override
   public boolean epsilonEquals(RelativeHumidity other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.relative_humidity_, other.relative_humidity_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.variance_, other.variance_, epsilon))
         return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof RelativeHumidity))
         return false;

      RelativeHumidity otherMyClass = (RelativeHumidity) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.relative_humidity_ != otherMyClass.relative_humidity_)
         return false;

      if (this.variance_ != otherMyClass.variance_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("RelativeHumidity {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("relative_humidity=");
      builder.append(this.relative_humidity_);

      builder.append(", ");
      builder.append("variance=");
      builder.append(this.variance_);

      builder.append("}");
      return builder.toString();
   }
}