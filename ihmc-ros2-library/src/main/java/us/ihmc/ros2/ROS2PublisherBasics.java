package us.ihmc.ros2;

import java.io.IOException;

public interface ROS2PublisherBasics<T>
{
   void publish(T data) throws IOException;
}
