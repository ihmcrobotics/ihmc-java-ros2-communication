package std_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
public class UInt16 implements Settable<UInt16>, EpsilonComparable<UInt16>
{
    public UInt16()
    {
    }

    public UInt16(UInt16 other)
    {
        set(other);
    }

    public void set(UInt16 other)
    {
        	data_ = other.data_;

    }

    public void setData(int data)
    {
        data_ = data;
    }

    public int getData()
    {
        return data_;
    }

        


    @Override
    public boolean epsilonEquals(UInt16 other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.data_, other.data_, epsilon)) return false;
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof UInt16)) return false;

        UInt16 otherMyClass = (UInt16) other;

                        if(this.data_ != otherMyClass.data_) return false;

                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("UInt16 {");
        builder.append("data=");
        builder.append(this.data_);

                
        builder.append("}");
		return builder.toString();
    }

        private int data_;
        

}