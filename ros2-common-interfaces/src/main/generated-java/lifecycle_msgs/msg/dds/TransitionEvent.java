package lifecycle_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "TransitionEvent" defined in TransitionEvent_.idl.
 *
 * This file was automatically generated from TransitionEvent_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit TransitionEvent_.idl instead.
 */
public class TransitionEvent implements Settable<TransitionEvent>, EpsilonComparable<TransitionEvent>
{
   private long timestamp_;
   private lifecycle_msgs.msg.dds.Transition transition_;
   private lifecycle_msgs.msg.dds.State start_state_;
   private lifecycle_msgs.msg.dds.State goal_state_;

   public TransitionEvent()
   {

      transition_ = new lifecycle_msgs.msg.dds.Transition();
      start_state_ = new lifecycle_msgs.msg.dds.State();
      goal_state_ = new lifecycle_msgs.msg.dds.State();
   }

   public TransitionEvent(TransitionEvent other)
   {
      set(other);
   }

   public void set(TransitionEvent other)
   {
      timestamp_ = other.timestamp_;

      lifecycle_msgs.msg.dds.TransitionPubSubType.staticCopy(other.transition_, transition_);
      lifecycle_msgs.msg.dds.StatePubSubType.staticCopy(other.start_state_, start_state_);
      lifecycle_msgs.msg.dds.StatePubSubType.staticCopy(other.goal_state_, goal_state_);
   }

   public long getTimestamp()
   {
      return timestamp_;
   }

   public void setTimestamp(long timestamp)
   {
      timestamp_ = timestamp;
   }

   public lifecycle_msgs.msg.dds.Transition getTransition()
   {
      return transition_;
   }

   public lifecycle_msgs.msg.dds.State getStartState()
   {
      return start_state_;
   }

   public lifecycle_msgs.msg.dds.State getGoalState()
   {
      return goal_state_;
   }

   @Override
   public boolean epsilonEquals(TransitionEvent other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.timestamp_, other.timestamp_, epsilon))
         return false;

      if (!this.transition_.epsilonEquals(other.transition_, epsilon))
         return false;

      if (!this.start_state_.epsilonEquals(other.start_state_, epsilon))
         return false;

      if (!this.goal_state_.epsilonEquals(other.goal_state_, epsilon))
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
      if (!(other instanceof TransitionEvent))
         return false;

      TransitionEvent otherMyClass = (TransitionEvent) other;

      if (this.timestamp_ != otherMyClass.timestamp_)
         return false;

      if (!this.transition_.equals(otherMyClass.transition_))
         return false;

      if (!this.start_state_.equals(otherMyClass.start_state_))
         return false;

      if (!this.goal_state_.equals(otherMyClass.goal_state_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TransitionEvent {");
      builder.append("timestamp=");
      builder.append(this.timestamp_);

      builder.append(", ");
      builder.append("transition=");
      builder.append(this.transition_);

      builder.append(", ");
      builder.append("start_state=");
      builder.append(this.start_state_);

      builder.append(", ");
      builder.append("goal_state=");
      builder.append(this.goal_state_);

      builder.append("}");
      return builder.toString();
   }
}