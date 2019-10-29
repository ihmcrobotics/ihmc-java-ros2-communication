package us.ihmc.ros2;

import java.io.IOException;

public interface Ros2PublisherBasics<T>
{
   /**
    * Publish data to the ROS2 domain
    *
    * @param data Data to publisher
    * @throws IOException If the data cannot be serialized or another error occurs
    */
   void publish(T data) throws IOException;

   /**
    * Remove this publisher from the ROS domain
    */
   void remove();
}
