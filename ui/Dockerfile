FROM openjdk:17-ea-11-jdk-sli
ENV DSPRING_PROFILES_ACTIVE=prod
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ui.jar
ENTRYPOINT ["java", "-jar", "ui.jar"]