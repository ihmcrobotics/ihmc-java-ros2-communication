package sensor_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
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
        	for(int i1 = 0; i1 < orientation_covariance_.length; ++i1)
        	{
        	    	orientation_covariance_[i1] = other.orientation_covariance_[i1];	

        	}
        	

           	geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.angular_velocity_, angular_velocity_);
        	for(int i3 = 0; i3 < angular_velocity_covariance_.length; ++i3)
        	{
        	    	angular_velocity_covariance_[i3] = other.angular_velocity_covariance_[i3];	

        	}
        	

           	geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.linear_acceleration_, linear_acceleration_);
        	for(int i5 = 0; i5 < linear_acceleration_covariance_.length; ++i5)
        	{
        	    	linear_acceleration_covariance_[i5] = other.linear_acceleration_covariance_[i5];	

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
        if(other == null) return false;
        if(other == this) return true;

                        if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
                
                        if (!this.orientation_.epsilonEquals(other.orientation_, epsilon)) return false;
                
                        for(int i7 = 0; i7 < orientation_covariance_.length; ++i7)
                        {
                                    if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.orientation_covariance_[i7], other.orientation_covariance_[i7], epsilon)) return false;
                        }
                
                        if (!this.angular_velocity_.epsilonEquals(other.angular_velocity_, epsilon)) return false;
                
                        for(int i9 = 0; i9 < angular_velocity_covariance_.length; ++i9)
                        {
                                    if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.angular_velocity_covariance_[i9], other.angular_velocity_covariance_[i9], epsilon)) return false;
                        }
                
                        if (!this.linear_acceleration_.epsilonEquals(other.linear_acceleration_, epsilon)) return false;
                
                        for(int i11 = 0; i11 < linear_acceleration_covariance_.length; ++i11)
                        {
                                    if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.linear_acceleration_covariance_[i11], other.linear_acceleration_covariance_[i11], epsilon)) return false;
                        }
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof Imu)) return false;

        Imu otherMyClass = (Imu) other;

                        if (!this.header_.equals(otherMyClass.header_)) return false;
                
                        if (!this.orientation_.equals(otherMyClass.orientation_)) return false;
                
                        for(int i13 = 0; i13 < orientation_covariance_.length; ++i13)
                        {
                                    if(this.orientation_covariance_[i13] != otherMyClass.orientation_covariance_[i13]) return false;

                        }        
                        if (!this.angular_velocity_.equals(otherMyClass.angular_velocity_)) return false;
                
                        for(int i15 = 0; i15 < angular_velocity_covariance_.length; ++i15)
                        {
                                    if(this.angular_velocity_covariance_[i15] != otherMyClass.angular_velocity_covariance_[i15]) return false;

                        }        
                        if (!this.linear_acceleration_.equals(otherMyClass.linear_acceleration_)) return false;
                
                        for(int i17 = 0; i17 < linear_acceleration_covariance_.length; ++i17)
                        {
                                    if(this.linear_acceleration_covariance_[i17] != otherMyClass.linear_acceleration_covariance_[i17]) return false;

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
        

}