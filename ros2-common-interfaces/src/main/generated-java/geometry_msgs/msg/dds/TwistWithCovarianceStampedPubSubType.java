package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "TwistWithCovarianceStamped" defined in "TwistWithCovarianceStamped_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TwistWithCovarianceStamped_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TwistWithCovarianceStamped_.idl instead.
*
*/
public class TwistWithCovarianceStampedPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.TwistWithCovarianceStamped>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::TwistWithCovarianceStamped_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "c800aacc58057ea5a33e7f974c94a8b9ac37c11fcf5e8c891fc4bf884075e4e1";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.TwistWithCovarianceStamped data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.TwistWithCovarianceStamped data) throws java.io.IOException
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

      current_alignment += geometry_msgs.msg.dds.TwistWithCovariancePubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.TwistWithCovarianceStamped data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.TwistWithCovarianceStamped data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += geometry_msgs.msg.dds.TwistWithCovariancePubSubType.getCdrSerializedSize(data.getTwist(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.TwistWithCovarianceStamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      geometry_msgs.msg.dds.TwistWithCovariancePubSubType.write(data.getTwist(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.TwistWithCovarianceStamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      geometry_msgs.msg.dds.TwistWithCovariancePubSubType.read(data.getTwist(), cdr);	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.TwistWithCovarianceStamped data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("twist", new geometry_msgs.msg.dds.TwistWithCovariancePubSubType(), data.getTwist());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.TwistWithCovarianceStamped data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("twist", new geometry_msgs.msg.dds.TwistWithCovariancePubSubType(), data.getTwist());

   }

   public static void staticCopy(geometry_msgs.msg.dds.TwistWithCovarianceStamped src, geometry_msgs.msg.dds.TwistWithCovarianceStamped dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.TwistWithCovarianceStamped createData()
   {
      return new geometry_msgs.msg.dds.TwistWithCovarianceStamped();
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
   
   public void serialize(geometry_msgs.msg.dds.TwistWithCovarianceStamped data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.TwistWithCovarianceStamped data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.TwistWithCovarianceStamped src, geometry_msgs.msg.dds.TwistWithCovarianceStamped dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TwistWithCovarianceStampedPubSubType newInstance()
   {
      return new TwistWithCovarianceStampedPubSubType();
   }
}
