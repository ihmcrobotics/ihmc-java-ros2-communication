package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Single photometric illuminance measurement.  Light should be assumed to be
 * measured along the sensor's x-axis (the area of detection is the y-z plane).
 * The illuminance should have a 0 or positive value and be received with
 * the sensor's +X axis pointing toward the light source.
 * Photometric illuminance is the measure of the human eye's sensitivity of the
 * intensity of light encountering or passing through a surface.
 * All other Photometric and Radiometric measurements should not use this message.
 * This message cannot represent:
 * - Luminous intensity (candela/light source output)
 * - Luminance (nits/light output per area)
 * - Irradiance (watt/area), etc.
 * frame_id is the location and direction of the reading
 */
public class Illuminance implements Settable<Illuminance>, EpsilonComparable<Illuminance>
{
   /**
    * timestamp is the time the illuminance was measured
    */
   private std_msgs.msg.dds.Header header_;
   /**
    * Measurement of the Photometric Illuminance in Lux.
    */
   private double illuminance_;
   /**
    * 0 is interpreted as variance unknown
    */
   private double variance_;

   public Illuminance()
   {
      header_ = new std_msgs.msg.dds.Header();
   }

   public Illuminance(Illuminance other)
   {
      set(other);
   }

   public void set(Illuminance other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      illuminance_ = other.illuminance_;

      variance_ = other.variance_;
   }

   /**
    * timestamp is the time the illuminance was measured
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * Measurement of the Photometric Illuminance in Lux.
    */
   public double getIlluminance()
   {
      return illuminance_;
   }

   /**
    * Measurement of the Photometric Illuminance in Lux.
    */
   public void setIlluminance(double illuminance)
   {
      illuminance_ = illuminance;
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
   public boolean epsilonEquals(Illuminance other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.illuminance_, other.illuminance_, epsilon))
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
      if (!(other instanceof Illuminance))
         return false;

      Illuminance otherMyClass = (Illuminance) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.illuminance_ != otherMyClass.illuminance_)
         return false;

      if (this.variance_ != otherMyClass.variance_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Illuminance {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("illuminance=");
      builder.append(this.illuminance_);

      builder.append(", ");
      builder.append("variance=");
      builder.append(this.variance_);

      builder.append("}");
      return builder.toString();
   }
}