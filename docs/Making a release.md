# Making a release

#### Step 1: Update ihmc-pub-sub dependencies

1. Check for the latest version here: https://github.com/ihmcrobotics/ihmc-pub-sub/releases
1. Run "Find and replace" for ihmc-pub-sub, ihmc-pub-sub-generator and update the versions
1. Refresh Gradle

#### Step 2: Generate messages

###### Call `generateMessages`

```
> cd ihmc-java-ros2-communication/ros2-common-interfaces
> gradle generateMessages
```

###### Generate ros2-common-interfaces

Run `us.ihmc.idl.Ros2CommonInterfacesGenerateMessages`, 
located in `ros2-common-interfaces/src/generator/java` 
with `ihmc-java-ros2-communication/ros2-common-interfaces` set as the working directory.

In `ihmc-java-ros2-communication\ros2-common-interfaces\src\main\generated-java\sensor_msgs\msg\dds\TimeReference.java`, line 87, 
refactor `getSource()` to `getSourceAsStringBuilder()` (do not refactor the base method in `us.ihmc.communication.packets.Packet`).

###### Generate test IDLs

If there are no changes to the .msg to .idl parser, you can ignore this step.

Run `TestGenerateMSGToIDL`, 
located in `ros2-msg-to-idl-generator/src/test/java` 
with `ihmc-java-ros2-communication/ros2-msg-to-idl-generator` set as the working directory.

###### Generate test messages

If there are no changes to the .msg to .idl parser, you can ignore this step.

Run `us.ihmc.TestGenerateMSGToPubSub`, 
located in `ros2-msg-to-pubsub-generator/src/test/java` 
with `ihmc-java-ros2-communication/ros2-msg-to-pubsub-generator/src/test` set as the working directory.

Make sure the generated files have LF (Unix) line separators.

> Note: In IntelliJ, you may need to build with Eclipse compiler and use "Build, no error check".

#### Step 3: Run tests

```
> cd /path/to/ihmc-java-ros2-communication
> gradle compositeTask -PtaskName=test --info
```
Visit these urls to view test results:

```
file:///path/to/ihmc-java-ros2-communication/ihmc-ros2-library/src/test/build/reports/tests/test/index.html
file:///path/to/ihmc-java-ros2-communication/ros2-msg-to-pubsub-generator/src/test/build/reports/tests/test/index.html
```

#### Step 4: Start git flow release

First, perform a git-flow release. Optionally, use you Git GUI program to do this.

```
> git flow release start X.X.X
```

You now be on a branch called `release/X.X.X`.

Run a "Find and replace" on all files (not just *.gradle) in the repo to replace the old version with new version. Make sure to search over all files, not just *.gradle.

Update the README.md to document any changed procedures, new features, etc.

#### Step 5: Publish artifacts

Publish artifacts to Bintray.

`gradle publishAll -PpublishUrl=ihmcRelease`

Go to [https://bintray.com/ihmcrobotics/maven-release](https://bintray.com/ihmcrobotics/maven-release) and "Publish".

#### Step 6: Update generator version

Update the version of `ros2-msg-to-pubsub-generator` plugin in `ihmc-java-ros2-communication/ros2-common-interfaces`.

#### Step 7: Finish git flow release

Perform a git-flow finish release.

```
> git flow release finish X.X.X
```

#### Step 8: Draft and publish release on GitHub

1. Go to [https://github.com/ihmcrobotics/ihmc-java-ros2-communication/releases](https://github.com/ihmcrobotics/ihmc-java-ros2-communication/releases)
1. Click "Draft a new release"
1. Enter version X.X.X as the tag name
1. Title the release "X.X.X Release Notes"
1. Document all features, API changes, regressions, bug fixes, etc.
1. Tick the "This is a pre-release" box
1. Click "Publish release"