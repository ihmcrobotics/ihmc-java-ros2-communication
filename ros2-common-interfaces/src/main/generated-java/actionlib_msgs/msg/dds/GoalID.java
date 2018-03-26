package actionlib_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class GoalID implements Settable<GoalID>, EpsilonComparable<GoalID>
{
   /**
    * The stamp should store the time at which this goal was requested.
    * It is used by an action server when it tries to preempt all
    * goals that were requested before a certain time
    */
   private builtin_interfaces.msg.dds.Time stamp_;
   /**
    * The id provides a way to associate feedback and
    * result message with specific goal requests. The id
    * specified must be unique.
    */
   private java.lang.StringBuilder id_;

   public GoalID()
   {
      stamp_ = new builtin_interfaces.msg.dds.Time();
      id_ = new java.lang.StringBuilder(255);
   }

   public GoalID(GoalID other)
   {
      set(other);
   }

   public void set(GoalID other)
   {
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.stamp_, stamp_);
      id_.setLength(0);
      id_.append(other.id_);
   }

   /**
    * The stamp should store the time at which this goal was requested.
    * It is used by an action server when it tries to preempt all
    * goals that were requested before a certain time
    */
   public builtin_interfaces.msg.dds.Time getStamp()
   {
      return stamp_;
   }

   /**
    * The id provides a way to associate feedback and
    * result message with specific goal requests. The id
    * specified must be unique.
    */
   public java.lang.String getIdAsString()
   {
      return getId().toString();
   }

   /**
    * The id provides a way to associate feedback and
    * result message with specific goal requests. The id
    * specified must be unique.
    */
   public java.lang.StringBuilder getId()
   {
      return id_;
   }

   /**
    * The id provides a way to associate feedback and
    * result message with specific goal requests. The id
    * specified must be unique.
    */
   public void setId(java.lang.String id)
   {
      id_.setLength(0);
      id_.append(id);
   }

   @Override
   public boolean epsilonEquals(GoalID other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.stamp_.epsilonEquals(other.stamp_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.id_, other.id_, epsilon))
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
      if (!(other instanceof GoalID))
         return false;

      GoalID otherMyClass = (GoalID) other;

      if (!this.stamp_.equals(otherMyClass.stamp_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.id_, otherMyClass.id_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("GoalID {");
      builder.append("stamp=");
      builder.append(this.stamp_);

      builder.append(", ");
      builder.append("id=");
      builder.append(this.id_);

      builder.append("}");
      return builder.toString();
   }
}
