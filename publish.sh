#!/bin/bash

SCRIPT=`realpath -s "$0"`
DIR=`dirname "$SCRIPT"`

if [ "$#" -eq 1 ]; then

    URL="$1"

    cd "$DIR/ros2-msg-to-idl-generator"
    gradle publish -PpublishUrl="$URL" || exit -1

    cd "$DIR/ros2-msg-to-pubsub-generator"
    gradle publish -PpublishUrl="$URL" || exit -1

    cd "$DIR/ros2-common-interfaces"
    gradle generateMessages || exit -1
    gradle publish -PpublishUrl="$URL" || exit -1

    cd "$DIR/ihmc-ros2-library"
    gradle publish -PpublishUrl="$URL" || exit -1

    
elif [ "$#" -eq 3 ]; then
    URL="$1"
    USER="$2"
    PASS="$3"
    
    echo "Publishing to $USER:$PASS@$URL"

    cd "$DIR/ros2-msg-to-idl-generator"
    
    echo gradle publish -PpublishUrl="$URL/ros2-msg-to-idl-generator" -PpublishUsername="$USER" -PpublishPassword="$PASS"
    gradle publish -PpublishUrl="$URL/ros2-msg-to-idl-generator" -PpublishUsername="$USER" -PpublishPassword="$PASS" || exit -1

    cd "$DIR/ros2-msg-to-pubsub-generator"
    gradle publish -PpublishUrl="$URL/ros2-msg-to-pubsub-generator" -PpublishUsername="$USER" -PpublishPassword="$PASS" || exit -1

    cd "$DIR/ros2-common-interfaces"
    gradle generateMessages || exit -1
    gradle publish -PpublishUrl="$URL/ros2-common-interface" -PpublishUsername="$USER" -PpublishPassword="$PASS" || exit -1

    cd "$DIR/ihmc-ros2-library"
    gradle publish -PpublishUrl="$URL/ihmc-ros2-library" -PpublishUsername="$USER" -PpublishPassword="$PASS" || exit -1

else


    echo "Usage: publish.sh [target]"
    echo "Valid targets include 'local', 'ihmcRelease'"
    
    echo " -- OR --"
    echo "Usage: publish.sh [publishURL] [username] [password]"
    
    exit -1
    
fi
