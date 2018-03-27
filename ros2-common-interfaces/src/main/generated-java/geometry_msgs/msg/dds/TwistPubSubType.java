package geometry_msgs.msg.dds;

/**
 * Topic data type of the struct "Twist" defined in "Twist_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from Twist_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Twist_.idl instead.
 */
public class TwistPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.Twist>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Twist_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getMaxCdrSerializedSize(current_alignment);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Twist data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Twist data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getLinear(), current_alignment);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getAngular(), current_alignment);

      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.Twist data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getLinear(), cdr);
      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getAngular(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.Twist data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getLinear(), cdr);
      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getAngular(), cdr);
   }

   public static void staticCopy(geometry_msgs.msg.dds.Twist src, geometry_msgs.msg.dds.Twist dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(geometry_msgs.msg.dds.Twist data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.Twist data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.Twist data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("linear", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getLinear());

      ser.write_type_a("angular", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getAngular());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.Twist data)
   {
      ser.read_type_a("linear", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getLinear());

      ser.read_type_a("angular", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getAngular());
   }

   @Override
   public geometry_msgs.msg.dds.Twist createData()
   {
      return new geometry_msgs.msg.dds.Twist();
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

   public void serialize(geometry_msgs.msg.dds.Twist data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.Twist data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(geometry_msgs.msg.dds.Twist src, geometry_msgs.msg.dds.Twist dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TwistPubSubType newInstance()
   {
      return new TwistPubSubType();
   }
}
