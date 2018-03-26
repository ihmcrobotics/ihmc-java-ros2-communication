package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This represents a Vector3 with reference coordinate frame and timestamp
 */
public class Vector3Stamped implements Settable<Vector3Stamped>, EpsilonComparable<Vector3Stamped>
{
   private std_msgs.msg.dds.Header header_;
   private us.ihmc.euclid.tuple3D.Vector3D vector_;

   public Vector3Stamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      vector_ = new us.ihmc.euclid.tuple3D.Vector3D();
   }

   public Vector3Stamped(Vector3Stamped other)
   {
      set(other);
   }

   public void set(Vector3Stamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.vector_, vector_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public us.ihmc.euclid.tuple3D.Vector3D getVector()
   {
      return vector_;
   }

   @Override
   public boolean epsilonEquals(Vector3Stamped other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.vector_.epsilonEquals(other.vector_, epsilon))
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
      if (!(other instanceof Vector3Stamped))
         return false;

      Vector3Stamped otherMyClass = (Vector3Stamped) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.vector_.equals(otherMyClass.vector_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Vector3Stamped {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("vector=");
      builder.append(this.vector_);

      builder.append("}");
      return builder.toString();
   }
}