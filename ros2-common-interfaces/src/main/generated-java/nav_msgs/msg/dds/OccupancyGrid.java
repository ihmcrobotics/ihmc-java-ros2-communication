package nav_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "OccupancyGrid" defined in OccupancyGrid_.idl.
 *
 * This file was automatically generated from OccupancyGrid_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit OccupancyGrid_.idl instead.
 */
public class OccupancyGrid implements Settable<OccupancyGrid>, EpsilonComparable<OccupancyGrid>
{
   private std_msgs.msg.dds.Header header_;
   private nav_msgs.msg.dds.MapMetaData info_;
   private us.ihmc.idl.IDLSequence.Byte data_;

   public OccupancyGrid()
   {
      header_ = new std_msgs.msg.dds.Header();
      info_ = new nav_msgs.msg.dds.MapMetaData();
      data_ = new us.ihmc.idl.IDLSequence.Byte(100, "type_9");
   }

   public OccupancyGrid(OccupancyGrid other)
   {
      set(other);
   }

   public void set(OccupancyGrid other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      nav_msgs.msg.dds.MapMetaDataPubSubType.staticCopy(other.info_, info_);
      data_.set(other.data_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public nav_msgs.msg.dds.MapMetaData getInfo()
   {
      return info_;
   }

   public us.ihmc.idl.IDLSequence.Byte getData()
   {
      return data_;
   }

   @Override
   public boolean epsilonEquals(OccupancyGrid other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!this.info_.epsilonEquals(other.info_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.data_, other.data_, epsilon))
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
      if (!(other instanceof OccupancyGrid))
         return false;

      OccupancyGrid otherMyClass = (OccupancyGrid) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.info_.equals(otherMyClass.info_))
         return false;

      if (!this.data_.equals(otherMyClass.data_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("OccupancyGrid {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("info=");
      builder.append(this.info_);

      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}