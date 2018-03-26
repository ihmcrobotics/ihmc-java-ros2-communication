package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Single pressure reading.  This message is appropriate for measuring the
 * pressure inside of a fluid (air, water, etc).  This also includes
 * atmospheric or barometric pressure.
 * This message is not appropriate for force/pressure contact sensors.
 * frame_id is the location of the pressure sensor
 */
public class FluidPressure implements Settable<FluidPressure>, EpsilonComparable<FluidPressure>
{
   /**
    * timestamp of the measurement
    */
   public std_msgs.msg.dds.Header header_;
   /**
    * Absolute pressure reading in Pascals.
    */
   public double fluid_pressure_;
   /**
    * 0 is interpreted as variance unknown
    */
   public double variance_;

   public FluidPressure()
   {
      header_ = new std_msgs.msg.dds.Header();
   }

   public FluidPressure(FluidPressure other)
   {
      set(other);
   }

   public void set(FluidPressure other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      fluid_pressure_ = other.fluid_pressure_;

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
    * Absolute pressure reading in Pascals.
    */
   public double getFluidPressure()
   {
      return fluid_pressure_;
   }

   /**
    * Absolute pressure reading in Pascals.
    */
   public void setFluidPressure(double fluid_pressure)
   {
      fluid_pressure_ = fluid_pressure;
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
   public boolean epsilonEquals(FluidPressure other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.fluid_pressure_, other.fluid_pressure_, epsilon))
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
      if (!(other instanceof FluidPressure))
         return false;

      FluidPressure otherMyClass = (FluidPressure) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.fluid_pressure_ != otherMyClass.fluid_pressure_)
         return false;

      if (this.variance_ != otherMyClass.variance_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("FluidPressure {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("fluid_pressure=");
      builder.append(this.fluid_pressure_);

      builder.append(", ");
      builder.append("variance=");
      builder.append(this.variance_);

      builder.append("}");
      return builder.toString();
   }
}