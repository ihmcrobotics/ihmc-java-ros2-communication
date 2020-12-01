package us.ihmc.ros2;

import us.ihmc.pubsub.TopicDataType;

import java.io.IOException;

public interface ROS2NodeInterface
{
   /**
    * Create a new ROS2 compatible publisher in this Node
    *
    * This call makes a publisher with the default settings
    *
    * @param topicDataType The topic data type of the message
    * @param topicName Name for the topic
    * @return A ROS publisher
    *
    * @throws IOException if no publisher can be made
    */
   <T> ROS2PublisherBasics<T> createPublisher(TopicDataType<T> topicDataType, String topicName) throws IOException;

   /**
    * Create a new ROS2 compatible publisher in this Node
    *
    * @param topicDataType The topic data type of the message
    * @param topicName Name for the topic
    * @param qosProfile ROS Qos Profile
    * @return A ROS publisher
    *
    * @throws IOException if no publisher can be made
    */
   <T> ROS2PublisherBasics<T> createPublisher(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile) throws IOException;

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
   <T> ROS2SubscriptionInterface createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener, String topicName) throws IOException;

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
   <T> ROS2SubscriptionInterface createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener, String topicName,
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
   <T> ROS2SubscriptionInterface createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener,
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
