package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Single range reading from an active ranger that emits energy and reports
 * one range reading that is valid along an arc at the distance measured.
 * This message is  not appropriate for laser scanners. See the LaserScan
 * message if you are working with a laser scanner.
 * This message also can represent a fixed-distance (binary) ranger.  This
 * sensor will have min_range===max_range===distance of detection.
 * These sensors follow REP 117 and will output -Inf if the object is detected
 * and +Inf if the object is outside of the detection range.
 * returned the distance reading
 * (sound, IR, etc) [enum]
 * valid for [rad]
 * the object causing the range reading may have
 * been anywhere within -field_of_view/2 and
 * field_of_view/2 at the measured range.
 * 0 angle corresponds to the x-axis of the sensor.
 * Fixed distance rangers require min_range==max_range
 */
public class Range extends Packet<Range> implements Settable<Range>, EpsilonComparable<Range>
{
   /**
    * Radiation type enums
    * If you want a value added to this list, send an email to the ros-users list
    */
   public static final byte ULTRASOUND = (byte) 0;
   public static final byte INFRARED = (byte) 1;
   /**
    * timestamp in the header is the time the ranger
    */
   public std_msgs.msg.dds.Header header_;
   /**
    * the type of radiation used by the sensor
    */
   public byte radiation_type_;
   /**
    * the size of the arc that the distance reading is
    */
   public float field_of_view_;
   /**
    * minimum range value [m]
    */
   public float min_range_;
   /**
    * maximum range value [m]
    */
   public float max_range_;
   /**
    * range data [m]
    */
   public float range_;

   public Range()
   {
      header_ = new std_msgs.msg.dds.Header();
   }

   public Range(Range other)
   {
      set(other);
   }

   public void set(Range other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      radiation_type_ = other.radiation_type_;

      field_of_view_ = other.field_of_view_;

      min_range_ = other.min_range_;

      max_range_ = other.max_range_;

      range_ = other.range_;
   }

   /**
    * timestamp in the header is the time the ranger
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * the type of radiation used by the sensor
    */
   public byte getRadiationType()
   {
      return radiation_type_;
   }

   /**
    * the type of radiation used by the sensor
    */
   public void setRadiationType(byte radiation_type)
   {
      radiation_type_ = radiation_type;
   }

   /**
    * the size of the arc that the distance reading is
    */
   public float getFieldOfView()
   {
      return field_of_view_;
   }

   /**
    * the size of the arc that the distance reading is
    */
   public void setFieldOfView(float field_of_view)
   {
      field_of_view_ = field_of_view;
   }

   /**
    * minimum range value [m]
    */
   public float getMinRange()
   {
      return min_range_;
   }

   /**
    * minimum range value [m]
    */
   public void setMinRange(float min_range)
   {
      min_range_ = min_range;
   }

   /**
    * maximum range value [m]
    */
   public float getMaxRange()
   {
      return max_range_;
   }

   /**
    * maximum range value [m]
    */
   public void setMaxRange(float max_range)
   {
      max_range_ = max_range;
   }

   /**
    * range data [m]
    */
   public float getRange()
   {
      return range_;
   }

   /**
    * range data [m]
    */
   public void setRange(float range)
   {
      range_ = range;
   }

   @Override
   public boolean epsilonEquals(Range other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.radiation_type_, other.radiation_type_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.field_of_view_, other.field_of_view_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.min_range_, other.min_range_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.max_range_, other.max_range_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.range_, other.range_, epsilon))
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
      if (!(other instanceof Range))
         return false;

      Range otherMyClass = (Range) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.radiation_type_ != otherMyClass.radiation_type_)
         return false;

      if (this.field_of_view_ != otherMyClass.field_of_view_)
         return false;

      if (this.min_range_ != otherMyClass.min_range_)
         return false;

      if (this.max_range_ != otherMyClass.max_range_)
         return false;

      if (this.range_ != otherMyClass.range_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Range {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("radiation_type=");
      builder.append(this.radiation_type_);

      builder.append(", ");
      builder.append("field_of_view=");
      builder.append(this.field_of_view_);

      builder.append(", ");
      builder.append("min_range=");
      builder.append(this.min_range_);

      builder.append(", ");
      builder.append("max_range=");
      builder.append(this.max_range_);

      builder.append(", ");
      builder.append("range=");
      builder.append(this.range_);

      builder.append("}");
      return builder.toString();
   }
}
