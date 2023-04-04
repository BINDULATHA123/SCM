 #Build stage
FROM maven:3.8-jdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn package

# Run stage
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/Scmlite_Producer-0.0.1-SNAPSHOT.jar /app/producer.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/producer.jar"]