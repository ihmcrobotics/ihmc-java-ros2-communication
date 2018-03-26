package std_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class UInt8 extends Packet<UInt8> implements Settable<UInt8>, EpsilonComparable<UInt8>
{
   public byte data_;

   public UInt8()
   {
   }

   public UInt8(UInt8 other)
   {
      set(other);
   }

   public void set(UInt8 other)
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
   public boolean epsilonEquals(UInt8 other, double epsilon)
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
      if (!(other instanceof UInt8))
         return false;

      UInt8 otherMyClass = (UInt8) other;

      if (this.data_ != otherMyClass.data_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("UInt8 {");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}
