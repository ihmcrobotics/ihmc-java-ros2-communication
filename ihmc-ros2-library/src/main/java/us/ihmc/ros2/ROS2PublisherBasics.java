package us.ihmc.ros2;

public interface ROS2PublisherBasics<T> extends RealtimeROS2Publisher<T>
{
   /**
    * Publish data to the ROS2 domain
    *
    * @param data Data to publisher
    * @return true if succesful, false on error
    */
   boolean publish(T data);

   /**
    * Remove this publisher from the ROS domain
    */
   void remove();
   
}
