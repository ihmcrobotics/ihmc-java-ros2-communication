package shape_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Defines box, sphere, cylinder, and cone.
 * All shapes are defined to have their bounding boxes centered around 0,0,0.
 * The meaning of the shape dimensions: each constant defines the index in the 'dimensions' array.
 * For the CYLINDER and CONE types, the center line is oriented along the Z axis.
 * Therefore the CYLINDER_HEIGHT (CONE_HEIGHT) component of dimensions gives the
 * height of the cylinder (cone).
 * The CYLINDER_RADIUS (CONE_RADIUS) component of dimensions gives the radius of
 * the base of the cylinder (cone).
 * Cone and cylinder primitives are defined to be circular. The tip of the cone
 * is pointing up, along +Z axis.
 */
public class SolidPrimitive implements Settable<SolidPrimitive>, EpsilonComparable<SolidPrimitive>
{
   public static final byte BOX = (byte) 1;
   public static final byte SPHERE = (byte) 2;
   public static final byte CYLINDER = (byte) 3;
   public static final byte CONE = (byte) 4;
   /**
    * For type BOX, the X, Y, and Z dimensions are the length of the corresponding sides of the box.
    */
   public static final byte BOX_X = (byte) 0;
   public static final byte BOX_Y = (byte) 1;
   public static final byte BOX_Z = (byte) 2;
   /**
    * For the SPHERE type, only one component is used, and it gives the radius of the sphere.
    */
   public static final byte SPHERE_RADIUS = (byte) 0;
   public static final byte CYLINDER_HEIGHT = (byte) 0;
   public static final byte CYLINDER_RADIUS = (byte) 1;
   public static final byte CONE_HEIGHT = (byte) 0;
   public static final byte CONE_RADIUS = (byte) 1;
   /**
    * The type of the shape
    */
   private byte type_;
   /**
    * The dimensions of the shape
    * At no point will dimensions have a length > 3.
    */
   private us.ihmc.idl.IDLSequence.Double dimensions_;

   public SolidPrimitive()
   {

      dimensions_ = new us.ihmc.idl.IDLSequence.Double(3, "type_6");
   }

   public SolidPrimitive(SolidPrimitive other)
   {
      set(other);
   }

   public void set(SolidPrimitive other)
   {
      type_ = other.type_;

      dimensions_.set(other.dimensions_);
   }

   /**
    * The type of the shape
    */
   public byte getType()
   {
      return type_;
   }

   /**
    * The type of the shape
    */
   public void setType(byte type)
   {
      type_ = type;
   }

   /**
    * The dimensions of the shape
    * At no point will dimensions have a length > 3.
    */
   public us.ihmc.idl.IDLSequence.Double getDimensions()
   {
      return dimensions_;
   }

   @Override
   public boolean epsilonEquals(SolidPrimitive other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.dimensions_, other.dimensions_, epsilon))
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
      if (!(other instanceof SolidPrimitive))
         return false;

      SolidPrimitive otherMyClass = (SolidPrimitive) other;

      if (this.type_ != otherMyClass.type_)
         return false;

      if (!this.dimensions_.equals(otherMyClass.dimensions_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("SolidPrimitive {");
      builder.append("type=");
      builder.append(this.type_);

      builder.append(", ");
      builder.append("dimensions=");
      builder.append(this.dimensions_);

      builder.append("}");
      return builder.toString();
   }
}