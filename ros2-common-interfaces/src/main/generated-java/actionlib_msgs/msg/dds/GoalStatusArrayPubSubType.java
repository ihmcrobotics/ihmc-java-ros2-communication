package actionlib_msgs.msg.dds;

/**
* 
* Topic data type of the struct "GoalStatusArray" defined in "GoalStatusArray_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from GoalStatusArray_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit GoalStatusArray_.idl instead.
*
*/
public class GoalStatusArrayPubSubType implements us.ihmc.pubsub.TopicDataType<actionlib_msgs.msg.dds.GoalStatusArray>
{
	public static final java.lang.String name = "actionlib_msgs::msg::dds_::GoalStatusArray_";
	
	
	
    public GoalStatusArrayPubSubType()
    {
        
    }

	private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
	private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

    
    @Override
   public void serialize(actionlib_msgs.msg.dds.GoalStatusArray data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }
   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, actionlib_msgs.msg.dds.GoalStatusArray data) throws java.io.IOException
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
	    current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
	    for(int i0 = 0; i0 < 100; ++i0)
	    {
	        current_alignment += actionlib_msgs.msg.dds.GoalStatusPubSubType.getMaxCdrSerializedSize(current_alignment);}

	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(actionlib_msgs.msg.dds.GoalStatusArray data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(actionlib_msgs.msg.dds.GoalStatusArray data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);
	    current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
	    for(int i0 = 0; i0 < data.getStatusList().size(); ++i0)
	    {
	        current_alignment += actionlib_msgs.msg.dds.GoalStatusPubSubType.getCdrSerializedSize(data.getStatusList().get(i0), current_alignment);}

	
	    return current_alignment - initial_alignment;
	}
	
   public static void write(actionlib_msgs.msg.dds.GoalStatusArray data, us.ihmc.idl.CDR cdr)
   {

	    std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);

	    if(data.getStatusList().size() <= 100)
	    cdr.write_type_e(data.getStatusList());else
	        throw new RuntimeException("status_list field exceeds the maximum length");
   }

   public static void read(actionlib_msgs.msg.dds.GoalStatusArray data, us.ihmc.idl.CDR cdr)
   {

	    	std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	

	    	cdr.read_type_e(data.getStatusList());	
   }
   
	@Override
	public final void serialize(actionlib_msgs.msg.dds.GoalStatusArray data, us.ihmc.idl.InterchangeSerializer ser)
	{
			    ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

			    
			    ser.write_type_e("status_list", data.getStatusList());
			    
	}
	
	@Override
	public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, actionlib_msgs.msg.dds.GoalStatusArray data)
	{
	    			ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());
	    	
	    	    
	    			ser.read_type_e("status_list", data.getStatusList());	
	    	    
	}

   public static void staticCopy(actionlib_msgs.msg.dds.GoalStatusArray src, actionlib_msgs.msg.dds.GoalStatusArray dest)
   {
      dest.set(src);
   }
   
   
   @Override
   public actionlib_msgs.msg.dds.GoalStatusArray createData()
   {
      return new actionlib_msgs.msg.dds.GoalStatusArray();
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
   
   public void serialize(actionlib_msgs.msg.dds.GoalStatusArray data, us.ihmc.idl.CDR cdr)
	{
		write(data, cdr);
	}

   public void deserialize(actionlib_msgs.msg.dds.GoalStatusArray data, us.ihmc.idl.CDR cdr)
   {
        read(data, cdr);
   }
   
   public void copy(actionlib_msgs.msg.dds.GoalStatusArray src, actionlib_msgs.msg.dds.GoalStatusArray dest)
   {
      staticCopy(src, dest);
   }	

   
   @Override
   public GoalStatusArrayPubSubType newInstance()
   {
   	  return new GoalStatusArrayPubSubType();
   }
}