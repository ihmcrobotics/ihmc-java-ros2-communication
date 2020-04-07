package std_msgs.msg.dds;

/**
* 
* Topic data type of the struct "ColorRGBA" defined in "ColorRGBA_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ColorRGBA_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ColorRGBA_.idl instead.
*
*/
public class ColorRGBAPubSubType implements us.ihmc.pubsub.TopicDataType<std_msgs.msg.dds.ColorRGBA>
{
   public static final java.lang.String name = "std_msgs::msg::dds_::ColorRGBA_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(std_msgs.msg.dds.ColorRGBA data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, std_msgs.msg.dds.ColorRGBA data) throws java.io.IOException
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


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.ColorRGBA data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.ColorRGBA data, int current_alignment)
   {
      int initial_alignment = current_alignment;


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(std_msgs.msg.dds.ColorRGBA data, us.ihmc.idl.CDR cdr)
   {

      cdr.write_type_5(data.getR());


      cdr.write_type_5(data.getG());


      cdr.write_type_5(data.getB());


      cdr.write_type_5(data.getA());

   }

   public static void read(std_msgs.msg.dds.ColorRGBA data, us.ihmc.idl.CDR cdr)
   {

      data.setR(cdr.read_type_5());
      	

      data.setG(cdr.read_type_5());
      	

      data.setB(cdr.read_type_5());
      	

      data.setA(cdr.read_type_5());
      	

   }

   @Override
   public final void serialize(std_msgs.msg.dds.ColorRGBA data, us.ihmc.idl.InterchangeSerializer ser)
   {

      ser.write_type_5("r", data.getR());

      ser.write_type_5("g", data.getG());

      ser.write_type_5("b", data.getB());

      ser.write_type_5("a", data.getA());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, std_msgs.msg.dds.ColorRGBA data)
   {

      data.setR(ser.read_type_5("r"));

      data.setG(ser.read_type_5("g"));

      data.setB(ser.read_type_5("b"));

      data.setA(ser.read_type_5("a"));
   }

   public static void staticCopy(std_msgs.msg.dds.ColorRGBA src, std_msgs.msg.dds.ColorRGBA dest)
   {
      dest.set(src);
   }

   @Override
   public std_msgs.msg.dds.ColorRGBA createData()
   {
      return new std_msgs.msg.dds.ColorRGBA();
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
   
   public void serialize(std_msgs.msg.dds.ColorRGBA data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(std_msgs.msg.dds.ColorRGBA data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(std_msgs.msg.dds.ColorRGBA src, std_msgs.msg.dds.ColorRGBA dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ColorRGBAPubSubType newInstance()
   {
      return new ColorRGBAPubSubType();
   }
}
