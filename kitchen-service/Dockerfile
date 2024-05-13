FROM openjdk:17
EXPOSE 8082
ARG JAR_FILE=target/kitchen-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar", "/app.jar"]