package test_msgs.msg.dds;

/**
* 
* Topic data type of the struct "StaticArrayNested" defined in "StaticArrayNested_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from StaticArrayNested_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit StaticArrayNested_.idl instead.
*
*/
public class StaticArrayNestedPubSubType implements us.ihmc.pubsub.TopicDataType<test_msgs.msg.dds.StaticArrayNested>
{
   public static final java.lang.String name = "test_msgs::msg::dds_::StaticArrayNested_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(test_msgs.msg.dds.StaticArrayNested data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, test_msgs.msg.dds.StaticArrayNested data) throws java.io.IOException
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

      for(int i0 = 0; i0 < (4); ++i0)
      {
          current_alignment += test_msgs.msg.dds.PrimitivesPubSubType.getMaxCdrSerializedSize(current_alignment);}
      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.StaticArrayNested data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(test_msgs.msg.dds.StaticArrayNested data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      for(int i0 = 0; i0 < data.getPrimitiveValues().length; ++i0)
      {
              current_alignment += test_msgs.msg.dds.PrimitivesPubSubType.getCdrSerializedSize(data.getPrimitiveValues()[i0], current_alignment);
      }
      return current_alignment - initial_alignment;
   }

   public static void write(test_msgs.msg.dds.StaticArrayNested data, us.ihmc.idl.CDR cdr)
   {
      for(int i0 = 0; i0 < data.getPrimitiveValues().length; ++i0)
      {
        	test_msgs.msg.dds.PrimitivesPubSubType.write(data.getPrimitiveValues()[i0], cdr);		
      }
   }

   public static void read(test_msgs.msg.dds.StaticArrayNested data, us.ihmc.idl.CDR cdr)
   {
      for(int i0 = 0; i0 < data.getPrimitiveValues().length; ++i0)
      {
        	test_msgs.msg.dds.PrimitivesPubSubType.read(data.getPrimitiveValues()[i0], cdr);	
      }
      	

   }

   @Override
   public final void serialize(test_msgs.msg.dds.StaticArrayNested data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_f("primitive_values", new test_msgs.msg.dds.PrimitivesPubSubType(), data.getPrimitiveValues());   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, test_msgs.msg.dds.StaticArrayNested data)
   {
      ser.read_type_f("primitive_values", new test_msgs.msg.dds.PrimitivesPubSubType(), data.getPrimitiveValues());   }

   public static void staticCopy(test_msgs.msg.dds.StaticArrayNested src, test_msgs.msg.dds.StaticArrayNested dest)
   {
      dest.set(src);
   }

   @Override
   public test_msgs.msg.dds.StaticArrayNested createData()
   {
      return new test_msgs.msg.dds.StaticArrayNested();
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
   
   public void serialize(test_msgs.msg.dds.StaticArrayNested data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(test_msgs.msg.dds.StaticArrayNested data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(test_msgs.msg.dds.StaticArrayNested src, test_msgs.msg.dds.StaticArrayNested dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public StaticArrayNestedPubSubType newInstance()
   {
      return new StaticArrayNestedPubSubType();
   }
}
