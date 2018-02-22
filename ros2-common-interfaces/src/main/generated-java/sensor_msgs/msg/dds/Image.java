package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Image" defined in Image_.idl.
 *
 * This file was automatically generated from Image_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Image_.idl instead.
 */
public class Image implements Settable<Image>, EpsilonComparable<Image>
{
   private std_msgs.msg.dds.Header header_;
   private long height_;
   private long width_;
   private java.lang.StringBuilder encoding_;
   private byte is_bigendian_;
   private long step_;
   private us.ihmc.idl.IDLSequence.Byte data_;

   public Image()
   {
      header_ = new std_msgs.msg.dds.Header();

      encoding_ = new java.lang.StringBuilder(255);

      data_ = new us.ihmc.idl.IDLSequence.Byte(100, "type_9");
   }

   public Image(Image other)
   {
      set(other);
   }

   public void set(Image other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      height_ = other.height_;

      width_ = other.width_;

      encoding_.setLength(0);
      encoding_.append(other.encoding_);

      is_bigendian_ = other.is_bigendian_;

      step_ = other.step_;

      data_.set(other.data_);
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

   public java.lang.String getEncodingAsString()
   {
      return getEncoding().toString();
   }

   public java.lang.StringBuilder getEncoding()
   {
      return encoding_;
   }

   public void setEncoding(String encoding)
   {
      encoding_.setLength(0);
      encoding_.append(encoding);
   }

   public byte getIsBigendian()
   {
      return is_bigendian_;
   }

   public void setIsBigendian(byte is_bigendian)
   {
      is_bigendian_ = is_bigendian;
   }

   public long getStep()
   {
      return step_;
   }

   public void setStep(long step)
   {
      step_ = step;
   }

   public us.ihmc.idl.IDLSequence.Byte getData()
   {
      return data_;
   }

   @Override
   public boolean epsilonEquals(Image other, double epsilon)
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

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.encoding_, other.encoding_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.is_bigendian_, other.is_bigendian_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.step_, other.step_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.data_, other.data_, epsilon))
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
      if (!(other instanceof Image))
         return false;

      Image otherMyClass = (Image) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.height_ != otherMyClass.height_)
         return false;

      if (this.width_ != otherMyClass.width_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.encoding_, otherMyClass.encoding_))
         return false;

      if (this.is_bigendian_ != otherMyClass.is_bigendian_)
         return false;

      if (this.step_ != otherMyClass.step_)
         return false;

      if (!this.data_.equals(otherMyClass.data_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Image {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("height=");
      builder.append(this.height_);

      builder.append(", ");
      builder.append("width=");
      builder.append(this.width_);

      builder.append(", ");
      builder.append("encoding=");
      builder.append(this.encoding_);

      builder.append(", ");
      builder.append("is_bigendian=");
      builder.append(this.is_bigendian_);

      builder.append(", ");
      builder.append("step=");
      builder.append(this.step_);

      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}