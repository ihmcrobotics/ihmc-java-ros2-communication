package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Represents a control that is to be displayed together with an interactive marker
 */
public class InteractiveMarkerControl implements Settable<InteractiveMarkerControl>, EpsilonComparable<InteractiveMarkerControl>
{
   /**
    * Orientation mode: controls how orientation changes.
    * INHERIT: Follow orientation of interactive marker
    * FIXED: Keep orientation fixed at initial state
    * VIEW_FACING: Align y-z plane with screen (x: forward, y:left, z:up).
    */
   public static final byte INHERIT = (byte) 0;
   public static final byte FIXED = (byte) 1;
   public static final byte VIEW_FACING = (byte) 2;
   /**
    * Interaction mode for this control
    *
    * NONE: This control is only meant for visualization; no context menu.
    * MENU: Like NONE, but right-click menu is active.
    * BUTTON: Element can be left-clicked.
    * MOVE_AXIS: Translate along local x-axis.
    * MOVE_PLANE: Translate in local y-z plane.
    * ROTATE_AXIS: Rotate around local x-axis.
    * MOVE_ROTATE: Combines MOVE_PLANE and ROTATE_AXIS.
    */
   public static final byte NONE = (byte) 0;
   public static final byte MENU = (byte) 1;
   public static final byte BUTTON = (byte) 2;
   public static final byte MOVE_AXIS = (byte) 3;
   public static final byte MOVE_PLANE = (byte) 4;
   public static final byte ROTATE_AXIS = (byte) 5;
   public static final byte MOVE_ROTATE = (byte) 6;
   /**
    * "3D" interaction modes work with the mouse+SHIFT+CTRL or with 3D cursors.
    * MOVE_3D: Translate freely in 3D space.
    * ROTATE_3D: Rotate freely in 3D space about the origin of parent frame.
    * MOVE_ROTATE_3D: Full 6-DOF freedom of translation and rotation about the cursor origin.
    */
   public static final byte MOVE_3D = (byte) 7;
   public static final byte ROTATE_3D = (byte) 8;
   public static final byte MOVE_ROTATE_3D = (byte) 9;
   /**
    * Identifying string for this control.
    * You need to assign a unique value to this to receive feedback from the GUI
    * on what actions the user performs on this control (e.g. a button click).
    */
   public java.lang.StringBuilder name_;
   /**
    * Defines the local coordinate frame (relative to the pose of the parent
    * interactive marker) in which is being rotated and translated.
    * Default: Identity
    */
   public us.ihmc.euclid.tuple4D.Quaternion orientation_;
   public byte orientation_mode_;
   public byte interaction_mode_;
   /**
    * If true, the contained markers will also be visible
    * when the gui is not in interactive mode.
    */
   public boolean always_visible_;
   /**
    * Markers to be displayed as custom visual representation.
    * Leave this empty to use the default control handles.
    *
    * Note:
    * - The markers can be defined in an arbitrary coordinate frame,
    * but will be transformed into the local frame of the interactive marker.
    * - If the header of a marker is empty, its pose will be interpreted as
    * relative to the pose of the parent interactive marker.
    */
   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.Marker> markers_;
   /**
    * In VIEW_FACING mode, set this to true if you don't want the markers
    * to be aligned with the camera view point. The markers will show up
    * as in INHERIT mode.
    */
   public boolean independent_marker_orientation_;
   /**
    * Short description (< 40 characters) of what this control does,
    * e.g. "Move the robot".
    * Default: A generic description based on the interaction mode
    */
   public java.lang.StringBuilder description_;

   public InteractiveMarkerControl()
   {
      name_ = new java.lang.StringBuilder(255);

      orientation_ = new us.ihmc.euclid.tuple4D.Quaternion();

      markers_ = new us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.Marker>(100, visualization_msgs.msg.dds.Marker.class,
                                                                                       new visualization_msgs.msg.dds.MarkerPubSubType());

      description_ = new java.lang.StringBuilder(255);
   }

   public InteractiveMarkerControl(InteractiveMarkerControl other)
   {
      set(other);
   }

   public void set(InteractiveMarkerControl other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      geometry_msgs.msg.dds.QuaternionPubSubType.staticCopy(other.orientation_, orientation_);
      orientation_mode_ = other.orientation_mode_;

      interaction_mode_ = other.interaction_mode_;

      always_visible_ = other.always_visible_;

      markers_.set(other.markers_);
      independent_marker_orientation_ = other.independent_marker_orientation_;

      description_.setLength(0);
      description_.append(other.description_);
   }

