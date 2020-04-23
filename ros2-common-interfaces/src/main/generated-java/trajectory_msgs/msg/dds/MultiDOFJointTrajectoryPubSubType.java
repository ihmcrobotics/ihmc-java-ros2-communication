package trajectory_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MultiDOFJointTrajectory" defined in "MultiDOFJointTrajectory_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MultiDOFJointTrajectory_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MultiDOFJointTrajectory_.idl instead.
*
*/
public class MultiDOFJointTrajectoryPubSubType implements us.ihmc.pubsub.TopicDataType<trajectory_msgs.msg.dds.MultiDOFJointTrajectory>
{
   public static final java.lang.String name = "trajectory_msgs::msg::dds_::MultiDOFJointTrajectory_";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(trajectory_msgs.msg.dds.MultiDOFJointTrajectory data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, trajectory_msgs.msg.dds.MultiDOFJointTrajectory data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPointPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(trajectory_msgs.msg.dds.MultiDOFJointTrajectory data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(trajectory_msgs.msg.dds.MultiDOFJointTrajectory data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getJointNames().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getJointNames().get(i0).length() + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getPoints().size(); ++i0)
      {
          current_alignment += trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPointPubSubType.getCdrSerializedSize(data.getPoints().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(trajectory_msgs.msg.dds.MultiDOFJointTrajectory data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getJointNames().size() <= 100)
      cdr.write_type_e(data.getJointNames());else
          throw new RuntimeException("joint_names field exceeds the maximum length");

      if(data.getPoints().size() <= 100)
      cdr.write_type_e(data.getPoints());else
          throw new RuntimeException("points field exceeds the maximum length");

   }

   public static void read(trajectory_msgs.msg.dds.MultiDOFJointTrajectory data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_e(data.getJointNames());	
      cdr.read_type_e(data.getPoints());	

   }

   @Override
   public final void serialize(trajectory_msgs.msg.dds.MultiDOFJointTrajectory data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_e("joint_names", data.getJointNames());
      ser.write_type_e("points", data.getPoints());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, trajectory_msgs.msg.dds.MultiDOFJointTrajectory data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_e("joint_names", data.getJointNames());
      ser.read_type_e("points", data.getPoints());
   }

   public static void staticCopy(trajectory_msgs.msg.dds.MultiDOFJointTrajectory src, trajectory_msgs.msg.dds.MultiDOFJointTrajectory dest)
   {
      dest.set(src);
   }

   @Override
   public trajectory_msgs.msg.dds.MultiDOFJointTrajectory createData()
   {
      return new trajectory_msgs.msg.dds.MultiDOFJointTrajectory();
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
   
   public void serialize(trajectory_msgs.msg.dds.MultiDOFJointTrajectory data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(trajectory_msgs.msg.dds.MultiDOFJointTrajectory data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(trajectory_msgs.msg.dds.MultiDOFJointTrajectory src, trajectory_msgs.msg.dds.MultiDOFJointTrajectory dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MultiDOFJointTrajectoryPubSubType newInstance()
   {
      return new MultiDOFJointTrajectoryPubSubType();
   }
}
