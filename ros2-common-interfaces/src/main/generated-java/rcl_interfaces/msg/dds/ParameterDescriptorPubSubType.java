package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "ParameterDescriptor" defined in "ParameterDescriptor_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ParameterDescriptor_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ParameterDescriptor_.idl instead.
*
*/
public class ParameterDescriptorPubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.ParameterDescriptor>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::ParameterDescriptor_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.ParameterDescriptor data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.ParameterDescriptor data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ParameterDescriptor data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ParameterDescriptor data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.ParameterDescriptor data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length");

      cdr.write_type_9(data.getType());

   }

   public static void read(rcl_interfaces.msg.dds.ParameterDescriptor data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      data.setType(cdr.read_type_9());
      	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.ParameterDescriptor data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_9("type", data.getType());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.ParameterDescriptor data)
   {
      ser.read_type_d("name", data.getName());
      data.setType(ser.read_type_9("type"));
   }

   public static void staticCopy(rcl_interfaces.msg.dds.ParameterDescriptor src, rcl_interfaces.msg.dds.ParameterDescriptor dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.ParameterDescriptor createData()
   {
      return new rcl_interfaces.msg.dds.ParameterDescriptor();
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
   
   public void serialize(rcl_interfaces.msg.dds.ParameterDescriptor data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.ParameterDescriptor data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.ParameterDescriptor src, rcl_interfaces.msg.dds.ParameterDescriptor dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ParameterDescriptorPubSubType newInstance()
   {
      return new ParameterDescriptorPubSubType();
   }
}
