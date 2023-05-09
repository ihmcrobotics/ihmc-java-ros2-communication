package us.ihmc.ros2;

@Deprecated
public interface RealtimeROS2Publisher<T>
{
   boolean publish(T data);

   void remove();
}
