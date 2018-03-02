package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class Int8 implements Settable<Int8>, EpsilonComparable<Int8>
{
   private byte data_;

   public Int8()
   {
   }

   public Int8(Int8 other)
   {
      set(other);
   }

   public void set(Int8 other)
   {
      data_ = other.data_;
   }

   public byte getData()
   {
      return data_;
   }

   public void setData(byte data)
   {
      data_ = data;
   }

   @Override
   public boolean epsilonEquals(Int8 other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.data_, other.data_, epsilon))
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
      if (!(other instanceof Int8))
         return false;

      Int8 otherMyClass = (Int8) other;

      if (this.data_ != otherMyClass.data_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Int8 {");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}