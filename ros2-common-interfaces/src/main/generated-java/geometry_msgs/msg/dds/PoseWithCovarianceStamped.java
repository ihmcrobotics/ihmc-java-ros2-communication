package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "PoseWithCovarianceStamped" defined in PoseWithCovarianceStamped_.idl.
 *
 * This file was automatically generated from PoseWithCovarianceStamped_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit PoseWithCovarianceStamped_.idl instead.
 */
public class PoseWithCovarianceStamped implements Settable<PoseWithCovarianceStamped>, EpsilonComparable<PoseWithCovarianceStamped>
{
   private std_msgs.msg.dds.Header header_;
   private geometry_msgs.msg.dds.PoseWithCovariance pose_;

   public PoseWithCovarianceStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      pose_ = new geometry_msgs.msg.dds.PoseWithCovariance();
   }

   public PoseWithCovarianceStamped(PoseWithCovarianceStamped other)
   {
      set(other);
   }

   public void set(PoseWithCovarianceStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.PoseWithCovariancePubSubType.staticCopy(other.pose_, pose_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public geometry_msgs.msg.dds.PoseWithCovariance getPose()
   {
      return pose_;
   }

   @Override
   public boolean epsilonEquals(PoseWithCovarianceStamped other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.pose_.epsilonEquals(other.pose_, epsilon))
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
      if (!(other instanceof PoseWithCovarianceStamped))
         return false;

      PoseWithCovarianceStamped otherMyClass = (PoseWithCovarianceStamped) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.pose_.equals(otherMyClass.pose_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PoseWithCovarianceStamped {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("pose=");
      builder.append(this.pose_);

      builder.append("}");
      return builder.toString();
   }
}