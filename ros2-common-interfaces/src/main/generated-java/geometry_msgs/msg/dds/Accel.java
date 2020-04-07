package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class Accel extends Packet<Accel> implements Settable<Accel>, EpsilonComparable<Accel>
{

   /**
            * This expresses acceleration in free space broken into its linear and angular parts.
            */
   public us.ihmc.euclid.tuple3D.Vector3D linear_;

   public us.ihmc.euclid.tuple3D.Vector3D angular_;

   public Accel()
   {

      linear_ = new us.ihmc.euclid.tuple3D.Vector3D();

      angular_ = new us.ihmc.euclid.tuple3D.Vector3D();

   }

   public Accel(Accel other)
   {
      this();
      set(other);
   }

   public void set(Accel other)
   {

      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.linear_, linear_);

      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.angular_, angular_);
   }



   /**
            * This expresses acceleration in free space broken into its linear and angular parts.
            */
   public us.ihmc.euclid.tuple3D.Vector3D getLinear()
   {
      return linear_;
   }



   public us.ihmc.euclid.tuple3D.Vector3D getAngular()
   {
      return angular_;
   }


   public static Supplier<AccelPubSubType> getPubSubType()
   {
      return AccelPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return AccelPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Accel other, double epsilon)
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
      if(!(other instanceof Accel)) return false;

      Accel otherMyClass = (Accel) other;


      if (!this.linear_.equals(otherMyClass.linear_)) return false;

      if (!this.angular_.equals(otherMyClass.angular_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Accel {");

      builder.append("linear=");
      builder.append(this.linear_);      builder.append(", ");

      builder.append("angular=");
      builder.append(this.angular_);
      builder.append("}");
      return builder.toString();
   }
}
