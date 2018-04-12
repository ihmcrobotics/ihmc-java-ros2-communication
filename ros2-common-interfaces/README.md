# ROS2 Common Interfaces

TODO: Write really good readme.

Generated Java files for interacting with and using [ROS2 common interfaces](https://github.com/ros2/common_interfaces).

## Maintainer Notes

### Generating Messages

`gradle generateMessages`

Refactor getSource() to getSourceAsStringBuilder()

### Publish
##### To maven local:

`gradle compositeTask -PtaskName=publishToMavenLocal  -PcompositeSearchHeight=0 -PpublishMode=STABLE`

##### To Bintray:

`gradle publishAll -PcompositeSearchHeight=0 -PpublishMode=STABLE`
