package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "InteractiveMarkerPose" defined in InteractiveMarkerPose_.idl.
 *
 * This file was automatically generated from InteractiveMarkerPose_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit InteractiveMarkerPose_.idl instead.
 */
public class InteractiveMarkerPose implements Settable<InteractiveMarkerPose>, EpsilonComparable<InteractiveMarkerPose>
{
   private std_msgs.msg.dds.Header header_;
   private us.ihmc.euclid.geometry.Pose3D pose_;
   private java.lang.StringBuilder name_;

   public InteractiveMarkerPose()
   {
      header_ = new std_msgs.msg.dds.Header();
      pose_ = new us.ihmc.euclid.geometry.Pose3D();
      name_ = new java.lang.StringBuilder(255);
   }

   public InteractiveMarkerPose(InteractiveMarkerPose other)
   {
      set(other);
   }

   public void set(InteractiveMarkerPose other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.pose_, pose_);
      name_.setLength(0);
      name_.append(other.name_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.euclid.geometry.Pose3D getPose()
   {
      return pose_;
   }

   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }

   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   public void setName(String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   @Override
   public boolean epsilonEquals(InteractiveMarkerPose other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.pose_.epsilonEquals(other.pose_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon))
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
      if (!(other instanceof InteractiveMarkerPose))
         return false;

      InteractiveMarkerPose otherMyClass = (InteractiveMarkerPose) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.pose_.equals(otherMyClass.pose_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("InteractiveMarkerPose {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("pose=");
      builder.append(this.pose_);

      builder.append(", ");
      builder.append("name=");
      builder.append(this.name_);

      builder.append("}");
      return builder.toString();
   }
}