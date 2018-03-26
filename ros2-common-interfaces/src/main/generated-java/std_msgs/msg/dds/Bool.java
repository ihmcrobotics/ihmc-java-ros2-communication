package std_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class Bool extends Packet<Bool> implements Settable<Bool>, EpsilonComparable<Bool>
{
   public boolean data_;

   public Bool()
   {
   }

   public Bool(Bool other)
   {
      set(other);
   }

   public void set(Bool other)
   {
      data_ = other.data_;
   }

   public boolean getData()
   {
      return data_;
   }

   public void setData(boolean data)
   {
      data_ = data;
   }

   @Override
   public boolean epsilonEquals(Bool other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.data_, other.data_, epsilon))
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
      if (!(other instanceof Bool))
         return false;

      Bool otherMyClass = (Bool) other;

      if (this.data_ != otherMyClass.data_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Bool {");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}
