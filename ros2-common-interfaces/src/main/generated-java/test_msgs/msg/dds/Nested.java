package test_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class Nested implements Settable<Nested>, EpsilonComparable<Nested>
{
   public test_msgs.msg.dds.Primitives primitive_values_;

   public Nested()
   {
      primitive_values_ = new test_msgs.msg.dds.Primitives();
   }

   public Nested(Nested other)
   {
      set(other);
   }

   public void set(Nested other)
   {
      test_msgs.msg.dds.PrimitivesPubSubType.staticCopy(other.primitive_values_, primitive_values_);
   }

   public test_msgs.msg.dds.Primitives getPrimitiveValues()
   {
      return primitive_values_;
   }

   @Override
   public boolean epsilonEquals(Nested other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.primitive_values_.epsilonEquals(other.primitive_values_, epsilon))
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
      if (!(other instanceof Nested))
         return false;

      Nested otherMyClass = (Nested) other;

      if (!this.primitive_values_.equals(otherMyClass.primitive_values_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Nested {");
      builder.append("primitive_values=");
      builder.append(this.primitive_values_);

      builder.append("}");
      return builder.toString();
   }
}