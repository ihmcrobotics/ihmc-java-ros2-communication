package shape_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Definition of a mesh.
       */
public class Mesh extends Packet<Mesh> implements Settable<Mesh>, EpsilonComparable<Mesh>
{
   /**
            * List of triangles; the index values refer to positions in vertices[].
            */
   public us.ihmc.idl.IDLSequence.Object<shape_msgs.msg.dds.MeshTriangle>  triangles_;
   /**
            * The actual vertices that make up the mesh.
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>  vertices_;

   public Mesh()
   {
      triangles_ = new us.ihmc.idl.IDLSequence.Object<shape_msgs.msg.dds.MeshTriangle> (100, new shape_msgs.msg.dds.MeshTrianglePubSubType());
      vertices_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D> (100, new geometry_msgs.msg.dds.PointPubSubType());

   }

   public Mesh(Mesh other)
   {
      this();
      set(other);
   }

   public void set(Mesh other)
   {
      triangles_.set(other.triangles_);
      vertices_.set(other.vertices_);
   }


   /**
            * List of triangles; the index values refer to positions in vertices[].
            */
   public us.ihmc.idl.IDLSequence.Object<shape_msgs.msg.dds.MeshTriangle>  getTriangles()
   {
      return triangles_;
   }


   /**
            * The actual vertices that make up the mesh.
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>  getVertices()
   {
      return vertices_;
   }


   public static Supplier<MeshPubSubType> getPubSubType()
   {
      return MeshPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MeshPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Mesh other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (this.triangles_.size() != other.triangles_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.triangles_.size(); i++)
         {  if (!this.triangles_.get(i).epsilonEquals(other.triangles_.get(i), epsilon)) return false; }
      }

      if (this.vertices_.size() != other.vertices_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.vertices_.size(); i++)
         {  if (!this.vertices_.get(i).epsilonEquals(other.vertices_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Mesh)) return false;

      Mesh otherMyClass = (Mesh) other;

      if (!this.triangles_.equals(otherMyClass.triangles_)) return false;
      if (!this.vertices_.equals(otherMyClass.vertices_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Mesh {");
      builder.append("triangles=");
      builder.append(this.triangles_);      builder.append(", ");
      builder.append("vertices=");
      builder.append(this.vertices_);
      builder.append("}");
      return builder.toString();
   }
}
