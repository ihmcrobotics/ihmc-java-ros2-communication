package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "NavSatFix" defined in "NavSatFix_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from NavSatFix_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit NavSatFix_.idl instead.
*
*/
public class NavSatFixPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.NavSatFix>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::NavSatFix_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "85e5692767964cfb3f86995edef4debf1e80961c9417e98b6a1ed0ea82a0aa22";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.NavSatFix data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.NavSatFix data) throws java.io.IOException
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

      current_alignment += sensor_msgs.msg.dds.NavSatStatusPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += ((9) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.NavSatFix data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.NavSatFix data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += sensor_msgs.msg.dds.NavSatStatusPubSubType.getCdrSerializedSize(data.getStatus(), current_alignment);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += ((9) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.NavSatFix data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      sensor_msgs.msg.dds.NavSatStatusPubSubType.write(data.getStatus(), cdr);
      cdr.write_type_6(data.getLatitude());

      cdr.write_type_6(data.getLongitude());

      cdr.write_type_6(data.getAltitude());

      for(int i0 = 0; i0 < data.getPositionCovariance().length; ++i0)
      {
        	cdr.write_type_6(data.getPositionCovariance()[i0]);	
      }

      cdr.write_type_9(data.getPositionCovarianceType());

   }

   public static void read(sensor_msgs.msg.dds.NavSatFix data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      sensor_msgs.msg.dds.NavSatStatusPubSubType.read(data.getStatus(), cdr);	
      data.setLatitude(cdr.read_type_6());
      	
      data.setLongitude(cdr.read_type_6());
      	
      data.setAltitude(cdr.read_type_6());
      	
      for(int i0 = 0; i0 < data.getPositionCovariance().length; ++i0)
      {
        	data.getPositionCovariance()[i0] = cdr.read_type_6();
        	
      }
      	
      data.setPositionCovarianceType(cdr.read_type_9());
      	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.NavSatFix data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("status", new sensor_msgs.msg.dds.NavSatStatusPubSubType(), data.getStatus());

      ser.write_type_6("latitude", data.getLatitude());
      ser.write_type_6("longitude", data.getLongitude());
      ser.write_type_6("altitude", data.getAltitude());
      ser.write_type_f("position_covariance", data.getPositionCovariance());
      ser.write_type_9("position_covariance_type", data.getPositionCovarianceType());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.NavSatFix data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("status", new sensor_msgs.msg.dds.NavSatStatusPubSubType(), data.getStatus());

      data.setLatitude(ser.read_type_6("latitude"));
      data.setLongitude(ser.read_type_6("longitude"));
      data.setAltitude(ser.read_type_6("altitude"));
      ser.read_type_f("position_covariance", data.getPositionCovariance());
      data.setPositionCovarianceType(ser.read_type_9("position_covariance_type"));
   }

   public static void staticCopy(sensor_msgs.msg.dds.NavSatFix src, sensor_msgs.msg.dds.NavSatFix dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.NavSatFix createData()
   {
      return new sensor_msgs.msg.dds.NavSatFix();
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
   
   public void serialize(sensor_msgs.msg.dds.NavSatFix data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.NavSatFix data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.NavSatFix src, sensor_msgs.msg.dds.NavSatFix dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public NavSatFixPubSubType newInstance()
   {
      return new NavSatFixPubSubType();
   }
}
