package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Int32MultiArray" defined in Int32MultiArray_.idl.
 *
 * This file was automatically generated from Int32MultiArray_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Int32MultiArray_.idl instead.
 */
public class Int32MultiArray implements Settable<Int32MultiArray>, EpsilonComparable<Int32MultiArray>
{
   /**
    * specification of data layout
    */
   private std_msgs.msg.dds.MultiArrayLayout layout_;
   /**
    * array of data
    */
   private us.ihmc.idl.IDLSequence.Integer data_;

   public Int32MultiArray()
   {
      layout_ = new std_msgs.msg.dds.MultiArrayLayout();
      data_ = new us.ihmc.idl.IDLSequence.Integer(100, "type_2");
   }

   /**
    * specification of data layout
    */

   public Int32MultiArray(Int32MultiArray other)
   {
      set(other);
   }

   /**
    * array of data
    */

   public void set(Int32MultiArray other)
   {
      std_msgs.msg.dds.MultiArrayLayoutPubSubType.staticCopy(other.layout_, layout_);
      data_.set(other.data_);
   }

   /**
    * specification of data layout
    */
   public std_msgs.msg.dds.MultiArrayLayout getLayout()
   {
      return layout_;
   }

   /**
    * array of data
    */
   public us.ihmc.idl.IDLSequence.Integer getData()
   {
      return data_;
   }

   @Override
   public boolean epsilonEquals(Int32MultiArray other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.layout_.epsilonEquals(other.layout_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(this.data_, other.data_, epsilon))
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
      if (!(other instanceof Int32MultiArray))
         return false;

      Int32MultiArray otherMyClass = (Int32MultiArray) other;

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

      builder.append("Int32MultiArray {");
      builder.append("layout=");
      builder.append(this.layout_);

      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}