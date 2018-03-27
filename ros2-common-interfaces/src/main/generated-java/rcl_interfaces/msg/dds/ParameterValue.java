package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Used to determine which of the next *_value fields are set.
 * ParameterType.PARAMETER_NOT_SET indicates that the parameter was not set
 * (if gotten) or is uninitialized.
 * Values are enumerated in ParameterType.msg
 */
public class ParameterValue extends Packet<ParameterValue> implements Settable<ParameterValue>, EpsilonComparable<ParameterValue>
{
   public byte type_;
   /**
    * "Variant" style storage of the parameter value.
    */
   public boolean bool_value_;
   public long integer_value_;
   public double double_value_;
   public java.lang.StringBuilder string_value_;
   public us.ihmc.idl.IDLSequence.Byte bytes_value_;

   public ParameterValue()
   {
      string_value_ = new java.lang.StringBuilder(255);
      bytes_value_ = new us.ihmc.idl.IDLSequence.Byte(100, "type_9");
   }

   public ParameterValue(ParameterValue other)
   {
      set(other);
   }

   public void set(ParameterValue other)
   {
      type_ = other.type_;

      bool_value_ = other.bool_value_;

      integer_value_ = other.integer_value_;

      double_value_ = other.double_value_;

      string_value_.setLength(0);
      string_value_.append(other.string_value_);

      bytes_value_.set(other.bytes_value_);
   }

   public byte getType()
   {
      return type_;
   }

   public void setType(byte type)
   {
      type_ = type;
   }

   /**
    * "Variant" style storage of the parameter value.
    */
   public boolean getBoolValue()
   {
      return bool_value_;
   }

   /**
    * "Variant" style storage of the parameter value.
    */
   public void setBoolValue(boolean bool_value)
   {
      bool_value_ = bool_value;
   }

   public long getIntegerValue()
   {
      return integer_value_;
   }

   public void setIntegerValue(long integer_value)
   {
      integer_value_ = integer_value;
   }

   public double getDoubleValue()
   {
      return double_value_;
   }

   public void setDoubleValue(double double_value)
   {
      double_value_ = double_value;
   }

   public java.lang.String getStringValueAsString()
   {
      return getStringValue().toString();
   }

   public java.lang.StringBuilder getStringValue()
   {
      return string_value_;
   }

   public void setStringValue(java.lang.String string_value)
   {
      string_value_.setLength(0);
      string_value_.append(string_value);
   }

   public us.ihmc.idl.IDLSequence.Byte getBytesValue()
   {
      return bytes_value_;
   }

   @Override
   public boolean epsilonEquals(ParameterValue other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.bool_value_, other.bool_value_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.integer_value_, other.integer_value_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.double_value_, other.double_value_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.string_value_, other.string_value_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.bytes_value_, other.bytes_value_, epsilon))
         return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof ParameterValue))
         return false;

      ParameterValue otherMyClass = (ParameterValue) other;

      if (this.type_ != otherMyClass.type_)
         return false;

      if (this.bool_value_ != otherMyClass.bool_value_)
         return false;

      if (this.integer_value_ != otherMyClass.integer_value_)
         return false;

      if (this.double_value_ != otherMyClass.double_value_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.string_value_, otherMyClass.string_value_))
         return false;

      if (!this.bytes_value_.equals(otherMyClass.bytes_value_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ParameterValue {");
      builder.append("type=");
      builder.append(this.type_);
      builder.append(", ");
      builder.append("bool_value=");
      builder.append(this.bool_value_);
      builder.append(", ");
      builder.append("integer_value=");
      builder.append(this.integer_value_);
      builder.append(", ");
      builder.append("double_value=");
      builder.append(this.double_value_);
      builder.append(", ");
      builder.append("string_value=");
      builder.append(this.string_value_);
      builder.append(", ");
      builder.append("bytes_value=");
      builder.append(this.bytes_value_);
      builder.append("}");
      return builder.toString();
   }
}
