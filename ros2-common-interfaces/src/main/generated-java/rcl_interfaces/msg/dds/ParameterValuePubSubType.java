package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "ParameterValue" defined in "ParameterValue_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ParameterValue_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ParameterValue_.idl instead.
*
*/
public class ParameterValuePubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.ParameterValue>
{
	public static final java.lang.String name = "rcl_interfaces::msg::dds_::ParameterValue_";
	
	
	
    public ParameterValuePubSubType()
    {
        
    }

	private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
	private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

    
    @Override
   public void serialize(rcl_interfaces.msg.dds.ParameterValue data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }
   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.ParameterValue data) throws java.io.IOException
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
	            
	    current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

	    current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

	    current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
	    current_alignment += (100 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ParameterValue data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ParameterValue data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

	    current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

	    current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStringValue().length() + 1;

	    current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getBytesValue().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


	
	    return current_alignment - initial_alignment;
	}
	
   public static void write(rcl_interfaces.msg.dds.ParameterValue data, us.ihmc.idl.CDR cdr)
   {

	    cdr.write_type_9(data.getType());

	    cdr.write_type_7(data.getBoolValue());

	    cdr.write_type_11(data.getIntegerValue());

	    cdr.write_type_6(data.getDoubleValue());

	    if(data.getStringValue().length() <= 255)
	    cdr.write_type_d(data.getStringValue());else
	        throw new RuntimeException("string_value field exceeds the maximum length");

	    if(data.getBytesValue().size() <= 100)
	    cdr.write_type_e(data.getBytesValue());else
	        throw new RuntimeException("bytes_value field exceeds the maximum length");
   }

   public static void read(rcl_interfaces.msg.dds.ParameterValue data, us.ihmc.idl.CDR cdr)
   {

	    	data.setType(cdr.read_type_9());
	    	

	    	data.setBoolValue(cdr.read_type_7());
	    	

	    	data.setIntegerValue(cdr.read_type_11());
	    	

	    	data.setDoubleValue(cdr.read_type_6());
	    	

	    	cdr.read_type_d(data.getStringValue());	

	    	cdr.read_type_e(data.getBytesValue());	
   }
   
	@Override
	public final void serialize(rcl_interfaces.msg.dds.ParameterValue data, us.ihmc.idl.InterchangeSerializer ser)
	{
			    ser.write_type_9("type", data.getType());
			    
			    ser.write_type_7("bool_value", data.getBoolValue());
			    
			    ser.write_type_11("integer_value", data.getIntegerValue());
			    
			    ser.write_type_6("double_value", data.getDoubleValue());
			    
			    ser.write_type_d("string_value", data.getStringValue());
			    
			    ser.write_type_e("bytes_value", data.getBytesValue());
			    
	}
	
	@Override
	public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.ParameterValue data)
	{
	    			data.setType(ser.read_type_9("type"));	
	    	    
	    			data.setBoolValue(ser.read_type_7("bool_value"));	
	    	    
	    			data.setIntegerValue(ser.read_type_11("integer_value"));	
	    	    
	    			data.setDoubleValue(ser.read_type_6("double_value"));	
	    	    
	    			ser.read_type_d("string_value", data.getStringValue());	
	    	    
	    			ser.read_type_e("bytes_value", data.getBytesValue());	
	    	    
	}

   public static void staticCopy(rcl_interfaces.msg.dds.ParameterValue src, rcl_interfaces.msg.dds.ParameterValue dest)
   {
      dest.set(src);
   }
   
   
   @Override
   public rcl_interfaces.msg.dds.ParameterValue createData()
   {
      return new rcl_interfaces.msg.dds.ParameterValue();
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
   
   public void serialize(rcl_interfaces.msg.dds.ParameterValue data, us.ihmc.idl.CDR cdr)
	{
		write(data, cdr);
	}

   public void deserialize(rcl_interfaces.msg.dds.ParameterValue data, us.ihmc.idl.CDR cdr)
   {
        read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.ParameterValue src, rcl_interfaces.msg.dds.ParameterValue dest)
   {
      staticCopy(src, dest);
   }	

   
   @Override
   public ParameterValuePubSubType newInstance()
   {
   	  return new ParameterValuePubSubType();
   }
}