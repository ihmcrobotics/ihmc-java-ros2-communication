package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

/**
       * This represents a Polygon with reference coordinate frame and timestamp
       */
public class PolygonStamped extends Packet<PolygonStamped> implements Settable<PolygonStamped>, EpsilonComparable<PolygonStamped>
{
   public std_msgs.msg.dds.Header header_;
   public geometry_msgs.msg.dds.Polygon polygon_;

   public PolygonStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      polygon_ = new geometry_msgs.msg.dds.Polygon();
   }

   public PolygonStamped(PolygonStamped other)
   {
      this();
      set(other);
   }

   public void set(PolygonStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.PolygonPubSubType.staticCopy(other.polygon_, polygon_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   public geometry_msgs.msg.dds.Polygon getPolygon()
   {
      return polygon_;
   }


   @Override
   public boolean epsilonEquals(PolygonStamped other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!this.polygon_.epsilonEquals(other.polygon_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof PolygonStamped)) return false;

      PolygonStamped otherMyClass = (PolygonStamped) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.polygon_.equals(otherMyClass.polygon_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PolygonStamped {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("polygon=");
      builder.append(this.polygon_);
      builder.append("}");
      return builder.toString();
   }
}
