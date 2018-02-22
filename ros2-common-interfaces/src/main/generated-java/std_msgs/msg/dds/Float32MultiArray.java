package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Float32MultiArray" defined in Float32MultiArray_.idl.
 *
 * This file was automatically generated from Float32MultiArray_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Float32MultiArray_.idl instead.
 */
public class Float32MultiArray implements Settable<Float32MultiArray>, EpsilonComparable<Float32MultiArray>
{
   private std_msgs.msg.dds.MultiArrayLayout layout_;
   private us.ihmc.idl.IDLSequence.Float data_;

   public Float32MultiArray()
   {
      layout_ = new std_msgs.msg.dds.MultiArrayLayout();
      data_ = new us.ihmc.idl.IDLSequence.Float(100, "type_5");
   }

   public Float32MultiArray(Float32MultiArray other)
   {
      set(other);
   }

   public void set(Float32MultiArray other)
   {
      std_msgs.msg.dds.MultiArrayLayoutPubSubType.staticCopy(other.layout_, layout_);
      data_.set(other.data_);
   }

   public std_msgs.msg.dds.MultiArrayLayout getLayout()
   {
      return layout_;
   }

   public us.ihmc.idl.IDLSequence.Float getData()
   {
      return data_;
   }

   @Override
   public boolean epsilonEquals(Float32MultiArray other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.layout_.epsilonEquals(other.layout_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(this.data_, other.data_, epsilon))
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
      if (!(other instanceof Float32MultiArray))
         return false;

      Float32MultiArray otherMyClass = (Float32MultiArray) other;

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

      builder.append("Float32MultiArray {");
      builder.append("layout=");
      builder.append(this.layout_);

      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}