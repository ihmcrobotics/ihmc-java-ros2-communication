package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Float64MultiArray" defined in Float64MultiArray_.idl.
 *
 * This file was automatically generated from Float64MultiArray_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Float64MultiArray_.idl instead.
 */
public class Float64MultiArray implements Settable<Float64MultiArray>, EpsilonComparable<Float64MultiArray>
{
   /**
    * specification of data layout
    */
   private std_msgs.msg.dds.MultiArrayLayout layout_;
   /**
    * array of data
    */
   private us.ihmc.idl.IDLSequence.Double data_;

   public Float64MultiArray()
   {
      layout_ = new std_msgs.msg.dds.MultiArrayLayout();
      data_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");
   }

   /**
    * specification of data layout
    */

   public Float64MultiArray(Float64MultiArray other)
   {
      set(other);
   }

   /**
    * array of data
    */

   public void set(Float64MultiArray other)
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
   public us.ihmc.idl.IDLSequence.Double getData()
   {
      return data_;
   }

   @Override
   public boolean epsilonEquals(Float64MultiArray other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.layout_.epsilonEquals(other.layout_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.data_, other.data_, epsilon))
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
      if (!(other instanceof Float64MultiArray))
         return false;

      Float64MultiArray otherMyClass = (Float64MultiArray) other;

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

      builder.append("Float64MultiArray {");
      builder.append("layout=");
      builder.append(this.layout_);

      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}