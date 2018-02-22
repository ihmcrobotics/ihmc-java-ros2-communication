package shape_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "MeshTriangle" defined in MeshTriangle_.idl.
 *
 * This file was automatically generated from MeshTriangle_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit MeshTriangle_.idl instead.
 */
public class MeshTriangle implements Settable<MeshTriangle>, EpsilonComparable<MeshTriangle>
{
   private long[] vertex_indices_;

   public MeshTriangle()
   {
      vertex_indices_ = new long[3];
   }

   public MeshTriangle(MeshTriangle other)
   {
      set(other);
   }

   public void set(MeshTriangle other)
   {
      for (int b = 0; b < vertex_indices_.length; ++b)
      {
         vertex_indices_[b] = other.vertex_indices_[b];
      }
   }

   public long[] getVertexIndices()
   {
      return vertex_indices_;
   }

   @Override
   public boolean epsilonEquals(MeshTriangle other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      for (int d = 0; d < vertex_indices_.length; ++d)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.vertex_indices_[d], other.vertex_indices_[d], epsilon))
            return false;
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
      if (!(other instanceof MeshTriangle))
         return false;

      MeshTriangle otherMyClass = (MeshTriangle) other;

      for (int f = 0; f < vertex_indices_.length; ++f)
      {
         if (this.vertex_indices_[f] != otherMyClass.vertex_indices_[f])
            return false;
      }

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MeshTriangle {");
      builder.append("vertex_indices=");
      builder.append(java.util.Arrays.toString(this.vertex_indices_));

      builder.append("}");
      return builder.toString();
   }
}