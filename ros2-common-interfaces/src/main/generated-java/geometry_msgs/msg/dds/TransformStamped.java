package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This expresses a transform from coordinate frame header.frame_id
 * to the coordinate frame child_frame_id
 *
 * This message is mostly used by the
 * <a href="http://www.ros.org/wiki/tf">tf</a> package.
 * See its documentation for more information.
 */
public class TransformStamped extends Packet<TransformStamped> implements Settable<TransformStamped>, EpsilonComparable<TransformStamped>
{
   public std_msgs.msg.dds.Header header_;
   /**
    * the frame id of the child frame
    */
   public java.lang.StringBuilder child_frame_id_;
   public us.ihmc.euclid.transform.QuaternionBasedTransform transform_;

   public TransformStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      child_frame_id_ = new java.lang.StringBuilder(255);
      transform_ = new us.ihmc.euclid.transform.QuaternionBasedTransform();
   }

   public TransformStamped(TransformStamped other)
   {
      set(other);
   }

   public void set(TransformStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      child_frame_id_.setLength(0);
      child_frame_id_.append(other.child_frame_id_);

      geometry_msgs.msg.dds.TransformPubSubType.staticCopy(other.transform_, transform_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * the frame id of the child frame
    */
   public java.lang.String getChildFrameIdAsString()
   {
      return getChildFrameId().toString();
   }

   /**
    * the frame id of the child frame
    */
   public java.lang.StringBuilder getChildFrameId()
   {
      return child_frame_id_;
   }

   /**
    * the frame id of the child frame
    */
   public void setChildFrameId(java.lang.String child_frame_id)
   {
      child_frame_id_.setLength(0);
      child_frame_id_.append(child_frame_id);
   }

   public us.ihmc.euclid.transform.QuaternionBasedTransform getTransform()
   {
      return transform_;
   }

   @Override
   public boolean epsilonEquals(TransformStamped other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.child_frame_id_, other.child_frame_id_, epsilon))
         return false;

      if (!this.transform_.epsilonEquals(other.transform_, epsilon))
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
      if (!(other instanceof TransformStamped))
         return false;

      TransformStamped otherMyClass = (TransformStamped) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;
      if (!us.ihmc.idl.IDLTools.equals(this.child_frame_id_, otherMyClass.child_frame_id_))
         return false;

      if (!this.transform_.equals(otherMyClass.transform_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TransformStamped {");
      builder.append("header=");
      builder.append(this.header_);
      builder.append(", ");
      builder.append("child_frame_id=");
      builder.append(this.child_frame_id_);
      builder.append(", ");
      builder.append("transform=");
      builder.append(this.transform_);
      builder.append("}");
      return builder.toString();
   }
}
