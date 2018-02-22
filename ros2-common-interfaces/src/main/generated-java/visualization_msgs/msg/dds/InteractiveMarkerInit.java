package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "InteractiveMarkerInit" defined in InteractiveMarkerInit_.idl.
 *
 * This file was automatically generated from InteractiveMarkerInit_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit InteractiveMarkerInit_.idl instead.
 */
public class InteractiveMarkerInit implements Settable<InteractiveMarkerInit>, EpsilonComparable<InteractiveMarkerInit>
{
   private java.lang.StringBuilder server_id_;
   private long seq_num_;
   private us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarker> markers_;

   public InteractiveMarkerInit()
   {
      server_id_ = new java.lang.StringBuilder(255);

      markers_ = new us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarker>(100, visualization_msgs.msg.dds.InteractiveMarker.class,
                                                                                                  new visualization_msgs.msg.dds.InteractiveMarkerPubSubType());
   }

   public InteractiveMarkerInit(InteractiveMarkerInit other)
   {
      set(other);
   }

   public void set(InteractiveMarkerInit other)
   {
      server_id_.setLength(0);
      server_id_.append(other.server_id_);

      seq_num_ = other.seq_num_;

      markers_.set(other.markers_);
   }

   public java.lang.String getServerIdAsString()
   {
      return getServerId().toString();
   }

   public java.lang.StringBuilder getServerId()
   {
      return server_id_;
   }

   public void setServerId(String server_id)
   {
      server_id_.setLength(0);
      server_id_.append(server_id);
   }

   public long getSeqNum()
   {
      return seq_num_;
   }

   public void setSeqNum(long seq_num)
   {
      seq_num_ = seq_num;
   }

   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarker> getMarkers()
   {
      return markers_;
   }

   @Override
   public boolean epsilonEquals(InteractiveMarkerInit other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.server_id_, other.server_id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.seq_num_, other.seq_num_, epsilon))
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

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof InteractiveMarkerInit))
         return false;

      InteractiveMarkerInit otherMyClass = (InteractiveMarkerInit) other;

      if (!us.ihmc.idl.IDLTools.equals(this.server_id_, otherMyClass.server_id_))
         return false;

      if (this.seq_num_ != otherMyClass.seq_num_)
         return false;

      if (!this.markers_.equals(otherMyClass.markers_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("InteractiveMarkerInit {");
      builder.append("server_id=");
      builder.append(this.server_id_);

      builder.append(", ");
      builder.append("seq_num=");
      builder.append(this.seq_num_);

      builder.append(", ");
      builder.append("markers=");
      builder.append(this.markers_);

      builder.append("}");
      return builder.toString();
   }
}