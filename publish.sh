#!/bin/bash

# Simple script to publish all repos to bintray or local

SCRIPT=`realpath -s "$0"`
DIR=`dirname "$SCRIPT"`

if [ "$#" -eq 1 ]; then

    URL="$1"

    # Avoid daemon error
    gradle --stop

    # All dependencies are published locally to avoid not found errors 

    cd "$DIR/ros2-msg-to-idl-generator"
    gradle publish -PpublishUrl=local  || exit -1
    gradle publish -PpublishUrl="$URL"  || exit -1

    cd "$DIR/ros2-msg-to-pubsub-generator"
    gradle publish -PpublishUrl=local  || exit -1
    gradle publish -PpublishUrl="$URL" || exit -1

    cd "$DIR/ros2-common-interfaces"
    # Daemon runs out of memory here
    gradle generateMessages --no-daemon || exit -1
    gradle publish -PpublishUrl=local  || exit -1
    gradle publish -PpublishUrl="$URL" || exit -1

    cd "$DIR/ihmc-ros2-library"
    gradle publish -PpublishUrl="$URL" || exit -1


else


    echo "Usage: publish.sh [target]"
    echo "Valid targets include 'local', 'ihmcRelease'"
    
    exit -1
    
fi
