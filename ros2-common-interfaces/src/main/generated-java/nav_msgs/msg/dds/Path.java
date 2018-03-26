package nav_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * An array of poses that represents a Path for a robot to follow.
 */
public class Path extends Packet<Path> implements Settable<Path>, EpsilonComparable<Path>
{
   public std_msgs.msg.dds.Header header_;
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.PoseStamped> poses_;

   public Path()
   {
      header_ = new std_msgs.msg.dds.Header();
      poses_ = new us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.PoseStamped>(100, geometry_msgs.msg.dds.PoseStamped.class,
                                                                                     new geometry_msgs.msg.dds.PoseStampedPubSubType());
   }

   public Path(Path other)
   {
      set(other);
   }

   public void set(Path other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      poses_.set(other.poses_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.PoseStamped> getPoses()
   {
      return poses_;
   }

   @Override
   public boolean epsilonEquals(Path other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (this.poses_.size() == other.poses_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.poses_.size(); i++)
         {
            if (!this.poses_.get(i).epsilonEquals(other.poses_.get(i), epsilon))
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
      if (!(other instanceof Path))
         return false;

      Path otherMyClass = (Path) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.poses_.equals(otherMyClass.poses_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Path {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("poses=");
      builder.append(this.poses_);

      builder.append("}");
      return builder.toString();
   }
}
