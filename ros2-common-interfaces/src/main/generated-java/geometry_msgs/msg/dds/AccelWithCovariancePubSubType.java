package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "AccelWithCovariance" defined in "AccelWithCovariance_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from AccelWithCovariance_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit AccelWithCovariance_.idl instead.
*
*/
public class AccelWithCovariancePubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.AccelWithCovariance>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::AccelWithCovariance_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "c1cd3aae55942c1f06fa6861ce60bd37cdb39e71fec0351c4d507b4260a2bbeb";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.AccelWithCovariance data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.AccelWithCovariance data) throws java.io.IOException
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

      current_alignment += geometry_msgs.msg.dds.AccelPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += ((36) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.AccelWithCovariance data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.AccelWithCovariance data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.AccelPubSubType.getCdrSerializedSize(data.getAccel(), current_alignment);

      current_alignment += ((36) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.AccelWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.AccelPubSubType.write(data.getAccel(), cdr);
      for(int i0 = 0; i0 < data.getCovariance().length; ++i0)
      {
        	cdr.write_type_6(data.getCovariance()[i0]);	
      }

   }

   public static void read(geometry_msgs.msg.dds.AccelWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.AccelPubSubType.read(data.getAccel(), cdr);	
      for(int i0 = 0; i0 < data.getCovariance().length; ++i0)
      {
        	data.getCovariance()[i0] = cdr.read_type_6();
        	
      }
      	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.AccelWithCovariance data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("accel", new geometry_msgs.msg.dds.AccelPubSubType(), data.getAccel());

      ser.write_type_f("covariance", data.getCovariance());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.AccelWithCovariance data)
   {
      ser.read_type_a("accel", new geometry_msgs.msg.dds.AccelPubSubType(), data.getAccel());

      ser.read_type_f("covariance", data.getCovariance());
   }

   public static void staticCopy(geometry_msgs.msg.dds.AccelWithCovariance src, geometry_msgs.msg.dds.AccelWithCovariance dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.AccelWithCovariance createData()
   {
      return new geometry_msgs.msg.dds.AccelWithCovariance();
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
   
   public void serialize(geometry_msgs.msg.dds.AccelWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.AccelWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.AccelWithCovariance src, geometry_msgs.msg.dds.AccelWithCovariance dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AccelWithCovariancePubSubType newInstance()
   {
      return new AccelWithCovariancePubSubType();
   }
}
