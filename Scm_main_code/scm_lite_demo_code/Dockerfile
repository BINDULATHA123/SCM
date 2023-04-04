# Build Stage
# Setup Base and Environment

FROM openjdk:8-jdk-alpine as build
RUN apk add maven
COPY . .

RUN mvn clean install -q

# Prod Stage
FROM openjdk:8-jdk-alpine as prod
WORKDIR /app
COPY --from=build /target /app/target
# COPY --from=build /src/main/resources/application.properties /app/application.properties

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/target/ScmliteDemoCodeProject-0.0.1-SNAPSHOT.jar"]
