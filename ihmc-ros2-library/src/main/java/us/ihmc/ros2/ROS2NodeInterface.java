package us.ihmc.ros2;

import us.ihmc.pubsub.TopicDataType;

import java.io.IOException;

import static us.ihmc.ros2.RealtimeROS2Node.DEFAULT_QUEUE_SIZE;

public interface ROS2NodeInterface
{
   /**
    * Create a new ROS2 compatible publisher in this Node
    * <p>
    * This call makes a publisher with the default settings
    *
    * @param topicDataType The topic data type of the message
    * @param topicName     Name for the topic
    * @return A ROS publisher
    * @throws IOException if no publisher can be made
    */
   <T> ROS2PublisherBasics<T> createPublisher(TopicDataType<T> topicDataType, String topicName) throws IOException;

   /**
    * Create a new ROS2 compatible publisher in this Node
    *
    * @param topicDataType The topic data type of the message
    * @param topicName     Name for the topic
    * @param qosProfile    ROS Qos Profile
    * @return A ROS publisher
    * @throws IOException if no publisher can be made
    */
   <T> ROS2PublisherBasics<T> createPublisher(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile) throws IOException;

   /**
    * Create a new realtime subscription with default qos profile and queue depth. Incoming messages
    * are stored in a queue of depth queueSize and can be polled by the realtime therad. This function
    * will allocate a queue of depth 10
    *
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @return A realtime-safe ROS2 subscriber
    * @throws IOException
    */
   public default <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createQueuedSubscription(topicDataType, topicName, ROS2QosProfile.DEFAULT(), DEFAULT_QUEUE_SIZE);
   }

   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime therad. The queueSize should weight memory requirements of the
    * message vs the change to lose incoming messages because the queue is full.
    *
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @param qosProfile    Desired ros qos profile
    * @param queueSize     Depth of the subscribtion queue (10 would be a good size for small messages)
    * @return A realtime-safe ROS2 subscriber
    * @throws IOException
    */
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile, int queueSize)
         throws IOException;

   /**
    * Create a new ROS2 compatible subscription.
    *
    * This call can be used to make a ROS2 topic with the default qos profile
    *
    *
    * @param topicDataType The topic data type of the message
    * @param newMessageListener New message listener
    * @param topicName Name for the topic
    * @return Ros Subscription
    * @throws IOException if no subscriber can be made
    */
   <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener, String topicName) throws IOException;

   /**
    * Create a new ROS2 compatible subscription.
    *
    * This call can be used to make a ROS2 topic with the default qos profile
    *
    * @param topicDataType The topic data type of the message
    * @param newMessageListener New message listener
    * @param topicName Name for the topic
    * @return Ros Subscription
    * @throws IOException if no subscriber can be made
    */
   <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener, String topicName,
                                              ROS2QosProfile qosProfile) throws IOException;

   /**
    * Create a new ROS2 compatible subscription.
    *
    * This call can be used to make a ROS2 topic with the default qos profile
    *
    * @param topicDataType The topic data type of the message
    * @param newMessageListener New message listener
    * @param subscriptionMatchedListener Subscription matched listener
    * @param topicName Name for the topic
    * @param qosProfile ROS Qos Profile
    * @return Ros Subscription
    * @throws IOException if no subscriber can be made
    */
   <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener,
                                              SubscriptionMatchedListener<T> subscriptionMatchedListener, String topicName,
                                              ROS2QosProfile qosProfile) throws IOException;

   /**
    *
    * @return the name of this node
    */
   String getName();

   /**
    *
    * @return the namespace of this node
    */
   String getNamespace();
}
