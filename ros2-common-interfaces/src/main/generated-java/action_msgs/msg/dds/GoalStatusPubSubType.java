package action_msgs.msg.dds;

/**
* 
* Topic data type of the struct "GoalStatus" defined in "GoalStatus_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from GoalStatus_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit GoalStatus_.idl instead.
*
*/
public class GoalStatusPubSubType implements us.ihmc.pubsub.TopicDataType<action_msgs.msg.dds.GoalStatus>
{
   public static final java.lang.String name = "action_msgs::msg::dds_::GoalStatus_";
   
   @Override
   public final String getDefinitionChecksum()
   {
   		return "e1993ccdaa825104b6a77b83844fc4a44c192594a6b71c2f77a8bbc00623e4b6";
   }
   
   @Override
   public final String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(action_msgs.msg.dds.GoalStatus data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, action_msgs.msg.dds.GoalStatus data) throws java.io.IOException
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

      current_alignment += action_msgs.msg.dds.GoalInfoPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(action_msgs.msg.dds.GoalStatus data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(action_msgs.msg.dds.GoalStatus data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += action_msgs.msg.dds.GoalInfoPubSubType.getCdrSerializedSize(data.getGoalInfo(), current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(action_msgs.msg.dds.GoalStatus data, us.ihmc.idl.CDR cdr)
   {
      action_msgs.msg.dds.GoalInfoPubSubType.write(data.getGoalInfo(), cdr);
      cdr.write_type_9(data.getStatus());

   }

   public static void read(action_msgs.msg.dds.GoalStatus data, us.ihmc.idl.CDR cdr)
   {
      action_msgs.msg.dds.GoalInfoPubSubType.read(data.getGoalInfo(), cdr);	
      data.setStatus(cdr.read_type_9());
      	

   }

   @Override
   public final void serialize(action_msgs.msg.dds.GoalStatus data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("goal_info", new action_msgs.msg.dds.GoalInfoPubSubType(), data.getGoalInfo());

      ser.write_type_9("status", data.getStatus());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, action_msgs.msg.dds.GoalStatus data)
   {
      ser.read_type_a("goal_info", new action_msgs.msg.dds.GoalInfoPubSubType(), data.getGoalInfo());

      data.setStatus(ser.read_type_9("status"));
   }

   public static void staticCopy(action_msgs.msg.dds.GoalStatus src, action_msgs.msg.dds.GoalStatus dest)
   {
      dest.set(src);
   }

   @Override
   public action_msgs.msg.dds.GoalStatus createData()
   {
      return new action_msgs.msg.dds.GoalStatus();
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
   
   public void serialize(action_msgs.msg.dds.GoalStatus data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(action_msgs.msg.dds.GoalStatus data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(action_msgs.msg.dds.GoalStatus src, action_msgs.msg.dds.GoalStatus dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public GoalStatusPubSubType newInstance()
   {
      return new GoalStatusPubSubType();
   }
}
