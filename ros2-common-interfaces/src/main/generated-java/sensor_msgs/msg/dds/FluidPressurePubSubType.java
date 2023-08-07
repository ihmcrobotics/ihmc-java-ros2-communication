package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "FluidPressure" defined in "FluidPressure_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from FluidPressure_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FluidPressure_.idl instead.
*
*/
public class FluidPressurePubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.FluidPressure>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::FluidPressure_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "91645e56f2834a0550800ffaef556b8b7ca64a62da892c196ab237afa0c590b1";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.FluidPressure data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.FluidPressure data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.FluidPressure data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.FluidPressure data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.FluidPressure data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      cdr.write_type_6(data.getFluidPressure());

      cdr.write_type_6(data.getVariance());

   }

   public static void read(sensor_msgs.msg.dds.FluidPressure data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      data.setFluidPressure(cdr.read_type_6());
      	
      data.setVariance(cdr.read_type_6());
      	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.FluidPressure data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_6("fluid_pressure", data.getFluidPressure());
      ser.write_type_6("variance", data.getVariance());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.FluidPressure data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      data.setFluidPressure(ser.read_type_6("fluid_pressure"));
      data.setVariance(ser.read_type_6("variance"));
   }

   public static void staticCopy(sensor_msgs.msg.dds.FluidPressure src, sensor_msgs.msg.dds.FluidPressure dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.FluidPressure createData()
   {
      return new sensor_msgs.msg.dds.FluidPressure();
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
   
   public void serialize(sensor_msgs.msg.dds.FluidPressure data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.FluidPressure data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.FluidPressure src, sensor_msgs.msg.dds.FluidPressure dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FluidPressurePubSubType newInstance()
   {
      return new FluidPressurePubSubType();
   }
}
