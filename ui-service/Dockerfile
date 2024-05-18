FROM openjdk:17-alpine
EXPOSE 8088
ARG JAR_FILE=target/ui-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar", "/app.jar"]