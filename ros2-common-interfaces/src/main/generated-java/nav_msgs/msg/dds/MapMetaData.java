package nav_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "MapMetaData" defined in MapMetaData_.idl.
 *
 * This file was automatically generated from MapMetaData_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit MapMetaData_.idl instead.
 */
public class MapMetaData implements Settable<MapMetaData>, EpsilonComparable<MapMetaData>
{
   private builtin_interfaces.msg.dds.Time map_load_time_;
   private float resolution_;
   private long width_;
   private long height_;
   private us.ihmc.euclid.geometry.Pose3D origin_;

   public MapMetaData()
   {
      map_load_time_ = new builtin_interfaces.msg.dds.Time();

      origin_ = new us.ihmc.euclid.geometry.Pose3D();
   }

   public MapMetaData(MapMetaData other)
   {
      set(other);
   }

   public void set(MapMetaData other)
   {
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.map_load_time_, map_load_time_);
      resolution_ = other.resolution_;

      width_ = other.width_;

      height_ = other.height_;

      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.origin_, origin_);
   }

   public builtin_interfaces.msg.dds.Time getMapLoadTime()
   {
      return map_load_time_;
   }

   public float getResolution()
   {
      return resolution_;
   }

   public void setResolution(float resolution)
   {
      resolution_ = resolution;
   }

   public long getWidth()
   {
      return width_;
   }

   public void setWidth(long width)
   {
      width_ = width;
   }

   public long getHeight()
   {
      return height_;
   }

   public void setHeight(long height)
   {
      height_ = height;
   }

   public us.ihmc.euclid.geometry.Pose3D getOrigin()
   {
      return origin_;
   }

   @Override
   public boolean epsilonEquals(MapMetaData other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.map_load_time_.epsilonEquals(other.map_load_time_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.resolution_, other.resolution_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.width_, other.width_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.height_, other.height_, epsilon))
         return false;

      if (!this.origin_.epsilonEquals(other.origin_, epsilon))
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
      if (!(other instanceof MapMetaData))
         return false;

      MapMetaData otherMyClass = (MapMetaData) other;

      if (!this.map_load_time_.equals(otherMyClass.map_load_time_))
         return false;

      if (this.resolution_ != otherMyClass.resolution_)
         return false;

      if (this.width_ != otherMyClass.width_)
         return false;

      if (this.height_ != otherMyClass.height_)
         return false;

      if (!this.origin_.equals(otherMyClass.origin_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MapMetaData {");
      builder.append("map_load_time=");
      builder.append(this.map_load_time_);

      builder.append(", ");
      builder.append("resolution=");
      builder.append(this.resolution_);

      builder.append(", ");
      builder.append("width=");
      builder.append(this.width_);

      builder.append(", ");
      builder.append("height=");
      builder.append(this.height_);

      builder.append(", ");
      builder.append("origin=");
      builder.append(this.origin_);

      builder.append("}");
      return builder.toString();
   }
}