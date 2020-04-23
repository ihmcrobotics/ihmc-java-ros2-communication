# Making a release

This project is a group of project and contains a Gradle plugin. It requires various levels of attention and care
dependending on what changes are included in the upgrade.

#### Step 1: Update ihmc-pub-sub dependencies

1. Check for the latest version here: https://bintray.com/ihmcrobotics/maven-release/ihmc-pub-sub
   or here: https://github.com/ihmcrobotics/ihmc-pub-sub
1. Run "Find and replace" for ihmc-pub-sub, ihmc-pub-sub-generator and update the versions
1. Refresh Gradle

#### Step 2: Generate messages

###### Call `generateMessages`

```
> cd ihmc-java-ros2-communication/ros2-common-interfaces
> gradle generateMessages
```

###### Generate test IDLs

If there are no changes to the .msg to .idl parser, you can ignore this step.

Run `TestGenerateMSGToIDL`, 
located in `ros2-msg-to-idl-generator/src/test/java` 
with `ihmc-java-ros2-communication/ros2-msg-to-idl-generator` set as the working directory.

Note: This currently doesn't convert the generated files to Unix line endings

###### Generate test messages

If there are no changes to the .msg to .idl parser, you can ignore this step.

Run `us.ihmc.TestGenerateMSGToPubSub`, 
located in `ros2-msg-to-pubsub-generator/src/test/java` 
with `ihmc-java-ros2-communication/ros2-msg-to-pubsub-generator/src/test` set as the working directory.

Make sure the generated files have LF (Unix) line separators.

> Note: In IntelliJ, you may need to build with Eclipse compiler and use "Build, no error check".

#### Step 3: Ensure tests are passing

Wait for Bamboo or run the tests manually as follows.

```
> cd /path/to/ihmc-java-ros2-communication
> gradle compositeTask -PtaskName=test --info
```
Visit these urls to view test results:

```
file:///path/to/ihmc-java-ros2-communication/ihmc-ros2-library/src/test/build/reports/tests/test/index.html
file:///path/to/ihmc-java-ros2-communication/ros2-msg-to-pubsub-generator/src/test/build/reports/tests/test/index.html
```

#### Step 4: Publish artifacts

Bump version number in `ihmc-java-ros2-communication/group.gradle.properties`

Update the README.md to document any changed procedures, new features, etc.

Publish artifacts to Bintray: `gradle compositePublish -PpublishUrl=ihmcRelease` from `ihmc-java-ros2-communication/`

Go to [https://bintray.com/ihmcrobotics/maven-release](https://bintray.com/ihmcrobotics/maven-release) and "Publish".

#### Step 5: Update generator version

1. Update the version of `ros2-msg-to-pubsub-generator` plugin in `ihmc-java-ros2-communication/ros2-common-interfaces/build.gradle`.
1. Commit and push with message `:bookmark: X.X.X` and tag `X.X.X`
1. It will take several minutes before the newly published jars are available for Gradle to download such that it will take a moment before Gradle is able to assemble `ros2-common-interfaces`.

#### Step 6: (Optional) Draft and publish release on GitHub

1. Go to [https://github.com/ihmcrobotics/ihmc-java-ros2-communication/releases](https://github.com/ihmcrobotics/ihmc-java-ros2-communication/releases)
1. Click "Draft a new release"
1. Enter version X.X.X as the tag name
1. Title the release "X.X.X Release Notes"
1. Document all features, API changes, regressions, bug fixes, etc.
1. Tick the "This is a pre-release" box
1. Click "Publish release"
