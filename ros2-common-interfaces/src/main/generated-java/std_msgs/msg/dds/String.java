package std_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;

public class String extends Packet<String> implements Settable<String>, EpsilonComparable<String>
{
   public java.lang.StringBuilder data_;

   public String()
   {
      data_ = new java.lang.StringBuilder(255);
   }

   public String(String other)
   {
      this();
      set(other);
   }

   public void set(String other)
   {
      data_.setLength(0);
      data_.append(other.data_);
   }

   public void setData(java.lang.String data)
   {
      data_.setLength(0);
      data_.append(data);
   }

   public java.lang.String getDataAsString()
   {
      return getData().toString();
   }
   public java.lang.StringBuilder getData()
   {
      return data_;
   }


   public static Supplier<StringPubSubType> getPubSubType()
   {
      return StringPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(String other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.data_, other.data_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof String)) return false;

      String otherMyClass = (String) other;

      if (!us.ihmc.idl.IDLTools.equals(this.data_, otherMyClass.data_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("String {");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}
