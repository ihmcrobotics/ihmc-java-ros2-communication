package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Int64MultiArray" defined in Int64MultiArray_.idl.
 *
 * This file was automatically generated from Int64MultiArray_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Int64MultiArray_.idl instead.
 */
public class Int64MultiArray implements Settable<Int64MultiArray>, EpsilonComparable<Int64MultiArray>
{
   private std_msgs.msg.dds.MultiArrayLayout layout_;
   private us.ihmc.idl.IDLSequence.Long data_;

   public Int64MultiArray()
   {
      layout_ = new std_msgs.msg.dds.MultiArrayLayout();
      data_ = new us.ihmc.idl.IDLSequence.Long(100, "type_11");
   }

   public Int64MultiArray(Int64MultiArray other)
   {
      set(other);
   }

   public void set(Int64MultiArray other)
   {
      std_msgs.msg.dds.MultiArrayLayoutPubSubType.staticCopy(other.layout_, layout_);
      data_.set(other.data_);
   }

   public std_msgs.msg.dds.MultiArrayLayout getLayout()
   {
      return layout_;
   }

   public us.ihmc.idl.IDLSequence.Long getData()
   {
      return data_;
   }

   @Override
   public boolean epsilonEquals(Int64MultiArray other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.layout_.epsilonEquals(other.layout_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(this.data_, other.data_, epsilon))
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
      if (!(other instanceof Int64MultiArray))
         return false;

      Int64MultiArray otherMyClass = (Int64MultiArray) other;

      if (!this.layout_.equals(otherMyClass.layout_))
         return false;

      if (!this.data_.equals(otherMyClass.data_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Int64MultiArray {");
      builder.append("layout=");
      builder.append(this.layout_);

      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}