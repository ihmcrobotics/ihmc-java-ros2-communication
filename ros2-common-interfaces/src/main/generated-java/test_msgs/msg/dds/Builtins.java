package test_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;

public class Builtins extends Packet<Builtins> implements Settable<Builtins>, EpsilonComparable<Builtins>
{
   public builtin_interfaces.msg.dds.Duration duration_value_;
   public builtin_interfaces.msg.dds.Time time_value_;

   public Builtins()
   {
      duration_value_ = new builtin_interfaces.msg.dds.Duration();
      time_value_ = new builtin_interfaces.msg.dds.Time();
   }

   public Builtins(Builtins other)
   {
      this();
      set(other);
   }

   public void set(Builtins other)
   {
      builtin_interfaces.msg.dds.DurationPubSubType.staticCopy(other.duration_value_, duration_value_);
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.time_value_, time_value_);
   }


   public builtin_interfaces.msg.dds.Duration getDurationValue()
   {
      return duration_value_;
   }


   public builtin_interfaces.msg.dds.Time getTimeValue()
   {
      return time_value_;
   }


   public static Supplier<BuiltinsPubSubType> getPubSubType()
   {
      return BuiltinsPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Builtins other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.duration_value_.epsilonEquals(other.duration_value_, epsilon)) return false;
      if (!this.time_value_.epsilonEquals(other.time_value_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Builtins)) return false;

      Builtins otherMyClass = (Builtins) other;

      if (!this.duration_value_.equals(otherMyClass.duration_value_)) return false;
      if (!this.time_value_.equals(otherMyClass.time_value_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Builtins {");
      builder.append("duration_value=");
      builder.append(this.duration_value_);      builder.append(", ");
      builder.append("time_value=");
      builder.append(this.time_value_);
      builder.append("}");
      return builder.toString();
   }
}
