package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Measurement of the Magnetic Field vector at a specific location.
       * 
       * If the covariance of the measurement is known, it should be filled in.
       * If all you know is the variance of each measurement, e.g. from the datasheet,
       * just put those along the diagonal.
       * A covariance matrix of all zeros will be interpreted as "covariance unknown",
       * and to use the data a covariance will have to be assumed or gotten from some
       * other source.
       * field was measured
       * frame_id is the location and orientation
       * of the field measurement
       * field vector in Tesla
       * If your sensor does not output 3 axes,
       * put NaNs in the components not reported.
       */
public class MagneticField extends Packet<MagneticField> implements Settable<MagneticField>, EpsilonComparable<MagneticField>
{
   /**
            * timestamp is the time the
            */
   public std_msgs.msg.dds.Header header_;
   /**
            * x, y, and z components of the
            */
   public us.ihmc.euclid.tuple3D.Vector3D magnetic_field_;
   /**
            * Row major about x, y, z axes
            */
   public double[] magnetic_field_covariance_;

   public MagneticField()
   {
      header_ = new std_msgs.msg.dds.Header();
      magnetic_field_ = new us.ihmc.euclid.tuple3D.Vector3D();
      magnetic_field_covariance_ = new double[9];

   }

   public MagneticField(MagneticField other)
   {
      this();
      set(other);
   }

   public void set(MagneticField other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.magnetic_field_, magnetic_field_);
      for(int i1 = 0; i1 < magnetic_field_covariance_.length; ++i1)
      {
            magnetic_field_covariance_[i1] = other.magnetic_field_covariance_[i1];

      }

   }


   /**
            * timestamp is the time the
            */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   /**
            * x, y, and z components of the
            */
   public us.ihmc.euclid.tuple3D.Vector3D getMagneticField()
   {
      return magnetic_field_;
   }


   /**
            * Row major about x, y, z axes
            */
   public double[] getMagneticFieldCovariance()
   {
      return magnetic_field_covariance_;
   }


   public static Supplier<MagneticFieldPubSubType> getPubSubType()
   {
      return MagneticFieldPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MagneticFieldPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(MagneticField other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!this.magnetic_field_.epsilonEquals(other.magnetic_field_, epsilon)) return false;
      for(int i3 = 0; i3 < magnetic_field_covariance_.length; ++i3)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.magnetic_field_covariance_[i3], other.magnetic_field_covariance_[i3], epsilon)) return false;
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof MagneticField)) return false;

      MagneticField otherMyClass = (MagneticField) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.magnetic_field_.equals(otherMyClass.magnetic_field_)) return false;
      for(int i5 = 0; i5 < magnetic_field_covariance_.length; ++i5)
      {
                if(this.magnetic_field_covariance_[i5] != otherMyClass.magnetic_field_covariance_[i5]) return false;

      }

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MagneticField {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("magnetic_field=");
      builder.append(this.magnetic_field_);      builder.append(", ");
      builder.append("magnetic_field_covariance=");
      builder.append(java.util.Arrays.toString(this.magnetic_field_covariance_));
      builder.append("}");
      return builder.toString();
   }
}
