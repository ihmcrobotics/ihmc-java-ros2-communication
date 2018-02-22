package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Header" defined in Header_.idl.
 *
 * This file was automatically generated from Header_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Header_.idl instead.
 */
public class Header implements Settable<Header>, EpsilonComparable<Header>
{
   private builtin_interfaces.msg.dds.Time stamp_;
   private java.lang.StringBuilder frame_id_;

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

   public builtin_interfaces.msg.dds.Time getStamp()
   {
      return stamp_;
   }

   public java.lang.String getFrameIdAsString()
   {
      return getFrameId().toString();
   }

   public java.lang.StringBuilder getFrameId()
   {
      return frame_id_;
   }

   public void setFrameId(String frame_id)
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