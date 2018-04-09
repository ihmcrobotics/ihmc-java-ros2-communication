package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Range" defined in "Range_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Range_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Range_.idl instead.
*
*/
public class RangePubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.Range>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::Range_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.Range data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.Range data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.Range data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.Range data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.Range data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      cdr.write_type_9(data.getRadiationType());

      cdr.write_type_5(data.getFieldOfView());

      cdr.write_type_5(data.getMinRange());

      cdr.write_type_5(data.getMaxRange());

      cdr.write_type_5(data.getRange());

   }

   public static void read(sensor_msgs.msg.dds.Range data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      data.setRadiationType(cdr.read_type_9());
      	
      data.setFieldOfView(cdr.read_type_5());
      	
      data.setMinRange(cdr.read_type_5());
      	
      data.setMaxRange(cdr.read_type_5());
      	
      data.setRange(cdr.read_type_5());
      	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.Range data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_9("radiation_type", data.getRadiationType());
      ser.write_type_5("field_of_view", data.getFieldOfView());
      ser.write_type_5("min_range", data.getMinRange());
      ser.write_type_5("max_range", data.getMaxRange());
      ser.write_type_5("range", data.getRange());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.Range data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      data.setRadiationType(ser.read_type_9("radiation_type"));
      data.setFieldOfView(ser.read_type_5("field_of_view"));
      data.setMinRange(ser.read_type_5("min_range"));
      data.setMaxRange(ser.read_type_5("max_range"));
      data.setRange(ser.read_type_5("range"));
   }

   public static void staticCopy(sensor_msgs.msg.dds.Range src, sensor_msgs.msg.dds.Range dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.Range createData()
   {
      return new sensor_msgs.msg.dds.Range();
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
   
   public void serialize(sensor_msgs.msg.dds.Range data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.Range data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.Range src, sensor_msgs.msg.dds.Range dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public RangePubSubType newInstance()
   {
      return new RangePubSubType();
   }
}
