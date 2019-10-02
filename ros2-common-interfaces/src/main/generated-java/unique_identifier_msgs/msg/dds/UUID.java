package unique_identifier_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * A universally unique identifier (UUID).
       * 
       * http://en.wikipedia.org/wiki/Universally_unique_identifier
       * http://tools.ietf.org/html/rfc4122.html
       */
public class UUID extends Packet<UUID> implements Settable<UUID>, EpsilonComparable<UUID>
{
   public byte[] uuid_;

   public UUID()
   {
      uuid_ = new byte[16];

   }

   public UUID(UUID other)
   {
      this();
      set(other);
   }

   public void set(UUID other)
   {
      for(int i1 = 0; i1 < uuid_.length; ++i1)
      {
            uuid_[i1] = other.uuid_[i1];

      }
   }


   public byte[] getUuid()
   {
      return uuid_;
   }


   public static Supplier<UUIDPubSubType> getPubSubType()
   {
      return UUIDPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return UUIDPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(UUID other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      for(int i3 = 0; i3 < uuid_.length; ++i3)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.uuid_[i3], other.uuid_[i3], epsilon)) return false;
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof UUID)) return false;

      UUID otherMyClass = (UUID) other;

      for(int i5 = 0; i5 < uuid_.length; ++i5)
      {
                if(this.uuid_[i5] != otherMyClass.uuid_[i5]) return false;

      }
      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("UUID {");
      builder.append("uuid=");
      builder.append(java.util.Arrays.toString(this.uuid_));
      builder.append("}");
      return builder.toString();
   }
}
