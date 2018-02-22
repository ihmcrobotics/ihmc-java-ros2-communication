package rcl_interfaces.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Parameter" defined in Parameter_.idl.
 *
 * This file was automatically generated from Parameter_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Parameter_.idl instead.
 */
public class Parameter implements Settable<Parameter>, EpsilonComparable<Parameter>
{
   private java.lang.StringBuilder name_;
   private rcl_interfaces.msg.dds.ParameterValue value_;

   public Parameter()
   {
      name_ = new java.lang.StringBuilder(255);

      value_ = new rcl_interfaces.msg.dds.ParameterValue();
   }

   public Parameter(Parameter other)
   {
      set(other);
   }

   public void set(Parameter other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      rcl_interfaces.msg.dds.ParameterValuePubSubType.staticCopy(other.value_, value_);
   }

   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }

   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   public void setName(String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   public rcl_interfaces.msg.dds.ParameterValue getValue()
   {
      return value_;
   }

   @Override
   public boolean epsilonEquals(Parameter other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon))
         return false;

      if (!this.value_.epsilonEquals(other.value_, epsilon))
         return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof Parameter))
         return false;

      Parameter otherMyClass = (Parameter) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_))
         return false;

      if (!this.value_.equals(otherMyClass.value_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Parameter {");
      builder.append("name=");
      builder.append(this.name_);

      builder.append(", ");
      builder.append("value=");
      builder.append(this.value_);

      builder.append("}");
      return builder.toString();
   }
}