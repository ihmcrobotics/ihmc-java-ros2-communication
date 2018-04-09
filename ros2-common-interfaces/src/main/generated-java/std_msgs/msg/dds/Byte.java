package std_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

public class Byte extends Packet<Byte> implements Settable<Byte>, EpsilonComparable<Byte>
{
   public byte data_;

   public Byte()
   {
   }

   public Byte(Byte other)
   {
      this();
      set(other);
   }

   public void set(Byte other)
   {
      data_ = other.data_;

   }

   public void setData(byte data)
   {
      data_ = data;
   }
   public byte getData()
   {
      return data_;
   }


   @Override
   public boolean epsilonEquals(Byte other, double epsilon)
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
      if(!(other instanceof Byte)) return false;

      Byte otherMyClass = (Byte) other;

      if(this.data_ != otherMyClass.data_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Byte {");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}
