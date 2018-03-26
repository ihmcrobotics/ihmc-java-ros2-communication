package test_msgs.msg.dds;

/**
 * Topic data type of the struct "BoundedArrayPrimitives" defined in "BoundedArrayPrimitives_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from BoundedArrayPrimitives_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit BoundedArrayPrimitives_.idl instead.
 */
public class BoundedArrayPrimitivesPubSubType implements us.ihmc.pubsub.TopicDataType<test_msgs.msg.dds.BoundedArrayPrimitives>
{
   public static final java.lang.String name = "test_msgs::msg::dds_::BoundedArrayPrimitives_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public BoundedArrayPrimitivesPubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (3 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < 3; ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.BoundedArrayPrimitives data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.BoundedArrayPrimitives data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getBoolValues().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getByteValues().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getCharValues().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getFloat32Values().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getFloat64Values().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getInt8Values().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getUint8Values().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getInt16Values().size() * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getUint16Values().size() * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getInt32Values().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getUint32Values().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getInt64Values().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getUint64Values().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < data.getStringValues().size(); ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStringValues().get(i0).length() + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      return current_alignment - initial_alignment;
   }

   public static void write(test_msgs.msg.dds.BoundedArrayPrimitives data, us.ihmc.idl.CDR cdr)
   {

      if (data.getBoolValues().size() <= 3)
         cdr.write_type_e(data.getBoolValues());
      else
         throw new RuntimeException("bool_values field exceeds the maximum length");

      if (data.getByteValues().size() <= 3)
         cdr.write_type_e(data.getByteValues());
      else
         throw new RuntimeException("byte_values field exceeds the maximum length");

      if (data.getCharValues().size() <= 3)
         cdr.write_type_e(data.getCharValues());
      else
         throw new RuntimeException("char_values field exceeds the maximum length");

      if (data.getFloat32Values().size() <= 3)
         cdr.write_type_e(data.getFloat32Values());
      else
         throw new RuntimeException("float32_values field exceeds the maximum length");

      if (data.getFloat64Values().size() <= 3)
         cdr.write_type_e(data.getFloat64Values());
      else
         throw new RuntimeException("float64_values field exceeds the maximum length");

      if (data.getInt8Values().size() <= 3)
         cdr.write_type_e(data.getInt8Values());
      else
         throw new RuntimeException("int8_values field exceeds the maximum length");

      if (data.getUint8Values().size() <= 3)
         cdr.write_type_e(data.getUint8Values());
      else
         throw new RuntimeException("uint8_values field exceeds the maximum length");

      if (data.getInt16Values().size() <= 3)
         cdr.write_type_e(data.getInt16Values());
      else
         throw new RuntimeException("int16_values field exceeds the maximum length");

      if (data.getUint16Values().size() <= 3)
         cdr.write_type_e(data.getUint16Values());
      else
         throw new RuntimeException("uint16_values field exceeds the maximum length");

      if (data.getInt32Values().size() <= 3)
         cdr.write_type_e(data.getInt32Values());
      else
         throw new RuntimeException("int32_values field exceeds the maximum length");

      if (data.getUint32Values().size() <= 3)
         cdr.write_type_e(data.getUint32Values());
      else
         throw new RuntimeException("uint32_values field exceeds the maximum length");

      if (data.getInt64Values().size() <= 3)
         cdr.write_type_e(data.getInt64Values());
      else
         throw new RuntimeException("int64_values field exceeds the maximum length");

      if (data.getUint64Values().size() <= 3)
         cdr.write_type_e(data.getUint64Values());
      else
         throw new RuntimeException("uint64_values field exceeds the maximum length");

      if (data.getStringValues().size() <= 3)
         cdr.write_type_e(data.getStringValues());
      else
         throw new RuntimeException("string_values field exceeds the maximum length");

      cdr.write_type_2(data.getCheck());
   }

   public static void read(test_msgs.msg.dds.BoundedArrayPrimitives data, us.ihmc.idl.CDR cdr)
   {

      cdr.read_type_e(data.getBoolValues());

      cdr.read_type_e(data.getByteValues());

      cdr.read_type_e(data.getCharValues());

      cdr.read_type_e(data.getFloat32Values());

      cdr.read_type_e(data.getFloat64Values());

      cdr.read_type_e(data.getInt8Values());

      cdr.read_type_e(data.getUint8Values());

      cdr.read_type_e(data.getInt16Values());

      cdr.read_type_e(data.getUint16Values());

      cdr.read_type_e(data.getInt32Values());

      cdr.read_type_e(data.getUint32Values());

      cdr.read_type_e(data.getInt64Values());

      cdr.read_type_e(data.getUint64Values());

      cdr.read_type_e(data.getStringValues());

      data.setCheck(cdr.read_type_2());
   }

   public static void staticCopy(test_msgs.msg.dds.BoundedArrayPrimitives src, test_msgs.msg.dds.BoundedArrayPrimitives dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(test_msgs.msg.dds.BoundedArrayPrimitives data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, test_msgs.msg.dds.BoundedArrayPrimitives data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(test_msgs.msg.dds.BoundedArrayPrimitives data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("bool_values", data.getBoolValues());

      ser.write_type_e("byte_values", data.getByteValues());

      ser.write_type_e("char_values", data.getCharValues());

      ser.write_type_e("float32_values", data.getFloat32Values());

      ser.write_type_e("float64_values", data.getFloat64Values());

      ser.write_type_e("int8_values", data.getInt8Values());

      ser.write_type_e("uint8_values", data.getUint8Values());

      ser.write_type_e("int16_values", data.getInt16Values());

      ser.write_type_e("uint16_values", data.getUint16Values());

      ser.write_type_e("int32_values", data.getInt32Values());

      ser.write_type_e("uint32_values", data.getUint32Values());

      ser.write_type_e("int64_values", data.getInt64Values());

      ser.write_type_e("uint64_values", data.getUint64Values());

      ser.write_type_e("string_values", data.getStringValues());

      ser.write_type_2("check", data.getCheck());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, test_msgs.msg.dds.BoundedArrayPrimitives data)
   {
      ser.read_type_e("bool_values", data.getBoolValues());

      ser.read_type_e("byte_values", data.getByteValues());

      ser.read_type_e("char_values", data.getCharValues());

      ser.read_type_e("float32_values", data.getFloat32Values());

      ser.read_type_e("float64_values", data.getFloat64Values());

      ser.read_type_e("int8_values", data.getInt8Values());

      ser.read_type_e("uint8_values", data.getUint8Values());

      ser.read_type_e("int16_values", data.getInt16Values());

      ser.read_type_e("uint16_values", data.getUint16Values());

      ser.read_type_e("int32_values", data.getInt32Values());

      ser.read_type_e("uint32_values", data.getUint32Values());

      ser.read_type_e("int64_values", data.getInt64Values());

      ser.read_type_e("uint64_values", data.getUint64Values());

      ser.read_type_e("string_values", data.getStringValues());

      data.setCheck(ser.read_type_2("check"));
   }

   @Override
   public test_msgs.msg.dds.BoundedArrayPrimitives createData()
   {
      return new test_msgs.msg.dds.BoundedArrayPrimitives();
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

   public void serialize(test_msgs.msg.dds.BoundedArrayPrimitives data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(test_msgs.msg.dds.BoundedArrayPrimitives data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(test_msgs.msg.dds.BoundedArrayPrimitives src, test_msgs.msg.dds.BoundedArrayPrimitives dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public BoundedArrayPrimitivesPubSubType newInstance()
   {
      return new BoundedArrayPrimitivesPubSubType();
   }
}