package geometry_msgs.msg.dds;

/**
 * Topic data type of the struct "TwistWithCovariance" defined in "TwistWithCovariance_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from TwistWithCovariance_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit TwistWithCovariance_.idl instead.
 */
public class TwistWithCovariancePubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.TwistWithCovariance>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::TwistWithCovariance_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public TwistWithCovariancePubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getMaxCdrSerializedSize(current_alignment);
      current_alignment += ((36) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.TwistWithCovariance data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.TwistWithCovariance data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getCdrSerializedSize(data.getTwist(), current_alignment);
      current_alignment += ((36) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.TwistWithCovariance data, us.ihmc.idl.CDR cdr)
   {

      geometry_msgs.msg.dds.TwistPubSubType.write(data.getTwist(), cdr);

      for (int a = 0; a < data.getCovariance().length; ++a)
      {
         cdr.write_type_6(data.getCovariance()[a]);
      }
   }

   public static void read(geometry_msgs.msg.dds.TwistWithCovariance data, us.ihmc.idl.CDR cdr)
   {

      geometry_msgs.msg.dds.TwistPubSubType.read(data.getTwist(), cdr);

      for (int a = 0; a < data.getCovariance().length; ++a)
      {
         data.getCovariance()[a] = cdr.read_type_6();
      }
   }

   public static void staticCopy(geometry_msgs.msg.dds.TwistWithCovariance src, geometry_msgs.msg.dds.TwistWithCovariance dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(geometry_msgs.msg.dds.TwistWithCovariance data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.TwistWithCovariance data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.TwistWithCovariance data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("twist", new geometry_msgs.msg.dds.TwistPubSubType(), data.getTwist());

      ser.write_type_f("covariance", data.getCovariance());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.TwistWithCovariance data)
   {
      ser.read_type_a("twist", new geometry_msgs.msg.dds.TwistPubSubType(), data.getTwist());

      ser.read_type_f("covariance", data.getCovariance());
   }

   @Override
   public geometry_msgs.msg.dds.TwistWithCovariance createData()
   {
      return new geometry_msgs.msg.dds.TwistWithCovariance();
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

   public void serialize(geometry_msgs.msg.dds.TwistWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.TwistWithCovariance data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(geometry_msgs.msg.dds.TwistWithCovariance src, geometry_msgs.msg.dds.TwistWithCovariance dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TwistWithCovariancePubSubType newInstance()
   {
      return new TwistWithCovariancePubSubType();
   }
}