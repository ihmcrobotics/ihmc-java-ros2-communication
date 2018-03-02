package rcl_interfaces.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class ParameterType implements Settable<ParameterType>, EpsilonComparable<ParameterType>
{
   private boolean _dummy_;

   public ParameterType()
   {
   }

   public ParameterType(ParameterType other)
   {
      set(other);
   }

   public void set(ParameterType other)
   {
      _dummy_ = other._dummy_;
   }

   public boolean getDummy()
   {
      return _dummy_;
   }

   public void setDummy(boolean _dummy)
   {
      _dummy_ = _dummy;
   }

   @Override
   public boolean epsilonEquals(ParameterType other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this._dummy_, other._dummy_, epsilon))
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

      if (this._dummy_ != otherMyClass._dummy_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ParameterType {");
      builder.append("_dummy=");
      builder.append(this._dummy_);

      builder.append("}");
      return builder.toString();
   }
}