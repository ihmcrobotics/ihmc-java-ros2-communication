package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This expresses acceleration in free space with uncertainty.
       */
public class AccelWithCovariance extends Packet<AccelWithCovariance> implements Settable<AccelWithCovariance>, EpsilonComparable<AccelWithCovariance>
{

   public geometry_msgs.msg.dds.Accel accel_;

   /**
            * Row-major representation of the 6x6 covariance matrix
            * The orientation parameters use a fixed-axis representation.
            * In order, the parameters are:
            * (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)
            */
   public double[] covariance_;

   public AccelWithCovariance()
   {

      accel_ = new geometry_msgs.msg.dds.Accel();

      covariance_ = new double[36];


   }

   public AccelWithCovariance(AccelWithCovariance other)
   {
      this();
      set(other);
   }

   public void set(AccelWithCovariance other)
   {

      geometry_msgs.msg.dds.AccelPubSubType.staticCopy(other.accel_, accel_);

      for(int i1 = 0; i1 < covariance_.length; ++i1)
      {
            covariance_[i1] = other.covariance_[i1];

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


   public static Supplier<AccelWithCovariancePubSubType> getPubSubType()
   {
      return AccelWithCovariancePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return AccelWithCovariancePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(AccelWithCovariance other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;


      if (!this.accel_.epsilonEquals(other.accel_, epsilon)) return false;

      for(int i3 = 0; i3 < covariance_.length; ++i3)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.covariance_[i3], other.covariance_[i3], epsilon)) return false;
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof AccelWithCovariance)) return false;

      AccelWithCovariance otherMyClass = (AccelWithCovariance) other;


      if (!this.accel_.equals(otherMyClass.accel_)) return false;

      for(int i5 = 0; i5 < covariance_.length; ++i5)
      {
                if(this.covariance_[i5] != otherMyClass.covariance_[i5]) return false;

      }

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("AccelWithCovariance {");

      builder.append("accel=");
      builder.append(this.accel_);      builder.append(", ");

      builder.append("covariance=");
      builder.append(java.util.Arrays.toString(this.covariance_));
      builder.append("}");
      return builder.toString();
   }
}