   /**
    * Identifying string for this control.
    * You need to assign a unique value to this to receive feedback from the GUI
    * on what actions the user performs on this control (e.g. a button click).
    */
   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }

   /**
    * Identifying string for this control.
    * You need to assign a unique value to this to receive feedback from the GUI
    * on what actions the user performs on this control (e.g. a button click).
    */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   /**
    * Identifying string for this control.
    * You need to assign a unique value to this to receive feedback from the GUI
    * on what actions the user performs on this control (e.g. a button click).
    */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
    * Defines the local coordinate frame (relative to the pose of the parent
    * interactive marker) in which is being rotated and translated.
    * Default: Identity
    */
   public us.ihmc.euclid.tuple4D.Quaternion getOrientation()
   {
      return orientation_;
   }

   public byte getOrientationMode()
   {
      return orientation_mode_;
   }

   public void setOrientationMode(byte orientation_mode)
   {
      orientation_mode_ = orientation_mode;
   }

   public byte getInteractionMode()
   {
      return interaction_mode_;
   }

   public void setInteractionMode(byte interaction_mode)
   {
      interaction_mode_ = interaction_mode;
   }

   /**
    * If true, the contained markers will also be visible
    * when the gui is not in interactive mode.
    */
   public boolean getAlwaysVisible()
   {
      return always_visible_;
   }

   /**
    * If true, the contained markers will also be visible
    * when the gui is not in interactive mode.
    */
   public void setAlwaysVisible(boolean always_visible)
   {
      always_visible_ = always_visible;
   }

   /**
    * Markers to be displayed as custom visual representation.
    * Leave this empty to use the default control handles.
    *
    * Note:
    * - The markers can be defined in an arbitrary coordinate frame,
    * but will be transformed into the local frame of the interactive marker.
    * - If the header of a marker is empty, its pose will be interpreted as
    * relative to the pose of the parent interactive marker.
    */
   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.Marker> getMarkers()
   {
      return markers_;
   }

   /**
    * In VIEW_FACING mode, set this to true if you don't want the markers
    * to be aligned with the camera view point. The markers will show up
    * as in INHERIT mode.
    */
   public boolean getIndependentMarkerOrientation()
   {
      return independent_marker_orientation_;
   }

   /**
    * In VIEW_FACING mode, set this to true if you don't want the markers
    * to be aligned with the camera view point. The markers will show up
    * as in INHERIT mode.
    */
   public void setIndependentMarkerOrientation(boolean independent_marker_orientation)
   {
      independent_marker_orientation_ = independent_marker_orientation;
   }

   /**
    * Short description (< 40 characters) of what this control does,
    * e.g. "Move the robot".
    * Default: A generic description based on the interaction mode
    */
   public java.lang.String getDescriptionAsString()
   {
      return getDescription().toString();
   }

   /**
    * Short description (< 40 characters) of what this control does,
    * e.g. "Move the robot".
    * Default: A generic description based on the interaction mode
    */
   public java.lang.StringBuilder getDescription()
   {
      return description_;
   }

   /**
    * Short description (< 40 characters) of what this control does,
    * e.g. "Move the robot".
    * Default: A generic description based on the interaction mode
    */
   public void setDescription(java.lang.String description)
   {
      description_.setLength(0);
      description_.append(description);
   }

   @Override
   public boolean epsilonEquals(InteractiveMarkerControl other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon))
         return false;

      if (!this.orientation_.epsilonEquals(other.orientation_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.orientation_mode_, other.orientation_mode_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.interaction_mode_, other.interaction_mode_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.always_visible_, other.always_visible_, epsilon))
         return false;

      if (this.markers_.size() == other.markers_.size())
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

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.independent_marker_orientation_, other.independent_marker_orientation_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.description_, other.description_, epsilon))
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
      if (!(other instanceof InteractiveMarkerControl))
         return false;

      InteractiveMarkerControl otherMyClass = (InteractiveMarkerControl) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_))
         return false;

      if (!this.orientation_.equals(otherMyClass.orientation_))
         return false;

      if (this.orientation_mode_ != otherMyClass.orientation_mode_)
         return false;

      if (this.interaction_mode_ != otherMyClass.interaction_mode_)
         return false;

      if (this.always_visible_ != otherMyClass.always_visible_)
         return false;

      if (!this.markers_.equals(otherMyClass.markers_))
         return false;

      if (this.independent_marker_orientation_ != otherMyClass.independent_marker_orientation_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.description_, otherMyClass.description_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("InteractiveMarkerControl {");
      builder.append("name=");
      builder.append(this.name_);

      builder.append(", ");
      builder.append("orientation=");
      builder.append(this.orientation_);

      builder.append(", ");
      builder.append("orientation_mode=");
      builder.append(this.orientation_mode_);

      builder.append(", ");
      builder.append("interaction_mode=");
      builder.append(this.interaction_mode_);

      builder.append(", ");
      builder.append("always_visible=");
      builder.append(this.always_visible_);

      builder.append(", ");
      builder.append("markers=");
      builder.append(this.markers_);

      builder.append(", ");
      builder.append("independent_marker_orientation=");
      builder.append(this.independent_marker_orientation_);

      builder.append(", ");
      builder.append("description=");
      builder.append(this.description_);

      builder.append("}");
      return builder.toString();
   }
}