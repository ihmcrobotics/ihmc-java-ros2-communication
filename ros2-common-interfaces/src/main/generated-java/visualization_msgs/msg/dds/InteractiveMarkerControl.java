package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "InteractiveMarkerControl" defined in InteractiveMarkerControl_.idl.
 *
 * This file was automatically generated from InteractiveMarkerControl_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit InteractiveMarkerControl_.idl instead.
 */
public class InteractiveMarkerControl implements Settable<InteractiveMarkerControl>, EpsilonComparable<InteractiveMarkerControl>
{
   private java.lang.StringBuilder name_;
   private us.ihmc.euclid.tuple4D.Quaternion orientation_;
   private byte orientation_mode_;
   private byte interaction_mode_;
   private boolean always_visible_;
   private us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.Marker> markers_;
   private boolean independent_marker_orientation_;
   private java.lang.StringBuilder description_;

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

   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }

   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   public void setName(String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

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

   public boolean getAlwaysVisible()
   {
      return always_visible_;
   }

   public void setAlwaysVisible(boolean always_visible)
   {
      always_visible_ = always_visible;
   }

   public us.ihmc.idl.IDLSequence.Object<visualization_msgs.msg.dds.Marker> getMarkers()
   {
      return markers_;
   }

   public boolean getIndependentMarkerOrientation()
   {
      return independent_marker_orientation_;
   }

   public void setIndependentMarkerOrientation(boolean independent_marker_orientation)
   {
      independent_marker_orientation_ = independent_marker_orientation;
   }

   public java.lang.String getDescriptionAsString()
   {
      return getDescription().toString();
   }

   public java.lang.StringBuilder getDescription()
   {
      return description_;
   }

   public void setDescription(String description)
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