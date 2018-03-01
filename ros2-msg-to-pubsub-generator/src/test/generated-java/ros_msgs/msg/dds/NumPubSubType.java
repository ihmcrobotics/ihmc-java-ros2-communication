package ros_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Num" defined in "TwoNum_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TwoNum_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TwoNum_.idl instead.
*
*/
public class NumPubSubType implements us.ihmc.pubsub.TopicDataType<ros_msgs.msg.dds.Num>
{
	public static final java.lang.String name = "ros_msgs::msg::dds_::Num_";
	
	
	
    public NumPubSubType()
    {
        
    }

	private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
	private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

    
    @Override
   public void serialize(ros_msgs.msg.dds.Num data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }
   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, ros_msgs.msg.dds.Num data) throws java.io.IOException
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

	    current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(ros_msgs.msg.dds.Num data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(ros_msgs.msg.dds.Num data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}
	
   public static void write(ros_msgs.msg.dds.Num data, us.ihmc.idl.CDR cdr)
   {

	    cdr.write_type_11(data.getNum());

	    cdr.write_type_2(data.getHello());
   }

   public static void read(ros_msgs.msg.dds.Num data, us.ihmc.idl.CDR cdr)
   {

	    	data.setNum(cdr.read_type_11());
	    	

	    	data.setHello(cdr.read_type_2());
	    	
   }
   
	@Override
	public final void serialize(ros_msgs.msg.dds.Num data, us.ihmc.idl.InterchangeSerializer ser)
	{
			    ser.write_type_11("num", data.getNum());
			    
			    ser.write_type_2("hello", data.getHello());
			    
	}
	
	@Override
	public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, ros_msgs.msg.dds.Num data)
	{
	    			data.setNum(ser.read_type_11("num"));	
	    	    
	    			data.setHello(ser.read_type_2("hello"));	
	    	    
	}

   public static void staticCopy(ros_msgs.msg.dds.Num src, ros_msgs.msg.dds.Num dest)
   {
      dest.set(src);
   }
   
   
   @Override
   public ros_msgs.msg.dds.Num createData()
   {
      return new ros_msgs.msg.dds.Num();
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
   
   public void serialize(ros_msgs.msg.dds.Num data, us.ihmc.idl.CDR cdr)
	{
		write(data, cdr);
	}

   public void deserialize(ros_msgs.msg.dds.Num data, us.ihmc.idl.CDR cdr)
   {
        read(data, cdr);
   }
   
   public void copy(ros_msgs.msg.dds.Num src, ros_msgs.msg.dds.Num dest)
   {
      staticCopy(src, dest);
   }	

   
   @Override
   public NumPubSubType newInstance()
   {
   	  return new NumPubSubType();
   }
}