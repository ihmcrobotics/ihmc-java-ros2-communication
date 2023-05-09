package us.ihmc.ros2;

@Deprecated
public interface RealtimeROS2Subscription<T>
{
   boolean poll(T data);

   boolean flushAndGetLatest(T data);

   void remove();
}
