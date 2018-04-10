package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;

/**
       * This expresses velocity in free space broken into its linear and angular parts.
       */
public class Twist extends Packet<Twist> implements Settable<Twist>, EpsilonComparable<Twist>
{
   public us.ihmc.euclid.tuple3D.Vector3D linear_;
   public us.ihmc.euclid.tuple3D.Vector3D angular_;

   public Twist()
   {
      linear_ = new us.ihmc.euclid.tuple3D.Vector3D();
      angular_ = new us.ihmc.euclid.tuple3D.Vector3D();
   }

   public Twist(Twist other)
   {
      this();
      set(other);
   }

   public void set(Twist other)
   {
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.linear_, linear_);
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.angular_, angular_);
   }


   public us.ihmc.euclid.tuple3D.Vector3D getLinear()
   {
      return linear_;
   }


   public us.ihmc.euclid.tuple3D.Vector3D getAngular()
   {
      return angular_;
   }


   public static Supplier<TwistPubSubType> getPubSubType()
   {
      return TwistPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Twist other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.linear_.epsilonEquals(other.linear_, epsilon)) return false;
      if (!this.angular_.epsilonEquals(other.angular_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Twist)) return false;

      Twist otherMyClass = (Twist) other;

      if (!this.linear_.equals(otherMyClass.linear_)) return false;
      if (!this.angular_.equals(otherMyClass.angular_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Twist {");
      builder.append("linear=");
      builder.append(this.linear_);      builder.append(", ");
      builder.append("angular=");
      builder.append(this.angular_);
      builder.append("}");
      return builder.toString();
   }
}
