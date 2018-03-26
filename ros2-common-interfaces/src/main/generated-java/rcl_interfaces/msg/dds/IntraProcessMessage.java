package rcl_interfaces.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class IntraProcessMessage implements Settable<IntraProcessMessage>, EpsilonComparable<IntraProcessMessage>
{
   private long publisher_id_;
   private long message_sequence_;

   public IntraProcessMessage()
   {

   }

   public IntraProcessMessage(IntraProcessMessage other)
   {
      set(other);
   }

   public void set(IntraProcessMessage other)
   {
      publisher_id_ = other.publisher_id_;

      message_sequence_ = other.message_sequence_;
   }

   public long getPublisherId()
   {
      return publisher_id_;
   }

   public void setPublisherId(long publisher_id)
   {
      publisher_id_ = publisher_id;
   }

   public long getMessageSequence()
   {
      return message_sequence_;
   }

   public void setMessageSequence(long message_sequence)
   {
      message_sequence_ = message_sequence;
   }

   @Override
   public boolean epsilonEquals(IntraProcessMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.publisher_id_, other.publisher_id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.message_sequence_, other.message_sequence_, epsilon))
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
      if (!(other instanceof IntraProcessMessage))
         return false;

      IntraProcessMessage otherMyClass = (IntraProcessMessage) other;

      if (this.publisher_id_ != otherMyClass.publisher_id_)
         return false;

      if (this.message_sequence_ != otherMyClass.message_sequence_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("IntraProcessMessage {");
      builder.append("publisher_id=");
      builder.append(this.publisher_id_);

      builder.append(", ");
      builder.append("message_sequence=");
      builder.append(this.message_sequence_);

      builder.append("}");
      return builder.toString();
   }
}