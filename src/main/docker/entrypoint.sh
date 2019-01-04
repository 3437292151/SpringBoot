#!/bin/sh

exec java -Djava.security.egd=file:/dev/./urandom -jar "${HOME}/app.war" "$@"
