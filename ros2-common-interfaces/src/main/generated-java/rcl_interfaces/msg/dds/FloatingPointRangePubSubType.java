package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "FloatingPointRange" defined in "FloatingPointRange_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from FloatingPointRange_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FloatingPointRange_.idl instead.
*
*/
public class FloatingPointRangePubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.FloatingPointRange>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::FloatingPointRange_";
   
   @Override
   public final String getDefinitionChecksum()
   {
   		return "16fb1a1f131729cee23bf6b5becf2f2e4210ad2212aa4ca18cdc222643e3468f";
   }
   
   @Override
   public final String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.FloatingPointRange data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.FloatingPointRange data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.FloatingPointRange data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.FloatingPointRange data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.FloatingPointRange data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_6(data.getFromValue());

      cdr.write_type_6(data.getToValue());

      cdr.write_type_6(data.getStep());

   }

   public static void read(rcl_interfaces.msg.dds.FloatingPointRange data, us.ihmc.idl.CDR cdr)
   {
      data.setFromValue(cdr.read_type_6());
      	
      data.setToValue(cdr.read_type_6());
      	
      data.setStep(cdr.read_type_6());
      	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.FloatingPointRange data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_6("from_value", data.getFromValue());
      ser.write_type_6("to_value", data.getToValue());
      ser.write_type_6("step", data.getStep());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.FloatingPointRange data)
   {
      data.setFromValue(ser.read_type_6("from_value"));
      data.setToValue(ser.read_type_6("to_value"));
      data.setStep(ser.read_type_6("step"));
   }

   public static void staticCopy(rcl_interfaces.msg.dds.FloatingPointRange src, rcl_interfaces.msg.dds.FloatingPointRange dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.FloatingPointRange createData()
   {
      return new rcl_interfaces.msg.dds.FloatingPointRange();
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
   
   public void serialize(rcl_interfaces.msg.dds.FloatingPointRange data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.FloatingPointRange data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.FloatingPointRange src, rcl_interfaces.msg.dds.FloatingPointRange dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FloatingPointRangePubSubType newInstance()
   {
      return new FloatingPointRangePubSubType();
   }
}
