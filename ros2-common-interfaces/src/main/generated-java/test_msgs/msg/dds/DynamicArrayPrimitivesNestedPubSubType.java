package test_msgs.msg.dds;

/**
 * Topic data type of the struct "DynamicArrayPrimitivesNested" defined in "DynamicArrayPrimitivesNested_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from DynamicArrayPrimitivesNested_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit DynamicArrayPrimitivesNested_.idl instead.
 */
public class DynamicArrayPrimitivesNestedPubSubType implements us.ihmc.pubsub.TopicDataType<test_msgs.msg.dds.DynamicArrayPrimitivesNested>
{
   public static final java.lang.String name = "test_msgs::msg::dds_::DynamicArrayPrimitivesNested_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public DynamicArrayPrimitivesNestedPubSubType()
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
         current_alignment += test_msgs.msg.dds.DynamicArrayPrimitivesPubSubType.getMaxCdrSerializedSize(current_alignment);
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.DynamicArrayPrimitivesNested data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.DynamicArrayPrimitivesNested data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < data.getDynamicArrayPrimitiveValues().size(); ++i0)
      {
         current_alignment += test_msgs.msg.dds.DynamicArrayPrimitivesPubSubType
               .getCdrSerializedSize(data.getDynamicArrayPrimitiveValues().get(i0), current_alignment);
      }

      return current_alignment - initial_alignment;
   }

   public static void write(test_msgs.msg.dds.DynamicArrayPrimitivesNested data, us.ihmc.idl.CDR cdr)
   {

      if (data.getDynamicArrayPrimitiveValues().size() <= 100)
         cdr.write_type_e(data.getDynamicArrayPrimitiveValues());
      else
         throw new RuntimeException("dynamic_array_primitive_values field exceeds the maximum length");
   }

   public static void read(test_msgs.msg.dds.DynamicArrayPrimitivesNested data, us.ihmc.idl.CDR cdr)
   {

      cdr.read_type_e(data.getDynamicArrayPrimitiveValues());
   }

   public static void staticCopy(test_msgs.msg.dds.DynamicArrayPrimitivesNested src, test_msgs.msg.dds.DynamicArrayPrimitivesNested dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(test_msgs.msg.dds.DynamicArrayPrimitivesNested data, us.ihmc.pubsub.common.SerializedPayload serializedPayload)
         throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, test_msgs.msg.dds.DynamicArrayPrimitivesNested data)
         throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(test_msgs.msg.dds.DynamicArrayPrimitivesNested data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("dynamic_array_primitive_values", data.getDynamicArrayPrimitiveValues());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, test_msgs.msg.dds.DynamicArrayPrimitivesNested data)
   {
      ser.read_type_e("dynamic_array_primitive_values", data.getDynamicArrayPrimitiveValues());
   }

   @Override
   public test_msgs.msg.dds.DynamicArrayPrimitivesNested createData()
   {
      return new test_msgs.msg.dds.DynamicArrayPrimitivesNested();
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

   public void serialize(test_msgs.msg.dds.DynamicArrayPrimitivesNested data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(test_msgs.msg.dds.DynamicArrayPrimitivesNested data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(test_msgs.msg.dds.DynamicArrayPrimitivesNested src, test_msgs.msg.dds.DynamicArrayPrimitivesNested dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public DynamicArrayPrimitivesNestedPubSubType newInstance()
   {
      return new DynamicArrayPrimitivesNestedPubSubType();
   }
}