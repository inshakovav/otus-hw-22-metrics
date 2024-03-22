FROM openjdk:11
#COPY target/demo-0.0.1-SNAPSHOT.jar /app/
COPY target/*.jar app.jar

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar", "/app.jar"]