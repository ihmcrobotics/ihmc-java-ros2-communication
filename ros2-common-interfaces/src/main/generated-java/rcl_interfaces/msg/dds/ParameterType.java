package rcl_interfaces.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class ParameterType implements Settable<ParameterType>, EpsilonComparable<ParameterType>
{
   public static final byte PARAMETER_NOT_SET = (byte) 0;
   public static final byte PARAMETER_BOOL = (byte) 1;
   public static final byte PARAMETER_INTEGER = (byte) 2;
   public static final byte PARAMETER_DOUBLE = (byte) 3;
   public static final byte PARAMETER_STRING = (byte) 4;
   public static final byte PARAMETER_BYTES = (byte) 5;
   private boolean unused_placeholder_field_;

   public ParameterType()
   {
   }

   public ParameterType(ParameterType other)
   {
      set(other);
   }

   public void set(ParameterType other)
   {
      unused_placeholder_field_ = other.unused_placeholder_field_;
   }

   public boolean getUnusedPlaceholderField()
   {
      return unused_placeholder_field_;
   }

   public void setUnusedPlaceholderField(boolean unused_placeholder_field)
   {
      unused_placeholder_field_ = unused_placeholder_field;
   }

   @Override
   public boolean epsilonEquals(ParameterType other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.unused_placeholder_field_, other.unused_placeholder_field_, epsilon))
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
      if (!(other instanceof ParameterType))
         return false;

      ParameterType otherMyClass = (ParameterType) other;

      if (this.unused_placeholder_field_ != otherMyClass.unused_placeholder_field_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ParameterType {");
      builder.append("unused_placeholder_field=");
      builder.append(this.unused_placeholder_field_);

      builder.append("}");
      return builder.toString();
   }
}