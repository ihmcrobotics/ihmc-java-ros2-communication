package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Accel" defined in "Accel_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Accel_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Accel_.idl instead.
*
*/
public class AccelPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.Accel>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Accel_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.Accel data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.Accel data) throws java.io.IOException
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


      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getMaxCdrSerializedSize(current_alignment);


      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Accel data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Accel data, int current_alignment)
   {
      int initial_alignment = current_alignment;


      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getLinear(), current_alignment);


      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getAngular(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.Accel data, us.ihmc.idl.CDR cdr)
   {

      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getLinear(), cdr);

      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getAngular(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.Accel data, us.ihmc.idl.CDR cdr)
   {

      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getLinear(), cdr);	

      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getAngular(), cdr);	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.Accel data, us.ihmc.idl.InterchangeSerializer ser)
   {

      ser.write_type_a("linear", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getLinear());


      ser.write_type_a("angular", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getAngular());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.Accel data)
   {

      ser.read_type_a("linear", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getLinear());


      ser.read_type_a("angular", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getAngular());

   }

   public static void staticCopy(geometry_msgs.msg.dds.Accel src, geometry_msgs.msg.dds.Accel dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.Accel createData()
   {
      return new geometry_msgs.msg.dds.Accel();
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
   
   public void serialize(geometry_msgs.msg.dds.Accel data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.Accel data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.Accel src, geometry_msgs.msg.dds.Accel dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AccelPubSubType newInstance()
   {
      return new AccelPubSubType();
   }
}
