FROM openjdk:17-ea-11-jdk-sli
# 활성 프로필 설정
ENV SPRING_PROFILES_ACTIVE=prod
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ui.jar
ENTRYPOINT ["java", "-jar", "ui.jar"]