package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Measurement from an external time source not actively synchronized with the system clock.
       * frame_id is not used
       */
public class TimeReference extends Packet<TimeReference> implements Settable<TimeReference>, EpsilonComparable<TimeReference>
{
   /**
            * stamp is system time for which measurement was valid
            */
   public std_msgs.msg.dds.Header header_;
   /**
            * corresponding time from this external source
            */
   public builtin_interfaces.msg.dds.Time time_ref_;
   /**
            * (optional) name of time source
            */
   public java.lang.StringBuilder source_;

   public TimeReference()
   {
      header_ = new std_msgs.msg.dds.Header();
      time_ref_ = new builtin_interfaces.msg.dds.Time();
      source_ = new java.lang.StringBuilder(255);
   }

   public TimeReference(TimeReference other)
   {
      this();
      set(other);
   }

   public void set(TimeReference other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.time_ref_, time_ref_);
      source_.setLength(0);
      source_.append(other.source_);

   }


   /**
            * stamp is system time for which measurement was valid
            */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   /**
            * corresponding time from this external source
            */
   public builtin_interfaces.msg.dds.Time getTimeRef()
   {
      return time_ref_;
   }

   /**
            * (optional) name of time source
            */
   public void setSource(java.lang.String source)
   {
      source_.setLength(0);
      source_.append(source);
   }

   /**
            * (optional) name of time source
            */
   public java.lang.String getSourceAsString()
   {
      return getSourceAsStringBuilder().toString();
   }
   /**
            * (optional) name of time source
            */
   public java.lang.StringBuilder getSourceAsStringBuilder()
   {
      return source_;
   }


   public static Supplier<TimeReferencePubSubType> getPubSubType()
   {
      return TimeReferencePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TimeReferencePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(TimeReference other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!this.time_ref_.epsilonEquals(other.time_ref_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.source_, other.source_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof TimeReference)) return false;

      TimeReference otherMyClass = (TimeReference) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.time_ref_.equals(otherMyClass.time_ref_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.source_, otherMyClass.source_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TimeReference {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("time_ref=");
      builder.append(this.time_ref_);      builder.append(", ");
      builder.append("source=");
      builder.append(this.source_);
      builder.append("}");
      return builder.toString();
   }
}
