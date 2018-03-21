package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Vector3" defined in "Vector3_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Vector3_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Vector3_.idl instead.
*
*/
public class Vector3PubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.euclid.tuple3D.Vector3D>
{
	public static final java.lang.String name = "geometry_msgs::msg::dds_::Vector3_";
	
	
	
    public Vector3PubSubType()
    {
        
    }


	private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
	private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();



	private static AbstractVector3PubSubTypeImplementation impl = new us.ihmc.ros2.rosidl.geometry_msgs.msg.dds.Vector3PubSubTypeImpl();
	
	/**
	 * Abstract implementation of Vector3PubSubType. 
	 * 
	 * Extend this class to create a custom PubSubType for @Abstract idl datatypes. 
	 *
	 */
	public static abstract class AbstractVector3PubSubTypeImplementation
	{

		
		/**
		 * Copy src into dest. 
		 * 
		 * @param src Source object to copy data from
		 * @param dest Destination object to copy data to
		 */
		protected abstract void copy(us.ihmc.euclid.tuple3D.Vector3D src, us.ihmc.euclid.tuple3D.Vector3D dest);
		
		
		
	    /**
        * Getter for X 
        * 
        * @param data object to read from
        * @return value of X
        */
		protected abstract double getX(us.ihmc.euclid.tuple3D.Vector3D data);
	    /**
        * Setter for X 
        * 
        * @param data object to write to
        * @param x value
        */
		protected abstract void setX(us.ihmc.euclid.tuple3D.Vector3D data, double x);

		
		
	    /**
        * Getter for Y 
        * 
        * @param data object to read from
        * @return value of X
        */
		protected abstract double getY(us.ihmc.euclid.tuple3D.Vector3D data);
	    /**
        * Setter for Y 
        * 
        * @param data object to write to
        * @param y value
        */
		protected abstract void setY(us.ihmc.euclid.tuple3D.Vector3D data, double y);

		
		
	    /**
        * Getter for Z 
        * 
        * @param data object to read from
        * @return value of X
        */
		protected abstract double getZ(us.ihmc.euclid.tuple3D.Vector3D data);
	    /**
        * Setter for Z 
        * 
        * @param data object to write to
        * @param z value
        */
		protected abstract void setZ(us.ihmc.euclid.tuple3D.Vector3D data, double z);

		


   		public abstract us.ihmc.euclid.tuple3D.Vector3D createData();
	}

	private static AbstractVector3PubSubTypeImplementation getImpl()
	{
		if(impl == null)
		{
			throw new RuntimeException("Abstract pub/sub type implementation not set. Call setImplementation(AbstractVector3PubSubTypeImplementation implementation) before using this type.");
		}
		return impl;
	}
	
	public static void setImplementation(AbstractVector3PubSubTypeImplementation implementation)
	{
		Vector3PubSubType.impl = implementation;
	}

		
		
	public static int getMaxCdrSerializedSize()
	{
		return getMaxCdrSerializedSize(0);
	}

	public static int getMaxCdrSerializedSize(int current_alignment)
	{
		int initial_alignment = current_alignment;
	            
	    current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(us.ihmc.euclid.tuple3D.Vector3D data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(us.ihmc.euclid.tuple3D.Vector3D data, int current_alignment)
	{
		int initial_alignment = current_alignment;
	            
	    	current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    	current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    	current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	
	    	return current_alignment - initial_alignment;
	}


       @Override
   public void serialize(us.ihmc.euclid.tuple3D.Vector3D data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
   		
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();

   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.euclid.tuple3D.Vector3D data) throws java.io.IOException
   {
	 deserializeCDR.deserialize(serializedPayload);
     read(data, deserializeCDR);
	 deserializeCDR.finishDeserialize();
   }
   

   public static void write(us.ihmc.euclid.tuple3D.Vector3D data, us.ihmc.idl.CDR cdr)
   {

   		cdr.write_type_6(getImpl().getX(data));

   		cdr.write_type_6(getImpl().getY(data));

   		cdr.write_type_6(getImpl().getZ(data));
   }

   public static void read(us.ihmc.euclid.tuple3D.Vector3D data, us.ihmc.idl.CDR cdr)
   {

			getImpl().setX(data,cdr.read_type_6());
			

			getImpl().setY(data,cdr.read_type_6());
			

			getImpl().setZ(data,cdr.read_type_6());
			
   }
   
	@Override
	public final void serialize(us.ihmc.euclid.tuple3D.Vector3D data, us.ihmc.idl.InterchangeSerializer ser)
	{
			    ser.write_type_6("x", getImpl().getX(data));
			    
			    ser.write_type_6("y", getImpl().getY(data));
			    
			    ser.write_type_6("z", getImpl().getZ(data));
			    
	}
	
	@Override
	public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.euclid.tuple3D.Vector3D data)
	{
	    			getImpl().setX(data, ser.read_type_6("x"));	
	    	    
	    			getImpl().setY(data, ser.read_type_6("y"));	
	    	    
	    			getImpl().setZ(data, ser.read_type_6("z"));	
	    	    
	}


   public static void staticCopy(us.ihmc.euclid.tuple3D.Vector3D src, us.ihmc.euclid.tuple3D.Vector3D dest)
   {
   		getImpl().copy(src, dest);
   }
   
   
   @Override
   public us.ihmc.euclid.tuple3D.Vector3D createData()
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
   
   public void serialize(us.ihmc.euclid.tuple3D.Vector3D data, us.ihmc.idl.CDR cdr)
	{
		write(data, cdr);
	}

   public void deserialize(us.ihmc.euclid.tuple3D.Vector3D data, us.ihmc.idl.CDR cdr)
   {
        read(data, cdr);
   }
   
   public void copy(us.ihmc.euclid.tuple3D.Vector3D src, us.ihmc.euclid.tuple3D.Vector3D dest)
   {
      staticCopy(src, dest);
   }	

   
   @Override
   public Vector3PubSubType newInstance()
   {
   	  return new Vector3PubSubType();
   }
}