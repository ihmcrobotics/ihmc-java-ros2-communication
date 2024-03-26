package us.ihmc.ros2;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.UUID;

import com.eprosima.xmlschemas.fastrtps_profiles.RtpsTransportDescriptorType;

import us.ihmc.log.LogTools;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.subscriber.Subscriber;

public interface ROS2NodeInterface
{
   int DEFAULT_QUEUE_SIZE = 10;

   static ParticipantAttributes createParticipantAttributes(int domainId, boolean useSharedMemory, InetAddress... addressRestriction)
   {
      ParticipantAttributes participantAttributes = ParticipantAttributes.create().domainId(domainId).discoveryLeaseDuration(Time.Infinite);

      boolean restrictedToAddress = false;
      if (addressRestriction != null)
      {
         if (addressRestriction.length > 0)
         {
            if (addressRestriction[0] != null) // Check for null on the first element, to make sure passing in null works as usual -> no address restrictions
            {
               participantAttributes.bindToAddressRestrictions(useSharedMemory, Arrays.asList(addressRestriction));
               restrictedToAddress = true;
            }
         }
      }
      
      // If not restricted to an address, disable shared memory if useSharedMemory is false
      if(!restrictedToAddress)
      {
         if(!useSharedMemory)
         {
            // Disable default transports
            participantAttributes.useBuiltinTransports(false);
                        
            // Add custom UDPv4 transport
            String transportName = UUID.randomUUID().toString();
            RtpsTransportDescriptorType transportDescriptor = new RtpsTransportDescriptorType();
            transportDescriptor.setTransportId(transportName);
            transportDescriptor.setType("UDPv4");

            participantAttributes.addTransport(transportDescriptor);

         }
      }
      
      return participantAttributes;
   }
   
   static boolean useSHMFromEnvironment()
   {
      String disableSharedMemoryTransportEnv = System.getenv("ROS_DISABLE_SHARED_MEMORY_TRANSPORT");
      if(disableSharedMemoryTransportEnv == null)
      {
         return false;
      }
      else if (disableSharedMemoryTransportEnv.equalsIgnoreCase("true"))
      {
         LogTools.info("Shared memory transport is disabled via environment variable ROS_DISABLE_SHARED_MEMORY_TRANSPORT");
         return false;
      }
      else
      {
         return true;
      }
   }

   static int domainFromEnvironment()
   {
      String rosDomainId = System.getenv("ROS_DOMAIN_ID");

      int rosDomainIdAsInteger = 0; // default to 0

      if (rosDomainId != null)
      {
         rosDomainId = rosDomainId.trim();
         try
         {
            rosDomainIdAsInteger = Integer.parseInt(rosDomainId);
         }
         catch (NumberFormatException e)
         {
            LogTools.warn("Environment variable ROS_DOMAIN_ID cannot be parsed as an integer: {}", rosDomainId);
         }
      }

      LogTools.info("ROS_DOMAIN_ID from environment is {} (fallback only; ignore if set manually)", rosDomainIdAsInteger);

      return rosDomainIdAsInteger;
   }

   /**
    * Create a new ROS 2 compatible publisher in this node.
    * This call makes a publisher with the default settings.
    *
    * @param topicDataType The topic data type of the message
    * @param topicName     Name for the topic
    * @return a ROS 2 publisher
    * @throws IOException if no publisher can be made
    */
   default <T> ROS2PublisherBasics<T> createPublisher(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createPublisher(topicDataType, topicName, ROS2QosProfile.RELIABLE());
   }

   /**
    * Create a new ROS 2 compatible publisher in this node.
    *
    * @param topicDataType The topic data type of the message
    * @param topicName     Name for the topic
    * @param qosProfile    ROS 2 qos profile
    * @return a ROS 2 publisher
    * @throws IOException if no publisher can be made
    */
   default <T> ROS2PublisherBasics<T> createPublisher(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile) throws IOException
   {
      return createPublisher(topicDataType, createPublisherAttributes(topicDataType, topicName, qosProfile));
   }

   /**
    * Create publisher attributes for a topic.
    *
    * @param <T>           Data type of the topic
    * @param topicDataType Data type serializer of the topic
    * @param topicName     Topic Name
    * @param qosProfile    Initial ROS 2 qos profile
    * @return PublisherAttributes for createPublisher
    */
   <T> PublisherAttributes createPublisherAttributes(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile);

