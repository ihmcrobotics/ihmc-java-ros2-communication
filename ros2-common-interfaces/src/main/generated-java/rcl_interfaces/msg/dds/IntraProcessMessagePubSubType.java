package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "IntraProcessMessage" defined in "IntraProcessMessage_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from IntraProcessMessage_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit IntraProcessMessage_.idl instead.
*
*/
public class IntraProcessMessagePubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.IntraProcessMessage>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::IntraProcessMessage_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.IntraProcessMessage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.IntraProcessMessage data) throws java.io.IOException
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


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.IntraProcessMessage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.IntraProcessMessage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.IntraProcessMessage data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_12(data.getPublisherId());

      cdr.write_type_12(data.getMessageSequence());

   }

   public static void read(rcl_interfaces.msg.dds.IntraProcessMessage data, us.ihmc.idl.CDR cdr)
   {
      data.setPublisherId(cdr.read_type_12());
      	
      data.setMessageSequence(cdr.read_type_12());
      	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.IntraProcessMessage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_12("publisher_id", data.getPublisherId());
      ser.write_type_12("message_sequence", data.getMessageSequence());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.IntraProcessMessage data)
   {
      data.setPublisherId(ser.read_type_12("publisher_id"));
      data.setMessageSequence(ser.read_type_12("message_sequence"));
   }

   public static void staticCopy(rcl_interfaces.msg.dds.IntraProcessMessage src, rcl_interfaces.msg.dds.IntraProcessMessage dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.IntraProcessMessage createData()
   {
      return new rcl_interfaces.msg.dds.IntraProcessMessage();
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
   
   public void serialize(rcl_interfaces.msg.dds.IntraProcessMessage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.IntraProcessMessage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.IntraProcessMessage src, rcl_interfaces.msg.dds.IntraProcessMessage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public IntraProcessMessagePubSubType newInstance()
   {
      return new IntraProcessMessagePubSubType();
   }
}
