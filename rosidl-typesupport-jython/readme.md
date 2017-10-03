# ROS2 to IDL message generator package

This package provides the ROS2 IDL typesupport, backported to Python 2.7. A jar file with included Jython runtime will be built by Java.

## Usage

```
mvn package
java -jar target/rosidl-typesupport-ihmcpubsub-java-1.0-jar-with-dependencies.jar arguments.json ros_msgs/
```
