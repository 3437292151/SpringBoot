FROM openjdk:8-jdk-alpine
ADD *.war /usr/app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/app.war"]
EXPOSE 8081 5701/udp

