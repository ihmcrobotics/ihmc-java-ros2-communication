plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "7.4"
   id("us.ihmc.ihmc-cd") version "1.20"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   javaDirectory("main", "java-generated")
   resourceDirectory("test", "generated-idl")
   resourceDirectory("test", "custom-idl")
   resourceDirectory("test", "generated-ros1")
   javaDirectory("test", "generated-java")
   resourceDirectory("test", "ros_msgs")
   configurePublications()
}

mainDependencies {
   api(dependencies.gradleApi())
   api("us.ihmc:ihmc-pub-sub-generator:0.15.0")
   api("us.ihmc:ros2-msg-to-idl-generator:source")
}

testDependencies {
   api("us.ihmc:ihmc-pub-sub:0.15.0")
   api("us.ihmc:ihmc-commons:0.30.4")
}
