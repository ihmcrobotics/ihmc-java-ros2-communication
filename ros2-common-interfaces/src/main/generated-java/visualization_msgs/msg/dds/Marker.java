package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Marker" defined in Marker_.idl.
 *
 * This file was automatically generated from Marker_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Marker_.idl instead.
 */
public class Marker implements Settable<Marker>, EpsilonComparable<Marker>
{
   private std_msgs.msg.dds.Header header_;
   private java.lang.StringBuilder ns_;
   private int id_;
   private int type_;
   private int action_;
   private us.ihmc.euclid.geometry.Pose3D pose_;
   private us.ihmc.euclid.tuple3D.Vector3D scale_;
   private std_msgs.msg.dds.ColorRGBA color_;
   private builtin_interfaces.msg.dds.Duration lifetime_;
   private boolean frame_locked_;
   private us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D> points_;
   private us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA> colors_;
   private java.lang.StringBuilder text_;
   private java.lang.StringBuilder mesh_resource_;
   private boolean mesh_use_embedded_materials_;

   public Marker()
   {
      header_ = new std_msgs.msg.dds.Header();
      ns_ = new java.lang.StringBuilder(255);

      pose_ = new us.ihmc.euclid.geometry.Pose3D();
      scale_ = new us.ihmc.euclid.tuple3D.Vector3D();
      color_ = new std_msgs.msg.dds.ColorRGBA();
      lifetime_ = new builtin_interfaces.msg.dds.Duration();

      points_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>(100, us.ihmc.euclid.tuple3D.Point3D.class,
                                                                                   new geometry_msgs.msg.dds.PointPubSubType());

      colors_ = new us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA>(100, std_msgs.msg.dds.ColorRGBA.class,
                                                                               new std_msgs.msg.dds.ColorRGBAPubSubType());

      text_ = new java.lang.StringBuilder(255);

      mesh_resource_ = new java.lang.StringBuilder(255);
   }

   public Marker(Marker other)
   {
      set(other);
   }

