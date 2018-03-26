package tf2_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
public class TF2Error implements Settable<TF2Error>, EpsilonComparable<TF2Error>
{
                public static final byte NO_ERROR = (byte) 0;                public static final byte LOOKUP_ERROR = (byte) 1;                public static final byte CONNECTIVITY_ERROR = (byte) 2;                public static final byte EXTRAPOLATION_ERROR = (byte) 3;                public static final byte INVALID_ARGUMENT_ERROR = (byte) 4;                public static final byte TIMEOUT_ERROR = (byte) 5;                public static final byte TRANSFORM_ERROR = (byte) 6;    
    public TF2Error()
    {

        	error_string_ = new java.lang.StringBuilder(255); 

    }

    public TF2Error(TF2Error other)
    {
        set(other);
    }

    public void set(TF2Error other)
    {
        	error_ = other.error_;

        	error_string_.setLength(0);
        	error_string_.append(other.error_string_);

    }

    public void setError(byte error)
    {
        error_ = error;
    }

    public byte getError()
    {
        return error_;
    }

        
        public void setErrorString(java.lang.String error_string)
        {
        	error_string_.setLength(0);
        	error_string_.append(error_string);
        }

        public java.lang.String getErrorStringAsString()
        {
        	return getErrorString().toString();
        }

    public java.lang.StringBuilder getErrorString()
    {
        return error_string_;
    }

        


    @Override
    public boolean epsilonEquals(TF2Error other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.error_, other.error_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.error_string_, other.error_string_, epsilon)) return false;
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof TF2Error)) return false;

        TF2Error otherMyClass = (TF2Error) other;

                        if(this.error_ != otherMyClass.error_) return false;

                
                        if (!us.ihmc.idl.IDLTools.equals(this.error_string_, otherMyClass.error_string_)) return false;
                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("TF2Error {");
        builder.append("error=");
        builder.append(this.error_);

                builder.append(", ");
        builder.append("error_string=");
        builder.append(this.error_string_);

                
        builder.append("}");
		return builder.toString();
    }

        private byte error_;
        
        private java.lang.StringBuilder error_string_;
        

}