plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "7.5"
   id("us.ihmc.ihmc-cd") version "1.22"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   configurePublications()
}

mainDependencies {
   api("us.ihmc:ihmc-pub-sub:0.16.2")
   api("us.ihmc:ihmc-realtime:1.4.0")
   api("us.ihmc:ihmc-commons:0.30.5")
}

testDependencies {
   api("us.ihmc:ihmc-commons-test:0.30.5")
   api("us.ihmc:ros2-common-interfaces:source")
   api("us.ihmc:ros2-msg-to-pubsub-generator-test:source")
   api("com.google.guava:guava:18.0")
}
