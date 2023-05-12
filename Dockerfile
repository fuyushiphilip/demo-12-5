#
# Build stage
#
FROM maven:3.9.1-eclipse-temurin-11-alpine AS build
COPY . .
RUN mvn clean package -DskipTests
RUN #mvn clean package -Dmaven.test.skip=true
#
# Package stage
#
FROM openjdk:17
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]