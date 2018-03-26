package test_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class DynamicArrayPrimitives extends Packet<DynamicArrayPrimitives>
      implements Settable<DynamicArrayPrimitives>, EpsilonComparable<DynamicArrayPrimitives>
{
   public us.ihmc.idl.IDLSequence.Boolean bool_values_;
   public us.ihmc.idl.IDLSequence.Byte byte_values_;
   public us.ihmc.idl.IDLSequence.Char char_values_;
   public us.ihmc.idl.IDLSequence.Float float32_values_;
   public us.ihmc.idl.IDLSequence.Double float64_values_;
   public us.ihmc.idl.IDLSequence.Byte int8_values_;
   public us.ihmc.idl.IDLSequence.Byte uint8_values_;
   public us.ihmc.idl.IDLSequence.Short int16_values_;
   public us.ihmc.idl.IDLSequence.Integer uint16_values_;
   public us.ihmc.idl.IDLSequence.Integer int32_values_;
   public us.ihmc.idl.IDLSequence.Long uint32_values_;
   public us.ihmc.idl.IDLSequence.Long int64_values_;
   public us.ihmc.idl.IDLSequence.Long uint64_values_;
   public us.ihmc.idl.IDLSequence.StringBuilderHolder string_values_;
   public int check_;

   public DynamicArrayPrimitives()
   {
      bool_values_ = new us.ihmc.idl.IDLSequence.Boolean(100, "type_7");

      byte_values_ = new us.ihmc.idl.IDLSequence.Byte(100, "type_9");

      char_values_ = new us.ihmc.idl.IDLSequence.Char(100, "type_8");

      float32_values_ = new us.ihmc.idl.IDLSequence.Float(100, "type_5");

      float64_values_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      int8_values_ = new us.ihmc.idl.IDLSequence.Byte(100, "type_9");

      uint8_values_ = new us.ihmc.idl.IDLSequence.Byte(100, "type_9");

      int16_values_ = new us.ihmc.idl.IDLSequence.Short(100, "type_1");

      uint16_values_ = new us.ihmc.idl.IDLSequence.Integer(100, "type_3");

      int32_values_ = new us.ihmc.idl.IDLSequence.Integer(100, "type_2");

      uint32_values_ = new us.ihmc.idl.IDLSequence.Long(100, "type_4");

      int64_values_ = new us.ihmc.idl.IDLSequence.Long(100, "type_11");

      uint64_values_ = new us.ihmc.idl.IDLSequence.Long(100, "type_12");

      string_values_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder(100, "type_d");
   }

   public DynamicArrayPrimitives(DynamicArrayPrimitives other)
   {
      set(other);
   }

   public void set(DynamicArrayPrimitives other)
   {
      bool_values_.set(other.bool_values_);
      byte_values_.set(other.byte_values_);
      char_values_.set(other.char_values_);
      float32_values_.set(other.float32_values_);
      float64_values_.set(other.float64_values_);
      int8_values_.set(other.int8_values_);
      uint8_values_.set(other.uint8_values_);
      int16_values_.set(other.int16_values_);
      uint16_values_.set(other.uint16_values_);
      int32_values_.set(other.int32_values_);
      uint32_values_.set(other.uint32_values_);
      int64_values_.set(other.int64_values_);
      uint64_values_.set(other.uint64_values_);
      string_values_.set(other.string_values_);
      check_ = other.check_;
   }

   public us.ihmc.idl.IDLSequence.Boolean getBoolValues()
   {
      return bool_values_;
   }

   public us.ihmc.idl.IDLSequence.Byte getByteValues()
   {
      return byte_values_;
   }

   public us.ihmc.idl.IDLSequence.Char getCharValues()
   {
      return char_values_;
   }

   public us.ihmc.idl.IDLSequence.Float getFloat32Values()
   {
      return float32_values_;
   }

   public us.ihmc.idl.IDLSequence.Double getFloat64Values()
   {
      return float64_values_;
   }

   public us.ihmc.idl.IDLSequence.Byte getInt8Values()
   {
      return int8_values_;
   }

   public us.ihmc.idl.IDLSequence.Byte getUint8Values()
   {
      return uint8_values_;
   }

   public us.ihmc.idl.IDLSequence.Short getInt16Values()
   {
      return int16_values_;
   }

   public us.ihmc.idl.IDLSequence.Integer getUint16Values()
   {
      return uint16_values_;
   }

   public us.ihmc.idl.IDLSequence.Integer getInt32Values()
   {
      return int32_values_;
   }

   public us.ihmc.idl.IDLSequence.Long getUint32Values()
   {
      return uint32_values_;
   }

   public us.ihmc.idl.IDLSequence.Long getInt64Values()
   {
      return int64_values_;
   }

   public us.ihmc.idl.IDLSequence.Long getUint64Values()
   {
      return uint64_values_;
   }

   public us.ihmc.idl.IDLSequence.StringBuilderHolder getStringValues()
   {
      return string_values_;
   }

   public int getCheck()
   {
      return check_;
   }

   public void setCheck(int check)
   {
      check_ = check;
   }

   @Override
   public boolean epsilonEquals(DynamicArrayPrimitives other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBooleanSequence(this.bool_values_, other.bool_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.byte_values_, other.byte_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsCharSequence(this.char_values_, other.char_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(this.float32_values_, other.float32_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.float64_values_, other.float64_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.int8_values_, other.int8_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.uint8_values_, other.uint8_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsShortSequence(this.int16_values_, other.int16_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(this.uint16_values_, other.uint16_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(this.int32_values_, other.int32_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(this.uint32_values_, other.uint32_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(this.int64_values_, other.int64_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(this.uint64_values_, other.uint64_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.string_values_, other.string_values_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.check_, other.check_, epsilon))
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
      if (!(other instanceof DynamicArrayPrimitives))
         return false;

      DynamicArrayPrimitives otherMyClass = (DynamicArrayPrimitives) other;

      if (!this.bool_values_.equals(otherMyClass.bool_values_))
         return false;

      if (!this.byte_values_.equals(otherMyClass.byte_values_))
         return false;

      if (!this.char_values_.equals(otherMyClass.char_values_))
         return false;

      if (!this.float32_values_.equals(otherMyClass.float32_values_))
         return false;

      if (!this.float64_values_.equals(otherMyClass.float64_values_))
         return false;

      if (!this.int8_values_.equals(otherMyClass.int8_values_))
         return false;

      if (!this.uint8_values_.equals(otherMyClass.uint8_values_))
         return false;

      if (!this.int16_values_.equals(otherMyClass.int16_values_))
         return false;

      if (!this.uint16_values_.equals(otherMyClass.uint16_values_))
         return false;

      if (!this.int32_values_.equals(otherMyClass.int32_values_))
         return false;

      if (!this.uint32_values_.equals(otherMyClass.uint32_values_))
         return false;

      if (!this.int64_values_.equals(otherMyClass.int64_values_))
         return false;

      if (!this.uint64_values_.equals(otherMyClass.uint64_values_))
         return false;

      if (!this.string_values_.equals(otherMyClass.string_values_))
         return false;

      if (this.check_ != otherMyClass.check_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("DynamicArrayPrimitives {");
      builder.append("bool_values=");
      builder.append(this.bool_values_);

      builder.append(", ");
      builder.append("byte_values=");
      builder.append(this.byte_values_);

      builder.append(", ");
      builder.append("char_values=");
      builder.append(this.char_values_);

      builder.append(", ");
      builder.append("float32_values=");
      builder.append(this.float32_values_);

      builder.append(", ");
      builder.append("float64_values=");
      builder.append(this.float64_values_);

      builder.append(", ");
      builder.append("int8_values=");
      builder.append(this.int8_values_);

      builder.append(", ");
      builder.append("uint8_values=");
      builder.append(this.uint8_values_);

      builder.append(", ");
      builder.append("int16_values=");
      builder.append(this.int16_values_);

      builder.append(", ");
      builder.append("uint16_values=");
      builder.append(this.uint16_values_);

      builder.append(", ");
      builder.append("int32_values=");
      builder.append(this.int32_values_);

      builder.append(", ");
      builder.append("uint32_values=");
      builder.append(this.uint32_values_);

      builder.append(", ");
      builder.append("int64_values=");
      builder.append(this.int64_values_);

      builder.append(", ");
      builder.append("uint64_values=");
      builder.append(this.uint64_values_);

      builder.append(", ");
      builder.append("string_values=");
      builder.append(this.string_values_);

      builder.append(", ");
      builder.append("check=");
      builder.append(this.check_);

      builder.append("}");
      return builder.toString();
   }
}
