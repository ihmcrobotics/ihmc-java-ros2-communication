package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Standard metadata for higher-level stamped data types.
 * This is generally used to communicate timestamped data
 * in a particular coordinate frame.
 */
public class Header implements Settable<Header>, EpsilonComparable<Header>
{
   /**
    * Two-integer timestamp that is expressed as seconds and nanoseconds.
    */
   public builtin_interfaces.msg.dds.Time stamp_;
   /**
    * Transform frame with which this data is associated.
    */
   public java.lang.StringBuilder frame_id_;

   public Header()
   {
      stamp_ = new builtin_interfaces.msg.dds.Time();
      frame_id_ = new java.lang.StringBuilder(255);
   }

   public Header(Header other)
   {
      set(other);
   }

   public void set(Header other)
   {
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.stamp_, stamp_);
      frame_id_.setLength(0);
      frame_id_.append(other.frame_id_);
   }

   /**
    * Two-integer timestamp that is expressed as seconds and nanoseconds.
    */
   public builtin_interfaces.msg.dds.Time getStamp()
   {
      return stamp_;
   }

   /**
    * Transform frame with which this data is associated.
    */
   public java.lang.String getFrameIdAsString()
   {
      return getFrameId().toString();
   }

   /**
    * Transform frame with which this data is associated.
    */
   public java.lang.StringBuilder getFrameId()
   {
      return frame_id_;
   }

   /**
    * Transform frame with which this data is associated.
    */
   public void setFrameId(java.lang.String frame_id)
   {
      frame_id_.setLength(0);
      frame_id_.append(frame_id);
   }

   @Override
   public boolean epsilonEquals(Header other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.stamp_.epsilonEquals(other.stamp_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.frame_id_, other.frame_id_, epsilon))
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
      if (!(other instanceof Header))
         return false;

      Header otherMyClass = (Header) other;

      if (!this.stamp_.equals(otherMyClass.stamp_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.frame_id_, otherMyClass.frame_id_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Header {");
      builder.append("stamp=");
      builder.append(this.stamp_);

      builder.append(", ");
      builder.append("frame_id=");
      builder.append(this.frame_id_);

      builder.append("}");
      return builder.toString();
   }
}