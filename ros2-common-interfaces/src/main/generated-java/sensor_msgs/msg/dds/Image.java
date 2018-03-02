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
   /**
    * Header timestamp should be acquisition time of image
    */
   private std_msgs.msg.dds.Header header_;
   /**
    * image height, that is, number of rows
    */
   private long height_;
   /**
    * image width, that is, number of columns
    */
   private long width_;

   /**
    * Header timestamp should be acquisition time of image
    */
   /**
    * Encoding of pixels -- channel meaning, ordering, size
    */
   private java.lang.StringBuilder encoding_;
   /**
    * is this data bigendian?
    */
   private byte is_bigendian_;
   /**
    * Full row length in bytes
    */
   private long step_;
   /**
    * actual matrix data, size is (step * rows)
    */
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

   /**
    * Header timestamp should be acquisition time of image
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * image height, that is, number of rows
    */
   public long getHeight()
   {
      return height_;
   }

   /**
    * image height, that is, number of rows
    */
   public void setHeight(long height)
   {
      height_ = height;
   }

   /**
    * image width, that is, number of columns
    */
   public long getWidth()
   {
      return width_;
   }

   /**
    * image width, that is, number of columns
    */
   public void setWidth(long width)
   {
      width_ = width;
   }

   /**
    * actual matrix data, size is (step * rows)
    */

   public java.lang.String getEncodingAsString()
   {
      return getEncoding().toString();
   }

   /**
    * Encoding of pixels -- channel meaning, ordering, size
    */
   public java.lang.StringBuilder getEncoding()
   {
      return encoding_;
   }

   /**
    * Encoding of pixels -- channel meaning, ordering, size
    */
   public void setEncoding(String encoding)
   {
      encoding_.setLength(0);
      encoding_.append(encoding);
   }

   /**
    * is this data bigendian?
    */
   public byte getIsBigendian()
   {
      return is_bigendian_;
   }

   /**
    * is this data bigendian?
    */
   public void setIsBigendian(byte is_bigendian)
   {
      is_bigendian_ = is_bigendian;
   }

   /**
    * Full row length in bytes
    */
   public long getStep()
   {
      return step_;
   }

   /**
    * Full row length in bytes
    */
   public void setStep(long step)
   {
      step_ = step;
   }

   /**
    * actual matrix data, size is (step * rows)
    */
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