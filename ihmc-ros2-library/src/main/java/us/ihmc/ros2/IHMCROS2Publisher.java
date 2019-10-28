package us.ihmc.ros2;

import us.ihmc.commons.exception.DefaultExceptionHandler;
import us.ihmc.commons.exception.ExceptionTools;
import us.ihmc.communication.ROS2Tools.ROS2TopicQualifier;
import us.ihmc.log.LogTools;
import us.ihmc.ros2.ROS2Node;
import us.ihmc.ros2.ROS2Publisher;

public class IHMCROS2Publisher<T>
{
   private static final int NUMBER_OF_EXCEPTIONS_TO_PRINT = 5;

   private ROS2Publisher<T> publisher;

   private int numberOfExceptions = 0;

   IHMCROS2Publisher(ROS2Publisher<T> ros2Publisher)
   {
      this.publisher = ros2Publisher;
   }

   public IHMCROS2Publisher(ROS2Node ros2Node, Class<T> messageType)
   {
      this(ros2Node, messageType, null, null, null);
   }

   public IHMCROS2Publisher(ROS2Node ros2Node, Class<T> messageType, String robotName, ROS2ModuleIdentifier identifier)
   {
      this(ros2Node, messageType, robotName, identifier.getModuleTopicQualifier(), identifier.deriveIOTopicQualifierForPublisher(ros2Node.getName()));
   }

   public IHMCROS2Publisher(ROS2Node ros2Node, Class<T> messageType, String robotName, String moduleTopicQualifier, ROS2TopicQualifier ioTopicQualifier)
   {
      ExceptionTools.handle(() -> publisher = ros2Node.createPublisher(ROS2Tools.newMessageTopicDataTypeInstance(messageType),
                                                                       ROS2Tools.generateDefaultTopicName(messageType,
                                                                                                          robotName,
                                                                                                          moduleTopicQualifier,
                                                                                                          ioTopicQualifier)),
                            DefaultExceptionHandler.RUNTIME_EXCEPTION);
   }

   public void publish(T message)
   {
      try
      {
         publisher.publish(message);
      }
      catch (Exception e)
      {
         if (numberOfExceptions <= NUMBER_OF_EXCEPTIONS_TO_PRINT)
         {
            e.printStackTrace();

            if (++numberOfExceptions > NUMBER_OF_EXCEPTIONS_TO_PRINT)
            {
               LogTools.error("Stopping to print exceptions after {}.", NUMBER_OF_EXCEPTIONS_TO_PRINT);
            }
         }
      }
   }

   public void destroy()
   {
      publisher.remove();
   }
}
