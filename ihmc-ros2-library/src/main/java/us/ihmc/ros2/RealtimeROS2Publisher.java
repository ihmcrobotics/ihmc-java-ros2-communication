package us.ihmc.ros2;

import java.io.IOException;

/**
 * Helper interface for backwards compatibility
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
@Deprecated
public interface RealtimeROS2Publisher<T> 
{
   boolean publish(T data) throws IOException;

   void remove();
}
