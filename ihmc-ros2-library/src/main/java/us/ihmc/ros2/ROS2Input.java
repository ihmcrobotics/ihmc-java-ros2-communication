package us.ihmc.ros2;

import us.ihmc.communication.ROS2Tools.ROS2TopicQualifier;
import us.ihmc.ros2.ROS2Node;

import java.util.concurrent.atomic.AtomicReference;

/**
 * An atomic reference to the latest received message through an optional filter.
 *
 * @param <T> messageType
 */
public class ROS2Input<T>
{
   private final AtomicReference<T> atomicReference;
   private final MessageFilter<T> messageFilter;
   private boolean hasReceivedFirstMessage = false;
   private ROS2Callback<T> ros2Callback;

   public ROS2Input(ROS2Node ros2Node, Class<T> messageType, String robotName, ROS2ModuleIdentifier identifier)
   {
      this(ros2Node, messageType, robotName, identifier, ROS2Tools.newMessageInstance(messageType), message -> true);
   }

   public ROS2Input(ROS2Node ros2Node, Class<T> messageType, String robotName, ROS2ModuleIdentifier identifier, T initialValue)
   {
      this(ros2Node, messageType, robotName, identifier, initialValue, message -> true);
   }

   public ROS2Input(ROS2Node ros2Node, Class<T> messageType, String robotName, ROS2ModuleIdentifier identifier, MessageFilter<T> messageFilter)
   {
      this(ros2Node, messageType, robotName, identifier, ROS2Tools.newMessageInstance(messageType), messageFilter);
   }

   public ROS2Input(ROS2Node ros2Node, Class<T> messageType, String robotName, ROS2ModuleIdentifier identifier, T initialValue, MessageFilter<T> messageFilter)
   {
      this(ros2Node,
           messageType,
           robotName,
           identifier.getModuleTopicQualifier(),
           identifier.deriveIOTopicQualifierForSubscriber(ros2Node.getName()),
           initialValue,
           messageFilter);
   }

   public ROS2Input(ROS2Node ros2Node, Class<T> messageType)
   {
      this(ros2Node, messageType, null, null, null, ROS2Tools.newMessageInstance(messageType), message -> true);
   }

   public ROS2Input(ROS2Node ros2Node,
                    Class<T> messageType,
                    String robotName,
                    String moduleTopicQualifier,
                    ROS2TopicQualifier ioTopicQualifier,
                    T initialValue,
                    MessageFilter<T> messageFilter)
   {
      atomicReference = new AtomicReference<>(initialValue);
      this.messageFilter = messageFilter;
      ros2Callback = new ROS2Callback<>(ros2Node, messageType, robotName, moduleTopicQualifier, ioTopicQualifier, this::messageReceivedCallback);
   }

   public interface MessageFilter<T>
   {
      boolean accept(T message);
   }

   private void messageReceivedCallback(T incomingData)
   {
      if (messageFilter.accept(incomingData))
      {
         atomicReference.set(incomingData);
         hasReceivedFirstMessage = true;
      }
   }

   public T getLatest()
   {
      return atomicReference.get();
   }

   public boolean hasReceivedFirstMessage()
   {
      return hasReceivedFirstMessage;
   }

   public void setEnabled(boolean enabled)
   {
      ros2Callback.setEnabled(enabled);
   }

   public void destroy()
   {
      ros2Callback.destroy();
   }
}
