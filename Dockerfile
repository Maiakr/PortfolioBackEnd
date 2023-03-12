FROM amazoncorretto:17-alpine-jdk
MAINTAINER MK
COPY target/mk-0.0.1-SNAPSHOT.jar mk-app.jar
ENTRYPOINT ["java","-jar","/mk-app.jar"]