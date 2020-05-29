package us.ihmc.ros2;

import us.ihmc.commons.thread.TypedNotification;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

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
   private TypedNotification<T> messageNotification = new TypedNotification<>();
   private List<Consumer<T>> userCallbacks = new ArrayList<>();

   public ROS2Input(Ros2NodeInterface ros2Node, Class<T> messageType, ROS2Topic topicName)
   {
      this(ros2Node, messageType, topicName.withType(messageType).toString());
   }

   public ROS2Input(Ros2NodeInterface ros2Node, Class<T> messageType, ROS2Topic topicName, T initialValue, MessageFilter<T> messageFilter)
   {
      this(ros2Node, messageType, topicName.withType(messageType).toString(), initialValue, messageFilter);
   }

   public ROS2Input(Ros2NodeInterface ros2Node, Class<T> messageType, String topicName)
   {
      this(ros2Node, messageType, topicName, ROS2TopicNameTools.newMessageInstance(messageType), message -> true);
   }

   public ROS2Input(Ros2NodeInterface ros2Node, Class<T> messageType, String topicName, T initialValue, MessageFilter<T> messageFilter)
   {
      atomicReference = new AtomicReference<>(initialValue);
      this.messageFilter = messageFilter;
      ros2Callback = new ROS2Callback<>(ros2Node, messageType, topicName, this::messageReceivedCallback);
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
         messageNotification.set(incomingData);
         for (Consumer<T> userCallback : userCallbacks)
         {
            userCallback.accept(incomingData);
         }
         hasReceivedFirstMessage = true;
      }
   }

   public T getLatest()
   {
      return atomicReference.get();
   }

   public TypedNotification<T> getMessageNotification()
   {
      return messageNotification;
   }

   public boolean hasReceivedFirstMessage()
   {
      return hasReceivedFirstMessage;
   }

   public void setEnabled(boolean enabled)
   {
      ros2Callback.setEnabled(enabled);
   }

   public void addCallback(Consumer<T> messageReceivedCallback)
   {
      userCallbacks.add(messageReceivedCallback);
   }

   public void destroy()
   {
      ros2Callback.destroy();
   }
}
