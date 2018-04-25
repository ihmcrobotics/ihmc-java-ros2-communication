package visualization_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class InteractiveMarkerInit extends Packet<InteractiveMarkerInit> implements Settable<InteractiveMarkerInit>, EpsilonComparable<InteractiveMarkerInit>
{
   /**
            * Identifying string. Must be unique in the topic namespace
            * that this server works on.
            */
   public java.lang.StringBuilder server_id_;
   /**
            * Sequence number.
            * The client will use this to detect if it has missed a subsequent
            * update.  Every update message will have the same sequence number as
            * an init message.  Clients will likely want to unsubscribe from the
            * init topic after a successful initialization to avoid receiving
            * duplicate data.
            */
   public long seq_num_;
   /**
            * All markers.
            */
   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarker>  markers_;

   public InteractiveMarkerInit()
   {
      server_id_ = new java.lang.StringBuilder(255);
      markers_ = new us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarker> (100, visualization_msgs.msg.dds.InteractiveMarker.class, new visualization_msgs.msg.dds.InteractiveMarkerPubSubType());

   }

   public InteractiveMarkerInit(InteractiveMarkerInit other)
   {
      this();
      set(other);
   }

   public void set(InteractiveMarkerInit other)
   {
      server_id_.setLength(0);
      server_id_.append(other.server_id_);

      seq_num_ = other.seq_num_;

      markers_.set(other.markers_);
   }

   /**
            * Identifying string. Must be unique in the topic namespace
            * that this server works on.
            */
   public void setServerId(java.lang.String server_id)
   {
      server_id_.setLength(0);
      server_id_.append(server_id);
   }

   /**
            * Identifying string. Must be unique in the topic namespace
            * that this server works on.
            */
   public java.lang.String getServerIdAsString()
   {
      return getServerId().toString();
   }
   /**
            * Identifying string. Must be unique in the topic namespace
            * that this server works on.
            */
   public java.lang.StringBuilder getServerId()
   {
      return server_id_;
   }

   /**
            * Sequence number.
            * The client will use this to detect if it has missed a subsequent
            * update.  Every update message will have the same sequence number as
            * an init message.  Clients will likely want to unsubscribe from the
            * init topic after a successful initialization to avoid receiving
            * duplicate data.
            */
   public void setSeqNum(long seq_num)
   {
      seq_num_ = seq_num;
   }
   /**
            * Sequence number.
            * The client will use this to detect if it has missed a subsequent
            * update.  Every update message will have the same sequence number as
            * an init message.  Clients will likely want to unsubscribe from the
            * init topic after a successful initialization to avoid receiving
            * duplicate data.
            */
   public long getSeqNum()
   {
      return seq_num_;
   }


   /**
            * All markers.
            */
   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarker>  getMarkers()
   {
      return markers_;
   }


   public static Supplier<InteractiveMarkerInitPubSubType> getPubSubType()
   {
      return InteractiveMarkerInitPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return InteractiveMarkerInitPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(InteractiveMarkerInit other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.server_id_, other.server_id_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.seq_num_, other.seq_num_, epsilon)) return false;

      if (this.markers_.size() != other.markers_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.markers_.size(); i++)
         {  if (!this.markers_.get(i).epsilonEquals(other.markers_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof InteractiveMarkerInit)) return false;

      InteractiveMarkerInit otherMyClass = (InteractiveMarkerInit) other;

      if (!us.ihmc.idl.IDLTools.equals(this.server_id_, otherMyClass.server_id_)) return false;

      if(this.seq_num_ != otherMyClass.seq_num_) return false;

      if (!this.markers_.equals(otherMyClass.markers_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("InteractiveMarkerInit {");
      builder.append("server_id=");
      builder.append(this.server_id_);      builder.append(", ");
      builder.append("seq_num=");
      builder.append(this.seq_num_);      builder.append(", ");
      builder.append("markers=");
      builder.append(this.markers_);
      builder.append("}");
      return builder.toString();
   }
}
