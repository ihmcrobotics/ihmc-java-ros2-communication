package rosgraph_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Clock" defined in "Clock_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Clock_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Clock_.idl instead.
*
*/
public class ClockPubSubType implements us.ihmc.pubsub.TopicDataType<rosgraph_msgs.msg.dds.Clock>
{
   public static final java.lang.String name = "rosgraph_msgs::msg::dds_::Clock_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "f0b754e76fd92b7c0f4ebd130c7c129baf49f207e978402986a09dc706285359";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rosgraph_msgs.msg.dds.Clock data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rosgraph_msgs.msg.dds.Clock data) throws java.io.IOException
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

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rosgraph_msgs.msg.dds.Clock data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rosgraph_msgs.msg.dds.Clock data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getClock(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(rosgraph_msgs.msg.dds.Clock data, us.ihmc.idl.CDR cdr)
   {
      builtin_interfaces.msg.dds.TimePubSubType.write(data.getClock(), cdr);   }

   public static void read(rosgraph_msgs.msg.dds.Clock data, us.ihmc.idl.CDR cdr)
   {
      builtin_interfaces.msg.dds.TimePubSubType.read(data.getClock(), cdr);	

   }

   @Override
   public final void serialize(rosgraph_msgs.msg.dds.Clock data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("clock", new builtin_interfaces.msg.dds.TimePubSubType(), data.getClock());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rosgraph_msgs.msg.dds.Clock data)
   {
      ser.read_type_a("clock", new builtin_interfaces.msg.dds.TimePubSubType(), data.getClock());
   }

   public static void staticCopy(rosgraph_msgs.msg.dds.Clock src, rosgraph_msgs.msg.dds.Clock dest)
   {
      dest.set(src);
   }

   @Override
   public rosgraph_msgs.msg.dds.Clock createData()
   {
      return new rosgraph_msgs.msg.dds.Clock();
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
   
   public void serialize(rosgraph_msgs.msg.dds.Clock data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rosgraph_msgs.msg.dds.Clock data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rosgraph_msgs.msg.dds.Clock src, rosgraph_msgs.msg.dds.Clock dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ClockPubSubType newInstance()
   {
      return new ClockPubSubType();
   }
}
