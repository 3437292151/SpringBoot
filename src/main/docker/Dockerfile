FROM openjdk:8-jdk-alpine
WORKDIR /opt/project
ADD entrypoint.sh entrypoint.sh
ADD *.war app.war
ENTRYPOINT ["./entrypoint.sh"]
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","@{HOME}/app.war","$@"]
EXPOSE 8081 5701/udp

