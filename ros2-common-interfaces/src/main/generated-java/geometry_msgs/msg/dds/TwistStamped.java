package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * A twist with reference coordinate frame and timestamp
       */
public class TwistStamped extends Packet<TwistStamped> implements Settable<TwistStamped>, EpsilonComparable<TwistStamped>
{
   public std_msgs.msg.dds.Header header_;
   public geometry_msgs.msg.dds.Twist twist_;

   public TwistStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      twist_ = new geometry_msgs.msg.dds.Twist();
   }

   public TwistStamped(TwistStamped other)
   {
      this();
      set(other);
   }

   public void set(TwistStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.TwistPubSubType.staticCopy(other.twist_, twist_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   public geometry_msgs.msg.dds.Twist getTwist()
   {
      return twist_;
   }


   public static Supplier<TwistStampedPubSubType> getPubSubType()
   {
      return TwistStampedPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TwistStampedPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(TwistStamped other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!this.twist_.epsilonEquals(other.twist_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof TwistStamped)) return false;

      TwistStamped otherMyClass = (TwistStamped) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.twist_.equals(otherMyClass.twist_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TwistStamped {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("twist=");
      builder.append(this.twist_);
      builder.append("}");
      return builder.toString();
   }
}
