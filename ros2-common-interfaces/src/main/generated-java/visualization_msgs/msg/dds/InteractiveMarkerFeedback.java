package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "InteractiveMarkerFeedback" defined in InteractiveMarkerFeedback_.idl.
 *
 * This file was automatically generated from InteractiveMarkerFeedback_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit InteractiveMarkerFeedback_.idl instead.
 */
public class InteractiveMarkerFeedback implements Settable<InteractiveMarkerFeedback>, EpsilonComparable<InteractiveMarkerFeedback>
{
   private std_msgs.msg.dds.Header header_;
   private java.lang.StringBuilder client_id_;
   private java.lang.StringBuilder marker_name_;
   private java.lang.StringBuilder control_name_;
   private byte event_type_;
   private us.ihmc.euclid.geometry.Pose3D pose_;
   private long menu_entry_id_;
   private us.ihmc.euclid.tuple3D.Point3D mouse_point_;
   private boolean mouse_point_valid_;

   public InteractiveMarkerFeedback()
   {
      header_ = new std_msgs.msg.dds.Header();
      client_id_ = new java.lang.StringBuilder(255);

      marker_name_ = new java.lang.StringBuilder(255);

      control_name_ = new java.lang.StringBuilder(255);

      pose_ = new us.ihmc.euclid.geometry.Pose3D();

      mouse_point_ = new us.ihmc.euclid.tuple3D.Point3D();
   }

   public InteractiveMarkerFeedback(InteractiveMarkerFeedback other)
   {
      set(other);
   }

   public void set(InteractiveMarkerFeedback other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      client_id_.setLength(0);
      client_id_.append(other.client_id_);

      marker_name_.setLength(0);
      marker_name_.append(other.marker_name_);

      control_name_.setLength(0);
      control_name_.append(other.control_name_);

      event_type_ = other.event_type_;

      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.pose_, pose_);
      menu_entry_id_ = other.menu_entry_id_;

      geometry_msgs.msg.dds.PointPubSubType.staticCopy(other.mouse_point_, mouse_point_);
      mouse_point_valid_ = other.mouse_point_valid_;
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public java.lang.String getClientIdAsString()
   {
      return getClientId().toString();
   }

   public java.lang.StringBuilder getClientId()
   {
      return client_id_;
   }

   public void setClientId(String client_id)
   {
      client_id_.setLength(0);
      client_id_.append(client_id);
   }

   public java.lang.String getMarkerNameAsString()
   {
      return getMarkerName().toString();
   }

   public java.lang.StringBuilder getMarkerName()
   {
      return marker_name_;
   }

   public void setMarkerName(String marker_name)
   {
      marker_name_.setLength(0);
      marker_name_.append(marker_name);
   }

   public java.lang.String getControlNameAsString()
   {
      return getControlName().toString();
   }

   public java.lang.StringBuilder getControlName()
   {
      return control_name_;
   }

   public void setControlName(String control_name)
   {
      control_name_.setLength(0);
      control_name_.append(control_name);
   }

   public byte getEventType()
   {
      return event_type_;
   }

   public void setEventType(byte event_type)
   {
      event_type_ = event_type;
   }

   public us.ihmc.euclid.geometry.Pose3D getPose()
   {
      return pose_;
   }

   public long getMenuEntryId()
   {
      return menu_entry_id_;
   }

   public void setMenuEntryId(long menu_entry_id)
   {
      menu_entry_id_ = menu_entry_id;
   }

   public us.ihmc.euclid.tuple3D.Point3D getMousePoint()
   {
      return mouse_point_;
   }

   public boolean getMousePointValid()
   {
      return mouse_point_valid_;
   }

   public void setMousePointValid(boolean mouse_point_valid)
   {
      mouse_point_valid_ = mouse_point_valid;
   }

   @Override
   public boolean epsilonEquals(InteractiveMarkerFeedback other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.client_id_, other.client_id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.marker_name_, other.marker_name_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.control_name_, other.control_name_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.event_type_, other.event_type_, epsilon))
         return false;

      if (!this.pose_.epsilonEquals(other.pose_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.menu_entry_id_, other.menu_entry_id_, epsilon))
         return false;

      if (!this.mouse_point_.epsilonEquals(other.mouse_point_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.mouse_point_valid_, other.mouse_point_valid_, epsilon))
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
      if (!(other instanceof InteractiveMarkerFeedback))
         return false;

      InteractiveMarkerFeedback otherMyClass = (InteractiveMarkerFeedback) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.client_id_, otherMyClass.client_id_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.marker_name_, otherMyClass.marker_name_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.control_name_, otherMyClass.control_name_))
         return false;

      if (this.event_type_ != otherMyClass.event_type_)
         return false;

      if (!this.pose_.equals(otherMyClass.pose_))
         return false;

      if (this.menu_entry_id_ != otherMyClass.menu_entry_id_)
         return false;

      if (!this.mouse_point_.equals(otherMyClass.mouse_point_))
         return false;

      if (this.mouse_point_valid_ != otherMyClass.mouse_point_valid_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("InteractiveMarkerFeedback {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("client_id=");
      builder.append(this.client_id_);

      builder.append(", ");
      builder.append("marker_name=");
      builder.append(this.marker_name_);

      builder.append(", ");
      builder.append("control_name=");
      builder.append(this.control_name_);

      builder.append(", ");
      builder.append("event_type=");
      builder.append(this.event_type_);

      builder.append(", ");
      builder.append("pose=");
      builder.append(this.pose_);

      builder.append(", ");
      builder.append("menu_entry_id=");
      builder.append(this.menu_entry_id_);

      builder.append(", ");
      builder.append("mouse_point=");
      builder.append(this.mouse_point_);

      builder.append(", ");
      builder.append("mouse_point_valid=");
      builder.append(this.mouse_point_valid_);

      builder.append("}");
      return builder.toString();
   }
}