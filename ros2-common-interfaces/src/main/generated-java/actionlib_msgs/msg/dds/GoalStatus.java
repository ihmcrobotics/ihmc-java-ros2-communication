package actionlib_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "GoalStatus" defined in GoalStatus_.idl.
 *
 * This file was automatically generated from GoalStatus_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit GoalStatus_.idl instead.
 */
public class GoalStatus implements Settable<GoalStatus>, EpsilonComparable<GoalStatus>
{
   private actionlib_msgs.msg.dds.GoalID goal_id_;
   private byte status_;
   private java.lang.StringBuilder text_;

   public GoalStatus()
   {
      goal_id_ = new actionlib_msgs.msg.dds.GoalID();

      text_ = new java.lang.StringBuilder(255);
   }

   public GoalStatus(GoalStatus other)
   {
      set(other);
   }

   public void set(GoalStatus other)
   {
      actionlib_msgs.msg.dds.GoalIDPubSubType.staticCopy(other.goal_id_, goal_id_);
      status_ = other.status_;

      text_.setLength(0);
      text_.append(other.text_);
   }

   public actionlib_msgs.msg.dds.GoalID getGoalId()
   {
      return goal_id_;
   }

   public byte getStatus()
   {
      return status_;
   }

   public void setStatus(byte status)
   {
      status_ = status;
   }

   public java.lang.String getTextAsString()
   {
      return getText().toString();
   }

   public java.lang.StringBuilder getText()
   {
      return text_;
   }

   public void setText(String text)
   {
      text_.setLength(0);
      text_.append(text);
   }

   @Override
   public boolean epsilonEquals(GoalStatus other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.goal_id_.epsilonEquals(other.goal_id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.status_, other.status_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.text_, other.text_, epsilon))
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
      if (!(other instanceof GoalStatus))
         return false;

      GoalStatus otherMyClass = (GoalStatus) other;

      if (!this.goal_id_.equals(otherMyClass.goal_id_))
         return false;

      if (this.status_ != otherMyClass.status_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.text_, otherMyClass.text_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("GoalStatus {");
      builder.append("goal_id=");
      builder.append(this.goal_id_);

      builder.append(", ");
      builder.append("status=");
      builder.append(this.status_);

      builder.append(", ");
      builder.append("text=");
      builder.append(this.text_);

      builder.append("}");
      return builder.toString();
   }
}