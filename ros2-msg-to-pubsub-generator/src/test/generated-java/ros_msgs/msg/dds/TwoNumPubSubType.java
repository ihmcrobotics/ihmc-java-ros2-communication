package ros_msgs.msg.dds;

/**
 * Topic data type of the struct "TwoNum" defined in "TwoNum_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from TwoNum_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit TwoNum_.idl instead.
 */
public class TwoNumPubSubType implements us.ihmc.pubsub.TopicDataType<ros_msgs.msg.dds.TwoNum>
{
   public static final java.lang.String name = "ros_msgs::msg::dds_::TwoNum_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public TwoNumPubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += ros_msgs.msg.dds.NumPubSubType.getMaxCdrSerializedSize(current_alignment);
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < 100; ++i0)
      {
         current_alignment += ros_msgs.msg.dds.NumPubSubType.getMaxCdrSerializedSize(current_alignment);
      }

      for (int i0 = 0; i0 < (3); ++i0)
      {
         current_alignment += ros_msgs.msg.dds.NumPubSubType.getMaxCdrSerializedSize(current_alignment);
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < 3; ++i0)
      {
         current_alignment += ros_msgs.msg.dds.NumPubSubType.getMaxCdrSerializedSize(current_alignment);
      }

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 10 + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < 5; ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < 100; ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 10 + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < 5; ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 10 + 1;
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.TwoNum data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.TwoNum data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += ros_msgs.msg.dds.NumPubSubType.getCdrSerializedSize(data.getNum1(), current_alignment);
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < data.getNum2().size(); ++i0)
      {
         current_alignment += ros_msgs.msg.dds.NumPubSubType.getCdrSerializedSize(data.getNum2().get(i0), current_alignment);
      }

      for (int i0 = 0; i0 < data.getNum3().length; ++i0)
      {
         current_alignment += ros_msgs.msg.dds.NumPubSubType.getCdrSerializedSize(data.getNum3()[i0], current_alignment);
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < data.getNum4().size(); ++i0)
      {
         current_alignment += ros_msgs.msg.dds.NumPubSubType.getCdrSerializedSize(data.getNum4().get(i0), current_alignment);
      }

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr1().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr2().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < data.getStr3().size(); ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr3().get(i0).length() + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < data.getStr4().size(); ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr4().get(i0).length() + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for (int i0 = 0; i0 < data.getStr5().size(); ++i0)
      {
         current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr5().get(i0).length() + 1;
      }

      return current_alignment - initial_alignment;
   }

   public static void write(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.CDR cdr)
   {

      ros_msgs.msg.dds.NumPubSubType.write(data.getNum1(), cdr);

      if (data.getNum2().size() <= 100)
         cdr.write_type_e(data.getNum2());
      else
         throw new RuntimeException("num2 field exceeds the maximum length");

      for (int i0 = 0; i0 < data.getNum3().length; ++i0)
      {
         ros_msgs.msg.dds.NumPubSubType.write(data.getNum3()[i0], cdr);
      }

      if (data.getNum4().size() <= 3)
         cdr.write_type_e(data.getNum4());
      else
         throw new RuntimeException("num4 field exceeds the maximum length");

      if (data.getStr1().length() <= 255)
         cdr.write_type_d(data.getStr1());
      else
         throw new RuntimeException("str1 field exceeds the maximum length");

      if (data.getStr2().length() <= 10)
         cdr.write_type_d(data.getStr2());
      else
         throw new RuntimeException("str2 field exceeds the maximum length");

      if (data.getStr3().size() <= 5)
         cdr.write_type_e(data.getStr3());
      else
         throw new RuntimeException("str3 field exceeds the maximum length");

      if (data.getStr4().size() <= 100)
         cdr.write_type_e(data.getStr4());
      else
         throw new RuntimeException("str4 field exceeds the maximum length");

      if (data.getStr5().size() <= 5)
         cdr.write_type_e(data.getStr5());
      else
         throw new RuntimeException("str5 field exceeds the maximum length");
   }

   public static void read(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.CDR cdr)
   {

      ros_msgs.msg.dds.NumPubSubType.read(data.getNum1(), cdr);

      cdr.read_type_e(data.getNum2());

      for (int i0 = 0; i0 < data.getNum3().length; ++i0)
      {
         ros_msgs.msg.dds.NumPubSubType.read(data.getNum3()[i0], cdr);
      }

      cdr.read_type_e(data.getNum4());

      cdr.read_type_d(data.getStr1());

      cdr.read_type_d(data.getStr2());

      cdr.read_type_e(data.getStr3());

      cdr.read_type_e(data.getStr4());

      cdr.read_type_e(data.getStr5());
   }

   public static void staticCopy(ros_msgs.msg.dds.TwoNum src, ros_msgs.msg.dds.TwoNum dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(ros_msgs.msg.dds.TwoNum data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, ros_msgs.msg.dds.TwoNum data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("num1", new ros_msgs.msg.dds.NumPubSubType(), data.getNum1());

      ser.write_type_e("num2", data.getNum2());

      ser.write_type_f("num3", new ros_msgs.msg.dds.NumPubSubType(), data.getNum3());
      ser.write_type_e("num4", data.getNum4());

      ser.write_type_d("str1", data.getStr1());

      ser.write_type_d("str2", data.getStr2());

      ser.write_type_e("str3", data.getStr3());

      ser.write_type_e("str4", data.getStr4());

      ser.write_type_e("str5", data.getStr5());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, ros_msgs.msg.dds.TwoNum data)
   {
      ser.read_type_a("num1", new ros_msgs.msg.dds.NumPubSubType(), data.getNum1());

      ser.read_type_e("num2", data.getNum2());

      ser.read_type_f("num3", new ros_msgs.msg.dds.NumPubSubType(), data.getNum3());

      ser.read_type_e("num4", data.getNum4());

      ser.read_type_d("str1", data.getStr1());

      ser.read_type_d("str2", data.getStr2());

      ser.read_type_e("str3", data.getStr3());

      ser.read_type_e("str4", data.getStr4());

      ser.read_type_e("str5", data.getStr5());
   }

   @Override
   public ros_msgs.msg.dds.TwoNum createData()
   {
      return new ros_msgs.msg.dds.TwoNum();
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

   public void serialize(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(ros_msgs.msg.dds.TwoNum data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(ros_msgs.msg.dds.TwoNum src, ros_msgs.msg.dds.TwoNum dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TwoNumPubSubType newInstance()
   {
      return new TwoNumPubSubType();
   }
}