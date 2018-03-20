package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Feedback message sent back from the GUI, e.g.
 * when the status of an interactive marker was modified by the user.
 */
public class InteractiveMarkerFeedback implements Settable<InteractiveMarkerFeedback>, EpsilonComparable<InteractiveMarkerFeedback>
{
   /**
    * Type of the event
    * KEEP_ALIVE: sent while dragging to keep up control of the marker
    * MENU_SELECT: a menu entry has been selected
    * BUTTON_CLICK: a button control has been clicked
    * POSE_UPDATE: the pose has been changed using one of the controls
    */
   public static final byte KEEP_ALIVE = (byte) 0;
   public static final byte POSE_UPDATE = (byte) 1;
   public static final byte MENU_SELECT = (byte) 2;
   public static final byte BUTTON_CLICK = (byte) 3;
   public static final byte MOUSE_DOWN = (byte) 4;
   public static final byte MOUSE_UP = (byte) 5;
   /**
    * Time/frame info.
    */
   private std_msgs.msg.dds.Header header_;
   /**
    * Identifying string. Must be unique in the topic namespace.
    */
   private java.lang.StringBuilder client_id_;
   /**
    * Specifies which interactive marker and control this message refers to
    */
   private java.lang.StringBuilder marker_name_;
   private java.lang.StringBuilder control_name_;
   private byte event_type_;
   /**
    * Current pose of the marker
    * Note: Has to be valid for all feedback types.
    */
   private us.ihmc.euclid.geometry.Pose3D pose_;
   /**
    * Contains the ID of the selected menu entry
    * Only valid for MENU_SELECT events.
    */
   private long menu_entry_id_;
   /**
    * If event_type is BUTTON_CLICK, MOUSE_DOWN, or MOUSE_UP, mouse_point
    * may contain the 3 dimensional position of the event on the
    * control.  If it does, mouse_point_valid will be true.  mouse_point
    * will be relative to the frame listed in the header.
    */
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

   /**
    * Time/frame info.
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * Identifying string. Must be unique in the topic namespace.
    */
   public java.lang.String getClientIdAsString()
   {
      return getClientId().toString();
   }

   /**
    * Identifying string. Must be unique in the topic namespace.
    */
   public java.lang.StringBuilder getClientId()
   {
      return client_id_;
   }

   /**
    * Identifying string. Must be unique in the topic namespace.
    */
   public void setClientId(java.lang.String client_id)
   {
      client_id_.setLength(0);
      client_id_.append(client_id);
   }

   /**
    * Specifies which interactive marker and control this message refers to
    */
   public java.lang.String getMarkerNameAsString()
   {
      return getMarkerName().toString();
   }

   /**
    * Specifies which interactive marker and control this message refers to
    */
   public java.lang.StringBuilder getMarkerName()
   {
      return marker_name_;
   }

   /**
    * Specifies which interactive marker and control this message refers to
    */
   public void setMarkerName(java.lang.String marker_name)
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

   public void setControlName(java.lang.String control_name)
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

   /**
    * Current pose of the marker
    * Note: Has to be valid for all feedback types.
    */
   public us.ihmc.euclid.geometry.Pose3D getPose()
   {
      return pose_;
   }

   /**
    * Contains the ID of the selected menu entry
    * Only valid for MENU_SELECT events.
    */
   public long getMenuEntryId()
   {
      return menu_entry_id_;
   }

   /**
    * Contains the ID of the selected menu entry
    * Only valid for MENU_SELECT events.
    */
   public void setMenuEntryId(long menu_entry_id)
   {
      menu_entry_id_ = menu_entry_id;
   }

   /**
    * If event_type is BUTTON_CLICK, MOUSE_DOWN, or MOUSE_UP, mouse_point
    * may contain the 3 dimensional position of the event on the
    * control.  If it does, mouse_point_valid will be true.  mouse_point
    * will be relative to the frame listed in the header.
    */
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