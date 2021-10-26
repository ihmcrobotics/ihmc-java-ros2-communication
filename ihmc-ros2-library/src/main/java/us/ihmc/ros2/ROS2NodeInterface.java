package us.ihmc.ros2;

import java.io.IOException;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.subscriber.Subscriber;


public interface ROS2NodeInterface
{
   public static final int DEFAULT_QUEUE_SIZE = 10;

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
   default <T> ROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createPublisher(topicDataType, topicName, ROS2QosProfile.DEFAULT());
   }

   /**
    * Create a new ROS2 compatible publisher in this Node
    *
    * @param topicDataType The topic data type of the message
    * @param topicName     Name for the topic
    * @param qosProfile    ROS Qos Profile
    * @return A ROS publisher
    * @throws IOException if no publisher can be made
    */
   default <T> ROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile) throws IOException
   {
      return createPublisher(topicDataType, createPublisherAttributes(topicDataType, topicName, qosProfile));
   }
   

   /**
    * Create publisher attributes for a topic
    * @param <T> Data type of the topic
    * @param topicDataType Data type serializer of the topic
    * @param topicName Topic Name
    * @param qosProfile Initial ROS2 QOS profile 
    * @return PublisherAttributes for createPublisher
    */
   <T> PublisherAttributes createPublisherAttributes(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile);

   /**
    * Create a new ROS2 compatible publisher in this Node
    *
    * @param topicDataType The topic data type of the message
    * @param publisherAttributes Publisher attributes created with @see{createPublisherAttributes}
    * @return A ROS publisher
    * @throws IOException if no publisher can be made
    */
   <T> ROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, PublisherAttributes publisherAttributes) throws IOException;

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
   default <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName) throws IOException
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
   
   default <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile, int queueSize)
         throws IOException
   {
      return createQueuedSubscription(topicDataType, createSubscriberAttributes(topicName, topicDataType, qosProfile), queueSize);
   }
   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime therad. The queueSize should weight memory requirements of the
    * message vs the change to lose incoming messages because the queue is full.
    *
    * @param topicDataType Data type to subscribe to
    * @param SubscriberAttributes  Attributes for this topic, created using @see{createSubscriberAttributes}
    * @param queueSize     Depth of the subscribtion queue (10 would be a good size for small messages)
    * @return A realtime-safe ROS2 subscriber
    * @throws IOException
    */
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, SubscriberAttributes subscriberAttributes, int queueSize)
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
   default <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener, String topicName) throws IOException
   {
      return createSubscription(topicDataType, newMessageListener, topicName, ROS2QosProfile.DEFAULT());
   }

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
   default <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener, String topicName,
                                              ROS2QosProfile qosProfile) throws IOException
   {
      return createSubscription(topicDataType, newMessageListener, createSubscriberAttributes(topicName, topicDataType, qosProfile));
   }
   
   /**
    * Create a new ROS2 compatible subscription.
    *
    * @param topicDataType The topic data type of the message
    * @param subscriberListener Listener for new messages
    * @param topicName     Name for the topic
    * @param SubscriberAttributes  Attributes for this topic, created using @see{createSubscriberAttributes}
    * @throws IOException if no subscriber can be made
    */

   <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> subscriberListener, SubscriberAttributes subscriberAttributes) throws IOException;
   

   
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
   default <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener,
                                              SubscriptionMatchedListener<T> subscriptionMatchedListener, String topicName,
                                              ROS2QosProfile qosProfile) throws IOException
   {
      return createSubscription(topicDataType, new NewMessageListener<T>()
      {
         @Override
         public void onNewDataMessage(Subscriber<T> subscriber)
         {
            newMessageListener.onNewDataMessage(subscriber);
         }

         @Override
         public void onSubscriptionMatched(Subscriber<T> subscriber, MatchingInfo info)
         {
            subscriptionMatchedListener.onSubscriptionMatched(subscriber, info);
         }
      }, createSubscriberAttributes(topicName, topicDataType, qosProfile));
   }

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

   /**
    * Create subscriber attributes compatible with the desired topic
    * 
    * This allows advanced control over the DDS layer
    * 
    * @param <T> Type of data
    * @param topicName Name of the topic
    * @param topicDataType Data type class
    * @param qosProfile Default ROS2 profile for setup
    * @return A subscriber profile for this topic
    */
   <T> SubscriberAttributes createSubscriberAttributes(String topicName, TopicDataType<T> topicDataType, ROS2QosProfile qosProfile);

}

