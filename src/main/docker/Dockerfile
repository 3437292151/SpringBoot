FROM docker.cplh.com/apline_openjdk8_fonts:latest
ADD *.war app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]
EXPOSE 8080 5701/udp

