FROM openjdk:8-jdk-alpine
# Add a jhipster user to run our application so that it doesn't need to run as root
RUN adduser -D -s /bin/sh jhipster
WORKDIR /opt/project
ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown jhipster:jhipster entrypoint.sh

ADD *.war app.war
ENTRYPOINT ["./entrypoint.sh"]
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","@{HOME}/app.war","$@"]
EXPOSE 8081 5701/udp

