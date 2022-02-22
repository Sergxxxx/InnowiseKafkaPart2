FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} consumer.jar
ENTRYPOINT ["java","-jar","consumer.jar"]