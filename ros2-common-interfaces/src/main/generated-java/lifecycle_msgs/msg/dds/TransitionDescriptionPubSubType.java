package lifecycle_msgs.msg.dds;

/**
* 
* Topic data type of the struct "TransitionDescription" defined in "TransitionDescription_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TransitionDescription_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TransitionDescription_.idl instead.
*
*/
public class TransitionDescriptionPubSubType implements us.ihmc.pubsub.TopicDataType<lifecycle_msgs.msg.dds.TransitionDescription>
{
   public static final java.lang.String name = "lifecycle_msgs::msg::dds_::TransitionDescription_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(lifecycle_msgs.msg.dds.TransitionDescription data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, lifecycle_msgs.msg.dds.TransitionDescription data) throws java.io.IOException
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

      current_alignment += lifecycle_msgs.msg.dds.TransitionPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += lifecycle_msgs.msg.dds.StatePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += lifecycle_msgs.msg.dds.StatePubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(lifecycle_msgs.msg.dds.TransitionDescription data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(lifecycle_msgs.msg.dds.TransitionDescription data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += lifecycle_msgs.msg.dds.TransitionPubSubType.getCdrSerializedSize(data.getTransition(), current_alignment);

      current_alignment += lifecycle_msgs.msg.dds.StatePubSubType.getCdrSerializedSize(data.getStartState(), current_alignment);

      current_alignment += lifecycle_msgs.msg.dds.StatePubSubType.getCdrSerializedSize(data.getGoalState(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(lifecycle_msgs.msg.dds.TransitionDescription data, us.ihmc.idl.CDR cdr)
   {
      lifecycle_msgs.msg.dds.TransitionPubSubType.write(data.getTransition(), cdr);
      lifecycle_msgs.msg.dds.StatePubSubType.write(data.getStartState(), cdr);
      lifecycle_msgs.msg.dds.StatePubSubType.write(data.getGoalState(), cdr);
   }

   public static void read(lifecycle_msgs.msg.dds.TransitionDescription data, us.ihmc.idl.CDR cdr)
   {
      lifecycle_msgs.msg.dds.TransitionPubSubType.read(data.getTransition(), cdr);	
      lifecycle_msgs.msg.dds.StatePubSubType.read(data.getStartState(), cdr);	
      lifecycle_msgs.msg.dds.StatePubSubType.read(data.getGoalState(), cdr);	

   }

   @Override
   public final void serialize(lifecycle_msgs.msg.dds.TransitionDescription data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("transition", new lifecycle_msgs.msg.dds.TransitionPubSubType(), data.getTransition());

      ser.write_type_a("start_state", new lifecycle_msgs.msg.dds.StatePubSubType(), data.getStartState());

      ser.write_type_a("goal_state", new lifecycle_msgs.msg.dds.StatePubSubType(), data.getGoalState());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, lifecycle_msgs.msg.dds.TransitionDescription data)
   {
      ser.read_type_a("transition", new lifecycle_msgs.msg.dds.TransitionPubSubType(), data.getTransition());

      ser.read_type_a("start_state", new lifecycle_msgs.msg.dds.StatePubSubType(), data.getStartState());

      ser.read_type_a("goal_state", new lifecycle_msgs.msg.dds.StatePubSubType(), data.getGoalState());

   }

   public static void staticCopy(lifecycle_msgs.msg.dds.TransitionDescription src, lifecycle_msgs.msg.dds.TransitionDescription dest)
   {
      dest.set(src);
   }

   @Override
   public lifecycle_msgs.msg.dds.TransitionDescription createData()
   {
      return new lifecycle_msgs.msg.dds.TransitionDescription();
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
   
   public void serialize(lifecycle_msgs.msg.dds.TransitionDescription data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(lifecycle_msgs.msg.dds.TransitionDescription data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(lifecycle_msgs.msg.dds.TransitionDescription src, lifecycle_msgs.msg.dds.TransitionDescription dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TransitionDescriptionPubSubType newInstance()
   {
      return new TransitionDescriptionPubSubType();
   }
}
