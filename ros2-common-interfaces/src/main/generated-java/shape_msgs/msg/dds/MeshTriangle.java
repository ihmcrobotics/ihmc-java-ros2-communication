package shape_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of a triangle's vertices.
 */
public class MeshTriangle extends Packet<MeshTriangle> implements Settable<MeshTriangle>, EpsilonComparable<MeshTriangle>
{

   public MeshTriangle()
   {
   }

   public MeshTriangle(MeshTriangle other)
   {
      set(other);
   }

   public void set(MeshTriangle other)
   {
   }

   @Override
   public boolean epsilonEquals(MeshTriangle other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

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

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MeshTriangle {");
      builder.append("}");
      return builder.toString();
   }
}
