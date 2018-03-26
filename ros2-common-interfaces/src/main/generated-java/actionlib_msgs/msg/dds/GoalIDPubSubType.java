package actionlib_msgs.msg.dds;

/**
 * Topic data type of the struct "GoalID" defined in "GoalID_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from GoalID_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit GoalID_.idl instead.
 */
public class GoalIDPubSubType implements us.ihmc.pubsub.TopicDataType<actionlib_msgs.msg.dds.GoalID>
{
   public static final java.lang.String name = "actionlib_msgs::msg::dds_::GoalID_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();
   public GoalIDPubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(actionlib_msgs.msg.dds.GoalID data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(actionlib_msgs.msg.dds.GoalID data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getStamp(), current_alignment);
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getId().length() + 1;

      return current_alignment - initial_alignment;
   }

   public static void write(actionlib_msgs.msg.dds.GoalID data, us.ihmc.idl.CDR cdr)
   {

      builtin_interfaces.msg.dds.TimePubSubType.write(data.getStamp(), cdr);

      if (data.getId().length() <= 255)
         cdr.write_type_d(data.getId());
      else
         throw new RuntimeException("id field exceeds the maximum length");
   }

   public static void read(actionlib_msgs.msg.dds.GoalID data, us.ihmc.idl.CDR cdr)
   {

      builtin_interfaces.msg.dds.TimePubSubType.read(data.getStamp(), cdr);

      cdr.read_type_d(data.getId());
   }

   public static void staticCopy(actionlib_msgs.msg.dds.GoalID src, actionlib_msgs.msg.dds.GoalID dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(actionlib_msgs.msg.dds.GoalID data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, actionlib_msgs.msg.dds.GoalID data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(actionlib_msgs.msg.dds.GoalID data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

      ser.write_type_d("id", data.getId());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, actionlib_msgs.msg.dds.GoalID data)
   {
      ser.read_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

      ser.read_type_d("id", data.getId());
   }

   @Override
   public actionlib_msgs.msg.dds.GoalID createData()
   {
      return new actionlib_msgs.msg.dds.GoalID();
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

   public void serialize(actionlib_msgs.msg.dds.GoalID data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(actionlib_msgs.msg.dds.GoalID data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(actionlib_msgs.msg.dds.GoalID src, actionlib_msgs.msg.dds.GoalID dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public GoalIDPubSubType newInstance()
   {
      return new GoalIDPubSubType();
   }
}