   public void set(Marker other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      ns_.setLength(0);
      ns_.append(other.ns_);

      id_ = other.id_;

      type_ = other.type_;

      action_ = other.action_;

      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.pose_, pose_);
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.scale_, scale_);
      std_msgs.msg.dds.ColorRGBAPubSubType.staticCopy(other.color_, color_);
      builtin_interfaces.msg.dds.DurationPubSubType.staticCopy(other.lifetime_, lifetime_);
      frame_locked_ = other.frame_locked_;

      points_.set(other.points_);
      colors_.set(other.colors_);
      text_.setLength(0);
      text_.append(other.text_);

      mesh_resource_.setLength(0);
      mesh_resource_.append(other.mesh_resource_);

      mesh_use_embedded_materials_ = other.mesh_use_embedded_materials_;
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public java.lang.String getNsAsString()
   {
      return getNs().toString();
   }

   public java.lang.StringBuilder getNs()
   {
      return ns_;
   }

   public void setNs(String ns)
   {
      ns_.setLength(0);
      ns_.append(ns);
   }

   public int getId()
   {
      return id_;
   }

   public void setId(int id)
   {
      id_ = id;
   }

   public int getType()
   {
      return type_;
   }

   public void setType(int type)
   {
      type_ = type;
   }

   public int getAction()
   {
      return action_;
   }

   public void setAction(int action)
   {
      action_ = action;
   }

   public us.ihmc.euclid.geometry.Pose3D getPose()
   {
      return pose_;
   }

   public us.ihmc.euclid.tuple3D.Vector3D getScale()
   {
      return scale_;
   }

   public std_msgs.msg.dds.ColorRGBA getColor()
   {
      return color_;
   }

   public builtin_interfaces.msg.dds.Duration getLifetime()
   {
      return lifetime_;
   }

   public boolean getFrameLocked()
   {
      return frame_locked_;
   }

   public void setFrameLocked(boolean frame_locked)
   {
      frame_locked_ = frame_locked;
   }

   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D> getPoints()
   {
      return points_;
   }

   public us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA> getColors()
   {
      return colors_;
   }

   public java.lang.String getTextAsString()
   {
      return getText().toString();
   }

   public java.lang.StringBuilder getText()
   {
      return text_;
   }

   public void setText(String text)
   {
      text_.setLength(0);
      text_.append(text);
   }

   public java.lang.String getMeshResourceAsString()
   {
      return getMeshResource().toString();
   }

   public java.lang.StringBuilder getMeshResource()
   {
      return mesh_resource_;
   }

   public void setMeshResource(String mesh_resource)
   {
      mesh_resource_.setLength(0);
      mesh_resource_.append(mesh_resource);
   }

   public boolean getMeshUseEmbeddedMaterials()
   {
      return mesh_use_embedded_materials_;
   }

   public void setMeshUseEmbeddedMaterials(boolean mesh_use_embedded_materials)
   {
      mesh_use_embedded_materials_ = mesh_use_embedded_materials;
   }

   @Override
   public boolean epsilonEquals(Marker other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.ns_, other.ns_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.action_, other.action_, epsilon))
         return false;

      if (!this.pose_.epsilonEquals(other.pose_, epsilon))
         return false;

      if (!this.scale_.epsilonEquals(other.scale_, epsilon))
         return false;

      if (!this.color_.epsilonEquals(other.color_, epsilon))
         return false;

      if (!this.lifetime_.epsilonEquals(other.lifetime_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.frame_locked_, other.frame_locked_, epsilon))
         return false;

      if (this.points_.isEnum())
      {
         if (!this.points_.equals(other.points_))
            return false;
      }
      else if (this.points_.size() == other.points_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.points_.size(); i++)
         {
            if (!this.points_.get(i).epsilonEquals(other.points_.get(i), epsilon))
               return false;
         }
      }

      if (this.colors_.isEnum())
      {
         if (!this.colors_.equals(other.colors_))
            return false;
      }
      else if (this.colors_.size() == other.colors_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.colors_.size(); i++)
         {
            if (!this.colors_.get(i).epsilonEquals(other.colors_.get(i), epsilon))
               return false;
         }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.text_, other.text_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.mesh_resource_, other.mesh_resource_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.mesh_use_embedded_materials_, other.mesh_use_embedded_materials_, epsilon))
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
      if (!(other instanceof Marker))
         return false;

      Marker otherMyClass = (Marker) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.ns_, otherMyClass.ns_))
         return false;

      if (this.id_ != otherMyClass.id_)
         return false;

      if (this.type_ != otherMyClass.type_)
         return false;

      if (this.action_ != otherMyClass.action_)
         return false;

      if (!this.pose_.equals(otherMyClass.pose_))
         return false;

      if (!this.scale_.equals(otherMyClass.scale_))
         return false;

      if (!this.color_.equals(otherMyClass.color_))
         return false;

      if (!this.lifetime_.equals(otherMyClass.lifetime_))
         return false;

      if (this.frame_locked_ != otherMyClass.frame_locked_)
         return false;

      if (!this.points_.equals(otherMyClass.points_))
         return false;

      if (!this.colors_.equals(otherMyClass.colors_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.text_, otherMyClass.text_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.mesh_resource_, otherMyClass.mesh_resource_))
         return false;

      if (this.mesh_use_embedded_materials_ != otherMyClass.mesh_use_embedded_materials_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Marker {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("ns=");
      builder.append(this.ns_);

      builder.append(", ");
      builder.append("id=");
      builder.append(this.id_);

      builder.append(", ");
      builder.append("type=");
      builder.append(this.type_);

      builder.append(", ");
      builder.append("action=");
      builder.append(this.action_);

      builder.append(", ");
      builder.append("pose=");
      builder.append(this.pose_);

      builder.append(", ");
      builder.append("scale=");
      builder.append(this.scale_);

      builder.append(", ");
      builder.append("color=");
      builder.append(this.color_);

      builder.append(", ");
      builder.append("lifetime=");
      builder.append(this.lifetime_);

      builder.append(", ");
      builder.append("frame_locked=");
      builder.append(this.frame_locked_);

      builder.append(", ");
      builder.append("points=");
      builder.append(this.points_);

      builder.append(", ");
      builder.append("colors=");
      builder.append(this.colors_);

      builder.append(", ");
      builder.append("text=");
      builder.append(this.text_);

      builder.append(", ");
      builder.append("mesh_resource=");
      builder.append(this.mesh_resource_);

      builder.append(", ");
      builder.append("mesh_use_embedded_materials=");
      builder.append(this.mesh_use_embedded_materials_);

      builder.append("}");
      return builder.toString();
   }
}