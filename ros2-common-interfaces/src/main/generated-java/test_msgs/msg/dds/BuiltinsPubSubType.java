package test_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Builtins" defined in "Builtins_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Builtins_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Builtins_.idl instead.
*
*/
public class BuiltinsPubSubType implements us.ihmc.pubsub.TopicDataType<test_msgs.msg.dds.Builtins>
{
	public static final java.lang.String name = "test_msgs::msg::dds_::Builtins_";
	
	
	
    public BuiltinsPubSubType()
    {
        
    }

	private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
	private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

    
    @Override
   public void serialize(test_msgs.msg.dds.Builtins data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }
   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, test_msgs.msg.dds.Builtins data) throws java.io.IOException
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
	            
	    current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getMaxCdrSerializedSize(current_alignment);
	    current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);
	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(test_msgs.msg.dds.Builtins data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(test_msgs.msg.dds.Builtins data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getCdrSerializedSize(data.getDurationValue(), current_alignment);
	    current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getTimeValue(), current_alignment);
	
	    return current_alignment - initial_alignment;
	}
	
   public static void write(test_msgs.msg.dds.Builtins data, us.ihmc.idl.CDR cdr)
   {

	    builtin_interfaces.msg.dds.DurationPubSubType.write(data.getDurationValue(), cdr);

	    builtin_interfaces.msg.dds.TimePubSubType.write(data.getTimeValue(), cdr);
   }

   public static void read(test_msgs.msg.dds.Builtins data, us.ihmc.idl.CDR cdr)
   {

	    	builtin_interfaces.msg.dds.DurationPubSubType.read(data.getDurationValue(), cdr);	

	    	builtin_interfaces.msg.dds.TimePubSubType.read(data.getTimeValue(), cdr);	
   }
   
	@Override
	public final void serialize(test_msgs.msg.dds.Builtins data, us.ihmc.idl.InterchangeSerializer ser)
	{
			    ser.write_type_a("duration_value", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getDurationValue());

			    
			    ser.write_type_a("time_value", new builtin_interfaces.msg.dds.TimePubSubType(), data.getTimeValue());

			    
	}
	
	@Override
	public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, test_msgs.msg.dds.Builtins data)
	{
	    			ser.read_type_a("duration_value", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getDurationValue());
	    	
	    	    
	    			ser.read_type_a("time_value", new builtin_interfaces.msg.dds.TimePubSubType(), data.getTimeValue());
	    	
	    	    
	}

   public static void staticCopy(test_msgs.msg.dds.Builtins src, test_msgs.msg.dds.Builtins dest)
   {
      dest.set(src);
   }
   
   
   @Override
   public test_msgs.msg.dds.Builtins createData()
   {
      return new test_msgs.msg.dds.Builtins();
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
   
   public void serialize(test_msgs.msg.dds.Builtins data, us.ihmc.idl.CDR cdr)
	{
		write(data, cdr);
	}

   public void deserialize(test_msgs.msg.dds.Builtins data, us.ihmc.idl.CDR cdr)
   {
        read(data, cdr);
   }
   
   public void copy(test_msgs.msg.dds.Builtins src, test_msgs.msg.dds.Builtins dest)
   {
      staticCopy(src, dest);
   }	

   
   @Override
   public BuiltinsPubSubType newInstance()
   {
   	  return new BuiltinsPubSubType();
   }
}