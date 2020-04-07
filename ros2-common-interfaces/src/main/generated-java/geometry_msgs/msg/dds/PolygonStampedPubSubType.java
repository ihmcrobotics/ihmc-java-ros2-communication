package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "PolygonStamped" defined in "PolygonStamped_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from PolygonStamped_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit PolygonStamped_.idl instead.
*
*/
public class PolygonStampedPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.PolygonStamped>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::PolygonStamped_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.PolygonStamped data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.PolygonStamped data) throws java.io.IOException
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


      current_alignment += geometry_msgs.msg.dds.PolygonPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.PolygonStamped data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.PolygonStamped data, int current_alignment)
   {
      int initial_alignment = current_alignment;


      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);


      current_alignment += geometry_msgs.msg.dds.PolygonPubSubType.getCdrSerializedSize(data.getPolygon(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.PolygonStamped data, us.ihmc.idl.CDR cdr)
   {

      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);

      geometry_msgs.msg.dds.PolygonPubSubType.write(data.getPolygon(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.PolygonStamped data, us.ihmc.idl.CDR cdr)
   {

      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	

      geometry_msgs.msg.dds.PolygonPubSubType.read(data.getPolygon(), cdr);	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.PolygonStamped data, us.ihmc.idl.InterchangeSerializer ser)
   {

      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());


      ser.write_type_a("polygon", new geometry_msgs.msg.dds.PolygonPubSubType(), data.getPolygon());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.PolygonStamped data)
   {

      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());


      ser.read_type_a("polygon", new geometry_msgs.msg.dds.PolygonPubSubType(), data.getPolygon());

   }

   public static void staticCopy(geometry_msgs.msg.dds.PolygonStamped src, geometry_msgs.msg.dds.PolygonStamped dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.PolygonStamped createData()
   {
      return new geometry_msgs.msg.dds.PolygonStamped();
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
   
   public void serialize(geometry_msgs.msg.dds.PolygonStamped data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.PolygonStamped data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.PolygonStamped src, geometry_msgs.msg.dds.PolygonStamped dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PolygonStampedPubSubType newInstance()
   {
      return new PolygonStampedPubSubType();
   }
}
