# IHMC ROS2 Library

This library provides a minimal implementation of a RosNode in Java. Two version are available

- RosNode
	Publishes in the same thread and uses direct callbacks for incoming messages
- RealtimeNode
	Stores outgoing and incoming messages in a queue and uses non-blocking calls to publish messages and allows polling for new messages.
	
## License

Apache 2.0
 