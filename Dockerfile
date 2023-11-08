# Use a smaller Maven image as the build stage
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the POM file and build dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the project source code
COPY src src/

# Build the JAR file
RUN mvn package

# Create the final image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Expose the port your application will run on
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/todocrud-0.0.1-SNAPSHOT.jar app.jar

# Command to run your application
CMD ["java", "-jar", "app.jar"]