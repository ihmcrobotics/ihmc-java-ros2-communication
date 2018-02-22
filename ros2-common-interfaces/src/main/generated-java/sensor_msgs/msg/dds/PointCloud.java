package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "PointCloud" defined in PointCloud_.idl.
 *
 * This file was automatically generated from PointCloud_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit PointCloud_.idl instead.
 */
public class PointCloud implements Settable<PointCloud>, EpsilonComparable<PointCloud>
{
   private std_msgs.msg.dds.Header header_;
   private us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D32> points_;
   private us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.ChannelFloat32> channels_;

   public PointCloud()
   {
      header_ = new std_msgs.msg.dds.Header();
      points_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D32>(100, us.ihmc.euclid.tuple3D.Point3D32.class,
                                                                                     new geometry_msgs.msg.dds.Point32PubSubType());

      channels_ = new us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.ChannelFloat32>(100, sensor_msgs.msg.dds.ChannelFloat32.class,
                                                                                         new sensor_msgs.msg.dds.ChannelFloat32PubSubType());
   }

   public PointCloud(PointCloud other)
   {
      set(other);
   }

   public void set(PointCloud other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      points_.set(other.points_);
      channels_.set(other.channels_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D32> getPoints()
   {
      return points_;
   }

   public us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.ChannelFloat32> getChannels()
   {
      return channels_;
   }

   @Override
   public boolean epsilonEquals(PointCloud other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (this.points_.isEnum())
      {
         if (!this.points_.equals(other.points_))
            return false;
      }
      else if (this.points_.size() == other.points_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.points_.size(); i++)
         {
            if (!this.points_.get(i).epsilonEquals(other.points_.get(i), epsilon))
               return false;
         }
      }

      if (this.channels_.isEnum())
      {
         if (!this.channels_.equals(other.channels_))
            return false;
      }
      else if (this.channels_.size() == other.channels_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.channels_.size(); i++)
         {
            if (!this.channels_.get(i).epsilonEquals(other.channels_.get(i), epsilon))
               return false;
         }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof PointCloud))
         return false;

      PointCloud otherMyClass = (PointCloud) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.points_.equals(otherMyClass.points_))
         return false;

      if (!this.channels_.equals(otherMyClass.channels_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PointCloud {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("points=");
      builder.append(this.points_);

      builder.append(", ");
      builder.append("channels=");
      builder.append(this.channels_);

      builder.append("}");
      return builder.toString();
   }
}