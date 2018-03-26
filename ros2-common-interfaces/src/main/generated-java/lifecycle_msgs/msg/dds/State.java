package lifecycle_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Primary state definitions
 * as depicted in
 * http://design.ros2.org/articles/node_lifecycle.html
 */
public class State implements Settable<State>, EpsilonComparable<State>
{
   /**
    * These are the primary states
    * State changes can only be requested
    * when the node is in one of these states.
    */
   public static final byte PRIMARY_STATE_UNKNOWN = (byte) 0;
   public static final byte PRIMARY_STATE_UNCONFIGURED = (byte) 1;
   public static final byte PRIMARY_STATE_INACTIVE = (byte) 2;
   public static final byte PRIMARY_STATE_ACTIVE = (byte) 3;
   public static final byte PRIMARY_STATE_FINALIZED = (byte) 4;
   /**
    * Temporary intermediate states
    * When a transition is requested, the
    * node changes its state into one
    * of these states.
    */
   public static final byte TRANSITION_STATE_CONFIGURING = (byte) 10;
   public static final byte TRANSITION_STATE_CLEANINGUP = (byte) 11;
   public static final byte TRANSITION_STATE_SHUTTINGDOWN = (byte) 12;
   public static final byte TRANSITION_STATE_ACTIVATING = (byte) 13;
   public static final byte TRANSITION_STATE_DEACTIVATING = (byte) 14;
   public static final byte TRANSITION_STATE_ERRORPROCESSING = (byte) 15;
   public byte id_;
   public java.lang.StringBuilder label_;

   public State()
   {

      label_ = new java.lang.StringBuilder(255);
   }

   public State(State other)
   {
      set(other);
   }

   public void set(State other)
   {
      id_ = other.id_;

      label_.setLength(0);
      label_.append(other.label_);
   }

   public byte getId()
   {
      return id_;
   }

   public void setId(byte id)
   {
      id_ = id;
   }

   public java.lang.String getLabelAsString()
   {
      return getLabel().toString();
   }

   public java.lang.StringBuilder getLabel()
   {
      return label_;
   }

   public void setLabel(java.lang.String label)
   {
      label_.setLength(0);
      label_.append(label);
   }

   @Override
   public boolean epsilonEquals(State other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.label_, other.label_, epsilon))
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
      if (!(other instanceof State))
         return false;

      State otherMyClass = (State) other;

      if (this.id_ != otherMyClass.id_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.label_, otherMyClass.label_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("State {");
      builder.append("id=");
      builder.append(this.id_);

      builder.append(", ");
      builder.append("label=");
      builder.append(this.label_);

      builder.append("}");
      return builder.toString();
   }
}