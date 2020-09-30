package tf2_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class TFMessage extends Packet<TFMessage> implements Settable<TFMessage>, EpsilonComparable<TFMessage>
{
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.TransformStamped>  transforms_;

   public TFMessage()
   {
      transforms_ = new us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.TransformStamped> (10000000, new geometry_msgs.msg.dds.TransformStampedPubSubType());

   }

   public TFMessage(TFMessage other)
   {
      this();
      set(other);
   }

   public void set(TFMessage other)
   {
      transforms_.set(other.transforms_);
   }


   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.TransformStamped>  getTransforms()
   {
      return transforms_;
   }


   public static Supplier<TFMessagePubSubType> getPubSubType()
   {
      return TFMessagePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TFMessagePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(TFMessage other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (this.transforms_.size() != other.transforms_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.transforms_.size(); i++)
         {  if (!this.transforms_.get(i).epsilonEquals(other.transforms_.get(i), epsilon)) return false; }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof TFMessage)) return false;

      TFMessage otherMyClass = (TFMessage) other;

      if (!this.transforms_.equals(otherMyClass.transforms_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TFMessage {");
      builder.append("transforms=");
      builder.append(this.transforms_);
      builder.append("}");
      return builder.toString();
   }
}
