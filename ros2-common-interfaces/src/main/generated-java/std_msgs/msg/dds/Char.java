package std_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
public class Char implements Settable<Char>, EpsilonComparable<Char>
{
    public Char()
    {
    }

    public Char(Char other)
    {
        set(other);
    }

    public void set(Char other)
    {
        	data_ = other.data_;

    }

    public void setData(char data)
    {
        data_ = data;
    }

    public char getData()
    {
        return data_;
    }

        


    @Override
    public boolean epsilonEquals(Char other, double epsilon)
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
        if(!(other instanceof Char)) return false;

        Char otherMyClass = (Char) other;

                        if(this.data_ != otherMyClass.data_) return false;

                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("Char {");
        builder.append("data=");
        builder.append(this.data_);

                
        builder.append("}");
		return builder.toString();
    }

        private char data_;
        

}