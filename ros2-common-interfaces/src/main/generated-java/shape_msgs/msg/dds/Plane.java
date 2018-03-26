package shape_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
/**
       * Representation of a plane, using the plane equation ax + by + cz + d = 0.
       */
public class Plane implements Settable<Plane>, EpsilonComparable<Plane>
{
    public Plane()
    {
        	coef_ = new double[4];
    }

    public Plane(Plane other)
    {
        set(other);
    }

    public void set(Plane other)
    {
        	for(int i1 = 0; i1 < coef_.length; ++i1)
        	{
        	    	coef_[i1] = other.coef_[i1];	

        	}
        	
    }


        /**
                 * a := coef[0]
                 * b := coef[1]
                 * c := coef[2]
                 * d := coef[3]
                 */
    public double[] getCoef()
    {
        return coef_;
    }

        


    @Override
    public boolean epsilonEquals(Plane other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        for(int i3 = 0; i3 < coef_.length; ++i3)
                        {
                                    if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.coef_[i3], other.coef_[i3], epsilon)) return false;
                        }
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof Plane)) return false;

        Plane otherMyClass = (Plane) other;

                        for(int i5 = 0; i5 < coef_.length; ++i5)
                        {
                                    if(this.coef_[i5] != otherMyClass.coef_[i5]) return false;

                        }        

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("Plane {");
        builder.append("coef=");
        builder.append(java.util.Arrays.toString(this.coef_));

                
        builder.append("}");
		return builder.toString();
    }

    /**
             * a := coef[0]
             * b := coef[1]
             * c := coef[2]
             * d := coef[3]
             */
        private double[] coef_;
        

}