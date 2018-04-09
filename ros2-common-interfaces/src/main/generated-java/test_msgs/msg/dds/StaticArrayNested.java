package test_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

public class StaticArrayNested extends Packet<StaticArrayNested> implements Settable<StaticArrayNested>, EpsilonComparable<StaticArrayNested>
{
   public test_msgs.msg.dds.Primitives[] primitive_values_;

   public StaticArrayNested()
   {
      primitive_values_ = new test_msgs.msg.dds.Primitives[4];

      for(int i1 = 0; i1 < primitive_values_.length; ++i1)
      {
          primitive_values_[i1] = new test_msgs.msg.dds.Primitives();
      }
   }

   public StaticArrayNested(StaticArrayNested other)
   {
      this();
      set(other);
   }

   public void set(StaticArrayNested other)
   {
      for(int i3 = 0; i3 < primitive_values_.length; ++i3)
      {
            test_msgs.msg.dds.PrimitivesPubSubType.staticCopy(other.primitive_values_[i3], primitive_values_[i3]);}
   }


   public test_msgs.msg.dds.Primitives[] getPrimitiveValues()
   {
      return primitive_values_;
   }


   @Override
   public boolean epsilonEquals(StaticArrayNested other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      for(int i5 = 0; i5 < primitive_values_.length; ++i5)
      {
              if (!this.primitive_values_[i5].epsilonEquals(other.primitive_values_[i5], epsilon)) return false;
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof StaticArrayNested)) return false;

      StaticArrayNested otherMyClass = (StaticArrayNested) other;

      for(int i7 = 0; i7 < primitive_values_.length; ++i7)
      {
                if (!this.primitive_values_[i7].equals(otherMyClass.primitive_values_[i7])) return false;
      }
      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("StaticArrayNested {");
      builder.append("primitive_values=");
      builder.append(java.util.Arrays.toString(this.primitive_values_));
      builder.append("}");
      return builder.toString();
   }
}
