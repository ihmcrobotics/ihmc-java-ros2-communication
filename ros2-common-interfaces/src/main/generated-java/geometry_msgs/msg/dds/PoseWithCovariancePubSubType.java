package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "PoseWithCovariance" defined in "PoseWithCovariance_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from PoseWithCovariance_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit PoseWithCovariance_.idl instead.
*
*/
public class PoseWithCovariancePubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.PoseWithCovariance>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::PoseWithCovariance_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "4ce1a14ffc7290d048997532897b36d6ef11a34f0e0acfb40e38d0cd5441fa71";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.PoseWithCovariance data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.PoseWithCovariance data) throws java.io.IOException
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

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += ((36) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.PoseWithCovariance data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.PoseWithCovariance data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getCdrSerializedSize(data.getPose(), current_alignment);

      current_alignment += ((36) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.PoseWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.PosePubSubType.write(data.getPose(), cdr);
      for(int i0 = 0; i0 < data.getCovariance().length; ++i0)
      {
        	cdr.write_type_6(data.getCovariance()[i0]);	
      }

   }

   public static void read(geometry_msgs.msg.dds.PoseWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.PosePubSubType.read(data.getPose(), cdr);	
      for(int i0 = 0; i0 < data.getCovariance().length; ++i0)
      {
        	data.getCovariance()[i0] = cdr.read_type_6();
        	
      }
      	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.PoseWithCovariance data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      ser.write_type_f("covariance", data.getCovariance());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.PoseWithCovariance data)
   {
      ser.read_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      ser.read_type_f("covariance", data.getCovariance());
   }

   public static void staticCopy(geometry_msgs.msg.dds.PoseWithCovariance src, geometry_msgs.msg.dds.PoseWithCovariance dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.PoseWithCovariance createData()
   {
      return new geometry_msgs.msg.dds.PoseWithCovariance();
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
   
   public void serialize(geometry_msgs.msg.dds.PoseWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.PoseWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.PoseWithCovariance src, geometry_msgs.msg.dds.PoseWithCovariance dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PoseWithCovariancePubSubType newInstance()
   {
      return new PoseWithCovariancePubSubType();
   }
}
