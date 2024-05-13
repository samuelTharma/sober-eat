FROM openjdk:17-alpine
EXPOSE 8089
ARG JAR_FILE=target/order-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar", "/app.jar"]