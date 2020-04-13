plugins {
   id("us.ihmc.ihmc-build") version "0.20.1"
   id("us.ihmc.ihmc-ci") version "5.3"
   id("us.ihmc.ihmc-cd") version "1.8"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   configurePublications()
}

mainDependencies {
   api("us.ihmc:ihmc-pub-sub:0.12.0")
   api("us.ihmc:ihmc-realtime:1.3.0")
   api("us.ihmc:ihmc-commons:0.28.2")
}

testDependencies {
   api("us.ihmc:ros2-common-interfaces:$version")
   api("us.ihmc:ros2-msg-to-pubsub-generator-test:$version")
}
