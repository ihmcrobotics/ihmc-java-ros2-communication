package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "RegionOfInterest" defined in RegionOfInterest_.idl.
 *
 * This file was automatically generated from RegionOfInterest_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit RegionOfInterest_.idl instead.
 */
public class RegionOfInterest implements Settable<RegionOfInterest>, EpsilonComparable<RegionOfInterest>
{
   private long x_offset_;
   private long y_offset_;
   private long height_;
   private long width_;
   private boolean do_rectify_;

   public RegionOfInterest()
   {

   }

   public RegionOfInterest(RegionOfInterest other)
   {
      set(other);
   }

   public void set(RegionOfInterest other)
   {
      x_offset_ = other.x_offset_;

      y_offset_ = other.y_offset_;

      height_ = other.height_;

      width_ = other.width_;

      do_rectify_ = other.do_rectify_;
   }

   public long getXOffset()
   {
      return x_offset_;
   }

   public void setXOffset(long x_offset)
   {
      x_offset_ = x_offset;
   }

   public long getYOffset()
   {
      return y_offset_;
   }

   public void setYOffset(long y_offset)
   {
      y_offset_ = y_offset;
   }

   public long getHeight()
   {
      return height_;
   }

   public void setHeight(long height)
   {
      height_ = height;
   }

   public long getWidth()
   {
      return width_;
   }

   public void setWidth(long width)
   {
      width_ = width;
   }

   public boolean getDoRectify()
   {
      return do_rectify_;
   }

   public void setDoRectify(boolean do_rectify)
   {
      do_rectify_ = do_rectify;
   }

   @Override
   public boolean epsilonEquals(RegionOfInterest other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.x_offset_, other.x_offset_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.y_offset_, other.y_offset_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.height_, other.height_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.width_, other.width_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.do_rectify_, other.do_rectify_, epsilon))
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
      if (!(other instanceof RegionOfInterest))
         return false;

      RegionOfInterest otherMyClass = (RegionOfInterest) other;

      if (this.x_offset_ != otherMyClass.x_offset_)
         return false;

      if (this.y_offset_ != otherMyClass.y_offset_)
         return false;

      if (this.height_ != otherMyClass.height_)
         return false;

      if (this.width_ != otherMyClass.width_)
         return false;

      if (this.do_rectify_ != otherMyClass.do_rectify_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("RegionOfInterest {");
      builder.append("x_offset=");
      builder.append(this.x_offset_);

      builder.append(", ");
      builder.append("y_offset=");
      builder.append(this.y_offset_);

      builder.append(", ");
      builder.append("height=");
      builder.append(this.height_);

      builder.append(", ");
      builder.append("width=");
      builder.append(this.width_);

      builder.append(", ");
      builder.append("do_rectify=");
      builder.append(this.do_rectify_);

      builder.append("}");
      return builder.toString();
   }
}