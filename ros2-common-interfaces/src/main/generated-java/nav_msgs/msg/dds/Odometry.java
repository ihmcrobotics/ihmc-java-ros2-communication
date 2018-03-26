package nav_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
/**
       * This represents an estimate of a position and velocity in free space.
       * The pose in this message should be specified in the coordinate frame given by header.frame_id
       * The twist in this message should be specified in the coordinate frame given by the child_frame_id
       */
public class Odometry implements Settable<Odometry>, EpsilonComparable<Odometry>
{
    public Odometry()
    {
        	header_ = new std_msgs.msg.dds.Header();
        	child_frame_id_ = new java.lang.StringBuilder(255); 

        	pose_ = new geometry_msgs.msg.dds.PoseWithCovariance();
        	twist_ = new geometry_msgs.msg.dds.TwistWithCovariance();
    }

    public Odometry(Odometry other)
    {
        set(other);
    }

    public void set(Odometry other)
    {
           	std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
        	child_frame_id_.setLength(0);
        	child_frame_id_.append(other.child_frame_id_);

           	geometry_msgs.msg.dds.PoseWithCovariancePubSubType.staticCopy(other.pose_, pose_);
           	geometry_msgs.msg.dds.TwistWithCovariancePubSubType.staticCopy(other.twist_, twist_);
    }


    public std_msgs.msg.dds.Header getHeader()
    {
        return header_;
    }

        
        public void setChildFrameId(java.lang.String child_frame_id)
        {
        	child_frame_id_.setLength(0);
        	child_frame_id_.append(child_frame_id);
        }

        public java.lang.String getChildFrameIdAsString()
        {
        	return getChildFrameId().toString();
        }

    public java.lang.StringBuilder getChildFrameId()
    {
        return child_frame_id_;
    }

        

    public geometry_msgs.msg.dds.PoseWithCovariance getPose()
    {
        return pose_;
    }

        

    public geometry_msgs.msg.dds.TwistWithCovariance getTwist()
    {
        return twist_;
    }

        


    @Override
    public boolean epsilonEquals(Odometry other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.child_frame_id_, other.child_frame_id_, epsilon)) return false;
                
                        if (!this.pose_.epsilonEquals(other.pose_, epsilon)) return false;
                
                        if (!this.twist_.epsilonEquals(other.twist_, epsilon)) return false;
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof Odometry)) return false;

        Odometry otherMyClass = (Odometry) other;

                        if (!this.header_.equals(otherMyClass.header_)) return false;
                
                        if (!us.ihmc.idl.IDLTools.equals(this.child_frame_id_, otherMyClass.child_frame_id_)) return false;
                
                        if (!this.pose_.equals(otherMyClass.pose_)) return false;
                
                        if (!this.twist_.equals(otherMyClass.twist_)) return false;
                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("Odometry {");
        builder.append("header=");
        builder.append(this.header_);

                builder.append(", ");
        builder.append("child_frame_id=");
        builder.append(this.child_frame_id_);

                builder.append(", ");
        builder.append("pose=");
        builder.append(this.pose_);

                builder.append(", ");
        builder.append("twist=");
        builder.append(this.twist_);

                
        builder.append("}");
		return builder.toString();
    }

        private std_msgs.msg.dds.Header header_;
        
        private java.lang.StringBuilder child_frame_id_;
        
        private geometry_msgs.msg.dds.PoseWithCovariance pose_;
        
        private geometry_msgs.msg.dds.TwistWithCovariance twist_;
        

}