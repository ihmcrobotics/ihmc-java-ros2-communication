package action_msgs.msg.dds;

/**
* 
* Topic data type of the struct "GoalInfo" defined in "GoalInfo_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from GoalInfo_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit GoalInfo_.idl instead.
*
*/
public class GoalInfoPubSubType implements us.ihmc.pubsub.TopicDataType<action_msgs.msg.dds.GoalInfo>
{
   public static final java.lang.String name = "action_msgs::msg::dds_::GoalInfo_";
   
   @Override
   public final String getDefinitionChecksum()
   {
   		return "09655785afbdfa05fd61bfbf1d660acf6cccbff8bf942da274fb290a5e3a948b";
   }
   
   @Override
   public final String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(action_msgs.msg.dds.GoalInfo data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, action_msgs.msg.dds.GoalInfo data) throws java.io.IOException
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

      current_alignment += unique_identifier_msgs.msg.dds.UUIDPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(action_msgs.msg.dds.GoalInfo data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(action_msgs.msg.dds.GoalInfo data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += unique_identifier_msgs.msg.dds.UUIDPubSubType.getCdrSerializedSize(data.getGoalId(), current_alignment);

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getStamp(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(action_msgs.msg.dds.GoalInfo data, us.ihmc.idl.CDR cdr)
   {
      unique_identifier_msgs.msg.dds.UUIDPubSubType.write(data.getGoalId(), cdr);
      builtin_interfaces.msg.dds.TimePubSubType.write(data.getStamp(), cdr);
   }

   public static void read(action_msgs.msg.dds.GoalInfo data, us.ihmc.idl.CDR cdr)
   {
      unique_identifier_msgs.msg.dds.UUIDPubSubType.read(data.getGoalId(), cdr);	
      builtin_interfaces.msg.dds.TimePubSubType.read(data.getStamp(), cdr);	

   }

   @Override
   public final void serialize(action_msgs.msg.dds.GoalInfo data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("goal_id", new unique_identifier_msgs.msg.dds.UUIDPubSubType(), data.getGoalId());

      ser.write_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, action_msgs.msg.dds.GoalInfo data)
   {
      ser.read_type_a("goal_id", new unique_identifier_msgs.msg.dds.UUIDPubSubType(), data.getGoalId());

      ser.read_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

   }

   public static void staticCopy(action_msgs.msg.dds.GoalInfo src, action_msgs.msg.dds.GoalInfo dest)
   {
      dest.set(src);
   }

   @Override
   public action_msgs.msg.dds.GoalInfo createData()
   {
      return new action_msgs.msg.dds.GoalInfo();
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
   
   public void serialize(action_msgs.msg.dds.GoalInfo data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(action_msgs.msg.dds.GoalInfo data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(action_msgs.msg.dds.GoalInfo src, action_msgs.msg.dds.GoalInfo dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public GoalInfoPubSubType newInstance()
   {
      return new GoalInfoPubSubType();
   }
}
