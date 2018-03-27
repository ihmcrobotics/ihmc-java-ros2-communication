package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * A wrench with reference coordinate frame and timestamp
 */
public class WrenchStamped extends Packet<WrenchStamped> implements Settable<WrenchStamped>, EpsilonComparable<WrenchStamped>
{
   public std_msgs.msg.dds.Header header_;
   public geometry_msgs.msg.dds.Wrench wrench_;

   public WrenchStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      wrench_ = new geometry_msgs.msg.dds.Wrench();
   }

   public WrenchStamped(WrenchStamped other)
   {
      set(other);
   }

   public void set(WrenchStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.WrenchPubSubType.staticCopy(other.wrench_, wrench_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public geometry_msgs.msg.dds.Wrench getWrench()
   {
      return wrench_;
   }

   @Override
   public boolean epsilonEquals(WrenchStamped other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;
      if (!this.wrench_.epsilonEquals(other.wrench_, epsilon))
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
      if (!(other instanceof WrenchStamped))
         return false;

      WrenchStamped otherMyClass = (WrenchStamped) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;
      if (!this.wrench_.equals(otherMyClass.wrench_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("WrenchStamped {");
      builder.append("header=");
      builder.append(this.header_);
      builder.append(", ");
      builder.append("wrench=");
      builder.append(this.wrench_);
      builder.append("}");
      return builder.toString();
   }
}
