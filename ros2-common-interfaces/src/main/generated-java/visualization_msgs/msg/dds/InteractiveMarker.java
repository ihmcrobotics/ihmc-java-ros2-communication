package visualization_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;

public class InteractiveMarker extends Packet<InteractiveMarker> implements Settable<InteractiveMarker>, EpsilonComparable<InteractiveMarker>
{
   /**
            * Time/frame info.
            * If header.time is set to 0, the marker will be retransformed into
            * its frame on each timestep. You will receive the pose feedback
            * in the same frame.
            * Otherwise, you might receive feedback in a different frame.
            * For rviz, this will be the current 'fixed frame' set by the user.
            */
   public std_msgs.msg.dds.Header header_;
   /**
            * Initial pose. Also, defines the pivot point for rotations.
            */
   public us.ihmc.euclid.geometry.Pose3D pose_;
   /**
            * Identifying string. Must be globally unique in
            * the topic that this message is sent through.
            */
   public java.lang.StringBuilder name_;
   /**
            * Short description (< 40 characters).
            */
   public java.lang.StringBuilder description_;
   /**
            * Scale to be used for default controls (default=1).
            */
   public float scale_;
   /**
            * All menu and submenu entries associated with this marker.
            */
   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.MenuEntry>  menu_entries_;
   /**
            * List of controls displayed for this marker.
            */
   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarkerControl>  controls_;

   public InteractiveMarker()
   {
      header_ = new std_msgs.msg.dds.Header();
      pose_ = new us.ihmc.euclid.geometry.Pose3D();
      name_ = new java.lang.StringBuilder(255);
      description_ = new java.lang.StringBuilder(255);
      menu_entries_ = new us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.MenuEntry> (100, visualization_msgs.msg.dds.MenuEntry.class, new visualization_msgs.msg.dds.MenuEntryPubSubType());
      controls_ = new us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarkerControl> (100, visualization_msgs.msg.dds.InteractiveMarkerControl.class, new visualization_msgs.msg.dds.InteractiveMarkerControlPubSubType());

   }

   public InteractiveMarker(InteractiveMarker other)
   {
      this();
      set(other);
   }

   public void set(InteractiveMarker other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.pose_, pose_);
      name_.setLength(0);
      name_.append(other.name_);

      description_.setLength(0);
      description_.append(other.description_);

      scale_ = other.scale_;

      menu_entries_.set(other.menu_entries_);
      controls_.set(other.controls_);
   }


   /**
            * Time/frame info.
            * If header.time is set to 0, the marker will be retransformed into
            * its frame on each timestep. You will receive the pose feedback
            * in the same frame.
            * Otherwise, you might receive feedback in a different frame.
            * For rviz, this will be the current 'fixed frame' set by the user.
            */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   /**
            * Initial pose. Also, defines the pivot point for rotations.
            */
   public us.ihmc.euclid.geometry.Pose3D getPose()
   {
      return pose_;
   }

   /**
            * Identifying string. Must be globally unique in
            * the topic that this message is sent through.
            */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
            * Identifying string. Must be globally unique in
            * the topic that this message is sent through.
            */
   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }
   /**
            * Identifying string. Must be globally unique in
            * the topic that this message is sent through.
            */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   /**
            * Short description (< 40 characters).
            */
   public void setDescription(java.lang.String description)
   {
      description_.setLength(0);
      description_.append(description);
   }

   /**
            * Short description (< 40 characters).
            */
   public java.lang.String getDescriptionAsString()
   {
      return getDescription().toString();
   }
   /**
            * Short description (< 40 characters).
            */
   public java.lang.StringBuilder getDescription()
   {
      return description_;
   }

   /**
            * Scale to be used for default controls (default=1).
            */
   public void setScale(float scale)
   {
      scale_ = scale;
   }
   /**
            * Scale to be used for default controls (default=1).
            */
   public float getScale()
   {
      return scale_;
   }


   /**
            * All menu and submenu entries associated with this marker.
            */
   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.MenuEntry>  getMenuEntries()
   {
      return menu_entries_;
   }


   /**
            * List of controls displayed for this marker.
            */
   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.InteractiveMarkerControl>  getControls()
   {
      return controls_;
   }


   @Override
   public boolean epsilonEquals(InteractiveMarker other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!this.pose_.epsilonEquals(other.pose_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.description_, other.description_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.scale_, other.scale_, epsilon)) return false;

      if (this.menu_entries_.size() != other.menu_entries_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.menu_entries_.size(); i++)
         {  if (!this.menu_entries_.get(i).epsilonEquals(other.menu_entries_.get(i), epsilon)) return false; }
      }

      if (this.controls_.size() != other.controls_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.controls_.size(); i++)
         {  if (!this.controls_.get(i).epsilonEquals(other.controls_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof InteractiveMarker)) return false;

      InteractiveMarker otherMyClass = (InteractiveMarker) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.pose_.equals(otherMyClass.pose_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.description_, otherMyClass.description_)) return false;

      if(this.scale_ != otherMyClass.scale_) return false;

      if (!this.menu_entries_.equals(otherMyClass.menu_entries_)) return false;
      if (!this.controls_.equals(otherMyClass.controls_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("InteractiveMarker {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("pose=");
      builder.append(this.pose_);      builder.append(", ");
      builder.append("name=");
      builder.append(this.name_);      builder.append(", ");
      builder.append("description=");
      builder.append(this.description_);      builder.append(", ");
      builder.append("scale=");
      builder.append(this.scale_);      builder.append(", ");
      builder.append("menu_entries=");
      builder.append(this.menu_entries_);      builder.append(", ");
      builder.append("controls=");
      builder.append(this.controls_);
      builder.append("}");
      return builder.toString();
   }
}
