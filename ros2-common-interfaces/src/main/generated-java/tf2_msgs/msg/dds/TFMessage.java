package tf2_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
public class TFMessage implements Settable<TFMessage>, EpsilonComparable<TFMessage>
{
    public TFMessage()
    {
        	transforms_ = new us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.TransformStamped> (100, geometry_msgs.msg.dds.TransformStamped.class, new geometry_msgs.msg.dds.TransformStampedPubSubType());


    }

    public TFMessage(TFMessage other)
    {
        set(other);
    }

    public void set(TFMessage other)
    {
            transforms_.set(other.transforms_);	
    }


    public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.TransformStamped>  getTransforms()
    {
        return transforms_;
    }

        


    @Override
    public boolean epsilonEquals(TFMessage other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (this.transforms_.size() == other.transforms_.size()) { return false; }
                        else
                        {
                            for (int i = 0; i < this.transforms_.size(); i++)
                            {  if (!this.transforms_.get(i).epsilonEquals(other.transforms_.get(i), epsilon)) return false; }
                        }
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof TFMessage)) return false;

        TFMessage otherMyClass = (TFMessage) other;

                        if (!this.transforms_.equals(otherMyClass.transforms_)) return false;
                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("TFMessage {");
        builder.append("transforms=");
        builder.append(this.transforms_);

                
        builder.append("}");
		return builder.toString();
    }

        private us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.TransformStamped>  transforms_;
        

}