package unique_identifier_msgs.msg.dds;

/**
* 
* Topic data type of the struct "UUID" defined in "UUID_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from UUID_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit UUID_.idl instead.
*
*/
public class UUIDPubSubType implements us.ihmc.pubsub.TopicDataType<unique_identifier_msgs.msg.dds.UUID>
{
   public static final java.lang.String name = "unique_identifier_msgs::msg::dds_::UUID_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(unique_identifier_msgs.msg.dds.UUID data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, unique_identifier_msgs.msg.dds.UUID data) throws java.io.IOException
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


      current_alignment += ((16) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(unique_identifier_msgs.msg.dds.UUID data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(unique_identifier_msgs.msg.dds.UUID data, int current_alignment)
   {
      int initial_alignment = current_alignment;


      current_alignment += ((16) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      return current_alignment - initial_alignment;
   }

   public static void write(unique_identifier_msgs.msg.dds.UUID data, us.ihmc.idl.CDR cdr)
   {

      for(int i0 = 0; i0 < data.getUuid().length; ++i0)
      {
        	cdr.write_type_9(data.getUuid()[i0]);	
      }

   }

   public static void read(unique_identifier_msgs.msg.dds.UUID data, us.ihmc.idl.CDR cdr)
   {

      for(int i0 = 0; i0 < data.getUuid().length; ++i0)
      {
        	data.getUuid()[i0] = cdr.read_type_9();
        	
      }
      	

   }

   @Override
   public final void serialize(unique_identifier_msgs.msg.dds.UUID data, us.ihmc.idl.InterchangeSerializer ser)
   {

      ser.write_type_f("uuid", data.getUuid());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, unique_identifier_msgs.msg.dds.UUID data)
   {

      ser.read_type_f("uuid", data.getUuid());
   }

   public static void staticCopy(unique_identifier_msgs.msg.dds.UUID src, unique_identifier_msgs.msg.dds.UUID dest)
   {
      dest.set(src);
   }

   @Override
   public unique_identifier_msgs.msg.dds.UUID createData()
   {
      return new unique_identifier_msgs.msg.dds.UUID();
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
   
   public void serialize(unique_identifier_msgs.msg.dds.UUID data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(unique_identifier_msgs.msg.dds.UUID data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(unique_identifier_msgs.msg.dds.UUID src, unique_identifier_msgs.msg.dds.UUID dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public UUIDPubSubType newInstance()
   {
      return new UUIDPubSubType();
   }
}
