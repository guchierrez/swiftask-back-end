#
# Build stage
#
FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17
COPY --from=build /target/todocrud-1.0.0.jar todocrud.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","todocrud.jar"]