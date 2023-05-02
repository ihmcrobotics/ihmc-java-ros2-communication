package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Vector3Stamped" defined in "Vector3Stamped_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Vector3Stamped_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Vector3Stamped_.idl instead.
*
*/
public class Vector3StampedPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.Vector3Stamped>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Vector3Stamped_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "f2d284c7d0912d840ef4d5e6102f35d46e4abd68be54c3e30e3943044ae56cd1";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.Vector3Stamped data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.Vector3Stamped data) throws java.io.IOException
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

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Vector3Stamped data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Vector3Stamped data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getVector(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.Vector3Stamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getVector(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.Vector3Stamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getVector(), cdr);	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.Vector3Stamped data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("vector", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getVector());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.Vector3Stamped data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("vector", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getVector());

   }

   public static void staticCopy(geometry_msgs.msg.dds.Vector3Stamped src, geometry_msgs.msg.dds.Vector3Stamped dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.Vector3Stamped createData()
   {
      return new geometry_msgs.msg.dds.Vector3Stamped();
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
   
   public void serialize(geometry_msgs.msg.dds.Vector3Stamped data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.Vector3Stamped data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.Vector3Stamped src, geometry_msgs.msg.dds.Vector3Stamped dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public Vector3StampedPubSubType newInstance()
   {
      return new Vector3StampedPubSubType();
   }
}
