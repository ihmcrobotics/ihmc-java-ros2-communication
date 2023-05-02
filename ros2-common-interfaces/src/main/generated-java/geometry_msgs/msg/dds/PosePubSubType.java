package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Pose" defined in "Pose_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Pose_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Pose_.idl instead.
*
*/
public class PosePubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.euclid.geometry.Pose3D>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Pose_";
   
   @Override
   public final String getDefinitionChecksum()
   {
   		return "e73a7bb954279b957eec57fcb3f677c753a73f87e080ca823883fbdb947f3245";
   }
   
   @Override
   public final String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   private static AbstractPosePubSubTypeImplementation impl = new us.ihmc.ros2.rosidl.geometry_msgs.msg.dds.Pose3DPubSubTypeImpl();
   
   /**
    * Abstract implementation of PosePubSubType.
    *
    * Extend this class to create a custom PubSubType for @Abstract idl datatypes.
    *
    */
   public static abstract class AbstractPosePubSubTypeImplementation
   {
   /**
    * Copy src into dest.
    *
    * @param src Source object to copy data from
    * @param dest Destination object to copy data to
    */
   protected abstract void copy(us.ihmc.euclid.geometry.Pose3D src, us.ihmc.euclid.geometry.Pose3D dest);
   /**
    * Getter for Position
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract us.ihmc.euclid.tuple3D.Point3D getPosition(us.ihmc.euclid.geometry.Pose3D data);

   /**
    * Getter for Orientation
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract us.ihmc.euclid.tuple4D.Quaternion getOrientation(us.ihmc.euclid.geometry.Pose3D data);

      public abstract us.ihmc.euclid.geometry.Pose3D createData();
   }

   private static AbstractPosePubSubTypeImplementation getImpl()
   {
     if(impl == null)
     {
      throw new RuntimeException("Abstract pub/sub type implementation not set. Call setImplementation(AbstractPosePubSubTypeImplementation implementation) before using this type.");
     }
     return impl;
   }
   
   public static void setImplementation(AbstractPosePubSubTypeImplementation implementation)
   {
     PosePubSubType.impl = implementation;
   }

   public static int getMaxCdrSerializedSize()
   {
     return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.PointPubSubType.getMaxCdrSerializedSize(current_alignment);current_alignment += geometry_msgs.msg.dds.QuaternionPubSubType.getMaxCdrSerializedSize(current_alignment);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.euclid.geometry.Pose3D data)
   {
     return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.euclid.geometry.Pose3D data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.PointPubSubType.getCdrSerializedSize(getImpl().getPosition(data), current_alignment);

      current_alignment += geometry_msgs.msg.dds.QuaternionPubSubType.getCdrSerializedSize(getImpl().getOrientation(data), current_alignment);


      return current_alignment - initial_alignment;
   }

   @Override
   public void serialize(us.ihmc.euclid.geometry.Pose3D data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.euclid.geometry.Pose3D data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   public static void write(us.ihmc.euclid.geometry.Pose3D data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.PointPubSubType.write(getImpl().getPosition(data), cdr);
      geometry_msgs.msg.dds.QuaternionPubSubType.write(getImpl().getOrientation(data), cdr);
   }

   public static void read(us.ihmc.euclid.geometry.Pose3D data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.PointPubSubType.read(getImpl().getPosition(data), cdr);	
      geometry_msgs.msg.dds.QuaternionPubSubType.read(getImpl().getOrientation(data), cdr);	
   }

   @Override
   public final void serialize(us.ihmc.euclid.geometry.Pose3D data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("position", new geometry_msgs.msg.dds.PointPubSubType(), getImpl().getPosition(data));

      ser.write_type_a("orientation", new geometry_msgs.msg.dds.QuaternionPubSubType(), getImpl().getOrientation(data));

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.euclid.geometry.Pose3D data)
   {
      ser.read_type_a("position", new geometry_msgs.msg.dds.PointPubSubType(), getImpl().getPosition(data));

      ser.read_type_a("orientation", new geometry_msgs.msg.dds.QuaternionPubSubType(), getImpl().getOrientation(data));

   }

   public static void staticCopy(us.ihmc.euclid.geometry.Pose3D src, us.ihmc.euclid.geometry.Pose3D dest)
   {
      getImpl().copy(src, dest);
   }

   @Override
   public us.ihmc.euclid.geometry.Pose3D createData()
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
   
   public void serialize(us.ihmc.euclid.geometry.Pose3D data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.euclid.geometry.Pose3D data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.euclid.geometry.Pose3D src, us.ihmc.euclid.geometry.Pose3D dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PosePubSubType newInstance()
   {
      return new PosePubSubType();
   }
}
