package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "ChannelFloat32" defined in ChannelFloat32_.idl.
 *
 * This file was automatically generated from ChannelFloat32_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit ChannelFloat32_.idl instead.
 */
public class ChannelFloat32 implements Settable<ChannelFloat32>, EpsilonComparable<ChannelFloat32>
{
   /**
    * The channel name should give semantics of the channel (e.g.
    * "intensity" instead of "value").
    */
   private java.lang.StringBuilder name_;
   /**
    * The values array should be 1-1 with the elements of the associated
    * PointCloud.
    */
   private us.ihmc.idl.IDLSequence.Float values_;

   public ChannelFloat32()
   {
      name_ = new java.lang.StringBuilder(255);

      values_ = new us.ihmc.idl.IDLSequence.Float(100, "type_5");
   }

   public ChannelFloat32(ChannelFloat32 other)
   {
      set(other);
   }

   public void set(ChannelFloat32 other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      values_.set(other.values_);
   }

   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }

   /**
    * The values array should be 1-1 with the elements of the associated
    * PointCloud.
    */

   /**
    * The channel name should give semantics of the channel (e.g.
    * "intensity" instead of "value").
    */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   /**
    * The channel name should give semantics of the channel (e.g.
    * "intensity" instead of "value").
    */
   public void setName(String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
    * The values array should be 1-1 with the elements of the associated
    * PointCloud.
    */
   public us.ihmc.idl.IDLSequence.Float getValues()
   {
      return values_;
   }

   @Override
   public boolean epsilonEquals(ChannelFloat32 other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(this.values_, other.values_, epsilon))
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
      if (!(other instanceof ChannelFloat32))
         return false;

      ChannelFloat32 otherMyClass = (ChannelFloat32) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_))
         return false;

      if (!this.values_.equals(otherMyClass.values_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ChannelFloat32 {");
      builder.append("name=");
      builder.append(this.name_);

      builder.append(", ");
      builder.append("values=");
      builder.append(this.values_);

      builder.append("}");
      return builder.toString();
   }
}