package visualization_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

public class MarkerArray extends Packet<MarkerArray> implements Settable<MarkerArray>, EpsilonComparable<MarkerArray>
{
   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.Marker>  markers_;

   public MarkerArray()
   {
      markers_ = new us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.Marker> (100, visualization_msgs.msg.dds.Marker.class, new visualization_msgs.msg.dds.MarkerPubSubType());

   }

   public MarkerArray(MarkerArray other)
   {
      this();
      set(other);
   }

   public void set(MarkerArray other)
   {
      markers_.set(other.markers_);
   }


   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.Marker>  getMarkers()
   {
      return markers_;
   }


   @Override
   public boolean epsilonEquals(MarkerArray other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

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
      if(!(other instanceof MarkerArray)) return false;

      MarkerArray otherMyClass = (MarkerArray) other;

      if (!this.markers_.equals(otherMyClass.markers_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MarkerArray {");
      builder.append("markers=");
      builder.append(this.markers_);
      builder.append("}");
      return builder.toString();
   }
}
