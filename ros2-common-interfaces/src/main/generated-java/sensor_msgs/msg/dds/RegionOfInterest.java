package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

/**
       * This message is used to specify a region of interest within an image.
       * 
       * When used to specify the ROI setting of the camera when the image was
       * taken, the height and width fields should either match the height and
       * width fields for the associated image; or height = width = 0
       * indicates that the full resolution image was captured.
       */
public class RegionOfInterest extends Packet<RegionOfInterest> implements Settable<RegionOfInterest>, EpsilonComparable<RegionOfInterest>
{
   /**
            * Leftmost pixel of the ROI
            */
   public long x_offset_;
   /**
            * (0 if the ROI includes the left edge of the image)
            * Topmost pixel of the ROI
            */
   public long y_offset_;
   /**
            * (0 if the ROI includes the top edge of the image)
            * Height of ROI
            */
   public long height_;
   /**
            * Width of ROI
            */
   public long width_;
   /**
            * True if a distinct rectified ROI should be calculated from the "raw"
            * ROI in this message. Typically this should be False if the full image
            * is captured (ROI not used), and True if a subwindow is captured (ROI
            * used).
            */
   public boolean do_rectify_;

   public RegionOfInterest()
   {
   }

   public RegionOfInterest(RegionOfInterest other)
   {
      this();
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

   /**
            * Leftmost pixel of the ROI
            */
   public void setXOffset(long x_offset)
   {
      x_offset_ = x_offset;
   }
   /**
            * Leftmost pixel of the ROI
            */
   public long getXOffset()
   {
      return x_offset_;
   }

   /**
            * (0 if the ROI includes the left edge of the image)
            * Topmost pixel of the ROI
            */
   public void setYOffset(long y_offset)
   {
      y_offset_ = y_offset;
   }
   /**
            * (0 if the ROI includes the left edge of the image)
            * Topmost pixel of the ROI
            */
   public long getYOffset()
   {
      return y_offset_;
   }

   /**
            * (0 if the ROI includes the top edge of the image)
            * Height of ROI
            */
   public void setHeight(long height)
   {
      height_ = height;
   }
   /**
            * (0 if the ROI includes the top edge of the image)
            * Height of ROI
            */
   public long getHeight()
   {
      return height_;
   }

   /**
            * Width of ROI
            */
   public void setWidth(long width)
   {
      width_ = width;
   }
   /**
            * Width of ROI
            */
   public long getWidth()
   {
      return width_;
   }

   /**
            * True if a distinct rectified ROI should be calculated from the "raw"
            * ROI in this message. Typically this should be False if the full image
            * is captured (ROI not used), and True if a subwindow is captured (ROI
            * used).
            */
   public void setDoRectify(boolean do_rectify)
   {
      do_rectify_ = do_rectify;
   }
   /**
            * True if a distinct rectified ROI should be calculated from the "raw"
            * ROI in this message. Typically this should be False if the full image
            * is captured (ROI not used), and True if a subwindow is captured (ROI
            * used).
            */
   public boolean getDoRectify()
   {
      return do_rectify_;
   }


   @Override
   public boolean epsilonEquals(RegionOfInterest other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.x_offset_, other.x_offset_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.y_offset_, other.y_offset_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.height_, other.height_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.width_, other.width_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.do_rectify_, other.do_rectify_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof RegionOfInterest)) return false;

      RegionOfInterest otherMyClass = (RegionOfInterest) other;

      if(this.x_offset_ != otherMyClass.x_offset_) return false;

      if(this.y_offset_ != otherMyClass.y_offset_) return false;

      if(this.height_ != otherMyClass.height_) return false;

      if(this.width_ != otherMyClass.width_) return false;

      if(this.do_rectify_ != otherMyClass.do_rectify_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("RegionOfInterest {");
      builder.append("x_offset=");
      builder.append(this.x_offset_);      builder.append(", ");
      builder.append("y_offset=");
      builder.append(this.y_offset_);      builder.append(", ");
      builder.append("height=");
      builder.append(this.height_);      builder.append(", ");
      builder.append("width=");
      builder.append(this.width_);      builder.append(", ");
      builder.append("do_rectify=");
      builder.append(this.do_rectify_);
      builder.append("}");
      return builder.toString();
   }
}
