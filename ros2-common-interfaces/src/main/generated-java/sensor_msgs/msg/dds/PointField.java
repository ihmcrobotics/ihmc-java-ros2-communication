package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "PointField" defined in PointField_.idl.
 *
 * This file was automatically generated from PointField_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit PointField_.idl instead.
 */
public class PointField implements Settable<PointField>, EpsilonComparable<PointField>
{
   private java.lang.StringBuilder name_;
   private long offset_;
   private byte datatype_;
   private long count_;

   public PointField()
   {
      name_ = new java.lang.StringBuilder(255);
   }

   public PointField(PointField other)
   {
      set(other);
   }

   public void set(PointField other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      offset_ = other.offset_;

      datatype_ = other.datatype_;

      count_ = other.count_;
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

   public long getOffset()
   {
      return offset_;
   }

   public void setOffset(long offset)
   {
      offset_ = offset;
   }

   public byte getDatatype()
   {
      return datatype_;
   }

   public void setDatatype(byte datatype)
   {
      datatype_ = datatype;
   }

   public long getCount()
   {
      return count_;
   }

   public void setCount(long count)
   {
      count_ = count;
   }

   @Override
   public boolean epsilonEquals(PointField other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.offset_, other.offset_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.datatype_, other.datatype_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.count_, other.count_, epsilon))
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
      if (!(other instanceof PointField))
         return false;

      PointField otherMyClass = (PointField) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_))
         return false;

      if (this.offset_ != otherMyClass.offset_)
         return false;

      if (this.datatype_ != otherMyClass.datatype_)
         return false;

      if (this.count_ != otherMyClass.count_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PointField {");
      builder.append("name=");
      builder.append(this.name_);

      builder.append(", ");
      builder.append("offset=");
      builder.append(this.offset_);

      builder.append(", ");
      builder.append("datatype=");
      builder.append(this.datatype_);

      builder.append(", ");
      builder.append("count=");
      builder.append(this.count_);

      builder.append("}");
      return builder.toString();
   }
}