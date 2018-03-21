package test_msgs.msg.dds;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
public class Primitives implements Settable<Primitives>, EpsilonComparable<Primitives>
{
    public Primitives()
    {













        	string_value_ = new java.lang.StringBuilder(255); 

    }

    public Primitives(Primitives other)
    {
        set(other);
    }

    public void set(Primitives other)
    {
        	bool_value_ = other.bool_value_;

        	byte_value_ = other.byte_value_;

        	char_value_ = other.char_value_;

        	float32_value_ = other.float32_value_;

        	float64_value_ = other.float64_value_;

        	int8_value_ = other.int8_value_;

        	uint8_value_ = other.uint8_value_;

        	int16_value_ = other.int16_value_;

        	uint16_value_ = other.uint16_value_;

        	int32_value_ = other.int32_value_;

        	uint32_value_ = other.uint32_value_;

        	int64_value_ = other.int64_value_;

        	uint64_value_ = other.uint64_value_;

        	string_value_.setLength(0);
        	string_value_.append(other.string_value_);

    }

    public void setBoolValue(boolean bool_value)
    {
        bool_value_ = bool_value;
    }

    public boolean getBoolValue()
    {
        return bool_value_;
    }

        
    public void setByteValue(byte byte_value)
    {
        byte_value_ = byte_value;
    }

    public byte getByteValue()
    {
        return byte_value_;
    }

        
    public void setCharValue(char char_value)
    {
        char_value_ = char_value;
    }

    public char getCharValue()
    {
        return char_value_;
    }

        
    public void setFloat32Value(float float32_value)
    {
        float32_value_ = float32_value;
    }

    public float getFloat32Value()
    {
        return float32_value_;
    }

        
    public void setFloat64Value(double float64_value)
    {
        float64_value_ = float64_value;
    }

    public double getFloat64Value()
    {
        return float64_value_;
    }

        
    public void setInt8Value(byte int8_value)
    {
        int8_value_ = int8_value;
    }

    public byte getInt8Value()
    {
        return int8_value_;
    }

        
    public void setUint8Value(byte uint8_value)
    {
        uint8_value_ = uint8_value;
    }

    public byte getUint8Value()
    {
        return uint8_value_;
    }

        
    public void setInt16Value(short int16_value)
    {
        int16_value_ = int16_value;
    }

    public short getInt16Value()
    {
        return int16_value_;
    }

        
    public void setUint16Value(int uint16_value)
    {
        uint16_value_ = uint16_value;
    }

    public int getUint16Value()
    {
        return uint16_value_;
    }

        
    public void setInt32Value(int int32_value)
    {
        int32_value_ = int32_value;
    }

    public int getInt32Value()
    {
        return int32_value_;
    }

        
    public void setUint32Value(long uint32_value)
    {
        uint32_value_ = uint32_value;
    }

    public long getUint32Value()
    {
        return uint32_value_;
    }

        
    public void setInt64Value(long int64_value)
    {
        int64_value_ = int64_value;
    }

    public long getInt64Value()
    {
        return int64_value_;
    }

        
    public void setUint64Value(long uint64_value)
    {
        uint64_value_ = uint64_value;
    }

    public long getUint64Value()
    {
        return uint64_value_;
    }

        
        public void setStringValue(java.lang.String string_value)
        {
        	string_value_.setLength(0);
        	string_value_.append(string_value);
        }

        public java.lang.String getStringValueAsString()
        {
        	return getStringValue().toString();
        }

    public java.lang.StringBuilder getStringValue()
    {
        return string_value_;
    }

        


    @Override
    public boolean epsilonEquals(Primitives other, double epsilon)
    {
        if(other == null) return false;
        if(other == this) return true;

                        if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.bool_value_, other.bool_value_, epsilon)) return false;

                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.byte_value_, other.byte_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.char_value_, other.char_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.float32_value_, other.float32_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.float64_value_, other.float64_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.int8_value_, other.int8_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.uint8_value_, other.uint8_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.int16_value_, other.int16_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.uint16_value_, other.uint16_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.int32_value_, other.int32_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.uint32_value_, other.uint32_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.int64_value_, other.int64_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.uint64_value_, other.uint64_value_, epsilon)) return false;
                
                        if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.string_value_, other.string_value_, epsilon)) return false;
                

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof Primitives)) return false;

        Primitives otherMyClass = (Primitives) other;

                        if(this.bool_value_ != otherMyClass.bool_value_) return false;

                
                        if(this.byte_value_ != otherMyClass.byte_value_) return false;

                
                        if(this.char_value_ != otherMyClass.char_value_) return false;

                
                        if(this.float32_value_ != otherMyClass.float32_value_) return false;

                
                        if(this.float64_value_ != otherMyClass.float64_value_) return false;

                
                        if(this.int8_value_ != otherMyClass.int8_value_) return false;

                
                        if(this.uint8_value_ != otherMyClass.uint8_value_) return false;

                
                        if(this.int16_value_ != otherMyClass.int16_value_) return false;

                
                        if(this.uint16_value_ != otherMyClass.uint16_value_) return false;

                
                        if(this.int32_value_ != otherMyClass.int32_value_) return false;

                
                        if(this.uint32_value_ != otherMyClass.uint32_value_) return false;

                
                        if(this.int64_value_ != otherMyClass.int64_value_) return false;

                
                        if(this.uint64_value_ != otherMyClass.uint64_value_) return false;

                
                        if (!us.ihmc.idl.IDLTools.equals(this.string_value_, otherMyClass.string_value_)) return false;
                

        return true;
    }

     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();

      	builder.append("Primitives {");
        builder.append("bool_value=");
        builder.append(this.bool_value_);

                builder.append(", ");
        builder.append("byte_value=");
        builder.append(this.byte_value_);

                builder.append(", ");
        builder.append("char_value=");
        builder.append(this.char_value_);

                builder.append(", ");
        builder.append("float32_value=");
        builder.append(this.float32_value_);

                builder.append(", ");
        builder.append("float64_value=");
        builder.append(this.float64_value_);

                builder.append(", ");
        builder.append("int8_value=");
        builder.append(this.int8_value_);

                builder.append(", ");
        builder.append("uint8_value=");
        builder.append(this.uint8_value_);

                builder.append(", ");
        builder.append("int16_value=");
        builder.append(this.int16_value_);

                builder.append(", ");
        builder.append("uint16_value=");
        builder.append(this.uint16_value_);

                builder.append(", ");
        builder.append("int32_value=");
        builder.append(this.int32_value_);

                builder.append(", ");
        builder.append("uint32_value=");
        builder.append(this.uint32_value_);

                builder.append(", ");
        builder.append("int64_value=");
        builder.append(this.int64_value_);

                builder.append(", ");
        builder.append("uint64_value=");
        builder.append(this.uint64_value_);

                builder.append(", ");
        builder.append("string_value=");
        builder.append(this.string_value_);

                
        builder.append("}");
		return builder.toString();
    }

        private boolean bool_value_;
        
        private byte byte_value_;
        
        private char char_value_;
        
        private float float32_value_;
        
        private double float64_value_;
        
        private byte int8_value_;
        
        private byte uint8_value_;
        
        private short int16_value_;
        
        private int uint16_value_;
        
        private int int32_value_;
        
        private long uint32_value_;
        
        private long int64_value_;
        
        private long uint64_value_;
        
        private java.lang.StringBuilder string_value_;
        

}