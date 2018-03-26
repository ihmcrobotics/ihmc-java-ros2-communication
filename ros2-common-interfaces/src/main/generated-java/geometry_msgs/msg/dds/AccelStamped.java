package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class AccelStamped implements Settable<AccelStamped>, EpsilonComparable<AccelStamped>
{
   /**
    * An accel with reference coordinate frame and timestamp
    */
   private std_msgs.msg.dds.Header header_;
   private geometry_msgs.msg.dds.Accel accel_;

   public AccelStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      accel_ = new geometry_msgs.msg.dds.Accel();
   }

   public AccelStamped(AccelStamped other)
   {
      set(other);
   }

   public void set(AccelStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.AccelPubSubType.staticCopy(other.accel_, accel_);
   }

   /**
    * An accel with reference coordinate frame and timestamp
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public geometry_msgs.msg.dds.Accel getAccel()
   {
      return accel_;
   }

   @Override
   public boolean epsilonEquals(AccelStamped other, double epsilon)
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
      if (!(other instanceof AccelStamped))
         return false;

      AccelStamped otherMyClass = (AccelStamped) other;

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

      builder.append("AccelStamped {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("accel=");
      builder.append(this.accel_);

      builder.append("}");
      return builder.toString();
   }
}
