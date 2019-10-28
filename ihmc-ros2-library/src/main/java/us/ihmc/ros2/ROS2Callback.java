package us.ihmc.ros2;

import us.ihmc.commons.exception.DefaultExceptionHandler;
import us.ihmc.commons.exception.ExceptionTools;
import us.ihmc.communication.ROS2Tools.ROS2TopicQualifier;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.ros2.ROS2Node;
import us.ihmc.ros2.ROS2Subscription;

import java.util.function.Consumer;

/**
 * Callback listener to non-null reception of a message on a ROS 2 topic.
 *
 * @param <T> messageType
 */
public class ROS2Callback<T>
{
   private final Consumer<T> messageCallback;
   private ROS2Subscription<T> subscription;
   private volatile boolean enabled = true;

   public ROS2Callback(ROS2Node ros2Node, Class<T> messageType, String robotName, ROS2ModuleIdentifier identifier, Consumer<T> messageCallback)
   {
      this(ros2Node,
           messageType,
           robotName,
           identifier.getModuleTopicQualifier(),
           identifier.deriveIOTopicQualifierForSubscriber(ros2Node.getName()),
           messageCallback);
   }

   /**
    *  For topics that use the default /ihmc/topic_name.
    */
   public ROS2Callback(ROS2Node ros2Node, Class<T> messageType, Consumer<T> messageCallback)
   {
      this(ros2Node, messageType, null, null, null, messageCallback);
   }

   public ROS2Callback(ROS2Node ros2Node,
                       Class<T> messageType,
                       String robotName,
                       String moduleTopicQualifier,
                       ROS2TopicQualifier ioTopicQualifier,
                       Consumer<T> messageCallback)
   {
      this.messageCallback = messageCallback;
      ExceptionTools.handle(() ->
      {
         subscription = ros2Node.createSubscription(ROS2Tools.newMessageTopicDataTypeInstance(messageType),
                                                    this::nullOmissionCallback,
                                                    ROS2Tools.generateDefaultTopicName(messageType,
                                                                                       robotName,
                                                                                       moduleTopicQualifier,
                                                                                       ioTopicQualifier));
      },
      DefaultExceptionHandler.RUNTIME_EXCEPTION);
   }

   private void nullOmissionCallback(Subscriber<T> subscriber)
   {
      if (enabled)
      {
         T incomingData = subscriber.takeNextData();
         if (incomingData != null)
         {
            messageCallback.accept(incomingData);
         }
         else
         {
            LogTools.warn("Received null from takeNextData()");
         }
      }
   }

   public void setEnabled(boolean enabled)
   {
      this.enabled = enabled;
   }

   public void destroy()
   {
      if (subscription != null)
      {
         subscription.remove();
      }
   }
}
