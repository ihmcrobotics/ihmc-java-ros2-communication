# ROS2 Common Interfaces

TODO: Write really good readme.

Generated Java files for interacting with and using [ROS2 common interfaces](https://github.com/ros2/common_interfaces).

MESSAGE GENERATION FOR THIS PROJECT NOT YET SUPPORTED. Contact dcalvert@ihmc.us to regenerate.

## Generating Messages

Clone ihmc-pub-sub. Temporarily set:

`ihmc-pub-sub/gradle.properties/excludeFromCompositeBuild = false`

`ihmc-java-ros2-communication/gradle.properties/excludeFromCompositeBuild = false`

In JavaType.stg, remove `import us.ihmc.communication.packets.Packet;` and ` extends Packet<$struct.name$>`

In ihmc-java-ros2-communication/ros2-common-interfaces:

`gradle generateMessages`

## Publish
##### To maven local:

`gradle compositeTask -PtaskName=publishToMavenLocal  -PcompositeSearchHeight=0 -PpublishMode=STABLE`

##### To Bintray:

`gradle publishAll -PcompositeSearchHeight=0 -PpublishMode=STABLE`
