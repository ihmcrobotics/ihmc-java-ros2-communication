package test_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class StaticArrayPrimitives extends Packet<StaticArrayPrimitives> implements Settable<StaticArrayPrimitives>, EpsilonComparable<StaticArrayPrimitives>
{
   public boolean[] bool_values_;
   public byte[] byte_values_;
   public char[] char_values_;
   public float[] float32_values_;
   public double[] float64_values_;
   public byte[] int8_values_;
   public byte[] uint8_values_;
   public short[] int16_values_;
   public int[] int32_values_;
   public java.lang.StringBuilder[] string_values_;

   public StaticArrayPrimitives()
   {
      bool_values_ = new boolean[3];

      byte_values_ = new byte[3];

      char_values_ = new char[3];

      float32_values_ = new float[3];

      float64_values_ = new double[3];

      int8_values_ = new byte[3];

      uint8_values_ = new byte[3];

      int16_values_ = new short[3];

      int32_values_ = new int[3];

      string_values_ = new java.lang.StringBuilder[3];
      for (int i1 = 0; i1 < string_values_.length; ++i1)
      {
         string_values_[i1] = new java.lang.StringBuilder();
      }
   }

   public StaticArrayPrimitives(StaticArrayPrimitives other)
   {
      set(other);
   }

   public void set(StaticArrayPrimitives other)
   {
      for (int i3 = 0; i3 < bool_values_.length; ++i3)
      {
         bool_values_[i3] = other.bool_values_[i3];
      }

      for (int i5 = 0; i5 < byte_values_.length; ++i5)
      {
         byte_values_[i5] = other.byte_values_[i5];
      }

      for (int i7 = 0; i7 < char_values_.length; ++i7)
      {
         char_values_[i7] = other.char_values_[i7];
      }

      for (int i9 = 0; i9 < float32_values_.length; ++i9)
      {
         float32_values_[i9] = other.float32_values_[i9];
      }

      for (int i11 = 0; i11 < float64_values_.length; ++i11)
      {
         float64_values_[i11] = other.float64_values_[i11];
      }

      for (int i13 = 0; i13 < int8_values_.length; ++i13)
      {
         int8_values_[i13] = other.int8_values_[i13];
      }

      for (int i15 = 0; i15 < uint8_values_.length; ++i15)
      {
         uint8_values_[i15] = other.uint8_values_[i15];
      }

      for (int i17 = 0; i17 < int16_values_.length; ++i17)
      {
         int16_values_[i17] = other.int16_values_[i17];
      }

      for (int i19 = 0; i19 < int32_values_.length; ++i19)
      {
         int32_values_[i19] = other.int32_values_[i19];
      }

      for (int i21 = 0; i21 < string_values_.length; ++i21)
      {
         string_values_[i21].setLength(0);
         string_values_[i21].append(other.string_values_[i21]);
      }
   }

   public boolean[] getBoolValues()
   {
      return bool_values_;
   }

   public byte[] getByteValues()
   {
      return byte_values_;
   }

   public char[] getCharValues()
   {
      return char_values_;
   }

   public float[] getFloat32Values()
   {
      return float32_values_;
   }

   public double[] getFloat64Values()
   {
      return float64_values_;
   }

   public byte[] getInt8Values()
   {
      return int8_values_;
   }

   public byte[] getUint8Values()
   {
      return uint8_values_;
   }

   public short[] getInt16Values()
   {
      return int16_values_;
   }

   public int[] getInt32Values()
   {
      return int32_values_;
   }

   public java.lang.StringBuilder[] getStringValues()
   {
      return string_values_;
   }

   @Override
   public boolean epsilonEquals(StaticArrayPrimitives other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      for (int i23 = 0; i23 < bool_values_.length; ++i23)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.bool_values_[i23], other.bool_values_[i23], epsilon))
            return false;
      }

      for (int i25 = 0; i25 < byte_values_.length; ++i25)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.byte_values_[i25], other.byte_values_[i25], epsilon))
            return false;
      }

      for (int i27 = 0; i27 < char_values_.length; ++i27)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.char_values_[i27], other.char_values_[i27], epsilon))
            return false;
      }

      for (int i29 = 0; i29 < float32_values_.length; ++i29)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.float32_values_[i29], other.float32_values_[i29], epsilon))
            return false;
      }

      for (int i31 = 0; i31 < float64_values_.length; ++i31)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.float64_values_[i31], other.float64_values_[i31], epsilon))
            return false;
      }

      for (int i33 = 0; i33 < int8_values_.length; ++i33)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.int8_values_[i33], other.int8_values_[i33], epsilon))
            return false;
      }

      for (int i35 = 0; i35 < uint8_values_.length; ++i35)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.uint8_values_[i35], other.uint8_values_[i35], epsilon))
            return false;
      }

      for (int i37 = 0; i37 < int16_values_.length; ++i37)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.int16_values_[i37], other.int16_values_[i37], epsilon))
            return false;
      }

      for (int i39 = 0; i39 < int32_values_.length; ++i39)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.int32_values_[i39], other.int32_values_[i39], epsilon))
            return false;
      }

      for (int i41 = 0; i41 < string_values_.length; ++i41)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.string_values_[i41], other.string_values_[i41], epsilon))
            return false;
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof StaticArrayPrimitives))
         return false;

      StaticArrayPrimitives otherMyClass = (StaticArrayPrimitives) other;

      for (int i43 = 0; i43 < bool_values_.length; ++i43)
      {
         if (this.bool_values_[i43] != otherMyClass.bool_values_[i43])
            return false;
      }
      for (int i45 = 0; i45 < byte_values_.length; ++i45)
      {
         if (this.byte_values_[i45] != otherMyClass.byte_values_[i45])
            return false;
      }
      for (int i47 = 0; i47 < char_values_.length; ++i47)
      {
         if (this.char_values_[i47] != otherMyClass.char_values_[i47])
            return false;
      }
      for (int i49 = 0; i49 < float32_values_.length; ++i49)
      {
         if (this.float32_values_[i49] != otherMyClass.float32_values_[i49])
            return false;
      }
      for (int i51 = 0; i51 < float64_values_.length; ++i51)
      {
         if (this.float64_values_[i51] != otherMyClass.float64_values_[i51])
            return false;
      }
      for (int i53 = 0; i53 < int8_values_.length; ++i53)
      {
         if (this.int8_values_[i53] != otherMyClass.int8_values_[i53])
            return false;
      }
      for (int i55 = 0; i55 < uint8_values_.length; ++i55)
      {
         if (this.uint8_values_[i55] != otherMyClass.uint8_values_[i55])
            return false;
      }
      for (int i57 = 0; i57 < int16_values_.length; ++i57)
      {
         if (this.int16_values_[i57] != otherMyClass.int16_values_[i57])
            return false;
      }
      for (int i59 = 0; i59 < int32_values_.length; ++i59)
      {
         if (this.int32_values_[i59] != otherMyClass.int32_values_[i59])
            return false;
      }
      for (int i61 = 0; i61 < string_values_.length; ++i61)
      {
         if (!us.ihmc.idl.IDLTools.equals(this.string_values_[i61], otherMyClass.string_values_[i61]))
            return false;
      }

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("StaticArrayPrimitives {");
      builder.append("bool_values=");
      builder.append(java.util.Arrays.toString(this.bool_values_));

      builder.append(", ");
      builder.append("byte_values=");
      builder.append(java.util.Arrays.toString(this.byte_values_));

      builder.append(", ");
      builder.append("char_values=");
      builder.append(java.util.Arrays.toString(this.char_values_));

      builder.append(", ");
      builder.append("float32_values=");
      builder.append(java.util.Arrays.toString(this.float32_values_));

      builder.append(", ");
      builder.append("float64_values=");
      builder.append(java.util.Arrays.toString(this.float64_values_));

      builder.append(", ");
      builder.append("int8_values=");
      builder.append(java.util.Arrays.toString(this.int8_values_));

      builder.append(", ");
      builder.append("uint8_values=");
      builder.append(java.util.Arrays.toString(this.uint8_values_));

      builder.append(", ");
      builder.append("int16_values=");
      builder.append(java.util.Arrays.toString(this.int16_values_));

      builder.append(", ");
      builder.append("int32_values=");
      builder.append(java.util.Arrays.toString(this.int32_values_));

      builder.append(", ");
      builder.append("string_values=");
      builder.append(java.util.Arrays.toString(this.string_values_));

      builder.append("}");
      return builder.toString();
   }
}
