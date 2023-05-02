# Making a release

This project is a group of project and contains a Gradle plugin. It requires various levels of attention and care
depending on what changes are included in the upgrade.

#### Update ihmc-pub-sub dependencies

1. Check for the latest version here: https://repo.maven.apache.org/maven2/us/ihmc/ihmc-pub-sub/
1. Run "Find and replace" for ihmc-pub-sub, ihmc-pub-sub-generator and update the versions
1. Refresh Gradle


#### Publish local versions of the generators (if generators changed in pub sub)

Bump version number in `ihmc-java-ros2-communication/group.gradle.properties`

1.  `cd ros2-msg-to-idl-generator/`
1. `gradle publish`
1.  `cd ros2-msg-to-pubsub-generator/`
1. `gradle publish`

Set the plugin management to use Maven local in 
`ihmc-java-ros2-communication/ros2-common-interfaces/settings.gradle.kts`:

```
pluginManagement {
   repositories {
      mavenLocal()
      gradlePluginPortal()
   }
```

Then, update the version of `ros2-msg-to-pubsub-generator` plugin in `ihmc-java-ros2-communication/ros2-common-interfaces/build.gradle` to the local version you just published.

#### Generate messages

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

#### Ensure tests are passing

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

#### Publish artifacts

Bump version number in `ihmc-java-ros2-communication/group.gradle.properties` (if you didn't already)

Update the README.md to document any changed procedures, new features, etc.

Publish artifacts to Bintray: `gradle compositePublish -PpublishUrl=ihmcRelease` from `ihmc-java-ros2-communication/`

Check when they become available at [https://repo.maven.apache.org/maven2/us/ihmc/](https://repo.maven.apache.org/maven2/us/ihmc/).

#### Update generator version (if you didn't already)

1. It will take several minutes before the newly published jars are available for Gradle to download such that it will take a moment 
before Gradle is able to assemble `ros2-common-interfaces`.
1. Update the version of `ros2-msg-to-pubsub-generator` plugin in `ihmc-java-ros2-communication/ros2-common-interfaces/build.gradle`.

#### Bookmark

1. Commit and push with message `:bookmark: X.X.X` and tag `X.X.X`

#### (Optional) Document release on GitHub

1. Go to [https://github.com/ihmcrobotics/ihmc-java-ros2-communication/releases](https://github.com/ihmcrobotics/ihmc-java-ros2-communication/releases)
1. Click "Draft a new release"
1. Enter version X.X.X as the tag name
1. Title the release "X.X.X Release Notes"
1. Document all features, API changes, regressions, bug fixes, etc.
1. Tick the "This is a pre-release" box
1. Click "Publish release"
