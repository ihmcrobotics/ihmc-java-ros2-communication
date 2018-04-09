package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "RegionOfInterest" defined in "RegionOfInterest_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from RegionOfInterest_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit RegionOfInterest_.idl instead.
*
*/
public class RegionOfInterestPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.RegionOfInterest>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::RegionOfInterest_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.RegionOfInterest data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.RegionOfInterest data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.RegionOfInterest data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.RegionOfInterest data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.RegionOfInterest data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_4(data.getXOffset());

      cdr.write_type_4(data.getYOffset());

      cdr.write_type_4(data.getHeight());

      cdr.write_type_4(data.getWidth());

      cdr.write_type_7(data.getDoRectify());

   }

   public static void read(sensor_msgs.msg.dds.RegionOfInterest data, us.ihmc.idl.CDR cdr)
   {
      data.setXOffset(cdr.read_type_4());
      	
      data.setYOffset(cdr.read_type_4());
      	
      data.setHeight(cdr.read_type_4());
      	
      data.setWidth(cdr.read_type_4());
      	
      data.setDoRectify(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.RegionOfInterest data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_4("x_offset", data.getXOffset());
      ser.write_type_4("y_offset", data.getYOffset());
      ser.write_type_4("height", data.getHeight());
      ser.write_type_4("width", data.getWidth());
      ser.write_type_7("do_rectify", data.getDoRectify());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.RegionOfInterest data)
   {
      data.setXOffset(ser.read_type_4("x_offset"));
      data.setYOffset(ser.read_type_4("y_offset"));
      data.setHeight(ser.read_type_4("height"));
      data.setWidth(ser.read_type_4("width"));
      data.setDoRectify(ser.read_type_7("do_rectify"));
   }

   public static void staticCopy(sensor_msgs.msg.dds.RegionOfInterest src, sensor_msgs.msg.dds.RegionOfInterest dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.RegionOfInterest createData()
   {
      return new sensor_msgs.msg.dds.RegionOfInterest();
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
   
   public void serialize(sensor_msgs.msg.dds.RegionOfInterest data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.RegionOfInterest data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.RegionOfInterest src, sensor_msgs.msg.dds.RegionOfInterest dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public RegionOfInterestPubSubType newInstance()
   {
      return new RegionOfInterestPubSubType();
   }
}
