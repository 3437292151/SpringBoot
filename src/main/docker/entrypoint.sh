#!/bin/sh

exec java -Djava.security.egd=file:/dev/./urandom -jar "${PROJECT_HOME}/app.war" "$@"
