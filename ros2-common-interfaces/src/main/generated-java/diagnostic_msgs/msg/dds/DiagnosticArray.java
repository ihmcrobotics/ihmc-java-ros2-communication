package diagnostic_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
public class DiagnosticArray implements Settable<DiagnosticArray>, EpsilonComparable<DiagnosticArray>
{
    public DiagnosticArray()
    {
        	header_ = new std_msgs.msg.dds.Header();
        	status_ = new us.ihmc.idl.IDLSequence.Object<diagnostic_msgs.msg.dds.DiagnosticStatus> (100, diagnostic_msgs.msg.dds.DiagnosticStatus.class, new diagnostic_msgs.msg.dds.DiagnosticStatusPubSubType());


    }

    public DiagnosticArray(DiagnosticArray other)
    {
        set(other);
    }

    public void set(DiagnosticArray other)
    {
           	std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
            status_.set(other.status_);	
    }


        /**
                 * This message is used to send diagnostic information about the state of the robot.
                 * for timestamp
                 */
    public std_msgs.msg.dds.Header getHeader()
    {
        return header_;
    }

        

        /**
                 * an array of components being reported on
                 */
    public us.ihmc.idl.IDLSequence.Object<diagnostic_msgs.msg.dds.DiagnosticStatus>  getStatus()
    {
        return status_;
    }

        


    @Override
    public boolean epsilonEquals(DiagnosticArray other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
                
                        if (this.status_.size() == other.status_.size()) { return false; }
                        else
                        {
                            for (int i = 0; i < this.status_.size(); i++)
                            {  if (!this.status_.get(i).epsilonEquals(other.status_.get(i), epsilon)) return false; }
                        }
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof DiagnosticArray)) return false;

        DiagnosticArray otherMyClass = (DiagnosticArray) other;

                        if (!this.header_.equals(otherMyClass.header_)) return false;
                
                        if (!this.status_.equals(otherMyClass.status_)) return false;
                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("DiagnosticArray {");
        builder.append("header=");
        builder.append(this.header_);

                builder.append(", ");
        builder.append("status=");
        builder.append(this.status_);

                
        builder.append("}");
		return builder.toString();
    }

    /**
             * This message is used to send diagnostic information about the state of the robot.
             * for timestamp
             */
        private std_msgs.msg.dds.Header header_;
        
    /**
             * an array of components being reported on
             */
        private us.ihmc.idl.IDLSequence.Object<diagnostic_msgs.msg.dds.DiagnosticStatus>  status_;
        

}