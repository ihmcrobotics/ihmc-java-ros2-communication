package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message holds a collection of N-dimensional points, which may
 * contain additional information such as normals, intensity, etc. The
 * point data is stored as a binary blob, its layout described by the
 * contents of the "fields" array.
 * The point cloud data may be organized 2d (image-like) or 1d (unordered).
 * Point clouds organized as 2d images may be produced by camera depth sensors
 * such as stereo or time-of-flight.
 */
public class PointCloud2 extends Packet<PointCloud2> implements Settable<PointCloud2>, EpsilonComparable<PointCloud2>
{
   /**
    * Time of sensor data acquisition, and the coordinate frame ID (for 3d points).
    */
   public std_msgs.msg.dds.Header header_;
   /**
    * 2D structure of the point cloud. If the cloud is unordered, height is
    * 1 and width is the length of the point cloud.
    */
   public long height_;
   public long width_;
   /**
    * Describes the channels and their layout in the binary data blob.
    */
   public us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.PointField> fields_;
   /**
    * Is this data bigendian?
    */
   public boolean is_bigendian_;
   /**
    * Length of a point in bytes
    */
   public long point_step_;
   /**
    * Length of a row in bytes
    */
   public long row_step_;
   /**
    * Actual point data, size is (row_step*height)
    */
   public us.ihmc.idl.IDLSequence.Byte data_;
   /**
    * True if there are no invalid points
    */
   public boolean is_dense_;

   public PointCloud2()
   {
      header_ = new std_msgs.msg.dds.Header();
      fields_ = new us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.PointField>(100, sensor_msgs.msg.dds.PointField.class,
                                                                                   new sensor_msgs.msg.dds.PointFieldPubSubType());
      data_ = new us.ihmc.idl.IDLSequence.Byte(100, "type_9");
   }

   public PointCloud2(PointCloud2 other)
   {
      set(other);
   }

   public void set(PointCloud2 other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      height_ = other.height_;

      width_ = other.width_;

      fields_.set(other.fields_);
      is_bigendian_ = other.is_bigendian_;

      point_step_ = other.point_step_;

      row_step_ = other.row_step_;

      data_.set(other.data_);
      is_dense_ = other.is_dense_;
   }

   /**
    * Time of sensor data acquisition, and the coordinate frame ID (for 3d points).
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * 2D structure of the point cloud. If the cloud is unordered, height is
    * 1 and width is the length of the point cloud.
    */
   public long getHeight()
   {
      return height_;
   }

   /**
    * 2D structure of the point cloud. If the cloud is unordered, height is
    * 1 and width is the length of the point cloud.
    */
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

   /**
    * Describes the channels and their layout in the binary data blob.
    */
   public us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.PointField> getFields()
   {
      return fields_;
   }

   /**
    * Is this data bigendian?
    */
   public boolean getIsBigendian()
   {
      return is_bigendian_;
   }

   /**
    * Is this data bigendian?
    */
   public void setIsBigendian(boolean is_bigendian)
   {
      is_bigendian_ = is_bigendian;
   }

   /**
    * Length of a point in bytes
    */
   public long getPointStep()
   {
      return point_step_;
   }

   /**
    * Length of a point in bytes
    */
   public void setPointStep(long point_step)
   {
      point_step_ = point_step;
   }

   /**
    * Length of a row in bytes
    */
   public long getRowStep()
   {
      return row_step_;
   }

   /**
    * Length of a row in bytes
    */
   public void setRowStep(long row_step)
   {
      row_step_ = row_step;
   }

   /**
    * Actual point data, size is (row_step*height)
    */
   public us.ihmc.idl.IDLSequence.Byte getData()
   {
      return data_;
   }

   /**
    * True if there are no invalid points
    */
   public boolean getIsDense()
   {
      return is_dense_;
   }

   /**
    * True if there are no invalid points
    */
   public void setIsDense(boolean is_dense)
   {
      is_dense_ = is_dense;
   }

   @Override
   public boolean epsilonEquals(PointCloud2 other, double epsilon)
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

      if (this.fields_.size() == other.fields_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.fields_.size(); i++)
         {
            if (!this.fields_.get(i).epsilonEquals(other.fields_.get(i), epsilon))
               return false;
         }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_bigendian_, other.is_bigendian_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.point_step_, other.point_step_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.row_step_, other.row_step_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.data_, other.data_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_dense_, other.is_dense_, epsilon))
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
      if (!(other instanceof PointCloud2))
         return false;

      PointCloud2 otherMyClass = (PointCloud2) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;
      if (this.height_ != otherMyClass.height_)
         return false;

      if (this.width_ != otherMyClass.width_)
         return false;

      if (!this.fields_.equals(otherMyClass.fields_))
         return false;
      if (this.is_bigendian_ != otherMyClass.is_bigendian_)
         return false;

      if (this.point_step_ != otherMyClass.point_step_)
         return false;

      if (this.row_step_ != otherMyClass.row_step_)
         return false;

      if (!this.data_.equals(otherMyClass.data_))
         return false;
      if (this.is_dense_ != otherMyClass.is_dense_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PointCloud2 {");
      builder.append("header=");
      builder.append(this.header_);
      builder.append(", ");
      builder.append("height=");
      builder.append(this.height_);
      builder.append(", ");
      builder.append("width=");
      builder.append(this.width_);
      builder.append(", ");
      builder.append("fields=");
      builder.append(this.fields_);
      builder.append(", ");
      builder.append("is_bigendian=");
      builder.append(this.is_bigendian_);
      builder.append(", ");
      builder.append("point_step=");
      builder.append(this.point_step_);
      builder.append(", ");
      builder.append("row_step=");
      builder.append(this.row_step_);
      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);
      builder.append(", ");
      builder.append("is_dense=");
      builder.append(this.is_dense_);
      builder.append("}");
      return builder.toString();
   }
}
