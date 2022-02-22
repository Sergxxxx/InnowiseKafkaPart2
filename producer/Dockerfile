FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} producer.jar
ENTRYPOINT ["java","-jar","producer.jar"]