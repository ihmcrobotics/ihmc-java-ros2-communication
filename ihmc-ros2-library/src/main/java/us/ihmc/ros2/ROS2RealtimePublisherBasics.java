package us.ihmc.ros2;

public interface ROS2RealtimePublisherBasics<T>
{
   boolean publish(T data);
}
