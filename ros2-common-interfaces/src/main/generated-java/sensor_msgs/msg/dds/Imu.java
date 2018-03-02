package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This is a message to hold data from an IMU (Inertial Measurement Unit)
 *
 * Accelerations should be in m/s^2 (not in g's), and rotational velocity should be in rad/sec
 *
 * If the covariance of the measurement is known, it should be filled in (if all you know is the
 * variance of each measurement, e.g. from the datasheet, just put those along the diagonal)
 * A covariance matrix of all zeros will be interpreted as "covariance unknown", and to use the
 * data a covariance will have to be assumed or gotten from some other source
 *
 * If you have no estimate for one of the data elements (e.g. your IMU doesn't produce an
 * orientation estimate), please set element 0 of the associated covariance matrix to -1
 * If you are interpreting this message, please check for a value of -1 in the first element of each
 * covariance matrix, and disregard the associated estimate.
 */
public class Imu implements Settable<Imu>, EpsilonComparable<Imu>
{
   private std_msgs.msg.dds.Header header_;
   private us.ihmc.euclid.tuple4D.Quaternion orientation_;
   /**
    * Row major about x, y, z axes
    */
   private double[] orientation_covariance_;
   private us.ihmc.euclid.tuple3D.Vector3D angular_velocity_;
   /**
    * Row major about x, y, z axes
    */
   private double[] angular_velocity_covariance_;
   private us.ihmc.euclid.tuple3D.Vector3D linear_acceleration_;
   /**
    * Row major x, y z
    */
   private double[] linear_acceleration_covariance_;

   public Imu()
   {
      header_ = new std_msgs.msg.dds.Header();
      orientation_ = new us.ihmc.euclid.tuple4D.Quaternion();
      orientation_covariance_ = new double[9];

      angular_velocity_ = new us.ihmc.euclid.tuple3D.Vector3D();
      angular_velocity_covariance_ = new double[9];

      linear_acceleration_ = new us.ihmc.euclid.tuple3D.Vector3D();
      linear_acceleration_covariance_ = new double[9];
   }

   public Imu(Imu other)
   {
      set(other);
   }

   public void set(Imu other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.QuaternionPubSubType.staticCopy(other.orientation_, orientation_);
      for (int b = 0; b < orientation_covariance_.length; ++b)
      {
         orientation_covariance_[b] = other.orientation_covariance_[b];
      }

      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.angular_velocity_, angular_velocity_);
      for (int d = 0; d < angular_velocity_covariance_.length; ++d)
      {
         angular_velocity_covariance_[d] = other.angular_velocity_covariance_[d];
      }

      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.linear_acceleration_, linear_acceleration_);
      for (int f = 0; f < linear_acceleration_covariance_.length; ++f)
      {
         linear_acceleration_covariance_[f] = other.linear_acceleration_covariance_[f];
      }
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.euclid.tuple4D.Quaternion getOrientation()
   {
      return orientation_;
   }

   /**
    * Row major about x, y, z axes
    */
   public double[] getOrientationCovariance()
   {
      return orientation_covariance_;
   }

   public us.ihmc.euclid.tuple3D.Vector3D getAngularVelocity()
   {
      return angular_velocity_;
   }

   /**
    * Row major about x, y, z axes
    */
   public double[] getAngularVelocityCovariance()
   {
      return angular_velocity_covariance_;
   }

   public us.ihmc.euclid.tuple3D.Vector3D getLinearAcceleration()
   {
      return linear_acceleration_;
   }

   /**
    * Row major x, y z
    */
   public double[] getLinearAccelerationCovariance()
   {
      return linear_acceleration_covariance_;
   }

   @Override
   public boolean epsilonEquals(Imu other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.orientation_.epsilonEquals(other.orientation_, epsilon))
         return false;

      for (int h = 0; h < orientation_covariance_.length; ++h)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.orientation_covariance_[h], other.orientation_covariance_[h], epsilon))
            return false;
      }

      if (!this.angular_velocity_.epsilonEquals(other.angular_velocity_, epsilon))
         return false;

      for (int j = 0; j < angular_velocity_covariance_.length; ++j)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.angular_velocity_covariance_[j], other.angular_velocity_covariance_[j], epsilon))
            return false;
      }

      if (!this.linear_acceleration_.epsilonEquals(other.linear_acceleration_, epsilon))
         return false;

      for (int l = 0; l < linear_acceleration_covariance_.length; ++l)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.linear_acceleration_covariance_[l], other.linear_acceleration_covariance_[l], epsilon))
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
      if (!(other instanceof Imu))
         return false;

      Imu otherMyClass = (Imu) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.orientation_.equals(otherMyClass.orientation_))
         return false;

      for (int n = 0; n < orientation_covariance_.length; ++n)
      {
         if (this.orientation_covariance_[n] != otherMyClass.orientation_covariance_[n])
            return false;
      }
      if (!this.angular_velocity_.equals(otherMyClass.angular_velocity_))
         return false;

      for (int p = 0; p < angular_velocity_covariance_.length; ++p)
      {
         if (this.angular_velocity_covariance_[p] != otherMyClass.angular_velocity_covariance_[p])
            return false;
      }
      if (!this.linear_acceleration_.equals(otherMyClass.linear_acceleration_))
         return false;

      for (int r = 0; r < linear_acceleration_covariance_.length; ++r)
      {
         if (this.linear_acceleration_covariance_[r] != otherMyClass.linear_acceleration_covariance_[r])
            return false;
      }

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Imu {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("orientation=");
      builder.append(this.orientation_);

      builder.append(", ");
      builder.append("orientation_covariance=");
      builder.append(java.util.Arrays.toString(this.orientation_covariance_));

      builder.append(", ");
      builder.append("angular_velocity=");
      builder.append(this.angular_velocity_);

      builder.append(", ");
      builder.append("angular_velocity_covariance=");
      builder.append(java.util.Arrays.toString(this.angular_velocity_covariance_));

      builder.append(", ");
      builder.append("linear_acceleration=");
      builder.append(this.linear_acceleration_);

      builder.append(", ");
      builder.append("linear_acceleration_covariance=");
      builder.append(java.util.Arrays.toString(this.linear_acceleration_covariance_));

      builder.append("}");
      return builder.toString();
   }
}