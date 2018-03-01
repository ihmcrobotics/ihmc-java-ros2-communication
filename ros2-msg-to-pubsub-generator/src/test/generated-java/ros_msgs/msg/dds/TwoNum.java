package ros_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
/**
* 
* Definition of the class "TwoNum" defined in TwoNum_.idl. 
*
* This file was automatically generated from TwoNum_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TwoNum_.idl instead.
*
*/
public class TwoNum implements Settable<TwoNum>, EpsilonComparable<TwoNum>
{
    public TwoNum()
    {
        	num1_ = new ros_msgs.msg.dds.Num();
        	num2_ = new ros_msgs.msg.dds.Num();
    }

    public TwoNum(TwoNum other)
    {
        set(other);
    }

    public void set(TwoNum other)
    {
           	ros_msgs.msg.dds.NumPubSubType.staticCopy(other.num1_, num1_);
           	ros_msgs.msg.dds.NumPubSubType.staticCopy(other.num2_, num2_);
    }


    public ros_msgs.msg.dds.Num getNum1()
    {
        return num1_;
    }

        

    public ros_msgs.msg.dds.Num getNum2()
    {
        return num2_;
    }

        


    @Override
    public boolean epsilonEquals(TwoNum other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!this.num1_.epsilonEquals(other.num1_, epsilon)) return false;
                
                        if (!this.num2_.epsilonEquals(other.num2_, epsilon)) return false;
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof TwoNum)) return false;

        TwoNum otherMyClass = (TwoNum) other;

                        if (!this.num1_.equals(otherMyClass.num1_)) return false;
                
                        if (!this.num2_.equals(otherMyClass.num2_)) return false;
                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("TwoNum {");
        builder.append("num1=");
        builder.append(this.num1_);

                builder.append(", ");
        builder.append("num2=");
        builder.append(this.num2_);

                
        builder.append("}");
		return builder.toString();
    }

    private ros_msgs.msg.dds.Num num1_; 
    private ros_msgs.msg.dds.Num num2_; 

}