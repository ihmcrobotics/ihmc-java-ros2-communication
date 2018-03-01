package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "JointState" defined in JointState_.idl.
 *
 * This file was automatically generated from JointState_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit JointState_.idl instead.
 */
public class JointState implements Settable<JointState>, EpsilonComparable<JointState>
{
   private std_msgs.msg.dds.Header header_;
   private us.ihmc.idl.IDLSequence.StringBuilderHolder name_;
   private us.ihmc.idl.IDLSequence.Double position_;
   private us.ihmc.idl.IDLSequence.Double velocity_;
   private us.ihmc.idl.IDLSequence.Double effort_;

   public JointState()
   {
      header_ = new std_msgs.msg.dds.Header();
      name_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder(100, "type_d");
      position_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      velocity_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      effort_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");
   }

   public JointState(JointState other)
   {
      set(other);
   }

   public void set(JointState other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      name_.set(other.name_);
      position_.set(other.position_);
      velocity_.set(other.velocity_);
      effort_.set(other.effort_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.idl.IDLSequence.StringBuilderHolder getName()
   {
      return name_;
   }

   public us.ihmc.idl.IDLSequence.Double getPosition()
   {
      return position_;
   }

   public us.ihmc.idl.IDLSequence.Double getVelocity()
   {
      return velocity_;
   }

   public us.ihmc.idl.IDLSequence.Double getEffort()
   {
      return effort_;
   }

   @Override
   public boolean epsilonEquals(JointState other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.name_, other.name_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.position_, other.position_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.velocity_, other.velocity_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.effort_, other.effort_, epsilon))
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
      if (!(other instanceof JointState))
         return false;

      JointState otherMyClass = (JointState) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.name_.equals(otherMyClass.name_))
         return false;

      if (!this.position_.equals(otherMyClass.position_))
         return false;

      if (!this.velocity_.equals(otherMyClass.velocity_))
         return false;

      if (!this.effort_.equals(otherMyClass.effort_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("JointState {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("name=");
      builder.append(this.name_);

      builder.append(", ");
      builder.append("position=");
      builder.append(this.position_);

      builder.append(", ");
      builder.append("velocity=");
      builder.append(this.velocity_);

      builder.append(", ");
      builder.append("effort=");
      builder.append(this.effort_);

      builder.append("}");
      return builder.toString();
   }
}