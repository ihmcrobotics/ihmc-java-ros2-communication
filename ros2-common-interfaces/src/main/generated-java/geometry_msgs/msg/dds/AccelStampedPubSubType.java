package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "AccelStamped" defined in "AccelStamped_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from AccelStamped_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit AccelStamped_.idl instead.
*
*/
public class AccelStampedPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.AccelStamped>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::AccelStamped_";
   
   @Override
   public final String getDefinitionChecksum()
   {
   		return "5921fb7a4a04b40f6a057e8aa4c9c0093e7d3a34d6f42d7d358134713b33ec9c";
   }
   
   @Override
   public final String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.AccelStamped data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.AccelStamped data) throws java.io.IOException
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

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += geometry_msgs.msg.dds.AccelPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.AccelStamped data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.AccelStamped data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += geometry_msgs.msg.dds.AccelPubSubType.getCdrSerializedSize(data.getAccel(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.AccelStamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      geometry_msgs.msg.dds.AccelPubSubType.write(data.getAccel(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.AccelStamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      geometry_msgs.msg.dds.AccelPubSubType.read(data.getAccel(), cdr);	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.AccelStamped data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("accel", new geometry_msgs.msg.dds.AccelPubSubType(), data.getAccel());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.AccelStamped data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("accel", new geometry_msgs.msg.dds.AccelPubSubType(), data.getAccel());

   }

   public static void staticCopy(geometry_msgs.msg.dds.AccelStamped src, geometry_msgs.msg.dds.AccelStamped dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.AccelStamped createData()
   {
      return new geometry_msgs.msg.dds.AccelStamped();
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
   
   public void serialize(geometry_msgs.msg.dds.AccelStamped data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.AccelStamped data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.AccelStamped src, geometry_msgs.msg.dds.AccelStamped dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AccelStampedPubSubType newInstance()
   {
      return new AccelStampedPubSubType();
   }
}
