package test_msgs.msg.dds;

/**
 * Topic data type of the struct "StaticArrayPrimitives" defined in "StaticArrayPrimitives_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from StaticArrayPrimitives_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit StaticArrayPrimitives_.idl instead.
 */
public class StaticArrayPrimitivesPubSubType implements us.ihmc.pubsub.TopicDataType<test_msgs.msg.dds.StaticArrayPrimitives>
{
   public static final java.lang.String name = "test_msgs::msg::dds_::StaticArrayPrimitives_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public StaticArrayPrimitivesPubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += ((3) * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += ((3) * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += ((3) * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      for (int i0 = 0; i0 < (3); ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.StaticArrayPrimitives data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.StaticArrayPrimitives data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);
      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);
      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);
      current_alignment += ((3) * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);
      current_alignment += ((3) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);
      current_alignment += ((3) * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);
      current_alignment += ((3) * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < data.getStringValues().length; ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStringValues()[i0].length() + 1;
      }

      return current_alignment - initial_alignment;
   }

   public static void write(test_msgs.msg.dds.StaticArrayPrimitives data, us.ihmc.idl.CDR cdr)
   {

      for (int i0 = 0; i0 < data.getBoolValues().length; ++i0)
      {
         cdr.write_type_7(data.getBoolValues()[i0]);
      }

      for (int i0 = 0; i0 < data.getByteValues().length; ++i0)
      {
         cdr.write_type_9(data.getByteValues()[i0]);
      }

      for (int i0 = 0; i0 < data.getCharValues().length; ++i0)
      {
         cdr.write_type_8(data.getCharValues()[i0]);
      }

      for (int i0 = 0; i0 < data.getFloat32Values().length; ++i0)
      {
         cdr.write_type_5(data.getFloat32Values()[i0]);
      }

      for (int i0 = 0; i0 < data.getFloat64Values().length; ++i0)
      {
         cdr.write_type_6(data.getFloat64Values()[i0]);
      }

      for (int i0 = 0; i0 < data.getInt8Values().length; ++i0)
      {
         cdr.write_type_9(data.getInt8Values()[i0]);
      }

      for (int i0 = 0; i0 < data.getUint8Values().length; ++i0)
      {
         cdr.write_type_9(data.getUint8Values()[i0]);
      }

      for (int i0 = 0; i0 < data.getInt16Values().length; ++i0)
      {
         cdr.write_type_1(data.getInt16Values()[i0]);
      }

      for (int i0 = 0; i0 < data.getInt32Values().length; ++i0)
      {
         cdr.write_type_2(data.getInt32Values()[i0]);
      }

      for (int i0 = 0; i0 < data.getStringValues().length; ++i0)
      {
         cdr.write_type_d(data.getStringValues()[i0]);
      }
   }

   public static void read(test_msgs.msg.dds.StaticArrayPrimitives data, us.ihmc.idl.CDR cdr)
   {

      for (int i0 = 0; i0 < data.getBoolValues().length; ++i0)
      {
         data.getBoolValues()[i0] = cdr.read_type_7();
      }

      for (int i0 = 0; i0 < data.getByteValues().length; ++i0)
      {
         data.getByteValues()[i0] = cdr.read_type_9();
      }

      for (int i0 = 0; i0 < data.getCharValues().length; ++i0)
      {
         data.getCharValues()[i0] = cdr.read_type_8();
      }

      for (int i0 = 0; i0 < data.getFloat32Values().length; ++i0)
      {
         data.getFloat32Values()[i0] = cdr.read_type_5();
      }

      for (int i0 = 0; i0 < data.getFloat64Values().length; ++i0)
      {
         data.getFloat64Values()[i0] = cdr.read_type_6();
      }

      for (int i0 = 0; i0 < data.getInt8Values().length; ++i0)
      {
         data.getInt8Values()[i0] = cdr.read_type_9();
      }

      for (int i0 = 0; i0 < data.getUint8Values().length; ++i0)
      {
         data.getUint8Values()[i0] = cdr.read_type_9();
      }

      for (int i0 = 0; i0 < data.getInt16Values().length; ++i0)
      {
         data.getInt16Values()[i0] = cdr.read_type_1();
      }

      for (int i0 = 0; i0 < data.getInt32Values().length; ++i0)
      {
         data.getInt32Values()[i0] = cdr.read_type_2();
      }

      for (int i0 = 0; i0 < data.getStringValues().length; ++i0)
      {
         cdr.read_type_d(data.getStringValues()[i0]);
      }
   }

   public static void staticCopy(test_msgs.msg.dds.StaticArrayPrimitives src, test_msgs.msg.dds.StaticArrayPrimitives dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(test_msgs.msg.dds.StaticArrayPrimitives data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, test_msgs.msg.dds.StaticArrayPrimitives data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(test_msgs.msg.dds.StaticArrayPrimitives data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_f("bool_values", data.getBoolValues());
      ser.write_type_f("byte_values", data.getByteValues());
      ser.write_type_f("char_values", data.getCharValues());
      ser.write_type_f("float32_values", data.getFloat32Values());
      ser.write_type_f("float64_values", data.getFloat64Values());
      ser.write_type_f("int8_values", data.getInt8Values());
      ser.write_type_f("uint8_values", data.getUint8Values());
      ser.write_type_f("int16_values", data.getInt16Values());
      ser.write_type_f("int32_values", data.getInt32Values());
      ser.write_type_f("string_values", data.getStringValues());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, test_msgs.msg.dds.StaticArrayPrimitives data)
   {
      ser.read_type_f("bool_values", data.getBoolValues());

      ser.read_type_f("byte_values", data.getByteValues());

      ser.read_type_f("char_values", data.getCharValues());

      ser.read_type_f("float32_values", data.getFloat32Values());

      ser.read_type_f("float64_values", data.getFloat64Values());

      ser.read_type_f("int8_values", data.getInt8Values());

      ser.read_type_f("uint8_values", data.getUint8Values());

      ser.read_type_f("int16_values", data.getInt16Values());

      ser.read_type_f("int32_values", data.getInt32Values());

      ser.read_type_f("string_values", data.getStringValues());
   }

   @Override
   public test_msgs.msg.dds.StaticArrayPrimitives createData()
   {
      return new test_msgs.msg.dds.StaticArrayPrimitives();
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

   public void serialize(test_msgs.msg.dds.StaticArrayPrimitives data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(test_msgs.msg.dds.StaticArrayPrimitives data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(test_msgs.msg.dds.StaticArrayPrimitives src, test_msgs.msg.dds.StaticArrayPrimitives dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public StaticArrayPrimitivesPubSubType newInstance()
   {
      return new StaticArrayPrimitivesPubSubType();
   }
}
