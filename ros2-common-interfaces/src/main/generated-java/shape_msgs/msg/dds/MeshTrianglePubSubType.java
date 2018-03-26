package shape_msgs.msg.dds;

/**
 * Topic data type of the struct "MeshTriangle" defined in "MeshTriangle_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from MeshTriangle_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit MeshTriangle_.idl instead.
 */
public class MeshTrianglePubSubType implements us.ihmc.pubsub.TopicDataType<shape_msgs.msg.dds.MeshTriangle>
{
   public static final java.lang.String name = "shape_msgs::msg::dds_::MeshTriangle_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public MeshTrianglePubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(shape_msgs.msg.dds.MeshTriangle data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(shape_msgs.msg.dds.MeshTriangle data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      return current_alignment - initial_alignment;
   }

   public static void write(shape_msgs.msg.dds.MeshTriangle data, us.ihmc.idl.CDR cdr)
   {
   }

   public static void read(shape_msgs.msg.dds.MeshTriangle data, us.ihmc.idl.CDR cdr)
   {
   }

   public static void staticCopy(shape_msgs.msg.dds.MeshTriangle src, shape_msgs.msg.dds.MeshTriangle dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(shape_msgs.msg.dds.MeshTriangle data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, shape_msgs.msg.dds.MeshTriangle data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(shape_msgs.msg.dds.MeshTriangle data, us.ihmc.idl.InterchangeSerializer ser)
   {
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, shape_msgs.msg.dds.MeshTriangle data)
   {
   }

   @Override
   public shape_msgs.msg.dds.MeshTriangle createData()
   {
      return new shape_msgs.msg.dds.MeshTriangle();
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

   public void serialize(shape_msgs.msg.dds.MeshTriangle data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(shape_msgs.msg.dds.MeshTriangle data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(shape_msgs.msg.dds.MeshTriangle src, shape_msgs.msg.dds.MeshTriangle dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MeshTrianglePubSubType newInstance()
   {
      return new MeshTrianglePubSubType();
   }
}
