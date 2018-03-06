package ros_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class EmptyOne implements Settable<EmptyOne>, EpsilonComparable<EmptyOne>
{
   private boolean unused_placeholder_field_;

   public EmptyOne()
   {
   }

   public EmptyOne(EmptyOne other)
   {
      set(other);
   }

   public void set(EmptyOne other)
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
   public boolean epsilonEquals(EmptyOne other, double epsilon)
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
      if (!(other instanceof EmptyOne))
         return false;

      EmptyOne otherMyClass = (EmptyOne) other;

      if (this.unused_placeholder_field_ != otherMyClass.unused_placeholder_field_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("EmptyOne {");
      builder.append("unused_placeholder_field=");
      builder.append(this.unused_placeholder_field_);

      builder.append("}");
      return builder.toString();
   }
}