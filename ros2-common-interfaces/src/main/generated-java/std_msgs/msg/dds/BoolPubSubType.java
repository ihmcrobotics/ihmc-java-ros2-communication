package std_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Bool" defined in "Bool_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Bool_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Bool_.idl instead.
*
*/
public class BoolPubSubType implements us.ihmc.pubsub.TopicDataType<std_msgs.msg.dds.Bool>
{
   public static final java.lang.String name = "std_msgs::msg::dds_::Bool_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "844a4e78098f81aba69a63ce7102d5463acf72d74727422a0803c47ed60326d5";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(std_msgs.msg.dds.Bool data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, std_msgs.msg.dds.Bool data) throws java.io.IOException
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

   public final static int getCdrSerializedSize(std_msgs.msg.dds.Bool data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.Bool data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(std_msgs.msg.dds.Bool data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getData());

   }

   public static void read(std_msgs.msg.dds.Bool data, us.ihmc.idl.CDR cdr)
   {
      data.setData(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(std_msgs.msg.dds.Bool data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, std_msgs.msg.dds.Bool data)
   {
      data.setData(ser.read_type_7("data"));   }

   public static void staticCopy(std_msgs.msg.dds.Bool src, std_msgs.msg.dds.Bool dest)
   {
      dest.set(src);
   }

   @Override
   public std_msgs.msg.dds.Bool createData()
   {
      return new std_msgs.msg.dds.Bool();
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
   
   public void serialize(std_msgs.msg.dds.Bool data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(std_msgs.msg.dds.Bool data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(std_msgs.msg.dds.Bool src, std_msgs.msg.dds.Bool dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public BoolPubSubType newInstance()
   {
      return new BoolPubSubType();
   }
}
