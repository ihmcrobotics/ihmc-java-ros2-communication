package builtin_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "Time" defined in "Time_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Time_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Time_.idl instead.
*
*/
public class TimePubSubType implements us.ihmc.pubsub.TopicDataType<builtin_interfaces.msg.dds.Time>
{
   public static final java.lang.String name = "builtin_interfaces::msg::dds_::Time_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "5b16ab3b1a21e6d5efd7f954bafdf197295e22c27f672a7e0fe019ac5805cdba";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(builtin_interfaces.msg.dds.Time data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, builtin_interfaces.msg.dds.Time data) throws java.io.IOException
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


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(builtin_interfaces.msg.dds.Time data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(builtin_interfaces.msg.dds.Time data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(builtin_interfaces.msg.dds.Time data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_2(data.getSec());

      cdr.write_type_4(data.getNanosec());

   }

   public static void read(builtin_interfaces.msg.dds.Time data, us.ihmc.idl.CDR cdr)
   {
      data.setSec(cdr.read_type_2());
      	
      data.setNanosec(cdr.read_type_4());
      	

   }

   @Override
   public final void serialize(builtin_interfaces.msg.dds.Time data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_2("sec", data.getSec());
      ser.write_type_4("nanosec", data.getNanosec());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, builtin_interfaces.msg.dds.Time data)
   {
      data.setSec(ser.read_type_2("sec"));
      data.setNanosec(ser.read_type_4("nanosec"));
   }

   public static void staticCopy(builtin_interfaces.msg.dds.Time src, builtin_interfaces.msg.dds.Time dest)
   {
      dest.set(src);
   }

   @Override
   public builtin_interfaces.msg.dds.Time createData()
   {
      return new builtin_interfaces.msg.dds.Time();
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
   
   public void serialize(builtin_interfaces.msg.dds.Time data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(builtin_interfaces.msg.dds.Time data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(builtin_interfaces.msg.dds.Time src, builtin_interfaces.msg.dds.Time dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TimePubSubType newInstance()
   {
      return new TimePubSubType();
   }
}
