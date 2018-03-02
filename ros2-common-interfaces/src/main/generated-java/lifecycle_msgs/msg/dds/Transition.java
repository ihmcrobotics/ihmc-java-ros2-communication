package lifecycle_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Default values for transitions
 * as described on
 * http://design.ros2.org/articles/node_lifecycle.html
 */
public class Transition implements Settable<Transition>, EpsilonComparable<Transition>
{
   private byte id_;
   private java.lang.StringBuilder label_;

   public Transition()
   {

      label_ = new java.lang.StringBuilder(255);
   }

   public Transition(Transition other)
   {
      set(other);
   }

   public void set(Transition other)
   {
      id_ = other.id_;

      label_.setLength(0);
      label_.append(other.label_);
   }

   public byte getId()
   {
      return id_;
   }

   public void setId(byte id)
   {
      id_ = id;
   }

   public java.lang.String getLabelAsString()
   {
      return getLabel().toString();
   }

   public java.lang.StringBuilder getLabel()
   {
      return label_;
   }

   public void setLabel(String label)
   {
      label_.setLength(0);
      label_.append(label);
   }

   @Override
   public boolean epsilonEquals(Transition other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.label_, other.label_, epsilon))
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
      if (!(other instanceof Transition))
         return false;

      Transition otherMyClass = (Transition) other;

      if (this.id_ != otherMyClass.id_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.label_, otherMyClass.label_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Transition {");
      builder.append("id=");
      builder.append(this.id_);

      builder.append(", ");
      builder.append("label=");
      builder.append(this.label_);

      builder.append("}");
      return builder.toString();
   }
}