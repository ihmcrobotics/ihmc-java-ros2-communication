package test_msgs.msg.dds;

/**
 * Topic data type of the struct "DynamicArrayNested" defined in "DynamicArrayNested_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from DynamicArrayNested_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit DynamicArrayNested_.idl instead.
 */
public class DynamicArrayNestedPubSubType implements us.ihmc.pubsub.TopicDataType<test_msgs.msg.dds.DynamicArrayNested>
{
   public static final java.lang.String name = "test_msgs::msg::dds_::DynamicArrayNested_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public DynamicArrayNestedPubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < 100; ++i0)
      {
         current_alignment += test_msgs.msg.dds.PrimitivesPubSubType.getMaxCdrSerializedSize(current_alignment);
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.DynamicArrayNested data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.DynamicArrayNested data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < data.getPrimitiveValues().size(); ++i0)
      {
         current_alignment += test_msgs.msg.dds.PrimitivesPubSubType.getCdrSerializedSize(data.getPrimitiveValues().get(i0), current_alignment);
      }

      return current_alignment - initial_alignment;
   }

   public static void write(test_msgs.msg.dds.DynamicArrayNested data, us.ihmc.idl.CDR cdr)
   {

      if (data.getPrimitiveValues().size() <= 100)
         cdr.write_type_e(data.getPrimitiveValues());
      else
         throw new RuntimeException("primitive_values field exceeds the maximum length");
   }

   public static void read(test_msgs.msg.dds.DynamicArrayNested data, us.ihmc.idl.CDR cdr)
   {

      cdr.read_type_e(data.getPrimitiveValues());
   }

   public static void staticCopy(test_msgs.msg.dds.DynamicArrayNested src, test_msgs.msg.dds.DynamicArrayNested dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(test_msgs.msg.dds.DynamicArrayNested data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, test_msgs.msg.dds.DynamicArrayNested data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(test_msgs.msg.dds.DynamicArrayNested data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("primitive_values", data.getPrimitiveValues());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, test_msgs.msg.dds.DynamicArrayNested data)
   {
      ser.read_type_e("primitive_values", data.getPrimitiveValues());
   }

   @Override
   public test_msgs.msg.dds.DynamicArrayNested createData()
   {
      return new test_msgs.msg.dds.DynamicArrayNested();
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

   public void serialize(test_msgs.msg.dds.DynamicArrayNested data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(test_msgs.msg.dds.DynamicArrayNested data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(test_msgs.msg.dds.DynamicArrayNested src, test_msgs.msg.dds.DynamicArrayNested dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public DynamicArrayNestedPubSubType newInstance()
   {
      return new DynamicArrayNestedPubSubType();
   }
}
