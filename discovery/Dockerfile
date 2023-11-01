FROM openjdk:17-ea-11-jdk-slim
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} discovery.jar
ENTRYPOINT ["java", "-jar", "discovery.jar"]