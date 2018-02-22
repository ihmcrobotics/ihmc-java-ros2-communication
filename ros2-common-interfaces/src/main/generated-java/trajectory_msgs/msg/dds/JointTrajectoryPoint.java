package trajectory_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "JointTrajectoryPoint" defined in JointTrajectoryPoint_.idl.
 *
 * This file was automatically generated from JointTrajectoryPoint_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit JointTrajectoryPoint_.idl instead.
 */
public class JointTrajectoryPoint implements Settable<JointTrajectoryPoint>, EpsilonComparable<JointTrajectoryPoint>
{
   private us.ihmc.idl.IDLSequence.Double positions_;
   private us.ihmc.idl.IDLSequence.Double velocities_;
   private us.ihmc.idl.IDLSequence.Double accelerations_;
   private us.ihmc.idl.IDLSequence.Double effort_;
   private builtin_interfaces.msg.dds.Duration time_from_start_;

   public JointTrajectoryPoint()
   {
      positions_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      velocities_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      accelerations_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      effort_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      time_from_start_ = new builtin_interfaces.msg.dds.Duration();
   }

   public JointTrajectoryPoint(JointTrajectoryPoint other)
   {
      set(other);
   }

   public void set(JointTrajectoryPoint other)
   {
      positions_.set(other.positions_);
      velocities_.set(other.velocities_);
      accelerations_.set(other.accelerations_);
      effort_.set(other.effort_);
      builtin_interfaces.msg.dds.DurationPubSubType.staticCopy(other.time_from_start_, time_from_start_);
   }

   public us.ihmc.idl.IDLSequence.Double getPositions()
   {
      return positions_;
   }

   public us.ihmc.idl.IDLSequence.Double getVelocities()
   {
      return velocities_;
   }

   public us.ihmc.idl.IDLSequence.Double getAccelerations()
   {
      return accelerations_;
   }

   public us.ihmc.idl.IDLSequence.Double getEffort()
   {
      return effort_;
   }

   public builtin_interfaces.msg.dds.Duration getTimeFromStart()
   {
      return time_from_start_;
   }

   @Override
   public boolean epsilonEquals(JointTrajectoryPoint other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.positions_, other.positions_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.velocities_, other.velocities_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.accelerations_, other.accelerations_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.effort_, other.effort_, epsilon))
         return false;

      if (!this.time_from_start_.epsilonEquals(other.time_from_start_, epsilon))
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
      if (!(other instanceof JointTrajectoryPoint))
         return false;

      JointTrajectoryPoint otherMyClass = (JointTrajectoryPoint) other;

      if (!this.positions_.equals(otherMyClass.positions_))
         return false;

      if (!this.velocities_.equals(otherMyClass.velocities_))
         return false;

      if (!this.accelerations_.equals(otherMyClass.accelerations_))
         return false;

      if (!this.effort_.equals(otherMyClass.effort_))
         return false;

      if (!this.time_from_start_.equals(otherMyClass.time_from_start_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("JointTrajectoryPoint {");
      builder.append("positions=");
      builder.append(this.positions_);

      builder.append(", ");
      builder.append("velocities=");
      builder.append(this.velocities_);

      builder.append(", ");
      builder.append("accelerations=");
      builder.append(this.accelerations_);

      builder.append(", ");
      builder.append("effort=");
      builder.append(this.effort_);

      builder.append(", ");
      builder.append("time_from_start=");
      builder.append(this.time_from_start_);

      builder.append("}");
      return builder.toString();
   }
}