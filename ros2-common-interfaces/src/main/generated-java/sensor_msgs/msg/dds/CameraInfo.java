package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "CameraInfo" defined in CameraInfo_.idl.
 *
 * This file was automatically generated from CameraInfo_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit CameraInfo_.idl instead.
 */
public class CameraInfo implements Settable<CameraInfo>, EpsilonComparable<CameraInfo>
{
   private std_msgs.msg.dds.Header header_;
   private long height_;
   private long width_;
   private java.lang.StringBuilder distortion_model_;
   private us.ihmc.idl.IDLSequence.Double d_;
   private double[] k_;
   private double[] r_;
   private double[] p_;
   private long binning_x_;
   private long binning_y_;
   private sensor_msgs.msg.dds.RegionOfInterest roi_;

   public CameraInfo()
   {
      header_ = new std_msgs.msg.dds.Header();

      distortion_model_ = new java.lang.StringBuilder(255);

      d_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      k_ = new double[9];

      r_ = new double[9];

      p_ = new double[12];

      roi_ = new sensor_msgs.msg.dds.RegionOfInterest();
   }

   public CameraInfo(CameraInfo other)
   {
      set(other);
   }

   public void set(CameraInfo other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      height_ = other.height_;

      width_ = other.width_;

      distortion_model_.setLength(0);
      distortion_model_.append(other.distortion_model_);

      d_.set(other.d_);
      for (int b = 0; b < k_.length; ++b)
      {
         k_[b] = other.k_[b];
      }

      for (int d = 0; d < r_.length; ++d)
      {
         r_[d] = other.r_[d];
      }

      for (int f = 0; f < p_.length; ++f)
      {
         p_[f] = other.p_[f];
      }

      binning_x_ = other.binning_x_;

      binning_y_ = other.binning_y_;

      sensor_msgs.msg.dds.RegionOfInterestPubSubType.staticCopy(other.roi_, roi_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
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

   public java.lang.String getDistortionModelAsString()
   {
      return getDistortionModel().toString();
   }

   public java.lang.StringBuilder getDistortionModel()
   {
      return distortion_model_;
   }

   public void setDistortionModel(String distortion_model)
   {
      distortion_model_.setLength(0);
      distortion_model_.append(distortion_model);
   }

   public us.ihmc.idl.IDLSequence.Double getD()
   {
      return d_;
   }

   public double[] getK()
   {
      return k_;
   }

   public double[] getR()
   {
      return r_;
   }

   public double[] getP()
   {
      return p_;
   }

   public long getBinningX()
   {
      return binning_x_;
   }

   public void setBinningX(long binning_x)
   {
      binning_x_ = binning_x;
   }

   public long getBinningY()
   {
      return binning_y_;
   }

   public void setBinningY(long binning_y)
   {
      binning_y_ = binning_y;
   }

   public sensor_msgs.msg.dds.RegionOfInterest getRoi()
   {
      return roi_;
   }

   @Override
   public boolean epsilonEquals(CameraInfo other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.height_, other.height_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.width_, other.width_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.distortion_model_, other.distortion_model_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.d_, other.d_, epsilon))
         return false;

      for (int h = 0; h < k_.length; ++h)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.k_[h], other.k_[h], epsilon))
            return false;
      }

      for (int j = 0; j < r_.length; ++j)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.r_[j], other.r_[j], epsilon))
            return false;
      }

      for (int l = 0; l < p_.length; ++l)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.p_[l], other.p_[l], epsilon))
            return false;
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.binning_x_, other.binning_x_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.binning_y_, other.binning_y_, epsilon))
         return false;

      if (!this.roi_.epsilonEquals(other.roi_, epsilon))
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
      if (!(other instanceof CameraInfo))
         return false;

      CameraInfo otherMyClass = (CameraInfo) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.height_ != otherMyClass.height_)
         return false;

      if (this.width_ != otherMyClass.width_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.distortion_model_, otherMyClass.distortion_model_))
         return false;

      if (!this.d_.equals(otherMyClass.d_))
         return false;

      for (int n = 0; n < k_.length; ++n)
      {
         if (this.k_[n] != otherMyClass.k_[n])
            return false;
      }
      for (int p = 0; p < r_.length; ++p)
      {
         if (this.r_[p] != otherMyClass.r_[p])
            return false;
      }
      for (int r = 0; r < p_.length; ++r)
      {
         if (this.p_[r] != otherMyClass.p_[r])
            return false;
      }
      if (this.binning_x_ != otherMyClass.binning_x_)
         return false;

      if (this.binning_y_ != otherMyClass.binning_y_)
         return false;

      if (!this.roi_.equals(otherMyClass.roi_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("CameraInfo {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("height=");
      builder.append(this.height_);

      builder.append(", ");
      builder.append("width=");
      builder.append(this.width_);

      builder.append(", ");
      builder.append("distortion_model=");
      builder.append(this.distortion_model_);

      builder.append(", ");
      builder.append("d=");
      builder.append(this.d_);

      builder.append(", ");
      builder.append("k=");
      builder.append(java.util.Arrays.toString(this.k_));

      builder.append(", ");
      builder.append("r=");
      builder.append(java.util.Arrays.toString(this.r_));

      builder.append(", ");
      builder.append("p=");
      builder.append(java.util.Arrays.toString(this.p_));

      builder.append(", ");
      builder.append("binning_x=");
      builder.append(this.binning_x_);

      builder.append(", ");
      builder.append("binning_y=");
      builder.append(this.binning_y_);

      builder.append(", ");
      builder.append("roi=");
      builder.append(this.roi_);

      builder.append("}");
      return builder.toString();
   }
}