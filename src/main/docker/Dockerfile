FROM openjdk:8-jdk-alpine
WORKDIR /opt/project
ADD *.war app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/project/app.war"]
EXPOSE 8081 5701/udp

