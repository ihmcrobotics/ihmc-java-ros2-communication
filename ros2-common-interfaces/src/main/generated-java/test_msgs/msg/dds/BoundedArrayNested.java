package test_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class BoundedArrayNested extends Packet<BoundedArrayNested> implements Settable<BoundedArrayNested>, EpsilonComparable<BoundedArrayNested>
{
   public us.ihmc.idl.IDLSequence.Object<test_msgs.msg.dds.Primitives>  primitive_values_;

   public BoundedArrayNested()
   {
      primitive_values_ = new us.ihmc.idl.IDLSequence.Object<test_msgs.msg.dds.Primitives> (4, test_msgs.msg.dds.Primitives.class, new test_msgs.msg.dds.PrimitivesPubSubType());

   }

   public BoundedArrayNested(BoundedArrayNested other)
   {
      this();
      set(other);
   }

   public void set(BoundedArrayNested other)
   {
      primitive_values_.set(other.primitive_values_);
   }


   public us.ihmc.idl.IDLSequence.Object<test_msgs.msg.dds.Primitives>  getPrimitiveValues()
   {
      return primitive_values_;
   }


   public static Supplier<BoundedArrayNestedPubSubType> getPubSubType()
   {
      return BoundedArrayNestedPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return BoundedArrayNestedPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(BoundedArrayNested other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (this.primitive_values_.size() != other.primitive_values_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.primitive_values_.size(); i++)
         {  if (!this.primitive_values_.get(i).epsilonEquals(other.primitive_values_.get(i), epsilon)) return false; }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof BoundedArrayNested)) return false;

      BoundedArrayNested otherMyClass = (BoundedArrayNested) other;

      if (!this.primitive_values_.equals(otherMyClass.primitive_values_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("BoundedArrayNested {");
      builder.append("primitive_values=");
      builder.append(this.primitive_values_);
      builder.append("}");
      return builder.toString();
   }
}
