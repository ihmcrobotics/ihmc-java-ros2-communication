package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "InertiaStamped" defined in InertiaStamped_.idl.
 *
 * This file was automatically generated from InertiaStamped_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit InertiaStamped_.idl instead.
 */
public class InertiaStamped implements Settable<InertiaStamped>, EpsilonComparable<InertiaStamped>
{
   private std_msgs.msg.dds.Header header_;
   private geometry_msgs.msg.dds.Inertia inertia_;

   public InertiaStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      inertia_ = new geometry_msgs.msg.dds.Inertia();
   }

   public InertiaStamped(InertiaStamped other)
   {
      set(other);
   }

   public void set(InertiaStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.InertiaPubSubType.staticCopy(other.inertia_, inertia_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public geometry_msgs.msg.dds.Inertia getInertia()
   {
      return inertia_;
   }

   @Override
   public boolean epsilonEquals(InertiaStamped other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.inertia_.epsilonEquals(other.inertia_, epsilon))
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
      if (!(other instanceof InertiaStamped))
         return false;

      InertiaStamped otherMyClass = (InertiaStamped) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.inertia_.equals(otherMyClass.inertia_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("InertiaStamped {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("inertia=");
      builder.append(this.inertia_);

      builder.append("}");
      return builder.toString();
   }
}