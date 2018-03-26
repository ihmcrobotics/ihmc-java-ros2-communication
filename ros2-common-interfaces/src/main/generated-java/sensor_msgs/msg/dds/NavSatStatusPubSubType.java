package sensor_msgs.msg.dds;

/**
 * Topic data type of the struct "NavSatStatus" defined in "NavSatStatus_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from NavSatStatus_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit NavSatStatus_.idl instead.
 */
public class NavSatStatusPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.NavSatStatus>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::NavSatStatus_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();
   public NavSatStatusPubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.NavSatStatus data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.NavSatStatus data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.NavSatStatus data, us.ihmc.idl.CDR cdr)
   {

      cdr.write_type_9(data.getStatus());

      cdr.write_type_3(data.getService());
   }

   public static void read(sensor_msgs.msg.dds.NavSatStatus data, us.ihmc.idl.CDR cdr)
   {

      data.setStatus(cdr.read_type_9());

      data.setService(cdr.read_type_3());
   }

   public static void staticCopy(sensor_msgs.msg.dds.NavSatStatus src, sensor_msgs.msg.dds.NavSatStatus dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(sensor_msgs.msg.dds.NavSatStatus data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.NavSatStatus data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.NavSatStatus data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("status", data.getStatus());

      ser.write_type_3("service", data.getService());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.NavSatStatus data)
   {
      data.setStatus(ser.read_type_9("status"));

      data.setService(ser.read_type_3("service"));
   }

   @Override
   public sensor_msgs.msg.dds.NavSatStatus createData()
   {
      return new sensor_msgs.msg.dds.NavSatStatus();
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

   public void serialize(sensor_msgs.msg.dds.NavSatStatus data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.NavSatStatus data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(sensor_msgs.msg.dds.NavSatStatus src, sensor_msgs.msg.dds.NavSatStatus dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public NavSatStatusPubSubType newInstance()
   {
      return new NavSatStatusPubSubType();
   }
}
