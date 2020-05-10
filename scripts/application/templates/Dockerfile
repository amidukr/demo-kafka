FROM openjdk:14-jdk-alpine
ARG JAR_FILE=./*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT java $JAVA_OPTS -jar /app.jar

