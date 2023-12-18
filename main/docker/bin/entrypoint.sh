#!/bin/sh

echo current date:
date

echo JAVA_OPTS=$JAVA_OPTS

java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -cp /app.jar org.springframework.boot.loader.PropertiesLauncher
