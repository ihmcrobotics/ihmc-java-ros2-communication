package sensor_msgs.msg.dds;

/**
 * Topic data type of the struct "MagneticField" defined in "MagneticField_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from MagneticField_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit MagneticField_.idl instead.
 */
public class MagneticFieldPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.MagneticField>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::MagneticField_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += ((9) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.MagneticField data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.MagneticField data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getMagneticField(), current_alignment);

      current_alignment += ((9) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.MagneticField data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getMagneticField(), cdr);
      for (int i0 = 0; i0 < data.getMagneticFieldCovariance().length; ++i0)
      {
         cdr.write_type_6(data.getMagneticFieldCovariance()[i0]);
      }
   }

   public static void read(sensor_msgs.msg.dds.MagneticField data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);
      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getMagneticField(), cdr);
      for (int i0 = 0; i0 < data.getMagneticFieldCovariance().length; ++i0)
      {
         data.getMagneticFieldCovariance()[i0] = cdr.read_type_6();
      }
   }

   public static void staticCopy(sensor_msgs.msg.dds.MagneticField src, sensor_msgs.msg.dds.MagneticField dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(sensor_msgs.msg.dds.MagneticField data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.MagneticField data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.MagneticField data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("magnetic_field", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getMagneticField());

      ser.write_type_f("magnetic_field_covariance", data.getMagneticFieldCovariance());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.MagneticField data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("magnetic_field", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getMagneticField());

      ser.read_type_f("magnetic_field_covariance", data.getMagneticFieldCovariance());
   }

   @Override
   public sensor_msgs.msg.dds.MagneticField createData()
   {
      return new sensor_msgs.msg.dds.MagneticField();
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

   public void serialize(sensor_msgs.msg.dds.MagneticField data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.MagneticField data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(sensor_msgs.msg.dds.MagneticField src, sensor_msgs.msg.dds.MagneticField dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MagneticFieldPubSubType newInstance()
   {
      return new MagneticFieldPubSubType();
   }
}
