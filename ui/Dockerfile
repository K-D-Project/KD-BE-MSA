FROM openjdk:17-ea-11-jdk-slim
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ui.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod","-jar", "ui.jar"]