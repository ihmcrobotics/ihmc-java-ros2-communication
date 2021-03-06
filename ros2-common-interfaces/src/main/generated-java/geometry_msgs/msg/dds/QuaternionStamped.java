package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This represents an orientation with reference coordinate frame and timestamp.
       */
public class QuaternionStamped extends Packet<QuaternionStamped> implements Settable<QuaternionStamped>, EpsilonComparable<QuaternionStamped>
{
   public std_msgs.msg.dds.Header header_;
   public us.ihmc.euclid.tuple4D.Quaternion quaternion_;

   public QuaternionStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      quaternion_ = new us.ihmc.euclid.tuple4D.Quaternion();
   }

   public QuaternionStamped(QuaternionStamped other)
   {
      this();
      set(other);
   }

   public void set(QuaternionStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.QuaternionPubSubType.staticCopy(other.quaternion_, quaternion_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   public us.ihmc.euclid.tuple4D.Quaternion getQuaternion()
   {
      return quaternion_;
   }


   public static Supplier<QuaternionStampedPubSubType> getPubSubType()
   {
      return QuaternionStampedPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return QuaternionStampedPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(QuaternionStamped other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!this.quaternion_.epsilonEquals(other.quaternion_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof QuaternionStamped)) return false;

      QuaternionStamped otherMyClass = (QuaternionStamped) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.quaternion_.equals(otherMyClass.quaternion_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("QuaternionStamped {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("quaternion=");
      builder.append(this.quaternion_);
      builder.append("}");
      return builder.toString();
   }
}
