package ros_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
/**
* 
* Definition of the class "CustomBoi" defined in CustomBoi_.idl. 
*
* This file was automatically generated from CustomBoi_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit CustomBoi_.idl instead.
*
*/
public class CustomBoi implements Settable<CustomBoi>, EpsilonComparable<CustomBoi>
{
    public CustomBoi()
    {



    }

    public CustomBoi(CustomBoi other)
    {
        set(other);
    }

    public void set(CustomBoi other)
    {
        	x_ = other.x_;

        	y_ = other.y_;

        	z_ = other.z_;

    }

    public void setX(float x)
    {
        x_ = x;
    }

    public float getX()
    {
        return x_;
    }

        
    public void setY(float y)
    {
        y_ = y;
    }

    public float getY()
    {
        return y_;
    }

        
    public void setZ(float z)
    {
        z_ = z;
    }

    public float getZ()
    {
        return z_;
    }

        


    @Override
    public boolean epsilonEquals(CustomBoi other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.x_, other.x_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.y_, other.y_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.z_, other.z_, epsilon)) return false;
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof CustomBoi)) return false;

        CustomBoi otherMyClass = (CustomBoi) other;

                        if(this.x_ != otherMyClass.x_) return false;

                
                        if(this.y_ != otherMyClass.y_) return false;

                
                        if(this.z_ != otherMyClass.z_) return false;

                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("CustomBoi {");
        builder.append("x=");
        builder.append(this.x_);

                builder.append(", ");
        builder.append("y=");
        builder.append(this.y_);

                builder.append(", ");
        builder.append("z=");
        builder.append(this.z_);

                
        builder.append("}");
		return builder.toString();
    }

    private float x_; 
    private float y_; 
    private float z_; 

}