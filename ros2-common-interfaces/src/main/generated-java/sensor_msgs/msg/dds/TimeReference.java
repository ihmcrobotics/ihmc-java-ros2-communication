package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "TimeReference" defined in TimeReference_.idl.
 *
 * This file was automatically generated from TimeReference_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit TimeReference_.idl instead.
 */
public class TimeReference implements Settable<TimeReference>, EpsilonComparable<TimeReference>
{
   private std_msgs.msg.dds.Header header_;
   private builtin_interfaces.msg.dds.Time time_ref_;
   private java.lang.StringBuilder source_;

   public TimeReference()
   {
      header_ = new std_msgs.msg.dds.Header();
      time_ref_ = new builtin_interfaces.msg.dds.Time();
      source_ = new java.lang.StringBuilder(255);
   }

   public TimeReference(TimeReference other)
   {
      set(other);
   }

   public void set(TimeReference other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.time_ref_, time_ref_);
      source_.setLength(0);
      source_.append(other.source_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public builtin_interfaces.msg.dds.Time getTimeRef()
   {
      return time_ref_;
   }

   public java.lang.String getSourceAsString()
   {
      return getSource().toString();
   }

   public java.lang.StringBuilder getSource()
   {
      return source_;
   }

   public void setSource(String source)
   {
      source_.setLength(0);
      source_.append(source);
   }

   @Override
   public boolean epsilonEquals(TimeReference other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.time_ref_.epsilonEquals(other.time_ref_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.source_, other.source_, epsilon))
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
      if (!(other instanceof TimeReference))
         return false;

      TimeReference otherMyClass = (TimeReference) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.time_ref_.equals(otherMyClass.time_ref_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.source_, otherMyClass.source_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TimeReference {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("time_ref=");
      builder.append(this.time_ref_);

      builder.append(", ");
      builder.append("source=");
      builder.append(this.source_);

      builder.append("}");
      return builder.toString();
   }
}