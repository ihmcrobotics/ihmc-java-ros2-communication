package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This message contains a parameter event.
       * It was an atomic update.
       * A specific parameter name can only be in one of the three sets.
       */
public class ParameterEvent extends Packet<ParameterEvent> implements Settable<ParameterEvent>, EpsilonComparable<ParameterEvent>
{
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  new_parameters_;
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  changed_parameters_;
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  deleted_parameters_;

   public ParameterEvent()
   {
      new_parameters_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter> (100, rcl_interfaces.msg.dds.Parameter.class, new rcl_interfaces.msg.dds.ParameterPubSubType());
      changed_parameters_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter> (100, rcl_interfaces.msg.dds.Parameter.class, new rcl_interfaces.msg.dds.ParameterPubSubType());
      deleted_parameters_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter> (100, rcl_interfaces.msg.dds.Parameter.class, new rcl_interfaces.msg.dds.ParameterPubSubType());

   }

   public ParameterEvent(ParameterEvent other)
   {
      this();
      set(other);
   }

   public void set(ParameterEvent other)
   {
      new_parameters_.set(other.new_parameters_);
      changed_parameters_.set(other.changed_parameters_);
      deleted_parameters_.set(other.deleted_parameters_);
   }


   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  getNewParameters()
   {
      return new_parameters_;
   }


   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  getChangedParameters()
   {
      return changed_parameters_;
   }


   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  getDeletedParameters()
   {
      return deleted_parameters_;
   }


   public static Supplier<ParameterEventPubSubType> getPubSubType()
   {
      return ParameterEventPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ParameterEventPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ParameterEvent other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (this.new_parameters_.size() != other.new_parameters_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.new_parameters_.size(); i++)
         {  if (!this.new_parameters_.get(i).epsilonEquals(other.new_parameters_.get(i), epsilon)) return false; }
      }

      if (this.changed_parameters_.size() != other.changed_parameters_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.changed_parameters_.size(); i++)
         {  if (!this.changed_parameters_.get(i).epsilonEquals(other.changed_parameters_.get(i), epsilon)) return false; }
      }

      if (this.deleted_parameters_.size() != other.deleted_parameters_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.deleted_parameters_.size(); i++)
         {  if (!this.deleted_parameters_.get(i).epsilonEquals(other.deleted_parameters_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ParameterEvent)) return false;

      ParameterEvent otherMyClass = (ParameterEvent) other;

      if (!this.new_parameters_.equals(otherMyClass.new_parameters_)) return false;
      if (!this.changed_parameters_.equals(otherMyClass.changed_parameters_)) return false;
      if (!this.deleted_parameters_.equals(otherMyClass.deleted_parameters_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ParameterEvent {");
      builder.append("new_parameters=");
      builder.append(this.new_parameters_);      builder.append(", ");
      builder.append("changed_parameters=");
      builder.append(this.changed_parameters_);      builder.append(", ");
      builder.append("deleted_parameters=");
      builder.append(this.deleted_parameters_);
      builder.append("}");
      return builder.toString();
   }
}
