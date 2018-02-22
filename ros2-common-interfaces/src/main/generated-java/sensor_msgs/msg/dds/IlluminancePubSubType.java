package sensor_msgs.msg.dds;

/**
 * Topic data type of the struct "Illuminance" defined in "Illuminance_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from Illuminance_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Illuminance_.idl instead.
 */
public class IlluminancePubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.Illuminance>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::Illuminance_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public IlluminancePubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getMaxCdrSerializedSize(current_alignment);
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.Illuminance data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.Illuminance data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.Illuminance data, us.ihmc.idl.CDR cdr)
   {

      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);

      cdr.write_type_6(data.getIlluminance());

      cdr.write_type_6(data.getVariance());
   }

   public static void read(sensor_msgs.msg.dds.Illuminance data, us.ihmc.idl.CDR cdr)
   {

      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);

      data.setIlluminance(cdr.read_type_6());

      data.setVariance(cdr.read_type_6());
   }

   public static void staticCopy(sensor_msgs.msg.dds.Illuminance src, sensor_msgs.msg.dds.Illuminance dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(sensor_msgs.msg.dds.Illuminance data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.Illuminance data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.Illuminance data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_6("illuminance", data.getIlluminance());

      ser.write_type_6("variance", data.getVariance());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.Illuminance data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      data.setIlluminance(ser.read_type_6("illuminance"));

      data.setVariance(ser.read_type_6("variance"));
   }

   @Override
   public sensor_msgs.msg.dds.Illuminance createData()
   {
      return new sensor_msgs.msg.dds.Illuminance();
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

   public void serialize(sensor_msgs.msg.dds.Illuminance data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.Illuminance data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(sensor_msgs.msg.dds.Illuminance src, sensor_msgs.msg.dds.Illuminance dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public IlluminancePubSubType newInstance()
   {
      return new IlluminancePubSubType();
   }
}