   /**
    * Create a new ROS 2 compatible publisher in this node.
    *
    * @param topicDataType       The topic data type of the message
    * @param publisherAttributes Publisher attributes created with @see{createPublisherAttributes}
    * @return a ROS 2 publisher
    * @throws IOException if no publisher can be made
    */
   <T> ROS2PublisherBasics<T> createPublisher(TopicDataType<T> topicDataType, PublisherAttributes publisherAttributes) throws IOException;

   /**
    * Create a new realtime subscription with default qos profile and queue depth. Incoming messages
    * are stored in a queue of depth queueSize and can be polled by the realtime thread. This function
    * will allocate a queue of depth 10.
    *
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @return A realtime-safe ROS 2 subscriber
    * @throws IOException
    */
   default <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName) throws IOException
   {
      return createQueuedSubscription(topicDataType, topicName, ROS2QosProfile.RELIABLE(), DEFAULT_QUEUE_SIZE);
   }

   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime thread. The queueSize should weigh memory requirements of the
    * message vs the chance to lose incoming messages because the queue is full.
    *
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @param qosProfile    Desired ros qos profile
    * @param queueSize     Depth of the subscription queue (10 would be a good size for small messages)
    * @return a realtime-safe ROS 2 subscriber
    * @throws IOException
    */
   default <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile, int queueSize)
         throws IOException
   {
      return createQueuedSubscription(topicDataType, createSubscriberAttributes(topicName, topicDataType, qosProfile), queueSize);
   }

   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime thread. The queueSize should weigh memory requirements of the
    * message vs the chance to lose incoming messages because the queue is full.
    *
    * @param topicDataType        Data type to subscribe to
    * @param subscriberAttributes Attributes for this topic, created
    *                             using @see{createSubscriberAttributes}
    * @param queueSize            Depth of the subscription queue (10 would be a good size for small
    *                             messages)
    * @return a realtime-safe ROS 2 subscriber
    * @throws IOException
    */
   <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, SubscriberAttributes subscriberAttributes, int queueSize)
         throws IOException;

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param topicDataType      The topic data type of the message
    * @param newMessageListener New message listener
    * @param topicName          Name for the topic
    * @return a ROS 2 subscription
    * @throws IOException if no subscriber can be made
    */
   default <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener, String topicName)
         throws IOException
   {
      return createSubscription(topicDataType, newMessageListener, topicName, ROS2QosProfile.RELIABLE());
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param topicDataType      The topic data type of the message
    * @param newMessageListener New message listener
    * @param topicName          Name for the topic
    * @return a ROS 2 subscription
    * @throws IOException if no subscriber can be made
    */
   default <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType,
                                                      NewMessageListener<T> newMessageListener,
                                                      String topicName,
                                                      ROS2QosProfile qosProfile) throws IOException
   {
      return createSubscription(topicDataType, newMessageListener, createSubscriberAttributes(topicName, topicDataType, qosProfile));
   }

   /**
    * Create a new ROS 2 compatible subscription.
    *
    * @param topicDataType        The topic data type of the message
    * @param subscriberListener   Listener for new messages
    * @param subscriberAttributes Attributes for this topic, created
    *                             using @see{createSubscriberAttributes}
    * @throws IOException if no subscriber can be made
    */
   <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType,
                                              NewMessageListener<T> subscriberListener,
                                              SubscriberAttributes subscriberAttributes) throws IOException;

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param topicDataType               The topic data type of the message
    * @param newMessageListener          New message listener
    * @param subscriptionMatchedListener Subscription matched listener
    * @param topicName                   Name for the topic
    * @param qosProfile                  ROS 2 qos Profile
    * @return a ROS 2 subscription
    * @throws IOException if no subscriber can be made
    */
   default <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType,
                                                      NewMessageListener<T> newMessageListener,
                                                      SubscriptionMatchedListener<T> subscriptionMatchedListener,
                                                      String topicName,
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

   String getName();

   String getNamespace();

   <T> SubscriberAttributes createSubscriberAttributes(String topicName, TopicDataType<T> topicDataType, ROS2QosProfile qosProfile);
}
