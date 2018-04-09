package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

/**
       * Single temperature reading.
       * frame_id is the location of the temperature reading
       */
public class Temperature extends Packet<Temperature> implements Settable<Temperature>, EpsilonComparable<Temperature>
{
   /**
            * timestamp is the time the temperature was measured
            */
   public std_msgs.msg.dds.Header header_;
   /**
            * Measurement of the Temperature in Degrees Celsius.
            */
   public double temperature_;
   /**
            * 0 is interpreted as variance unknown.
            */
   public double variance_;

   public Temperature()
   {
      header_ = new std_msgs.msg.dds.Header();
   }

   public Temperature(Temperature other)
   {
      this();
      set(other);
   }

   public void set(Temperature other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      temperature_ = other.temperature_;

      variance_ = other.variance_;

   }


   /**
            * timestamp is the time the temperature was measured
            */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
            * Measurement of the Temperature in Degrees Celsius.
            */
   public void setTemperature(double temperature)
   {
      temperature_ = temperature;
   }
   /**
            * Measurement of the Temperature in Degrees Celsius.
            */
   public double getTemperature()
   {
      return temperature_;
   }

   /**
            * 0 is interpreted as variance unknown.
            */
   public void setVariance(double variance)
   {
      variance_ = variance;
   }
   /**
            * 0 is interpreted as variance unknown.
            */
   public double getVariance()
   {
      return variance_;
   }


   @Override
   public boolean epsilonEquals(Temperature other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.temperature_, other.temperature_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.variance_, other.variance_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Temperature)) return false;

      Temperature otherMyClass = (Temperature) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if(this.temperature_ != otherMyClass.temperature_) return false;

      if(this.variance_ != otherMyClass.variance_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Temperature {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("temperature=");
      builder.append(this.temperature_);      builder.append(", ");
      builder.append("variance=");
      builder.append(this.variance_);
      builder.append("}");
      return builder.toString();
   }
}
