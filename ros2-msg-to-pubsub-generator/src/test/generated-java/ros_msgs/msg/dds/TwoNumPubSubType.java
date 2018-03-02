package ros_msgs.msg.dds;

/**
 * Topic data type of the struct "TwoNum" defined in "TwoNum_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from TwoNum_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit TwoNum_.idl instead.
 */
public class TwoNumPubSubType implements us.ihmc.pubsub.TopicDataType<ros_msgs.msg.dds.TwoNum>
{
   public static final java.lang.String name = "ros_msgs::msg::dds_::TwoNum_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public TwoNumPubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += ros_msgs.msg.dds.NumPubSubType.getMaxCdrSerializedSize(current_alignment);
      current_alignment += ros_msgs.msg.dds.NumPubSubType.getMaxCdrSerializedSize(current_alignment);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.TwoNum data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.TwoNum data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += ros_msgs.msg.dds.NumPubSubType.getCdrSerializedSize(data.getNum1(), current_alignment);
      current_alignment += ros_msgs.msg.dds.NumPubSubType.getCdrSerializedSize(data.getNum2(), current_alignment);

      return current_alignment - initial_alignment;
   }

   public static void write(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.CDR cdr)
   {

      ros_msgs.msg.dds.NumPubSubType.write(data.getNum1(), cdr);

      ros_msgs.msg.dds.NumPubSubType.write(data.getNum2(), cdr);
   }

   public static void read(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.CDR cdr)
   {

      ros_msgs.msg.dds.NumPubSubType.read(data.getNum1(), cdr);

      ros_msgs.msg.dds.NumPubSubType.read(data.getNum2(), cdr);
   }

   public static void staticCopy(ros_msgs.msg.dds.TwoNum src, ros_msgs.msg.dds.TwoNum dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(ros_msgs.msg.dds.TwoNum data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, ros_msgs.msg.dds.TwoNum data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("num1", new ros_msgs.msg.dds.NumPubSubType(), data.getNum1());

      ser.write_type_a("num2", new ros_msgs.msg.dds.NumPubSubType(), data.getNum2());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, ros_msgs.msg.dds.TwoNum data)
   {
      ser.read_type_a("num1", new ros_msgs.msg.dds.NumPubSubType(), data.getNum1());

      ser.read_type_a("num2", new ros_msgs.msg.dds.NumPubSubType(), data.getNum2());
   }

   @Override
   public ros_msgs.msg.dds.TwoNum createData()
   {
      return new ros_msgs.msg.dds.TwoNum();
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

   public void serialize(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(ros_msgs.msg.dds.TwoNum src, ros_msgs.msg.dds.TwoNum dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TwoNumPubSubType newInstance()
   {
      return new TwoNumPubSubType();
   }
}