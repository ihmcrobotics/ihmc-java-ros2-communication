package action_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class GoalStatus extends Packet<GoalStatus> implements Settable<GoalStatus>, EpsilonComparable<GoalStatus>
{
   /**
          * An action goal can be in one of these states after it is accepted by an action server.
          * For more information, see http://design.ros2.org/articles/actions.html
          */
   public static final byte STATUS_UNKNOWN = (byte) 0;
   public static final byte STATUS_ACCEPTED = (byte) 1;
   public static final byte STATUS_EXECUTING = (byte) 2;
   public static final byte STATUS_CANCELING = (byte) 3;
   public static final byte STATUS_SUCCEEDED = (byte) 4;
   public static final byte STATUS_CANCELED = (byte) 5;
   public static final byte STATUS_ABORTED = (byte) 6;
   /**
            * Goal info (contains ID and timestamp)
            */
   public action_msgs.msg.dds.GoalInfo goal_info_;
   /**
            * Goal status
            */
   public byte status_;

   public GoalStatus()
   {
      goal_info_ = new action_msgs.msg.dds.GoalInfo();
   }

   public GoalStatus(GoalStatus other)
   {
      this();
      set(other);
   }

   public void set(GoalStatus other)
   {
      action_msgs.msg.dds.GoalInfoPubSubType.staticCopy(other.goal_info_, goal_info_);
      status_ = other.status_;

   }


   /**
            * Goal info (contains ID and timestamp)
            */
   public action_msgs.msg.dds.GoalInfo getGoalInfo()
   {
      return goal_info_;
   }

   /**
            * Goal status
            */
   public void setStatus(byte status)
   {
      status_ = status;
   }
   /**
            * Goal status
            */
   public byte getStatus()
   {
      return status_;
   }


   public static Supplier<GoalStatusPubSubType> getPubSubType()
   {
      return GoalStatusPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return GoalStatusPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(GoalStatus other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.goal_info_.epsilonEquals(other.goal_info_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.status_, other.status_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof GoalStatus)) return false;

      GoalStatus otherMyClass = (GoalStatus) other;

      if (!this.goal_info_.equals(otherMyClass.goal_info_)) return false;
      if(this.status_ != otherMyClass.status_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("GoalStatus {");
      builder.append("goal_info=");
      builder.append(this.goal_info_);      builder.append(", ");
      builder.append("status=");
      builder.append(this.status_);
      builder.append("}");
      return builder.toString();
   }
}
