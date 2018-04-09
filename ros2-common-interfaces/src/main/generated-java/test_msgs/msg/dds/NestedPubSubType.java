package test_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Nested" defined in "Nested_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Nested_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Nested_.idl instead.
*
*/
public class NestedPubSubType implements us.ihmc.pubsub.TopicDataType<test_msgs.msg.dds.Nested>
{
   public static final java.lang.String name = "test_msgs::msg::dds_::Nested_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(test_msgs.msg.dds.Nested data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, test_msgs.msg.dds.Nested data) throws java.io.IOException
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

      current_alignment += test_msgs.msg.dds.PrimitivesPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.Nested data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.Nested data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += test_msgs.msg.dds.PrimitivesPubSubType.getCdrSerializedSize(data.getPrimitiveValues(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(test_msgs.msg.dds.Nested data, us.ihmc.idl.CDR cdr)
   {
      test_msgs.msg.dds.PrimitivesPubSubType.write(data.getPrimitiveValues(), cdr);   }

   public static void read(test_msgs.msg.dds.Nested data, us.ihmc.idl.CDR cdr)
   {
      test_msgs.msg.dds.PrimitivesPubSubType.read(data.getPrimitiveValues(), cdr);	

   }

   @Override
   public final void serialize(test_msgs.msg.dds.Nested data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("primitive_values", new test_msgs.msg.dds.PrimitivesPubSubType(), data.getPrimitiveValues());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, test_msgs.msg.dds.Nested data)
   {
      ser.read_type_a("primitive_values", new test_msgs.msg.dds.PrimitivesPubSubType(), data.getPrimitiveValues());
   }

   public static void staticCopy(test_msgs.msg.dds.Nested src, test_msgs.msg.dds.Nested dest)
   {
      dest.set(src);
   }

   @Override
   public test_msgs.msg.dds.Nested createData()
   {
      return new test_msgs.msg.dds.Nested();
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
   
   public void serialize(test_msgs.msg.dds.Nested data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(test_msgs.msg.dds.Nested data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(test_msgs.msg.dds.Nested src, test_msgs.msg.dds.Nested dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public NestedPubSubType newInstance()
   {
      return new NestedPubSubType();
   }
}
