package actionlib_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * be sent over the wire by an action server.
 */
public class GoalStatus implements Settable<GoalStatus>, EpsilonComparable<GoalStatus>
{
   /**
    * The goal has yet to be processed by the action server.
    */
   public static final byte PENDING = (byte) 0;
   /**
    * The goal is currently being processed by the action server.
    */
   public static final byte ACTIVE = (byte) 1;
   /**
    * The goal received a cancel request after it started executing
    */
   public static final byte PREEMPTED = (byte) 2;
   /**
    * and has since completed its execution (Terminal State).
    * The goal was achieved successfully by the action server
    */
   public static final byte SUCCEEDED = (byte) 3;
   /**
    * (Terminal State).
    * The goal was aborted during execution by the action server due
    */
   public static final byte ABORTED = (byte) 4;
   /**
    * to some failure (Terminal State).
    * The goal was rejected by the action server without being processed,
    */
   public static final byte REJECTED = (byte) 5;
   /**
    * because the goal was unattainable or invalid (Terminal State).
    * The goal received a cancel request after it started executing
    */
   public static final byte PREEMPTING = (byte) 6;
   /**
    * and has not yet completed execution.
    * The goal received a cancel request before it started executing, but
    */
   public static final byte RECALLING = (byte) 7;
   /**
    * the action server has not yet confirmed that the goal is canceled.
    * The goal received a cancel request before it started executing
    */
   public static final byte RECALLED = (byte) 8;
   /**
    * and was successfully cancelled (Terminal State).
    * An action client can determine that a goal is LOST. This should not
    */
   public static final byte LOST = (byte) 9;
   private actionlib_msgs.msg.dds.GoalID goal_id_;
   private byte status_;
   /**
    * Allow for the user to associate a string with GoalStatus for debugging.
    */
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

   /**
    * Allow for the user to associate a string with GoalStatus for debugging.
    */
   public java.lang.String getTextAsString()
   {
      return getText().toString();
   }

   /**
    * Allow for the user to associate a string with GoalStatus for debugging.
    */
   public java.lang.StringBuilder getText()
   {
      return text_;
   }

   /**
    * Allow for the user to associate a string with GoalStatus for debugging.
    */
   public void setText(java.lang.String text)
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
