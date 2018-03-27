package geometry_msgs.msg.dds;

/**
 * Topic data type of the struct "Wrench" defined in "Wrench_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from Wrench_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Wrench_.idl instead.
 */
public class WrenchPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.Wrench>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Wrench_";

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

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Wrench data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Wrench data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getForce(), current_alignment);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getTorque(), current_alignment);

      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.Wrench data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getForce(), cdr);
      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getTorque(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.Wrench data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getForce(), cdr);
      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getTorque(), cdr);
   }

   public static void staticCopy(geometry_msgs.msg.dds.Wrench src, geometry_msgs.msg.dds.Wrench dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(geometry_msgs.msg.dds.Wrench data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.Wrench data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.Wrench data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("force", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getForce());

      ser.write_type_a("torque", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getTorque());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.Wrench data)
   {
      ser.read_type_a("force", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getForce());

      ser.read_type_a("torque", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getTorque());
   }

   @Override
   public geometry_msgs.msg.dds.Wrench createData()
   {
      return new geometry_msgs.msg.dds.Wrench();
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

   public void serialize(geometry_msgs.msg.dds.Wrench data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.Wrench data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(geometry_msgs.msg.dds.Wrench src, geometry_msgs.msg.dds.Wrench dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public WrenchPubSubType newInstance()
   {
      return new WrenchPubSubType();
   }
}
