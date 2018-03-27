package actionlib_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class GoalStatusArray extends Packet<GoalStatusArray> implements Settable<GoalStatusArray>, EpsilonComparable<GoalStatusArray>
{
   /**
    * Stores the statuses for goals that are currently being tracked
    * by an action server
    */
   public std_msgs.msg.dds.Header header_;
   public us.ihmc.idl.IDLSequence.Object<actionlib_msgs.msg.dds.GoalStatus> status_list_;

   public GoalStatusArray()
   {
      header_ = new std_msgs.msg.dds.Header();
      status_list_ = new us.ihmc.idl.IDLSequence.Object<actionlib_msgs.msg.dds.GoalStatus>(100, actionlib_msgs.msg.dds.GoalStatus.class,
                                                                                           new actionlib_msgs.msg.dds.GoalStatusPubSubType());
   }

   public GoalStatusArray(GoalStatusArray other)
   {
      set(other);
   }

   public void set(GoalStatusArray other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      status_list_.set(other.status_list_);
   }

   /**
    * Stores the statuses for goals that are currently being tracked
    * by an action server
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.idl.IDLSequence.Object<actionlib_msgs.msg.dds.GoalStatus> getStatusList()
   {
      return status_list_;
   }

   @Override
   public boolean epsilonEquals(GoalStatusArray other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;
      if (this.status_list_.size() == other.status_list_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.status_list_.size(); i++)
         {
            if (!this.status_list_.get(i).epsilonEquals(other.status_list_.get(i), epsilon))
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
      if (!(other instanceof GoalStatusArray))
         return false;

      GoalStatusArray otherMyClass = (GoalStatusArray) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;
      if (!this.status_list_.equals(otherMyClass.status_list_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("GoalStatusArray {");
      builder.append("header=");
      builder.append(this.header_);
      builder.append(", ");
      builder.append("status_list=");
      builder.append(this.status_list_);
      builder.append("}");
      return builder.toString();
   }
}
