package sensor_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
/**
       * Navigation Satellite fix for any Global Navigation Satellite System
       * 
       * Specified using the WGS 84 reference ellipsoid
       * If the covariance of the fix is known, fill it in completely. If the
       * GPS receiver provides the variance of each measurement, put them
       * along the diagonal. If only Dilution of Precision is available,
       * estimate an approximate covariance from that.
       */
public class NavSatFix implements Settable<NavSatFix>, EpsilonComparable<NavSatFix>
{
                public static final byte COVARIANCE_TYPE_UNKNOWN = (byte) 0;                public static final byte COVARIANCE_TYPE_APPROXIMATED = (byte) 1;                public static final byte COVARIANCE_TYPE_DIAGONAL_KNOWN = (byte) 2;                public static final byte COVARIANCE_TYPE_KNOWN = (byte) 3;    
    public NavSatFix()
    {
        	header_ = new std_msgs.msg.dds.Header();
        	status_ = new sensor_msgs.msg.dds.NavSatStatus();



        	position_covariance_ = new double[9];


    }

    public NavSatFix(NavSatFix other)
    {
        set(other);
    }

    public void set(NavSatFix other)
    {
           	std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
           	sensor_msgs.msg.dds.NavSatStatusPubSubType.staticCopy(other.status_, status_);
        	latitude_ = other.latitude_;

        	longitude_ = other.longitude_;

        	altitude_ = other.altitude_;

        	for(int i1 = 0; i1 < position_covariance_.length; ++i1)
        	{
        	    	position_covariance_[i1] = other.position_covariance_[i1];	

        	}
        	

        	position_covariance_type_ = other.position_covariance_type_;

    }


        /**
                 * header.stamp specifies the ROS time for this measurement (the
                 * corresponding satellite time may be reported using the
                 * sensor_msgs/TimeReference message).
                 * 
                 * header.frame_id is the frame of reference reported by the satellite
                 * receiver, usually the location of the antenna.  This is a
                 * Euclidean frame relative to the vehicle, not a reference
                 * ellipsoid.
                 */
    public std_msgs.msg.dds.Header getHeader()
    {
        return header_;
    }

        

        /**
                 * Satellite fix status information.
                 */
    public sensor_msgs.msg.dds.NavSatStatus getStatus()
    {
        return status_;
    }

        
        /**
                 * Latitude [degrees]. Positive is north of equator; negative is south.
                 */
    public void setLatitude(double latitude)
    {
        latitude_ = latitude;
    }

        /**
                 * Latitude [degrees]. Positive is north of equator; negative is south.
                 */
    public double getLatitude()
    {
        return latitude_;
    }

        
        /**
                 * Longitude [degrees]. Positive is east of prime meridian; negative is west.
                 */
    public void setLongitude(double longitude)
    {
        longitude_ = longitude;
    }

        /**
                 * Longitude [degrees]. Positive is east of prime meridian; negative is west.
                 */
    public double getLongitude()
    {
        return longitude_;
    }

        
        /**
                 * Altitude [m]. Positive is above the WGS 84 ellipsoid
                 * (quiet NaN if no altitude is available).
                 */
    public void setAltitude(double altitude)
    {
        altitude_ = altitude;
    }

        /**
                 * Altitude [m]. Positive is above the WGS 84 ellipsoid
                 * (quiet NaN if no altitude is available).
                 */
    public double getAltitude()
    {
        return altitude_;
    }

        

        /**
                 * Position covariance [m^2] defined relative to a tangential plane
                 * through the reported position. The components are East, North, and
                 * Up (ENU), in row-major order.
                 * 
                 * Beware: this coordinate system exhibits singularities at the poles.
                 */
    public double[] getPositionCovariance()
    {
        return position_covariance_;
    }

        
    public void setPositionCovarianceType(byte position_covariance_type)
    {
        position_covariance_type_ = position_covariance_type;
    }

    public byte getPositionCovarianceType()
    {
        return position_covariance_type_;
    }

        


    @Override
    public boolean epsilonEquals(NavSatFix other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
                
                        if (!this.status_.epsilonEquals(other.status_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.latitude_, other.latitude_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.longitude_, other.longitude_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.altitude_, other.altitude_, epsilon)) return false;
                
                        for(int i3 = 0; i3 < position_covariance_.length; ++i3)
                        {
                                    if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.position_covariance_[i3], other.position_covariance_[i3], epsilon)) return false;
                        }
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.position_covariance_type_, other.position_covariance_type_, epsilon)) return false;
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof NavSatFix)) return false;

        NavSatFix otherMyClass = (NavSatFix) other;

                        if (!this.header_.equals(otherMyClass.header_)) return false;
                
                        if (!this.status_.equals(otherMyClass.status_)) return false;
                
                        if(this.latitude_ != otherMyClass.latitude_) return false;

                
                        if(this.longitude_ != otherMyClass.longitude_) return false;

                
                        if(this.altitude_ != otherMyClass.altitude_) return false;

                
                        for(int i5 = 0; i5 < position_covariance_.length; ++i5)
                        {
                                    if(this.position_covariance_[i5] != otherMyClass.position_covariance_[i5]) return false;

                        }        
                        if(this.position_covariance_type_ != otherMyClass.position_covariance_type_) return false;

                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("NavSatFix {");
        builder.append("header=");
        builder.append(this.header_);

                builder.append(", ");
        builder.append("status=");
        builder.append(this.status_);

                builder.append(", ");
        builder.append("latitude=");
        builder.append(this.latitude_);

                builder.append(", ");
        builder.append("longitude=");
        builder.append(this.longitude_);

                builder.append(", ");
        builder.append("altitude=");
        builder.append(this.altitude_);

                builder.append(", ");
        builder.append("position_covariance=");
        builder.append(java.util.Arrays.toString(this.position_covariance_));

                builder.append(", ");
        builder.append("position_covariance_type=");
        builder.append(this.position_covariance_type_);

                
        builder.append("}");
		return builder.toString();
    }

    /**
             * header.stamp specifies the ROS time for this measurement (the
             * corresponding satellite time may be reported using the
             * sensor_msgs/TimeReference message).
             * 
             * header.frame_id is the frame of reference reported by the satellite
             * receiver, usually the location of the antenna.  This is a
             * Euclidean frame relative to the vehicle, not a reference
             * ellipsoid.
             */
        private std_msgs.msg.dds.Header header_;
        
    /**
             * Satellite fix status information.
             */
        private sensor_msgs.msg.dds.NavSatStatus status_;
        
    /**
             * Latitude [degrees]. Positive is north of equator; negative is south.
             */
        private double latitude_;
        
    /**
             * Longitude [degrees]. Positive is east of prime meridian; negative is west.
             */
        private double longitude_;
        
    /**
             * Altitude [m]. Positive is above the WGS 84 ellipsoid
             * (quiet NaN if no altitude is available).
             */
        private double altitude_;
        
    /**
             * Position covariance [m^2] defined relative to a tangential plane
             * through the reported position. The components are East, North, and
             * Up (ENU), in row-major order.
             * 
             * Beware: this coordinate system exhibits singularities at the poles.
             */
        private double[] position_covariance_;
        
        private byte position_covariance_type_;
        

}