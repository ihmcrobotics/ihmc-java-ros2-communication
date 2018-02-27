# ROS2 to IDL message generator package

This package provides the ROS2 IDL typesupport, backported to Python 2.7. A jar file with included Jython runtime will be built by Java.

This is used by the rosidl-typesupport-ihmc-pubsub-java library to provide a .msg to Java class compiler. 

This project uses Maven instead of Gradle, because the Maven Jython plugin (http://mavenjython.sf.net/compile) is used to package the Python scripts.  

## Installation

### Local installation
```
mvn install
```

### Bintray upload


1) Add the bintray server to your [user.home]/.m2/settings.xml. The file should look something like this, replace YOUR_USERNAME with your bintray username and YOUR_BINTRAY_KEY with your bintray key.

```
    <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                            https://maven.apache.org/xsd/settings-1.0.0.xsd">
        <servers>
            <server>
                <id>bintray-ihmcrobotics-release</id>
                <username>[YOUR_USERNAME]</username>
                <password>[YOUR_BINTRAY_KEY]</password>
            </server>
        </servers>
    </settings>
```

2) Call mvn deploy in this project

```
mvn source:jar deploy
```

