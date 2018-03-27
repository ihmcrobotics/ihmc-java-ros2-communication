package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class AccelWithCovarianceStamped extends Packet<AccelWithCovarianceStamped>
      implements Settable<AccelWithCovarianceStamped>, EpsilonComparable<AccelWithCovarianceStamped>
{
   /**
    * This represents an estimated accel with reference coordinate frame and timestamp.
    */
   public std_msgs.msg.dds.Header header_;
   public geometry_msgs.msg.dds.AccelWithCovariance accel_;

   public AccelWithCovarianceStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      accel_ = new geometry_msgs.msg.dds.AccelWithCovariance();
   }

   public AccelWithCovarianceStamped(AccelWithCovarianceStamped other)
   {
      set(other);
   }

   public void set(AccelWithCovarianceStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.AccelWithCovariancePubSubType.staticCopy(other.accel_, accel_);
   }

   /**
    * This represents an estimated accel with reference coordinate frame and timestamp.
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public geometry_msgs.msg.dds.AccelWithCovariance getAccel()
   {
      return accel_;
   }

   @Override
   public boolean epsilonEquals(AccelWithCovarianceStamped other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;
      if (!this.accel_.epsilonEquals(other.accel_, epsilon))
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
      if (!(other instanceof AccelWithCovarianceStamped))
         return false;

      AccelWithCovarianceStamped otherMyClass = (AccelWithCovarianceStamped) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;
      if (!this.accel_.equals(otherMyClass.accel_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("AccelWithCovarianceStamped {");
      builder.append("header=");
      builder.append(this.header_);
      builder.append(", ");
      builder.append("accel=");
      builder.append(this.accel_);
      builder.append("}");
      return builder.toString();
   }
}
