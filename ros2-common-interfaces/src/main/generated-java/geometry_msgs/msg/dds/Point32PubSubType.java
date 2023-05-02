package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Point32" defined in "Point32_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Point32_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Point32_.idl instead.
*
*/
public class Point32PubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.euclid.tuple3D.Point3D32>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Point32_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "f95723bc4a07835d0b5a32fd36d5cfadb6371169f6343802157270b2ac69709c";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   private static AbstractPoint32PubSubTypeImplementation impl = new us.ihmc.ros2.rosidl.geometry_msgs.msg.dds.Point3D32PubSubTypeImpl();
   
   /**
    * Abstract implementation of Point32PubSubType.
    *
    * Extend this class to create a custom PubSubType for @Abstract idl datatypes.
    *
    */
   public static abstract class AbstractPoint32PubSubTypeImplementation
   {
   /**
    * Copy src into dest.
    *
    * @param src Source object to copy data from
    * @param dest Destination object to copy data to
    */
   protected abstract void copy(us.ihmc.euclid.tuple3D.Point3D32 src, us.ihmc.euclid.tuple3D.Point3D32 dest);
   /**
    * Getter for X
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract float getX(us.ihmc.euclid.tuple3D.Point3D32 data);
   /**
    * Setter for X
    *
    * @param data object to write to
    * @param x value
    */
   protected abstract void setX(us.ihmc.euclid.tuple3D.Point3D32 data, float x);
   /**
    * Getter for Y
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract float getY(us.ihmc.euclid.tuple3D.Point3D32 data);
   /**
    * Setter for Y
    *
    * @param data object to write to
    * @param y value
    */
   protected abstract void setY(us.ihmc.euclid.tuple3D.Point3D32 data, float y);
   /**
    * Getter for Z
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract float getZ(us.ihmc.euclid.tuple3D.Point3D32 data);
   /**
    * Setter for Z
    *
    * @param data object to write to
    * @param z value
    */
   protected abstract void setZ(us.ihmc.euclid.tuple3D.Point3D32 data, float z);
      public abstract us.ihmc.euclid.tuple3D.Point3D32 createData();
   }

   private static AbstractPoint32PubSubTypeImplementation getImpl()
   {
     if(impl == null)
     {
      throw new RuntimeException("Abstract pub/sub type implementation not set. Call setImplementation(AbstractPoint32PubSubTypeImplementation implementation) before using this type.");
     }
     return impl;
   }
   
   public static void setImplementation(AbstractPoint32PubSubTypeImplementation implementation)
   {
     Point32PubSubType.impl = implementation;
   }

   public static int getMaxCdrSerializedSize()
   {
     return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.euclid.tuple3D.Point3D32 data)
   {
     return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.euclid.tuple3D.Point3D32 data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   @Override
   public void serialize(us.ihmc.euclid.tuple3D.Point3D32 data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.euclid.tuple3D.Point3D32 data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   public static void write(us.ihmc.euclid.tuple3D.Point3D32 data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_5(getImpl().getX(data));

      cdr.write_type_5(getImpl().getY(data));

      cdr.write_type_5(getImpl().getZ(data));

   }

   public static void read(us.ihmc.euclid.tuple3D.Point3D32 data, us.ihmc.idl.CDR cdr)
   {
      getImpl().setX(data,cdr.read_type_5());
      	
      getImpl().setY(data,cdr.read_type_5());
      	
      getImpl().setZ(data,cdr.read_type_5());
      	
   }

   @Override
   public final void serialize(us.ihmc.euclid.tuple3D.Point3D32 data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_5("x", getImpl().getX(data));
      ser.write_type_5("y", getImpl().getY(data));
      ser.write_type_5("z", getImpl().getZ(data));
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.euclid.tuple3D.Point3D32 data)
   {
      getImpl().setX(data, ser.read_type_5("x"));
      getImpl().setY(data, ser.read_type_5("y"));
      getImpl().setZ(data, ser.read_type_5("z"));
   }

   public static void staticCopy(us.ihmc.euclid.tuple3D.Point3D32 src, us.ihmc.euclid.tuple3D.Point3D32 dest)
   {
      getImpl().copy(src, dest);
   }

   @Override
   public us.ihmc.euclid.tuple3D.Point3D32 createData()
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
   
   public void serialize(us.ihmc.euclid.tuple3D.Point3D32 data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.euclid.tuple3D.Point3D32 data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.euclid.tuple3D.Point3D32 src, us.ihmc.euclid.tuple3D.Point3D32 dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public Point32PubSubType newInstance()
   {
      return new Point32PubSubType();
   }
}
