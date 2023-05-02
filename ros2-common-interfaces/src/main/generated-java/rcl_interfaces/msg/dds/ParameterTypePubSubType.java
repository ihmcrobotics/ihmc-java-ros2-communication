package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "ParameterType" defined in "ParameterType_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ParameterType_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ParameterType_.idl instead.
*
*/
public class ParameterTypePubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.ParameterType>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::ParameterType_";
   
   @Override
   public final String getDefinitionChecksum()
   {
   		return "cf200e93e677b946afdb30f82c43a726fb158729c832ee25dc9b1fac9147f079";
   }
   
   @Override
   public final String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.ParameterType data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.ParameterType data) throws java.io.IOException
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


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ParameterType data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ParameterType data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.ParameterType data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getUnusedPlaceholderField());

   }

   public static void read(rcl_interfaces.msg.dds.ParameterType data, us.ihmc.idl.CDR cdr)
   {
      data.setUnusedPlaceholderField(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.ParameterType data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("unused_placeholder_field", data.getUnusedPlaceholderField());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.ParameterType data)
   {
      data.setUnusedPlaceholderField(ser.read_type_7("unused_placeholder_field"));   }

   public static void staticCopy(rcl_interfaces.msg.dds.ParameterType src, rcl_interfaces.msg.dds.ParameterType dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.ParameterType createData()
   {
      return new rcl_interfaces.msg.dds.ParameterType();
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
   
   public void serialize(rcl_interfaces.msg.dds.ParameterType data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.ParameterType data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.ParameterType src, rcl_interfaces.msg.dds.ParameterType dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ParameterTypePubSubType newInstance()
   {
      return new ParameterTypePubSubType();
   }
}
