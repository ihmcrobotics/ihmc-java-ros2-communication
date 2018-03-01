package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "MultiEchoLaserScan" defined in MultiEchoLaserScan_.idl.
 *
 * This file was automatically generated from MultiEchoLaserScan_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit MultiEchoLaserScan_.idl instead.
 */
public class MultiEchoLaserScan implements Settable<MultiEchoLaserScan>, EpsilonComparable<MultiEchoLaserScan>
{
   private std_msgs.msg.dds.Header header_;
   private float angle_min_;
   private float angle_max_;
   private float angle_increment_;
   private float time_increment_;
   private float scan_time_;
   private float range_min_;
   private float range_max_;
   private us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.LaserEcho> ranges_;
   private us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.LaserEcho> intensities_;

   public MultiEchoLaserScan()
   {
      header_ = new std_msgs.msg.dds.Header();

      ranges_ = new us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.LaserEcho>(100, sensor_msgs.msg.dds.LaserEcho.class,
                                                                                  new sensor_msgs.msg.dds.LaserEchoPubSubType());

      intensities_ = new us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.LaserEcho>(100, sensor_msgs.msg.dds.LaserEcho.class,
                                                                                       new sensor_msgs.msg.dds.LaserEchoPubSubType());
   }

   public MultiEchoLaserScan(MultiEchoLaserScan other)
   {
      set(other);
   }

   public void set(MultiEchoLaserScan other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      angle_min_ = other.angle_min_;

      angle_max_ = other.angle_max_;

      angle_increment_ = other.angle_increment_;

      time_increment_ = other.time_increment_;

      scan_time_ = other.scan_time_;

      range_min_ = other.range_min_;

      range_max_ = other.range_max_;

      ranges_.set(other.ranges_);
      intensities_.set(other.intensities_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public float getAngleMin()
   {
      return angle_min_;
   }

   public void setAngleMin(float angle_min)
   {
      angle_min_ = angle_min;
   }

   public float getAngleMax()
   {
      return angle_max_;
   }

   public void setAngleMax(float angle_max)
   {
      angle_max_ = angle_max;
   }

   public float getAngleIncrement()
   {
      return angle_increment_;
   }

   public void setAngleIncrement(float angle_increment)
   {
      angle_increment_ = angle_increment;
   }

   public float getTimeIncrement()
   {
      return time_increment_;
   }

   public void setTimeIncrement(float time_increment)
   {
      time_increment_ = time_increment;
   }

   public float getScanTime()
   {
      return scan_time_;
   }

   public void setScanTime(float scan_time)
   {
      scan_time_ = scan_time;
   }

   public float getRangeMin()
   {
      return range_min_;
   }

   public void setRangeMin(float range_min)
   {
      range_min_ = range_min;
   }

   public float getRangeMax()
   {
      return range_max_;
   }

   public void setRangeMax(float range_max)
   {
      range_max_ = range_max;
   }

   public us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.LaserEcho> getRanges()
   {
      return ranges_;
   }

   public us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.LaserEcho> getIntensities()
   {
      return intensities_;
   }

   @Override
   public boolean epsilonEquals(MultiEchoLaserScan other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.angle_min_, other.angle_min_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.angle_max_, other.angle_max_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.angle_increment_, other.angle_increment_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.time_increment_, other.time_increment_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.scan_time_, other.scan_time_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.range_min_, other.range_min_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.range_max_, other.range_max_, epsilon))
         return false;

      if (this.ranges_.isEnum())
      {
         if (!this.ranges_.equals(other.ranges_))
            return false;
      }
      else if (this.ranges_.size() == other.ranges_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.ranges_.size(); i++)
         {
            if (!this.ranges_.get(i).epsilonEquals(other.ranges_.get(i), epsilon))
               return false;
         }
      }

      if (this.intensities_.isEnum())
      {
         if (!this.intensities_.equals(other.intensities_))
            return false;
      }
      else if (this.intensities_.size() == other.intensities_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.intensities_.size(); i++)
         {
            if (!this.intensities_.get(i).epsilonEquals(other.intensities_.get(i), epsilon))
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
      if (!(other instanceof MultiEchoLaserScan))
         return false;

      MultiEchoLaserScan otherMyClass = (MultiEchoLaserScan) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.angle_min_ != otherMyClass.angle_min_)
         return false;

      if (this.angle_max_ != otherMyClass.angle_max_)
         return false;

      if (this.angle_increment_ != otherMyClass.angle_increment_)
         return false;

      if (this.time_increment_ != otherMyClass.time_increment_)
         return false;

      if (this.scan_time_ != otherMyClass.scan_time_)
         return false;

      if (this.range_min_ != otherMyClass.range_min_)
         return false;

      if (this.range_max_ != otherMyClass.range_max_)
         return false;

      if (!this.ranges_.equals(otherMyClass.ranges_))
         return false;

      if (!this.intensities_.equals(otherMyClass.intensities_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MultiEchoLaserScan {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("angle_min=");
      builder.append(this.angle_min_);

      builder.append(", ");
      builder.append("angle_max=");
      builder.append(this.angle_max_);

      builder.append(", ");
      builder.append("angle_increment=");
      builder.append(this.angle_increment_);

      builder.append(", ");
      builder.append("time_increment=");
      builder.append(this.time_increment_);

      builder.append(", ");
      builder.append("scan_time=");
      builder.append(this.scan_time_);

      builder.append(", ");
      builder.append("range_min=");
      builder.append(this.range_min_);

      builder.append(", ");
      builder.append("range_max=");
      builder.append(this.range_max_);

      builder.append(", ");
      builder.append("ranges=");
      builder.append(this.ranges_);

      builder.append(", ");
      builder.append("intensities=");
      builder.append(this.intensities_);

      builder.append("}");
      return builder.toString();
   }
}