package nav_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This represents a 2-D grid map, in which each cell represents the probability of occupancy.
       */
public class OccupancyGrid extends Packet<OccupancyGrid> implements Settable<OccupancyGrid>, EpsilonComparable<OccupancyGrid>
{
   public std_msgs.msg.dds.Header header_;
   /**
            * MetaData for the map
            */
   public nav_msgs.msg.dds.MapMetaData info_;
   /**
            * The map data, in row-major order, starting with (0,0).  Occupancy
            * probabilities are in the range [0,100].  Unknown is -1.
            */
   public us.ihmc.idl.IDLSequence.Byte  data_;

   public OccupancyGrid()
   {
      header_ = new std_msgs.msg.dds.Header();
      info_ = new nav_msgs.msg.dds.MapMetaData();
      data_ = new us.ihmc.idl.IDLSequence.Byte (100, "type_9");

   }

   public OccupancyGrid(OccupancyGrid other)
   {
      this();
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


   /**
            * MetaData for the map
            */
   public nav_msgs.msg.dds.MapMetaData getInfo()
   {
      return info_;
   }


   /**
            * The map data, in row-major order, starting with (0,0).  Occupancy
            * probabilities are in the range [0,100].  Unknown is -1.
            */
   public us.ihmc.idl.IDLSequence.Byte  getData()
   {
      return data_;
   }


   public static Supplier<OccupancyGridPubSubType> getPubSubType()
   {
      return OccupancyGridPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return OccupancyGridPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(OccupancyGrid other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!this.info_.epsilonEquals(other.info_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.data_, other.data_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof OccupancyGrid)) return false;

      OccupancyGrid otherMyClass = (OccupancyGrid) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.info_.equals(otherMyClass.info_)) return false;
      if (!this.data_.equals(otherMyClass.data_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("OccupancyGrid {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("info=");
      builder.append(this.info_);      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}
