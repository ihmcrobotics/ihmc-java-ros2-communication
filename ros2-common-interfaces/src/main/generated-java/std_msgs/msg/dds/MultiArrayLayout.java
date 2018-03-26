package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * The multiarray declares a generic multi-dimensional array of a
 * particular data type.  Dimensions are ordered from outer most
 * to inner most.
 */
public class MultiArrayLayout implements Settable<MultiArrayLayout>, EpsilonComparable<MultiArrayLayout>
{
   /**
    * Array of dimension properties
    */
   private us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.MultiArrayDimension> dim_;
   /**
    * padding bytes at front of data
    */
   private long data_offset_;

   public MultiArrayLayout()
   {
      dim_ = new us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.MultiArrayDimension>(100, std_msgs.msg.dds.MultiArrayDimension.class,
                                                                                      new std_msgs.msg.dds.MultiArrayDimensionPubSubType());
   }

   public MultiArrayLayout(MultiArrayLayout other)
   {
      set(other);
   }

   public void set(MultiArrayLayout other)
   {
      dim_.set(other.dim_);
      data_offset_ = other.data_offset_;
   }

   /**
    * Array of dimension properties
    */
   public us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.MultiArrayDimension> getDim()
   {
      return dim_;
   }

   /**
    * padding bytes at front of data
    */
   public long getDataOffset()
   {
      return data_offset_;
   }

   /**
    * padding bytes at front of data
    */
   public void setDataOffset(long data_offset)
   {
      data_offset_ = data_offset;
   }

   @Override
   public boolean epsilonEquals(MultiArrayLayout other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (this.dim_.size() == other.dim_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.dim_.size(); i++)
         {
            if (!this.dim_.get(i).epsilonEquals(other.dim_.get(i), epsilon))
               return false;
         }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.data_offset_, other.data_offset_, epsilon))
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
      if (!(other instanceof MultiArrayLayout))
         return false;

      MultiArrayLayout otherMyClass = (MultiArrayLayout) other;

      if (!this.dim_.equals(otherMyClass.dim_))
         return false;

      if (this.data_offset_ != otherMyClass.data_offset_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MultiArrayLayout {");
      builder.append("dim=");
      builder.append(this.dim_);

      builder.append(", ");
      builder.append("data_offset=");
      builder.append(this.data_offset_);

      builder.append("}");
      return builder.toString();
   }
}
