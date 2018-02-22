package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "FluidPressure" defined in FluidPressure_.idl.
 *
 * This file was automatically generated from FluidPressure_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit FluidPressure_.idl instead.
 */
public class FluidPressure implements Settable<FluidPressure>, EpsilonComparable<FluidPressure>
{
   private std_msgs.msg.dds.Header header_;
   private double fluid_pressure_;
   private double variance_;

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

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public double getFluidPressure()
   {
      return fluid_pressure_;
   }

   public void setFluidPressure(double fluid_pressure)
   {
      fluid_pressure_ = fluid_pressure;
   }

   public double getVariance()
   {
      return variance_;
   }

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