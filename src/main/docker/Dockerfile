FROM openjdk:8-jdk-alpine
VOLUME /usr
ADD *.war app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/app.war"]
EXPOSE 8081 5701/udp

