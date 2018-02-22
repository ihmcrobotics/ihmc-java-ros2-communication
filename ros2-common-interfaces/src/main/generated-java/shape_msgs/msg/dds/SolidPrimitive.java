package shape_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "SolidPrimitive" defined in SolidPrimitive_.idl.
 *
 * This file was automatically generated from SolidPrimitive_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit SolidPrimitive_.idl instead.
 */
public class SolidPrimitive implements Settable<SolidPrimitive>, EpsilonComparable<SolidPrimitive>
{
   private byte type_;
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

   public byte getType()
   {
      return type_;
   }

   public void setType(byte type)
   {
      type_ = type;
   }

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