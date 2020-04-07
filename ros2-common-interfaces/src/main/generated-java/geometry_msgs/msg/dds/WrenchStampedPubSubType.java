package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "WrenchStamped" defined in "WrenchStamped_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from WrenchStamped_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit WrenchStamped_.idl instead.
*
*/
public class WrenchStampedPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.WrenchStamped>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::WrenchStamped_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.WrenchStamped data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.WrenchStamped data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;


      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getMaxCdrSerializedSize(current_alignment);


      current_alignment += geometry_msgs.msg.dds.WrenchPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.WrenchStamped data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.WrenchStamped data, int current_alignment)
   {
      int initial_alignment = current_alignment;


      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);


      current_alignment += geometry_msgs.msg.dds.WrenchPubSubType.getCdrSerializedSize(data.getWrench(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.WrenchStamped data, us.ihmc.idl.CDR cdr)
   {

      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);

      geometry_msgs.msg.dds.WrenchPubSubType.write(data.getWrench(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.WrenchStamped data, us.ihmc.idl.CDR cdr)
   {

      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	

      geometry_msgs.msg.dds.WrenchPubSubType.read(data.getWrench(), cdr);	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.WrenchStamped data, us.ihmc.idl.InterchangeSerializer ser)
   {

      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());


      ser.write_type_a("wrench", new geometry_msgs.msg.dds.WrenchPubSubType(), data.getWrench());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.WrenchStamped data)
   {

      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());


      ser.read_type_a("wrench", new geometry_msgs.msg.dds.WrenchPubSubType(), data.getWrench());

   }

   public static void staticCopy(geometry_msgs.msg.dds.WrenchStamped src, geometry_msgs.msg.dds.WrenchStamped dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.WrenchStamped createData()
   {
      return new geometry_msgs.msg.dds.WrenchStamped();
   }
   @Override
   public int getTypeSize()
   {
      return us.ihmc.idl.CDR.getTypeSize(getMaxCdrSerializedSize());
   }

   @Override
   public java.lang.String getName()
   {
      return name;
   }
   
   public void serialize(geometry_msgs.msg.dds.WrenchStamped data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.WrenchStamped data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.WrenchStamped src, geometry_msgs.msg.dds.WrenchStamped dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public WrenchStampedPubSubType newInstance()
   {
      return new WrenchStampedPubSubType();
   }
}
