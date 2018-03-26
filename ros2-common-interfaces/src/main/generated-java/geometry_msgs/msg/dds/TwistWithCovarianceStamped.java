package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This represents an estimated twist with reference coordinate frame and timestamp.
 */
public class TwistWithCovarianceStamped implements Settable<TwistWithCovarianceStamped>, EpsilonComparable<TwistWithCovarianceStamped>
{
   public std_msgs.msg.dds.Header header_;
   public geometry_msgs.msg.dds.TwistWithCovariance twist_;

   public TwistWithCovarianceStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      twist_ = new geometry_msgs.msg.dds.TwistWithCovariance();
   }

   public TwistWithCovarianceStamped(TwistWithCovarianceStamped other)
   {
      set(other);
   }

   public void set(TwistWithCovarianceStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.TwistWithCovariancePubSubType.staticCopy(other.twist_, twist_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public geometry_msgs.msg.dds.TwistWithCovariance getTwist()
   {
      return twist_;
   }

   @Override
   public boolean epsilonEquals(TwistWithCovarianceStamped other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.twist_.epsilonEquals(other.twist_, epsilon))
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
      if (!(other instanceof TwistWithCovarianceStamped))
         return false;

      TwistWithCovarianceStamped otherMyClass = (TwistWithCovarianceStamped) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.twist_.equals(otherMyClass.twist_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TwistWithCovarianceStamped {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("twist=");
      builder.append(this.twist_);

      builder.append("}");
      return builder.toString();
   }
}