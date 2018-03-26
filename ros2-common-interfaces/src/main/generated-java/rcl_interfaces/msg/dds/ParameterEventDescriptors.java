package rcl_interfaces.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message contains descriptors of a parameter event.
 * It was an atomic update.
 * A specific parameter name can only be in one of the three sets.
 */
public class ParameterEventDescriptors implements Settable<ParameterEventDescriptors>, EpsilonComparable<ParameterEventDescriptors>
{
   private us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.ParameterDescriptor> new_parameters_;
   private us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.ParameterDescriptor> changed_parameters_;
   private us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.ParameterDescriptor> deleted_parameters_;

   public ParameterEventDescriptors()
   {
      new_parameters_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.ParameterDescriptor>(100, rcl_interfaces.msg.dds.ParameterDescriptor.class,
                                                                                                       new rcl_interfaces.msg.dds.ParameterDescriptorPubSubType());

      changed_parameters_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.ParameterDescriptor>(100,
                                                                                                           rcl_interfaces.msg.dds.ParameterDescriptor.class,
                                                                                                           new rcl_interfaces.msg.dds.ParameterDescriptorPubSubType());

      deleted_parameters_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.ParameterDescriptor>(100,
                                                                                                           rcl_interfaces.msg.dds.ParameterDescriptor.class,
                                                                                                           new rcl_interfaces.msg.dds.ParameterDescriptorPubSubType());
   }

   public ParameterEventDescriptors(ParameterEventDescriptors other)
   {
      set(other);
   }

   public void set(ParameterEventDescriptors other)
   {
      new_parameters_.set(other.new_parameters_);
      changed_parameters_.set(other.changed_parameters_);
      deleted_parameters_.set(other.deleted_parameters_);
   }

   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.ParameterDescriptor> getNewParameters()
   {
      return new_parameters_;
   }

   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.ParameterDescriptor> getChangedParameters()
   {
      return changed_parameters_;
   }

   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.ParameterDescriptor> getDeletedParameters()
   {
      return deleted_parameters_;
   }

   @Override
   public boolean epsilonEquals(ParameterEventDescriptors other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (this.new_parameters_.size() == other.new_parameters_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.new_parameters_.size(); i++)
         {
            if (!this.new_parameters_.get(i).epsilonEquals(other.new_parameters_.get(i), epsilon))
               return false;
         }
      }

      if (this.changed_parameters_.size() == other.changed_parameters_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.changed_parameters_.size(); i++)
         {
            if (!this.changed_parameters_.get(i).epsilonEquals(other.changed_parameters_.get(i), epsilon))
               return false;
         }
      }

      if (this.deleted_parameters_.size() == other.deleted_parameters_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.deleted_parameters_.size(); i++)
         {
            if (!this.deleted_parameters_.get(i).epsilonEquals(other.deleted_parameters_.get(i), epsilon))
               return false;
         }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof ParameterEventDescriptors))
         return false;

      ParameterEventDescriptors otherMyClass = (ParameterEventDescriptors) other;

      if (!this.new_parameters_.equals(otherMyClass.new_parameters_))
         return false;

      if (!this.changed_parameters_.equals(otherMyClass.changed_parameters_))
         return false;

      if (!this.deleted_parameters_.equals(otherMyClass.deleted_parameters_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ParameterEventDescriptors {");
      builder.append("new_parameters=");
      builder.append(this.new_parameters_);

      builder.append(", ");
      builder.append("changed_parameters=");
      builder.append(this.changed_parameters_);

      builder.append(", ");
      builder.append("deleted_parameters=");
      builder.append(this.deleted_parameters_);

      builder.append("}");
      return builder.toString();
   }
}
