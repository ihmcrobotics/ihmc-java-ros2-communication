package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "InteractiveMarkerUpdate" defined in InteractiveMarkerUpdate_.idl.
 *
 * This file was automatically generated from InteractiveMarkerUpdate_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit InteractiveMarkerUpdate_.idl instead.
 */
public class InteractiveMarkerUpdate implements Settable<InteractiveMarkerUpdate>, EpsilonComparable<InteractiveMarkerUpdate>
{
   /**
    * Identifying string. Must be unique in the topic namespace
    * that this server works on.
    */
   private java.lang.StringBuilder server_id_;
   /**
    * Sequence number.
    * The client will use this to detect if it has missed an update.
    */
   private long seq_num_;
   private byte type_;
   private us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarker> markers_;
   private us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarkerPose> poses_;
   /**
    * Names of markers to be erased
    */
   private us.ihmc.idl.IDLSequence.StringBuilderHolder erases_;

   public InteractiveMarkerUpdate()
   {
      server_id_ = new java.lang.StringBuilder(255);

      markers_ = new us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarker>(100, visualization_msgs.msg.dds.InteractiveMarker.class,
                                                                                                  new visualization_msgs.msg.dds.InteractiveMarkerPubSubType());

      poses_ = new us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarkerPose>(100, visualization_msgs.msg.dds.InteractiveMarkerPose.class,
                                                                                                    new visualization_msgs.msg.dds.InteractiveMarkerPosePubSubType());

      erases_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder(100, "type_d");
   }

   public InteractiveMarkerUpdate(InteractiveMarkerUpdate other)
   {
      set(other);
   }

   public void set(InteractiveMarkerUpdate other)
   {
      server_id_.setLength(0);
      server_id_.append(other.server_id_);

      seq_num_ = other.seq_num_;

      type_ = other.type_;

      markers_.set(other.markers_);
      poses_.set(other.poses_);
      erases_.set(other.erases_);
   }

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
    * Identifying string. Must be unique in the topic namespace
    * that this server works on.
    */
   public void setServerId(String server_id)
   {
      server_id_.setLength(0);
      server_id_.append(server_id);
   }

   /**
    * Names of markers to be erased
    */

   /**
    * Sequence number.
    * The client will use this to detect if it has missed an update.
    */
   public long getSeqNum()
   {
      return seq_num_;
   }

   /**
    * Sequence number.
    * The client will use this to detect if it has missed an update.
    */
   public void setSeqNum(long seq_num)
   {
      seq_num_ = seq_num;
   }

   public byte getType()
   {
      return type_;
   }

   public void setType(byte type)
   {
      type_ = type;
   }

   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarker> getMarkers()
   {
      return markers_;
   }

   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarkerPose> getPoses()
   {
      return poses_;
   }

   /**
    * Names of markers to be erased
    */
   public us.ihmc.idl.IDLSequence.StringBuilderHolder getErases()
   {
      return erases_;
   }

   @Override
   public boolean epsilonEquals(InteractiveMarkerUpdate other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.server_id_, other.server_id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.seq_num_, other.seq_num_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon))
         return false;

      if (this.markers_.isEnum())
      {
         if (!this.markers_.equals(other.markers_))
            return false;
      }
      else if (this.markers_.size() == other.markers_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.markers_.size(); i++)
         {
            if (!this.markers_.get(i).epsilonEquals(other.markers_.get(i), epsilon))
               return false;
         }
      }

      if (this.poses_.isEnum())
      {
         if (!this.poses_.equals(other.poses_))
            return false;
      }
      else if (this.poses_.size() == other.poses_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.poses_.size(); i++)
         {
            if (!this.poses_.get(i).epsilonEquals(other.poses_.get(i), epsilon))
               return false;
         }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.erases_, other.erases_, epsilon))
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
      if (!(other instanceof InteractiveMarkerUpdate))
         return false;

      InteractiveMarkerUpdate otherMyClass = (InteractiveMarkerUpdate) other;

      if (!us.ihmc.idl.IDLTools.equals(this.server_id_, otherMyClass.server_id_))
         return false;

      if (this.seq_num_ != otherMyClass.seq_num_)
         return false;

      if (this.type_ != otherMyClass.type_)
         return false;

      if (!this.markers_.equals(otherMyClass.markers_))
         return false;

      if (!this.poses_.equals(otherMyClass.poses_))
         return false;

      if (!this.erases_.equals(otherMyClass.erases_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("InteractiveMarkerUpdate {");
      builder.append("server_id=");
      builder.append(this.server_id_);

      builder.append(", ");
      builder.append("seq_num=");
      builder.append(this.seq_num_);

      builder.append(", ");
      builder.append("type=");
      builder.append(this.type_);

      builder.append(", ");
      builder.append("markers=");
      builder.append(this.markers_);

      builder.append(", ");
      builder.append("poses=");
      builder.append(this.poses_);

      builder.append(", ");
      builder.append("erases=");
      builder.append(this.erases_);

      builder.append("}");
      return builder.toString();
   }
}