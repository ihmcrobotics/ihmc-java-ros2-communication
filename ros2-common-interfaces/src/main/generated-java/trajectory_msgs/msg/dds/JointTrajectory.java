package trajectory_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class JointTrajectory extends Packet<JointTrajectory> implements Settable<JointTrajectory>, EpsilonComparable<JointTrajectory>
{
   public std_msgs.msg.dds.Header header_;
   public us.ihmc.idl.IDLSequence.StringBuilderHolder joint_names_;
   public us.ihmc.idl.IDLSequence.Object<trajectory_msgs.msg.dds.JointTrajectoryPoint> points_;

   public JointTrajectory()
   {
      header_ = new std_msgs.msg.dds.Header();
      joint_names_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder(100, "type_d");
      points_ = new us.ihmc.idl.IDLSequence.Object<trajectory_msgs.msg.dds.JointTrajectoryPoint>(100, trajectory_msgs.msg.dds.JointTrajectoryPoint.class,
                                                                                                 new trajectory_msgs.msg.dds.JointTrajectoryPointPubSubType());
   }

   public JointTrajectory(JointTrajectory other)
   {
      set(other);
   }

   public void set(JointTrajectory other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      joint_names_.set(other.joint_names_);
      points_.set(other.points_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.idl.IDLSequence.StringBuilderHolder getJointNames()
   {
      return joint_names_;
   }

   public us.ihmc.idl.IDLSequence.Object<trajectory_msgs.msg.dds.JointTrajectoryPoint> getPoints()
   {
      return points_;
   }

   @Override
   public boolean epsilonEquals(JointTrajectory other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.joint_names_, other.joint_names_, epsilon))
         return false;

      if (this.points_.size() == other.points_.size())
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

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof JointTrajectory))
         return false;

      JointTrajectory otherMyClass = (JointTrajectory) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;
      if (!this.joint_names_.equals(otherMyClass.joint_names_))
         return false;
      if (!this.points_.equals(otherMyClass.points_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("JointTrajectory {");
      builder.append("header=");
      builder.append(this.header_);
      builder.append(", ");
      builder.append("joint_names=");
      builder.append(this.joint_names_);
      builder.append(", ");
      builder.append("points=");
      builder.append(this.points_);
      builder.append("}");
      return builder.toString();
   }
}
