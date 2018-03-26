package geometry_msgs.msg.dds;

/**
 * Topic data type of the struct "Transform" defined in "Transform_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from Transform_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Transform_.idl instead.
 */
public class TransformPubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.euclid.transform.QuaternionBasedTransform>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Transform_";
   private static AbstractTransformPubSubTypeImplementation impl = new us.ihmc.ros2.rosidl.geometry_msgs.msg.dds.TransformPubSubTypeImpl();
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public TransformPubSubType()
   {

   }

   private static AbstractTransformPubSubTypeImplementation getImpl()
   {
      if (impl == null)
      {
         throw new RuntimeException(
               "Abstract pub/sub type implementation not set. Call setImplementation(AbstractTransformPubSubTypeImplementation implementation) before using this type.");
      }
      return impl;
   }

   public static void setImplementation(AbstractTransformPubSubTypeImplementation implementation)
   {
      TransformPubSubType.impl = implementation;
   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getMaxCdrSerializedSize(current_alignment);
      current_alignment += geometry_msgs.msg.dds.QuaternionPubSubType.getMaxCdrSerializedSize(current_alignment);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.euclid.transform.QuaternionBasedTransform data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.euclid.transform.QuaternionBasedTransform data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(getImpl().getTranslation(data), current_alignment);
      current_alignment += geometry_msgs.msg.dds.QuaternionPubSubType.getCdrSerializedSize(getImpl().getRotation(data), current_alignment);

      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.euclid.transform.QuaternionBasedTransform data, us.ihmc.idl.CDR cdr)
   {

      geometry_msgs.msg.dds.Vector3PubSubType.write(getImpl().getTranslation(data), cdr);

      geometry_msgs.msg.dds.QuaternionPubSubType.write(getImpl().getRotation(data), cdr);
   }

   public static void read(us.ihmc.euclid.transform.QuaternionBasedTransform data, us.ihmc.idl.CDR cdr)
   {

      geometry_msgs.msg.dds.Vector3PubSubType.read(getImpl().getTranslation(data), cdr);

      geometry_msgs.msg.dds.QuaternionPubSubType.read(getImpl().getRotation(data), cdr);
   }

   public static void staticCopy(us.ihmc.euclid.transform.QuaternionBasedTransform src, us.ihmc.euclid.transform.QuaternionBasedTransform dest)
   {
      getImpl().copy(src, dest);
   }

   @Override
   public void serialize(us.ihmc.euclid.transform.QuaternionBasedTransform data, us.ihmc.pubsub.common.SerializedPayload serializedPayload)
         throws java.io.IOException
   {

      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.euclid.transform.QuaternionBasedTransform data)
         throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(us.ihmc.euclid.transform.QuaternionBasedTransform data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("translation", new geometry_msgs.msg.dds.Vector3PubSubType(), getImpl().getTranslation(data));

      ser.write_type_a("rotation", new geometry_msgs.msg.dds.QuaternionPubSubType(), getImpl().getRotation(data));
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.euclid.transform.QuaternionBasedTransform data)
   {
      ser.read_type_a("translation", new geometry_msgs.msg.dds.Vector3PubSubType(), getImpl().getTranslation(data));

      ser.read_type_a("rotation", new geometry_msgs.msg.dds.QuaternionPubSubType(), getImpl().getRotation(data));
   }

   @Override
   public us.ihmc.euclid.transform.QuaternionBasedTransform createData()
   {
      return getImpl().createData();
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

   public void serialize(us.ihmc.euclid.transform.QuaternionBasedTransform data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.euclid.transform.QuaternionBasedTransform data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(us.ihmc.euclid.transform.QuaternionBasedTransform src, us.ihmc.euclid.transform.QuaternionBasedTransform dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TransformPubSubType newInstance()
   {
      return new TransformPubSubType();
   }

   /**
    * Abstract implementation of TransformPubSubType.
    *
    * Extend this class to create a custom PubSubType for @Abstract idl datatypes.
    */
   public static abstract class AbstractTransformPubSubTypeImplementation
   {

      /**
       * Copy src into dest.
       *
       * @param src Source object to copy data from
       * @param dest Destination object to copy data to
       */
      protected abstract void copy(us.ihmc.euclid.transform.QuaternionBasedTransform src, us.ihmc.euclid.transform.QuaternionBasedTransform dest);

      /**
       * Getter for Translation
       *
       * @param data object to read from
       * @return value of X
       */
      protected abstract us.ihmc.euclid.tuple3D.Vector3D getTranslation(us.ihmc.euclid.transform.QuaternionBasedTransform data);

      /**
       * Getter for Rotation
       *
       * @param data object to read from
       * @return value of X
       */
      protected abstract us.ihmc.euclid.tuple4D.Quaternion getRotation(us.ihmc.euclid.transform.QuaternionBasedTransform data);

      public abstract us.ihmc.euclid.transform.QuaternionBasedTransform createData();
   }
}
