package nav_msgs.msg.dds;

/**
 * Topic data type of the struct "MapMetaData" defined in "MapMetaData_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from MapMetaData_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit MapMetaData_.idl instead.
 */
public class MapMetaDataPubSubType implements us.ihmc.pubsub.TopicDataType<nav_msgs.msg.dds.MapMetaData>
{
   public static final java.lang.String name = "nav_msgs::msg::dds_::MapMetaData_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();
   public MapMetaDataPubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getMaxCdrSerializedSize(current_alignment);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.MapMetaData data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.MapMetaData data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getMapLoadTime(), current_alignment);
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getCdrSerializedSize(data.getOrigin(), current_alignment);

      return current_alignment - initial_alignment;
   }

   public static void write(nav_msgs.msg.dds.MapMetaData data, us.ihmc.idl.CDR cdr)
   {

      builtin_interfaces.msg.dds.TimePubSubType.write(data.getMapLoadTime(), cdr);

      cdr.write_type_5(data.getResolution());

      cdr.write_type_4(data.getWidth());

      cdr.write_type_4(data.getHeight());

      geometry_msgs.msg.dds.PosePubSubType.write(data.getOrigin(), cdr);
   }

   public static void read(nav_msgs.msg.dds.MapMetaData data, us.ihmc.idl.CDR cdr)
   {

      builtin_interfaces.msg.dds.TimePubSubType.read(data.getMapLoadTime(), cdr);

      data.setResolution(cdr.read_type_5());

      data.setWidth(cdr.read_type_4());

      data.setHeight(cdr.read_type_4());

      geometry_msgs.msg.dds.PosePubSubType.read(data.getOrigin(), cdr);
   }

   public static void staticCopy(nav_msgs.msg.dds.MapMetaData src, nav_msgs.msg.dds.MapMetaData dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(nav_msgs.msg.dds.MapMetaData data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, nav_msgs.msg.dds.MapMetaData data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(nav_msgs.msg.dds.MapMetaData data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("map_load_time", new builtin_interfaces.msg.dds.TimePubSubType(), data.getMapLoadTime());

      ser.write_type_5("resolution", data.getResolution());

      ser.write_type_4("width", data.getWidth());

      ser.write_type_4("height", data.getHeight());

      ser.write_type_a("origin", new geometry_msgs.msg.dds.PosePubSubType(), data.getOrigin());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, nav_msgs.msg.dds.MapMetaData data)
   {
      ser.read_type_a("map_load_time", new builtin_interfaces.msg.dds.TimePubSubType(), data.getMapLoadTime());

      data.setResolution(ser.read_type_5("resolution"));

      data.setWidth(ser.read_type_4("width"));

      data.setHeight(ser.read_type_4("height"));

      ser.read_type_a("origin", new geometry_msgs.msg.dds.PosePubSubType(), data.getOrigin());
   }

   @Override
   public nav_msgs.msg.dds.MapMetaData createData()
   {
      return new nav_msgs.msg.dds.MapMetaData();
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

   public void serialize(nav_msgs.msg.dds.MapMetaData data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(nav_msgs.msg.dds.MapMetaData data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(nav_msgs.msg.dds.MapMetaData src, nav_msgs.msg.dds.MapMetaData dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MapMetaDataPubSubType newInstance()
   {
      return new MapMetaDataPubSubType();
   }
}
