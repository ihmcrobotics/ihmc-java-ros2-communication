package action_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class GoalInfo extends Packet<GoalInfo> implements Settable<GoalInfo>, EpsilonComparable<GoalInfo>
{
   /**
            * Goal ID
            */
   public unique_identifier_msgs.msg.dds.UUID goal_id_;
   /**
            * Time when the goal was accepted
            */
   public builtin_interfaces.msg.dds.Time stamp_;

   public GoalInfo()
   {
      goal_id_ = new unique_identifier_msgs.msg.dds.UUID();
      stamp_ = new builtin_interfaces.msg.dds.Time();
   }

   public GoalInfo(GoalInfo other)
   {
      this();
      set(other);
   }

   public void set(GoalInfo other)
   {
      unique_identifier_msgs.msg.dds.UUIDPubSubType.staticCopy(other.goal_id_, goal_id_);
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.stamp_, stamp_);
   }


   /**
            * Goal ID
            */
   public unique_identifier_msgs.msg.dds.UUID getGoalId()
   {
      return goal_id_;
   }


   /**
            * Time when the goal was accepted
            */
   public builtin_interfaces.msg.dds.Time getStamp()
   {
      return stamp_;
   }


   public static Supplier<GoalInfoPubSubType> getPubSubType()
   {
      return GoalInfoPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return GoalInfoPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(GoalInfo other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.goal_id_.epsilonEquals(other.goal_id_, epsilon)) return false;
      if (!this.stamp_.epsilonEquals(other.stamp_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof GoalInfo)) return false;

      GoalInfo otherMyClass = (GoalInfo) other;

      if (!this.goal_id_.equals(otherMyClass.goal_id_)) return false;
      if (!this.stamp_.equals(otherMyClass.stamp_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("GoalInfo {");
      builder.append("goal_id=");
      builder.append(this.goal_id_);      builder.append(", ");
      builder.append("stamp=");
      builder.append(this.stamp_);
      builder.append("}");
      return builder.toString();
   }
}
