package stereo_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "DisparityImage" defined in DisparityImage_.idl.
 *
 * This file was automatically generated from DisparityImage_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit DisparityImage_.idl instead.
 */
public class DisparityImage implements Settable<DisparityImage>, EpsilonComparable<DisparityImage>
{
   private std_msgs.msg.dds.Header header_;
   private sensor_msgs.msg.dds.Image image_;
   private float f_;
   private float t_;
   private sensor_msgs.msg.dds.RegionOfInterest valid_window_;
   private float min_disparity_;
   private float max_disparity_;
   private float delta_d_;

   public DisparityImage()
   {
      header_ = new std_msgs.msg.dds.Header();
      image_ = new sensor_msgs.msg.dds.Image();

      valid_window_ = new sensor_msgs.msg.dds.RegionOfInterest();
   }

   public DisparityImage(DisparityImage other)
   {
      set(other);
   }

   public void set(DisparityImage other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      sensor_msgs.msg.dds.ImagePubSubType.staticCopy(other.image_, image_);
      f_ = other.f_;

      t_ = other.t_;

      sensor_msgs.msg.dds.RegionOfInterestPubSubType.staticCopy(other.valid_window_, valid_window_);
      min_disparity_ = other.min_disparity_;

      max_disparity_ = other.max_disparity_;

      delta_d_ = other.delta_d_;
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public sensor_msgs.msg.dds.Image getImage()
   {
      return image_;
   }

   public float getF()
   {
      return f_;
   }

   public void setF(float f)
   {
      f_ = f;
   }

   public float getT()
   {
      return t_;
   }

   public void setT(float t)
   {
      t_ = t;
   }

   public sensor_msgs.msg.dds.RegionOfInterest getValidWindow()
   {
      return valid_window_;
   }

   public float getMinDisparity()
   {
      return min_disparity_;
   }

   public void setMinDisparity(float min_disparity)
   {
      min_disparity_ = min_disparity;
   }

   public float getMaxDisparity()
   {
      return max_disparity_;
   }

   public void setMaxDisparity(float max_disparity)
   {
      max_disparity_ = max_disparity;
   }

   public float getDeltaD()
   {
      return delta_d_;
   }

   public void setDeltaD(float delta_d)
   {
      delta_d_ = delta_d;
   }

   @Override
   public boolean epsilonEquals(DisparityImage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.image_.epsilonEquals(other.image_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.f_, other.f_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.t_, other.t_, epsilon))
         return false;

      if (!this.valid_window_.epsilonEquals(other.valid_window_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.min_disparity_, other.min_disparity_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.max_disparity_, other.max_disparity_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.delta_d_, other.delta_d_, epsilon))
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
      if (!(other instanceof DisparityImage))
         return false;

      DisparityImage otherMyClass = (DisparityImage) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.image_.equals(otherMyClass.image_))
         return false;

      if (this.f_ != otherMyClass.f_)
         return false;

      if (this.t_ != otherMyClass.t_)
         return false;

      if (!this.valid_window_.equals(otherMyClass.valid_window_))
         return false;

      if (this.min_disparity_ != otherMyClass.min_disparity_)
         return false;

      if (this.max_disparity_ != otherMyClass.max_disparity_)
         return false;

      if (this.delta_d_ != otherMyClass.delta_d_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("DisparityImage {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("image=");
      builder.append(this.image_);

      builder.append(", ");
      builder.append("f=");
      builder.append(this.f_);

      builder.append(", ");
      builder.append("t=");
      builder.append(this.t_);

      builder.append(", ");
      builder.append("valid_window=");
      builder.append(this.valid_window_);

      builder.append(", ");
      builder.append("min_disparity=");
      builder.append(this.min_disparity_);

      builder.append(", ");
      builder.append("max_disparity=");
      builder.append(this.max_disparity_);

      builder.append(", ");
      builder.append("delta_d=");
      builder.append(this.delta_d_);

      builder.append("}");
      return builder.toString();
   }
}