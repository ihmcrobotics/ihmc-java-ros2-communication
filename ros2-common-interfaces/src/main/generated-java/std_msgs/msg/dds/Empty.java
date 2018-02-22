package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Empty" defined in Empty_.idl.
 *
 * This file was automatically generated from Empty_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Empty_.idl instead.
 */
public class Empty implements Settable<Empty>, EpsilonComparable<Empty>
{
   private boolean _dummy_;

   public Empty()
   {
   }

   public Empty(Empty other)
   {
      set(other);
   }

   public void set(Empty other)
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
   public boolean epsilonEquals(Empty other, double epsilon)
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
      if (!(other instanceof Empty))
         return false;

      Empty otherMyClass = (Empty) other;

      if (this._dummy_ != otherMyClass._dummy_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Empty {");
      builder.append("_dummy=");
      builder.append(this._dummy_);

      builder.append("}");
      return builder.toString();
   }
}