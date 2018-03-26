package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Single scan from a planar laser range-finder
 *
 * If you have another ranging device with different behavior (e.g. a sonar
 * array), please find or create a different message, since applications
 * will make fairly laser-specific assumptions about this data
 * the first ray in the scan.
 *
 * in frame frame_id, angles are measured around
 * the positive Z axis (counterclockwise, if Z is up)
 * with zero angle being forward along the x axis
 */
public class LaserScan implements Settable<LaserScan>, EpsilonComparable<LaserScan>
{
   /**
    * timestamp in the header is the acquisition time of
    */
   private std_msgs.msg.dds.Header header_;
   /**
    * start angle of the scan [rad]
    */
   private float angle_min_;
   /**
    * end angle of the scan [rad]
    */
   private float angle_max_;
   /**
    * angular distance between measurements [rad]
    */
   private float angle_increment_;
   /**
    * time between measurements [seconds] - if your scanner
    */
   private float time_increment_;
   /**
    * is moving, this will be used in interpolating position
    * of 3d points
    * time between scans [seconds]
    */
   private float scan_time_;
   /**
    * minimum range value [m]
    */
   private float range_min_;
   /**
    * maximum range value [m]
    */
   private float range_max_;
   /**
    * range data [m]
    */
   private us.ihmc.idl.IDLSequence.Float ranges_;
   /**
    * (Note: values < range_min or > range_max should be discarded)
    * intensity data [device-specific units].  If your
    */
   private us.ihmc.idl.IDLSequence.Float intensities_;

   public LaserScan()
   {
      header_ = new std_msgs.msg.dds.Header();

      ranges_ = new us.ihmc.idl.IDLSequence.Float(100, "type_5");

      intensities_ = new us.ihmc.idl.IDLSequence.Float(100, "type_5");
   }

   public LaserScan(LaserScan other)
   {
      set(other);
   }

   public void set(LaserScan other)
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

   /**
    * timestamp in the header is the acquisition time of
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * start angle of the scan [rad]
    */
   public float getAngleMin()
   {
      return angle_min_;
   }

   /**
    * start angle of the scan [rad]
    */
   public void setAngleMin(float angle_min)
   {
      angle_min_ = angle_min;
   }

   /**
    * end angle of the scan [rad]
    */
   public float getAngleMax()
   {
      return angle_max_;
   }

   /**
    * end angle of the scan [rad]
    */
   public void setAngleMax(float angle_max)
   {
      angle_max_ = angle_max;
   }

   /**
    * angular distance between measurements [rad]
    */
   public float getAngleIncrement()
   {
      return angle_increment_;
   }

   /**
    * angular distance between measurements [rad]
    */
   public void setAngleIncrement(float angle_increment)
   {
      angle_increment_ = angle_increment;
   }

   /**
    * time between measurements [seconds] - if your scanner
    */
   public float getTimeIncrement()
   {
      return time_increment_;
   }

   /**
    * time between measurements [seconds] - if your scanner
    */
   public void setTimeIncrement(float time_increment)
   {
      time_increment_ = time_increment;
   }

   /**
    * is moving, this will be used in interpolating position
    * of 3d points
    * time between scans [seconds]
    */
   public float getScanTime()
   {
      return scan_time_;
   }

   /**
    * is moving, this will be used in interpolating position
    * of 3d points
    * time between scans [seconds]
    */
   public void setScanTime(float scan_time)
   {
      scan_time_ = scan_time;
   }

   /**
    * minimum range value [m]
    */
   public float getRangeMin()
   {
      return range_min_;
   }

   /**
    * minimum range value [m]
    */
   public void setRangeMin(float range_min)
   {
      range_min_ = range_min;
   }

   /**
    * maximum range value [m]
    */
   public float getRangeMax()
   {
      return range_max_;
   }

   /**
    * maximum range value [m]
    */
   public void setRangeMax(float range_max)
   {
      range_max_ = range_max;
   }

   /**
    * range data [m]
    */
   public us.ihmc.idl.IDLSequence.Float getRanges()
   {
      return ranges_;
   }

   /**
    * (Note: values < range_min or > range_max should be discarded)
    * intensity data [device-specific units].  If your
    */
   public us.ihmc.idl.IDLSequence.Float getIntensities()
   {
      return intensities_;
   }

   @Override
   public boolean epsilonEquals(LaserScan other, double epsilon)
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

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(this.ranges_, other.ranges_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(this.intensities_, other.intensities_, epsilon))
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
      if (!(other instanceof LaserScan))
         return false;

      LaserScan otherMyClass = (LaserScan) other;

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

      builder.append("LaserScan {");
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
