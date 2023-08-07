package shape_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Plane" defined in "Plane_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Plane_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Plane_.idl instead.
*
*/
public class PlanePubSubType implements us.ihmc.pubsub.TopicDataType<shape_msgs.msg.dds.Plane>
{
   public static final java.lang.String name = "shape_msgs::msg::dds_::Plane_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "2ebd0304bc4e64f8b66754258a5f7ee2807ab727441f0d506c2a9142d57f5651";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(shape_msgs.msg.dds.Plane data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, shape_msgs.msg.dds.Plane data) throws java.io.IOException
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

      current_alignment += ((4) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(shape_msgs.msg.dds.Plane data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(shape_msgs.msg.dds.Plane data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += ((4) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      return current_alignment - initial_alignment;
   }

   public static void write(shape_msgs.msg.dds.Plane data, us.ihmc.idl.CDR cdr)
   {
      for(int i0 = 0; i0 < data.getCoef().length; ++i0)
      {
        	cdr.write_type_6(data.getCoef()[i0]);	
      }
   }

   public static void read(shape_msgs.msg.dds.Plane data, us.ihmc.idl.CDR cdr)
   {
      for(int i0 = 0; i0 < data.getCoef().length; ++i0)
      {
        	data.getCoef()[i0] = cdr.read_type_6();
        	
      }
      	

   }

   @Override
   public final void serialize(shape_msgs.msg.dds.Plane data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_f("coef", data.getCoef());   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, shape_msgs.msg.dds.Plane data)
   {
      ser.read_type_f("coef", data.getCoef());   }

   public static void staticCopy(shape_msgs.msg.dds.Plane src, shape_msgs.msg.dds.Plane dest)
   {
      dest.set(src);
   }

   @Override
   public shape_msgs.msg.dds.Plane createData()
   {
      return new shape_msgs.msg.dds.Plane();
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
   
   public void serialize(shape_msgs.msg.dds.Plane data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(shape_msgs.msg.dds.Plane data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(shape_msgs.msg.dds.Plane src, shape_msgs.msg.dds.Plane dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PlanePubSubType newInstance()
   {
      return new PlanePubSubType();
   }
}
