plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "7.6"
   id("us.ihmc.ihmc-cd") version "1.23"
}

ihmc {
   loadProductProperties("../group.gradle.properties")
   repository("https://artifacts.halodi.com/repository/maven-open-source-group")

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
   api("us.ihmc:ihmc-pub-sub-generator:0.16.2")
   api("us.ihmc:ros2-msg-to-idl-generator:source")
}

testDependencies {
   api("us.ihmc:ihmc-pub-sub:0.18.0-halodi7")
   api("us.ihmc:ihmc-commons:0.30.6")
}

// Gradle 7 forces us to do this I guess...
// https://github.com/gradle/gradle/issues/17236
ihmc.sourceSetProject("test").tasks.named("processResources", Copy::class.java) {
   duplicatesStrategy = DuplicatesStrategy.INCLUDE
}
