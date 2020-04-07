package builtin_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class Duration extends Packet<Duration> implements Settable<Duration>, EpsilonComparable<Duration>
{

   public int sec_;

   public long nanosec_;

   public Duration()
   {



   }

   public Duration(Duration other)
   {
      this();
      set(other);
   }

   public void set(Duration other)
   {

      sec_ = other.sec_;


      nanosec_ = other.nanosec_;

   }


   public void setSec(int sec)
   {
      sec_ = sec;
   }
   public int getSec()
   {
      return sec_;
   }


   public void setNanosec(long nanosec)
   {
      nanosec_ = nanosec;
   }
   public long getNanosec()
   {
      return nanosec_;
   }


   public static Supplier<DurationPubSubType> getPubSubType()
   {
      return DurationPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return DurationPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Duration other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.sec_, other.sec_, epsilon)) return false;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.nanosec_, other.nanosec_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Duration)) return false;

      Duration otherMyClass = (Duration) other;


      if(this.sec_ != otherMyClass.sec_) return false;


      if(this.nanosec_ != otherMyClass.nanosec_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Duration {");

      builder.append("sec=");
      builder.append(this.sec_);      builder.append(", ");

      builder.append("nanosec=");
      builder.append(this.nanosec_);
      builder.append("}");
      return builder.toString();
   }
}
