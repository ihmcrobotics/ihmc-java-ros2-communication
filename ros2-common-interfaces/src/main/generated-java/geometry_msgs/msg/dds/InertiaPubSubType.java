package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Inertia" defined in "Inertia_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Inertia_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Inertia_.idl instead.
*
*/
public class InertiaPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.Inertia>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Inertia_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "8cc7e53ffd4263499587631a2c3188ee38d47317fb629f7a35624da7c568312a";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.Inertia data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.Inertia data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Inertia data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Inertia data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getCom(), current_alignment);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.Inertia data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_6(data.getM());

      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getCom(), cdr);
      cdr.write_type_6(data.getIxx());

      cdr.write_type_6(data.getIxy());

      cdr.write_type_6(data.getIxz());

      cdr.write_type_6(data.getIyy());

      cdr.write_type_6(data.getIyz());

      cdr.write_type_6(data.getIzz());

   }

   public static void read(geometry_msgs.msg.dds.Inertia data, us.ihmc.idl.CDR cdr)
   {
      data.setM(cdr.read_type_6());
      	
      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getCom(), cdr);	
      data.setIxx(cdr.read_type_6());
      	
      data.setIxy(cdr.read_type_6());
      	
      data.setIxz(cdr.read_type_6());
      	
      data.setIyy(cdr.read_type_6());
      	
      data.setIyz(cdr.read_type_6());
      	
      data.setIzz(cdr.read_type_6());
      	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.Inertia data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_6("m", data.getM());
      ser.write_type_a("com", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getCom());

      ser.write_type_6("ixx", data.getIxx());
      ser.write_type_6("ixy", data.getIxy());
      ser.write_type_6("ixz", data.getIxz());
      ser.write_type_6("iyy", data.getIyy());
      ser.write_type_6("iyz", data.getIyz());
      ser.write_type_6("izz", data.getIzz());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.Inertia data)
   {
      data.setM(ser.read_type_6("m"));
      ser.read_type_a("com", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getCom());

      data.setIxx(ser.read_type_6("ixx"));
      data.setIxy(ser.read_type_6("ixy"));
      data.setIxz(ser.read_type_6("ixz"));
      data.setIyy(ser.read_type_6("iyy"));
      data.setIyz(ser.read_type_6("iyz"));
      data.setIzz(ser.read_type_6("izz"));
   }

   public static void staticCopy(geometry_msgs.msg.dds.Inertia src, geometry_msgs.msg.dds.Inertia dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.Inertia createData()
   {
      return new geometry_msgs.msg.dds.Inertia();
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
   
   public void serialize(geometry_msgs.msg.dds.Inertia data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.Inertia data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.Inertia src, geometry_msgs.msg.dds.Inertia dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public InertiaPubSubType newInstance()
   {
      return new InertiaPubSubType();
   }
}
