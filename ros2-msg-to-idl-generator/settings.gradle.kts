buildscript {
   repositories {
      maven { url = uri("https://plugins.gradle.org/m2/") }
      mavenLocal()
   }
   dependencies {
      classpath("us.ihmc:ihmc-build:0.22.0")
   }
}

val ihmcSettingsConfigurator = us.ihmc.build.IHMCSettingsConfigurator(settings, logger, extra)
ihmcSettingsConfigurator.checkRequiredPropertiesAreSet()
ihmcSettingsConfigurator.configureExtraSourceSets()
ihmcSettingsConfigurator.findAndIncludeCompositeBuilds()
