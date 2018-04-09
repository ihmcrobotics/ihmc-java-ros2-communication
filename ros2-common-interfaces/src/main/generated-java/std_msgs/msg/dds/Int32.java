package std_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

public class Int32 extends Packet<Int32> implements Settable<Int32>, EpsilonComparable<Int32>
{
   public int data_;

   public Int32()
   {
   }

   public Int32(Int32 other)
   {
      this();
      set(other);
   }

   public void set(Int32 other)
   {
      data_ = other.data_;

   }

   public void setData(int data)
   {
      data_ = data;
   }
   public int getData()
   {
      return data_;
   }


   @Override
   public boolean epsilonEquals(Int32 other, double epsilon)
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
      if(!(other instanceof Int32)) return false;

      Int32 otherMyClass = (Int32) other;

      if(this.data_ != otherMyClass.data_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Int32 {");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}
