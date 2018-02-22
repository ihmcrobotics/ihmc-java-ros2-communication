package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Range" defined in Range_.idl.
 *
 * This file was automatically generated from Range_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Range_.idl instead.
 */
public class Range implements Settable<Range>, EpsilonComparable<Range>
{
   private std_msgs.msg.dds.Header header_;
   private byte radiation_type_;
   private float field_of_view_;
   private float min_range_;
   private float max_range_;
   private float range_;

   public Range()
   {
      header_ = new std_msgs.msg.dds.Header();
   }

   public Range(Range other)
   {
      set(other);
   }

   public void set(Range other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      radiation_type_ = other.radiation_type_;

      field_of_view_ = other.field_of_view_;

      min_range_ = other.min_range_;

      max_range_ = other.max_range_;

      range_ = other.range_;
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public byte getRadiationType()
   {
      return radiation_type_;
   }

   public void setRadiationType(byte radiation_type)
   {
      radiation_type_ = radiation_type;
   }

   public float getFieldOfView()
   {
      return field_of_view_;
   }

   public void setFieldOfView(float field_of_view)
   {
      field_of_view_ = field_of_view;
   }

   public float getMinRange()
   {
      return min_range_;
   }

   public void setMinRange(float min_range)
   {
      min_range_ = min_range;
   }

   public float getMaxRange()
   {
      return max_range_;
   }

   public void setMaxRange(float max_range)
   {
      max_range_ = max_range;
   }

   public float getRange()
   {
      return range_;
   }

   public void setRange(float range)
   {
      range_ = range;
   }

   @Override
   public boolean epsilonEquals(Range other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.radiation_type_, other.radiation_type_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.field_of_view_, other.field_of_view_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.min_range_, other.min_range_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.max_range_, other.max_range_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.range_, other.range_, epsilon))
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
      if (!(other instanceof Range))
         return false;

      Range otherMyClass = (Range) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.radiation_type_ != otherMyClass.radiation_type_)
         return false;

      if (this.field_of_view_ != otherMyClass.field_of_view_)
         return false;

      if (this.min_range_ != otherMyClass.min_range_)
         return false;

      if (this.max_range_ != otherMyClass.max_range_)
         return false;

      if (this.range_ != otherMyClass.range_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Range {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("radiation_type=");
      builder.append(this.radiation_type_);

      builder.append(", ");
      builder.append("field_of_view=");
      builder.append(this.field_of_view_);

      builder.append(", ");
      builder.append("min_range=");
      builder.append(this.min_range_);

      builder.append(", ");
      builder.append("max_range=");
      builder.append(this.max_range_);

      builder.append(", ");
      builder.append("range=");
      builder.append(this.range_);

      builder.append("}");
      return builder.toString();
   }
}