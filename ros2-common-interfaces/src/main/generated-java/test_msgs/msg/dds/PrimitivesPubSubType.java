package test_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Primitives" defined in "Primitives_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Primitives_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Primitives_.idl instead.
*
*/
public class PrimitivesPubSubType implements us.ihmc.pubsub.TopicDataType<test_msgs.msg.dds.Primitives>
{
   public static final java.lang.String name = "test_msgs::msg::dds_::Primitives_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(test_msgs.msg.dds.Primitives data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, test_msgs.msg.dds.Primitives data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.Primitives data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.Primitives data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);


      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStringValue().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(test_msgs.msg.dds.Primitives data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getBoolValue());

      cdr.write_type_9(data.getByteValue());

      cdr.write_type_8(data.getCharValue());

      cdr.write_type_5(data.getFloat32Value());

      cdr.write_type_6(data.getFloat64Value());

      cdr.write_type_9(data.getInt8Value());

      cdr.write_type_9(data.getUint8Value());

      cdr.write_type_1(data.getInt16Value());

      cdr.write_type_3(data.getUint16Value());

      cdr.write_type_2(data.getInt32Value());

      cdr.write_type_4(data.getUint32Value());

      cdr.write_type_11(data.getInt64Value());

      cdr.write_type_12(data.getUint64Value());

      if(data.getStringValue().length() <= 255)
      cdr.write_type_d(data.getStringValue());else
          throw new RuntimeException("string_value field exceeds the maximum length");

   }

   public static void read(test_msgs.msg.dds.Primitives data, us.ihmc.idl.CDR cdr)
   {
      data.setBoolValue(cdr.read_type_7());
      	
      data.setByteValue(cdr.read_type_9());
      	
      data.setCharValue(cdr.read_type_8());
      	
      data.setFloat32Value(cdr.read_type_5());
      	
      data.setFloat64Value(cdr.read_type_6());
      	
      data.setInt8Value(cdr.read_type_9());
      	
      data.setUint8Value(cdr.read_type_9());
      	
      data.setInt16Value(cdr.read_type_1());
      	
      data.setUint16Value(cdr.read_type_3());
      	
      data.setInt32Value(cdr.read_type_2());
      	
      data.setUint32Value(cdr.read_type_4());
      	
      data.setInt64Value(cdr.read_type_11());
      	
      data.setUint64Value(cdr.read_type_12());
      	
      cdr.read_type_d(data.getStringValue());	

   }

   @Override
   public final void serialize(test_msgs.msg.dds.Primitives data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("bool_value", data.getBoolValue());
      ser.write_type_9("byte_value", data.getByteValue());
      ser.write_type_8("char_value", data.getCharValue());
      ser.write_type_5("float32_value", data.getFloat32Value());
      ser.write_type_6("float64_value", data.getFloat64Value());
      ser.write_type_9("int8_value", data.getInt8Value());
      ser.write_type_9("uint8_value", data.getUint8Value());
      ser.write_type_1("int16_value", data.getInt16Value());
      ser.write_type_3("uint16_value", data.getUint16Value());
      ser.write_type_2("int32_value", data.getInt32Value());
      ser.write_type_4("uint32_value", data.getUint32Value());
      ser.write_type_11("int64_value", data.getInt64Value());
      ser.write_type_12("uint64_value", data.getUint64Value());
      ser.write_type_d("string_value", data.getStringValue());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, test_msgs.msg.dds.Primitives data)
   {
      data.setBoolValue(ser.read_type_7("bool_value"));
      data.setByteValue(ser.read_type_9("byte_value"));
      data.setCharValue(ser.read_type_8("char_value"));
      data.setFloat32Value(ser.read_type_5("float32_value"));
      data.setFloat64Value(ser.read_type_6("float64_value"));
      data.setInt8Value(ser.read_type_9("int8_value"));
      data.setUint8Value(ser.read_type_9("uint8_value"));
      data.setInt16Value(ser.read_type_1("int16_value"));
      data.setUint16Value(ser.read_type_3("uint16_value"));
      data.setInt32Value(ser.read_type_2("int32_value"));
      data.setUint32Value(ser.read_type_4("uint32_value"));
      data.setInt64Value(ser.read_type_11("int64_value"));
      data.setUint64Value(ser.read_type_12("uint64_value"));
      ser.read_type_d("string_value", data.getStringValue());
   }

   public static void staticCopy(test_msgs.msg.dds.Primitives src, test_msgs.msg.dds.Primitives dest)
   {
      dest.set(src);
   }

   @Override
   public test_msgs.msg.dds.Primitives createData()
   {
      return new test_msgs.msg.dds.Primitives();
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
   
   public void serialize(test_msgs.msg.dds.Primitives data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(test_msgs.msg.dds.Primitives data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(test_msgs.msg.dds.Primitives src, test_msgs.msg.dds.Primitives dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PrimitivesPubSubType newInstance()
   {
      return new PrimitivesPubSubType();
   }
}
