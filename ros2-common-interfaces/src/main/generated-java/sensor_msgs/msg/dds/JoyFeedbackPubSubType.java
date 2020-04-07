package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "JoyFeedback" defined in "JoyFeedback_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from JoyFeedback_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit JoyFeedback_.idl instead.
*
*/
public class JoyFeedbackPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.JoyFeedback>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::JoyFeedback_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.JoyFeedback data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.JoyFeedback data) throws java.io.IOException
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


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.JoyFeedback data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.JoyFeedback data, int current_alignment)
   {
      int initial_alignment = current_alignment;


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.JoyFeedback data, us.ihmc.idl.CDR cdr)
   {

      cdr.write_type_9(data.getType());


      cdr.write_type_9(data.getId());


      cdr.write_type_5(data.getIntensity());

   }

   public static void read(sensor_msgs.msg.dds.JoyFeedback data, us.ihmc.idl.CDR cdr)
   {

      data.setType(cdr.read_type_9());
      	

      data.setId(cdr.read_type_9());
      	

      data.setIntensity(cdr.read_type_5());
      	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.JoyFeedback data, us.ihmc.idl.InterchangeSerializer ser)
   {

      ser.write_type_9("type", data.getType());

      ser.write_type_9("id", data.getId());

      ser.write_type_5("intensity", data.getIntensity());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.JoyFeedback data)
   {

      data.setType(ser.read_type_9("type"));

      data.setId(ser.read_type_9("id"));

      data.setIntensity(ser.read_type_5("intensity"));
   }

   public static void staticCopy(sensor_msgs.msg.dds.JoyFeedback src, sensor_msgs.msg.dds.JoyFeedback dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.JoyFeedback createData()
   {
      return new sensor_msgs.msg.dds.JoyFeedback();
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
   
   public void serialize(sensor_msgs.msg.dds.JoyFeedback data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.JoyFeedback data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.JoyFeedback src, sensor_msgs.msg.dds.JoyFeedback dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public JoyFeedbackPubSubType newInstance()
   {
      return new JoyFeedbackPubSubType();
   }
}
