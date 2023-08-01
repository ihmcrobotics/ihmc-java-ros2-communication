package us.ihmc.ros2;

import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.publisher.Publisher;

import java.io.IOException;

/**
 * A ROS 2 compatible publisher
 *
 * @param <T> the data type
 */
public class ROS2Publisher<T> implements ROS2PublisherBasics<T>
{
   private final Domain domain;
   private final Publisher publisher;

   ROS2Publisher(Domain domain, Publisher publisher)
   {
      this.domain = domain;
      this.publisher = publisher;
   }

   @Override
   public boolean publish(T data)
   {
      try
      {
         if (publisher.isAvailable())
         {
            publisher.write(data);
            return true;
         }
         else
         {
            return false;
         }
      }
      catch (IOException ioException)
      {
         LogTools.error(ioException.getMessage());
         return false;
      }
   }

   @Override
   public void remove()
   {
      domain.removePublisher(publisher);
   }

   Publisher getPublisher()
   {
      return publisher;
   }

   Domain getDomain()
   {
      return domain;
   }
}
