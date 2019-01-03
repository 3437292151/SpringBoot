FROM openjdk:8-jdk-alpine
ADD *.war app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]
EXPOSE 8080 5701/udp

