package std_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

public class Int16 extends Packet<Int16> implements Settable<Int16>, EpsilonComparable<Int16>
{
   public short data_;

   public Int16()
   {
   }

   public Int16(Int16 other)
   {
      this();
      set(other);
   }

   public void set(Int16 other)
   {
      data_ = other.data_;

   }

   public void setData(short data)
   {
      data_ = data;
   }
   public short getData()
   {
      return data_;
   }


   @Override
   public boolean epsilonEquals(Int16 other, double epsilon)
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
      if(!(other instanceof Int16)) return false;

      Int16 otherMyClass = (Int16) other;

      if(this.data_ != otherMyClass.data_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Int16 {");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}
