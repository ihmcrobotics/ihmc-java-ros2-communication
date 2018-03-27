package std_msgs.msg.dds;

/**
 * Topic data type of the struct "Char" defined in "Char_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from Char_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Char_.idl instead.
 */
public class CharPubSubType implements us.ihmc.pubsub.TopicDataType<std_msgs.msg.dds.Char>
{
   public static final java.lang.String name = "std_msgs::msg::dds_::Char_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.Char data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.Char data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      return current_alignment - initial_alignment;
   }

   public static void write(std_msgs.msg.dds.Char data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_8(data.getData());
   }

   public static void read(std_msgs.msg.dds.Char data, us.ihmc.idl.CDR cdr)
   {
      data.setData(cdr.read_type_8());
   }

   public static void staticCopy(std_msgs.msg.dds.Char src, std_msgs.msg.dds.Char dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(std_msgs.msg.dds.Char data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, std_msgs.msg.dds.Char data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(std_msgs.msg.dds.Char data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_8("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, std_msgs.msg.dds.Char data)
   {
      data.setData(ser.read_type_8("data"));
   }

   @Override
   public std_msgs.msg.dds.Char createData()
   {
      return new std_msgs.msg.dds.Char();
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

   public void serialize(std_msgs.msg.dds.Char data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(std_msgs.msg.dds.Char data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(std_msgs.msg.dds.Char src, std_msgs.msg.dds.Char dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public CharPubSubType newInstance()
   {
      return new CharPubSubType();
   }
}
