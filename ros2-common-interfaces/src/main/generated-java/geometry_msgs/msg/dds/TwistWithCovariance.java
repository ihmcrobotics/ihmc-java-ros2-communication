package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

/**
       * This expresses velocity in free space with uncertainty.
       */
public class TwistWithCovariance extends Packet<TwistWithCovariance> implements Settable<TwistWithCovariance>, EpsilonComparable<TwistWithCovariance>
{
   public geometry_msgs.msg.dds.Twist twist_;
   /**
            * Row-major representation of the 6x6 covariance matrix
            * The orientation parameters use a fixed-axis representation.
            * In order, the parameters are:
            * (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)
            */
   public double[] covariance_;

   public TwistWithCovariance()
   {
      twist_ = new geometry_msgs.msg.dds.Twist();
      covariance_ = new double[36];

   }

   public TwistWithCovariance(TwistWithCovariance other)
   {
      this();
      set(other);
   }

   public void set(TwistWithCovariance other)
   {
      geometry_msgs.msg.dds.TwistPubSubType.staticCopy(other.twist_, twist_);
      for(int i1 = 0; i1 < covariance_.length; ++i1)
      {
            covariance_[i1] = other.covariance_[i1];

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
      if(other == null) return false;
      if(other == this) return true;

      if (!this.twist_.epsilonEquals(other.twist_, epsilon)) return false;
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
      if(!(other instanceof TwistWithCovariance)) return false;

      TwistWithCovariance otherMyClass = (TwistWithCovariance) other;

      if (!this.twist_.equals(otherMyClass.twist_)) return false;
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

      builder.append("TwistWithCovariance {");
      builder.append("twist=");
      builder.append(this.twist_);      builder.append(", ");
      builder.append("covariance=");
      builder.append(java.util.Arrays.toString(this.covariance_));
      builder.append("}");
      return builder.toString();
   }
}
