package us.ihmc.ros2;

import java.util.Objects;
import java.util.function.Function;

import static us.ihmc.ros2.ROS2TopicNameTools.messageTypeToTopicNamePart;
import static us.ihmc.ros2.ROS2TopicNameTools.processTopicNamePart;

/**
 * <p>
 * A ROS 2 topic, represented as a String builder with a type. It is designed to be an immutable class with
 * equals, hashCode, and toString support.
 * </p>
 * <p>The immutable methods start with "with".</p>
 * <p>It considers a ROS 2 topic name to be 5 string parts put together:</p>
 * <ul>
 *    <li>prefix</li>
 *    <li>robot name</li>
 *    <li>module name</li>
 *    <li>io qualifier</li>
 *    <li>suffix</li>
 * </ul>
 * <p>
 * The toString() method and the getName() methods evaluate to the topic name i.e. /ihmc/controller/output/status
 * </p>
 * <p>
 * It also is parameterized by type. This type is used to enforce topic type safety and
 * increase the usefulness of helper methods.
 *
 * Before the message type is known, for example the IHMC_ROOT topic in ROS2Tools,
 * the user would use the ? as ROS2Topic<?> to say the type has not yet been decided.
 * </p>
 * <p>
 * The standard usage of this class would be:
 * <pre>
 *    // evaluates to "/ihmc/atlas/rea/example_type/one"
 *    ROS2Topic topicName = new ROS2Topic().withPrefix("ihmc").withRobot("atlas").withModule("rea")
 *                                            .withType(ExampleTypeMessage.class).withSuffix(typeName -> typeName + "/one");
 *
 *    // use of immutable property
 *    // evaluates to "/ihmc"
 *    ROS2Topic ihmcPrefixed = new ROS2Topic().withPrefix("ihmc");
 *    // evaluates to "/ihmc/hello"
 *    ROS2Topic hello = ihmcPrefixed.withModule("hello");
 * </pre>
 *
 * @param <T>
 */
public class ROS2Topic<T>
{
   public static final String INPUT = "input";
   public static final String OUTPUT = "output";

   private final String prefix;
   private final String robotName;
   private final String moduleName;
   private final String ioQualifier;
   private final String suffix;

   private final Class<T> messageType;

   /**
    * <p>Create the emtpy topic. The name of this topic will evaluate to an empty String.</p>
    * <p>It is recommended to start from another existing topic name instead of starting from scratch every time.</p>
    */
   public ROS2Topic() // TODO make private and provide static root name method?
   {
      prefix = "";
      robotName = "";
      moduleName = "";
      ioQualifier = "";
      suffix = "";
      messageType = null;
   }

   private ROS2Topic(String prefix,
                     String robotName,
                     String moduleName,
                     String ioQualifier,
                     String suffix,
                     Class<T> messageType)
   {
      this.prefix = prefix;
      this.robotName = robotName;
      this.moduleName = moduleName;
      this.ioQualifier = ioQualifier;
      this.suffix = suffix;
      this.messageType = messageType;
   }

   /**
    * Returns a new topic with the provided prefix.
    * If the provided prefix is null, then the part will evaluate to an empty string not even a "/" will
    * appear in the resulting topic name.
    * @param prefix part 1/5 of this topic name
    * @return new topic
    */
   public ROS2Topic<T> withPrefix(String prefix)
   {
      return new ROS2Topic<>(processTopicNamePart(prefix), robotName, moduleName, ioQualifier, suffix, messageType);
   }

   /**
    *
    * @param robotName
    * @return
    */
   public ROS2Topic<T> withRobot(String robotName)
   {
      return new ROS2Topic<>(prefix, processTopicNamePart(robotName), moduleName, ioQualifier, suffix, messageType);
   }

   public ROS2Topic<T> withModule(String moduleName)
   {
      return new ROS2Topic<>(prefix, robotName, processTopicNamePart(moduleName), ioQualifier, suffix, messageType);
   }

   public ROS2Topic<T> withInput()
   {
      return withIOQualifier(INPUT);
   }

   public ROS2Topic<T> withOutput()
   {
      return withIOQualifier(OUTPUT);
   }

   public ROS2Topic<T> withIOQualifier(String ioQualifier)
   {
      return new ROS2Topic<T>(prefix, robotName, moduleName, processTopicNamePart(ioQualifier), suffix, messageType);
   }

   public ROS2Topic<T> withSuffix(String suffix)
   {
      return new ROS2Topic<>(prefix, robotName, moduleName, ioQualifier, processTopicNamePart(suffix), messageType);
   }

   public ROS2Topic<T> withSuffix(Function<String, String> typeToNameFunction)
   {
      String newSuffix = suffix;
      if (typeToNameFunction != null && messageType != null)
      {
         newSuffix = processTopicNamePart(typeToNameFunction.apply(messageTypeToTopicNamePart(messageType)));
      }
      return new ROS2Topic<>(prefix, robotName, moduleName, ioQualifier, newSuffix, messageType, typeToNameFunction);
   }

   public <K> ROS2Topic<K> withType(Class<K> messageType)
   {
      String newSuffix = suffix;
      if (messageType != null)
      {
         newSuffix = messageTypeToTopicNamePart(messageType);
      }
      return new ROS2Topic<>(prefix, robotName, moduleName, ioQualifier, newSuffix, messageType);
   }

   public ROS2Topic<T> withTopic(ROS2Topic<?> topic)
   {
      String newPrefix = takeNonNullOrSecond(prefix, topic.prefix);
      String newRobotName = takeNonNullOrSecond(robotName, topic.robotName);
      String newModuleName = takeNonNullOrSecond(moduleName, topic.moduleName);
      String newIOQualifier = takeNonNullOrSecond(ioQualifier, topic.ioQualifier);
      String newSuffix = takeNonNullOrSecond(suffix, topic.suffix);
      if (topic.messageType != null && !topic.messageType.equals(messageType))
      {
         throw new RuntimeException("Cannot change the type of a Topic with the withTopic method");
      }
      return new ROS2Topic<>(newPrefix, newRobotName, newModuleName, newIOQualifier, newSuffix, messageType);
   }

   private <K> K takeNonNullOrSecond(K first, K second)
   {
      if (first != null && second == null)
      {
         return first;
      }
      else if (first == null && second != null)
      {
         return second;
      }
      else if (first instanceof String && !((String) first).isEmpty()
               && second instanceof String && ((String) second).isEmpty())
      {
         return first;
      }
      else
      {
         return second;
      }
   }

   public Class<T> getType()
   {
      return messageType;
   }

   public String getName()
   {
      return toString();
   }

   @Override
   public String toString()
   {
      String topicName = "";
      topicName += prefix;
      topicName += robotName;
      topicName += moduleName;
      topicName += ioQualifier;
      topicName += suffix;
      return topicName;
   }

   @Override
   public boolean equals(Object other)
   {
      if (this == other)
         return true;
      if (other == null || getClass() != other.getClass())
         return false;
      ROS2Topic<?> topicName = (ROS2Topic<?>) other;
      return Objects.equals(prefix, topicName.prefix)
             && Objects.equals(robotName, topicName.robotName)
             && Objects.equals(moduleName, topicName.moduleName)
             && Objects.equals(ioQualifier, topicName.ioQualifier)
             && Objects.equals(suffix, topicName.suffix)
             && Objects.equals(messageType, topicName.messageType);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(prefix, robotName, moduleName, ioQualifier, suffix, messageType);
   }
}
