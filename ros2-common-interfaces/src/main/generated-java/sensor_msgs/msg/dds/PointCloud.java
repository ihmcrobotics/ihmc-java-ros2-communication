package sensor_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
/**
       * This message holds a collection of 3d points, plus optional additional
       * information about each point.
       */
public class PointCloud implements Settable<PointCloud>, EpsilonComparable<PointCloud>
{
    public PointCloud()
    {
        	header_ = new std_msgs.msg.dds.Header();
        	points_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D32> (100, us.ihmc.euclid.tuple3D.Point3D32.class, new geometry_msgs.msg.dds.Point32PubSubType());


        	channels_ = new us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.ChannelFloat32> (100, sensor_msgs.msg.dds.ChannelFloat32.class, new sensor_msgs.msg.dds.ChannelFloat32PubSubType());


    }

    public PointCloud(PointCloud other)
    {
        set(other);
    }

    public void set(PointCloud other)
    {
           	std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
            points_.set(other.points_);	
            channels_.set(other.channels_);	
    }


        /**
                 * Time of sensor data acquisition, coordinate frame ID.
                 */
    public std_msgs.msg.dds.Header getHeader()
    {
        return header_;
    }

        

        /**
                 * Array of 3d points. Each Point32 should be interpreted as a 3d point
                 * in the frame given in the header.
                 */
    public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D32>  getPoints()
    {
        return points_;
    }

        

        /**
                 * Each channel should have the same number of elements as points array,
                 * and the data in each channel should correspond 1:1 with each point.
                 * Channel names in common practice are listed in ChannelFloat32.msg.
                 */
    public us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.ChannelFloat32>  getChannels()
    {
        return channels_;
    }

        


    @Override
    public boolean epsilonEquals(PointCloud other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
                
                        if (this.points_.size() == other.points_.size()) { return false; }
                        else
                        {
                            for (int i = 0; i < this.points_.size(); i++)
                            {  if (!this.points_.get(i).epsilonEquals(other.points_.get(i), epsilon)) return false; }
                        }
                
                        if (this.channels_.size() == other.channels_.size()) { return false; }
                        else
                        {
                            for (int i = 0; i < this.channels_.size(); i++)
                            {  if (!this.channels_.get(i).epsilonEquals(other.channels_.get(i), epsilon)) return false; }
                        }
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof PointCloud)) return false;

        PointCloud otherMyClass = (PointCloud) other;

                        if (!this.header_.equals(otherMyClass.header_)) return false;
                
                        if (!this.points_.equals(otherMyClass.points_)) return false;
                
                        if (!this.channels_.equals(otherMyClass.channels_)) return false;
                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("PointCloud {");
        builder.append("header=");
        builder.append(this.header_);

                builder.append(", ");
        builder.append("points=");
        builder.append(this.points_);

                builder.append(", ");
        builder.append("channels=");
        builder.append(this.channels_);

                
        builder.append("}");
		return builder.toString();
    }

    /**
             * Time of sensor data acquisition, coordinate frame ID.
             */
        private std_msgs.msg.dds.Header header_;
        
    /**
             * Array of 3d points. Each Point32 should be interpreted as a 3d point
             * in the frame given in the header.
             */
        private us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D32>  points_;
        
    /**
             * Each channel should have the same number of elements as points array,
             * and the data in each channel should correspond 1:1 with each point.
             * Channel names in common practice are listed in ChannelFloat32.msg.
             */
        private us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.ChannelFloat32>  channels_;
        

}