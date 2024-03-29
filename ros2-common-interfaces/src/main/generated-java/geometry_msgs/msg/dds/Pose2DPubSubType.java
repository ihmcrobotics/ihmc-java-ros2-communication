package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Pose2D" defined in "Pose2D_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Pose2D_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Pose2D_.idl instead.
*
*/
public class Pose2DPubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.euclid.geometry.Pose2D>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Pose2D_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "3b80c9eb0daa9e352bb5867fece086348cc5969dece24382aa789cbbf7606f84";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   private static AbstractPose2DPubSubTypeImplementation impl = new us.ihmc.ros2.rosidl.geometry_msgs.msg.dds.Pose2DPubSubTypeImpl();
   
   /**
    * Abstract implementation of Pose2DPubSubType.
    *
    * Extend this class to create a custom PubSubType for @Abstract idl datatypes.
    *
    */
   public static abstract class AbstractPose2DPubSubTypeImplementation
   {
   /**
    * Copy src into dest.
    *
    * @param src Source object to copy data from
    * @param dest Destination object to copy data to
    */
   protected abstract void copy(us.ihmc.euclid.geometry.Pose2D src, us.ihmc.euclid.geometry.Pose2D dest);
   /**
    * Getter for X
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract double getX(us.ihmc.euclid.geometry.Pose2D data);
   /**
    * Setter for X
    *
    * @param data object to write to
    * @param x value
    */
   protected abstract void setX(us.ihmc.euclid.geometry.Pose2D data, double x);
   /**
    * Getter for Y
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract double getY(us.ihmc.euclid.geometry.Pose2D data);
   /**
    * Setter for Y
    *
    * @param data object to write to
    * @param y value
    */
   protected abstract void setY(us.ihmc.euclid.geometry.Pose2D data, double y);
   /**
    * Getter for Theta
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract double getTheta(us.ihmc.euclid.geometry.Pose2D data);
   /**
    * Setter for Theta
    *
    * @param data object to write to
    * @param theta value
    */
   protected abstract void setTheta(us.ihmc.euclid.geometry.Pose2D data, double theta);
      public abstract us.ihmc.euclid.geometry.Pose2D createData();
   }

   private static AbstractPose2DPubSubTypeImplementation getImpl()
   {
     if(impl == null)
     {
      throw new RuntimeException("Abstract pub/sub type implementation not set. Call setImplementation(AbstractPose2DPubSubTypeImplementation implementation) before using this type.");
     }
     return impl;
   }
   
   public static void setImplementation(AbstractPose2DPubSubTypeImplementation implementation)
   {
     Pose2DPubSubType.impl = implementation;
   }

   public static int getMaxCdrSerializedSize()
   {
     return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.euclid.geometry.Pose2D data)
   {
     return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.euclid.geometry.Pose2D data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   @Override
   public void serialize(us.ihmc.euclid.geometry.Pose2D data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.euclid.geometry.Pose2D data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   public static void write(us.ihmc.euclid.geometry.Pose2D data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_6(getImpl().getX(data));

      cdr.write_type_6(getImpl().getY(data));

      cdr.write_type_6(getImpl().getTheta(data));

   }

   public static void read(us.ihmc.euclid.geometry.Pose2D data, us.ihmc.idl.CDR cdr)
   {
      getImpl().setX(data,cdr.read_type_6());
      	
      getImpl().setY(data,cdr.read_type_6());
      	
      getImpl().setTheta(data,cdr.read_type_6());
      	
   }

   @Override
   public final void serialize(us.ihmc.euclid.geometry.Pose2D data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_6("x", getImpl().getX(data));
      ser.write_type_6("y", getImpl().getY(data));
      ser.write_type_6("theta", getImpl().getTheta(data));
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.euclid.geometry.Pose2D data)
   {
      getImpl().setX(data, ser.read_type_6("x"));
      getImpl().setY(data, ser.read_type_6("y"));
      getImpl().setTheta(data, ser.read_type_6("theta"));
   }

   public static void staticCopy(us.ihmc.euclid.geometry.Pose2D src, us.ihmc.euclid.geometry.Pose2D dest)
   {
      getImpl().copy(src, dest);
   }

   @Override
   public us.ihmc.euclid.geometry.Pose2D createData()
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
   
   public void serialize(us.ihmc.euclid.geometry.Pose2D data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.euclid.geometry.Pose2D data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.euclid.geometry.Pose2D src, us.ihmc.euclid.geometry.Pose2D dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public Pose2DPubSubType newInstance()
   {
      return new Pose2DPubSubType();
   }
}
