package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This represents a Point with reference coordinate frame and timestamp
 */
public class PointStamped extends Packet<PointStamped> implements Settable<PointStamped>, EpsilonComparable<PointStamped>
{
   public std_msgs.msg.dds.Header header_;
   public us.ihmc.euclid.tuple3D.Point3D point_;

   public PointStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      point_ = new us.ihmc.euclid.tuple3D.Point3D();
   }

   public PointStamped(PointStamped other)
   {
      set(other);
   }

   public void set(PointStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.PointPubSubType.staticCopy(other.point_, point_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.euclid.tuple3D.Point3D getPoint()
   {
      return point_;
   }

   @Override
   public boolean epsilonEquals(PointStamped other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;
      if (!this.point_.epsilonEquals(other.point_, epsilon))
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
      if (!(other instanceof PointStamped))
         return false;

      PointStamped otherMyClass = (PointStamped) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;
      if (!this.point_.equals(otherMyClass.point_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PointStamped {");
      builder.append("header=");
      builder.append(this.header_);
      builder.append(", ");
      builder.append("point=");
      builder.append(this.point_);
      builder.append("}");
      return builder.toString();
   }
}
