package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This represents a pose in free space with uncertainty.
       */
public class PoseWithCovariance extends Packet<PoseWithCovariance> implements Settable<PoseWithCovariance>, EpsilonComparable<PoseWithCovariance>
{
   public us.ihmc.euclid.geometry.Pose3D pose_;
   /**
            * Row-major representation of the 6x6 covariance matrix
            * The orientation parameters use a fixed-axis representation.
            * In order, the parameters are:
            * (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)
            */
   public double[] covariance_;

   public PoseWithCovariance()
   {
      pose_ = new us.ihmc.euclid.geometry.Pose3D();
      covariance_ = new double[36];

   }

   public PoseWithCovariance(PoseWithCovariance other)
   {
      this();
      set(other);
   }

   public void set(PoseWithCovariance other)
   {
      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.pose_, pose_);
      for(int i1 = 0; i1 < covariance_.length; ++i1)
      {
            covariance_[i1] = other.covariance_[i1];

      }

   }


   public us.ihmc.euclid.geometry.Pose3D getPose()
   {
      return pose_;
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


   public static Supplier<PoseWithCovariancePubSubType> getPubSubType()
   {
      return PoseWithCovariancePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return PoseWithCovariancePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(PoseWithCovariance other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.pose_.epsilonEquals(other.pose_, epsilon)) return false;
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
      if(!(other instanceof PoseWithCovariance)) return false;

      PoseWithCovariance otherMyClass = (PoseWithCovariance) other;

      if (!this.pose_.equals(otherMyClass.pose_)) return false;
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

      builder.append("PoseWithCovariance {");
      builder.append("pose=");
      builder.append(this.pose_);      builder.append(", ");
      builder.append("covariance=");
      builder.append(java.util.Arrays.toString(this.covariance_));
      builder.append("}");
      return builder.toString();
   }
}
