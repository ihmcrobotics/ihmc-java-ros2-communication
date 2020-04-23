package std_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Int8" defined in "Int8_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Int8_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Int8_.idl instead.
*
*/
public class Int8PubSubType implements us.ihmc.pubsub.TopicDataType<std_msgs.msg.dds.Int8>
{
   public static final java.lang.String name = "std_msgs::msg::dds_::Int8_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(std_msgs.msg.dds.Int8 data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, std_msgs.msg.dds.Int8 data) throws java.io.IOException
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

   public final static int getCdrSerializedSize(std_msgs.msg.dds.Int8 data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.Int8 data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(std_msgs.msg.dds.Int8 data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_9(data.getData());

   }

   public static void read(std_msgs.msg.dds.Int8 data, us.ihmc.idl.CDR cdr)
   {
      data.setData(cdr.read_type_9());
      	

   }

   @Override
   public final void serialize(std_msgs.msg.dds.Int8 data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, std_msgs.msg.dds.Int8 data)
   {
      data.setData(ser.read_type_9("data"));   }

   public static void staticCopy(std_msgs.msg.dds.Int8 src, std_msgs.msg.dds.Int8 dest)
   {
      dest.set(src);
   }

   @Override
   public std_msgs.msg.dds.Int8 createData()
   {
      return new std_msgs.msg.dds.Int8();
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
   
   public void serialize(std_msgs.msg.dds.Int8 data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(std_msgs.msg.dds.Int8 data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(std_msgs.msg.dds.Int8 src, std_msgs.msg.dds.Int8 dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public Int8PubSubType newInstance()
   {
      return new Int8PubSubType();
   }
}
