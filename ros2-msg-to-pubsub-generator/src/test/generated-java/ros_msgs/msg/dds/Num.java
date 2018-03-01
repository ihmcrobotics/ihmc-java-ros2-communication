package ros_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
/**
* 
* Definition of the class "Num" defined in Num_.idl. 
*
* This file was automatically generated from Num_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Num_.idl instead.
*
*/
public class Num implements Settable<Num>, EpsilonComparable<Num>
{
    public Num()
    {


    }

    public Num(Num other)
    {
        set(other);
    }

    public void set(Num other)
    {
        	num_ = other.num_;

        	hello_ = other.hello_;

    }

    public void setNum(long num)
    {
        num_ = num;
    }

    public long getNum()
    {
        return num_;
    }

        
    public void setHello(int hello)
    {
        hello_ = hello;
    }

    public int getHello()
    {
        return hello_;
    }

        


    @Override
    public boolean epsilonEquals(Num other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.num_, other.num_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.hello_, other.hello_, epsilon)) return false;
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof Num)) return false;

        Num otherMyClass = (Num) other;

                        if(this.num_ != otherMyClass.num_) return false;

                
                        if(this.hello_ != otherMyClass.hello_) return false;

                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("Num {");
        builder.append("num=");
        builder.append(this.num_);

                builder.append(", ");
        builder.append("hello=");
        builder.append(this.hello_);

                
        builder.append("}");
		return builder.toString();
    }

    private long num_; 
    private int hello_; 

}