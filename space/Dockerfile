FROM openjdk:17-ea-11-jdk-slim
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} space.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod","-jar", "space.jar"]