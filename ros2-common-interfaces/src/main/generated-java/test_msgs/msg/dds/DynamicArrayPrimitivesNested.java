package test_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class DynamicArrayPrimitivesNested extends Packet<DynamicArrayPrimitivesNested> implements Settable<DynamicArrayPrimitivesNested>, EpsilonComparable<DynamicArrayPrimitivesNested>
{
   public us.ihmc.idl.IDLSequence.Object<test_msgs.msg.dds.DynamicArrayPrimitives>  dynamic_array_primitive_values_;

   public DynamicArrayPrimitivesNested()
   {
      dynamic_array_primitive_values_ = new us.ihmc.idl.IDLSequence.Object<test_msgs.msg.dds.DynamicArrayPrimitives> (100, new test_msgs.msg.dds.DynamicArrayPrimitivesPubSubType());

   }

   public DynamicArrayPrimitivesNested(DynamicArrayPrimitivesNested other)
   {
      this();
      set(other);
   }

   public void set(DynamicArrayPrimitivesNested other)
   {
      dynamic_array_primitive_values_.set(other.dynamic_array_primitive_values_);
   }


   public us.ihmc.idl.IDLSequence.Object<test_msgs.msg.dds.DynamicArrayPrimitives>  getDynamicArrayPrimitiveValues()
   {
      return dynamic_array_primitive_values_;
   }


   public static Supplier<DynamicArrayPrimitivesNestedPubSubType> getPubSubType()
   {
      return DynamicArrayPrimitivesNestedPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return DynamicArrayPrimitivesNestedPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(DynamicArrayPrimitivesNested other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (this.dynamic_array_primitive_values_.size() != other.dynamic_array_primitive_values_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.dynamic_array_primitive_values_.size(); i++)
         {  if (!this.dynamic_array_primitive_values_.get(i).epsilonEquals(other.dynamic_array_primitive_values_.get(i), epsilon)) return false; }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof DynamicArrayPrimitivesNested)) return false;

      DynamicArrayPrimitivesNested otherMyClass = (DynamicArrayPrimitivesNested) other;

      if (!this.dynamic_array_primitive_values_.equals(otherMyClass.dynamic_array_primitive_values_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("DynamicArrayPrimitivesNested {");
      builder.append("dynamic_array_primitive_values=");
      builder.append(this.dynamic_array_primitive_values_);
      builder.append("}");
      return builder.toString();
   }
}
