# Use ubuntu as base image for build stage
FROM ubuntu:latest AS build

# Update packages and install OpenJDK 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean

# Set the working directory in the container
WORKDIR /app

# Copy only necessary files for Gradle build
COPY build.gradle.old settings.gradle gradlew /app/
COPY gradle /app/gradle
COPY src /app/src

# Copy the .env file
COPY .env /app

# Build the application
RUN ./gradlew bootJar --no-daemon

# Use openjdk as base image for runtime stage
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Expose the port that your Spring Boot application uses
EXPOSE 8080

# Copy the built JAR file from the build stage to the runtime image
COPY --from=build /app/build/libs/coolMusic-1.jar /app/app.jar

# Command to run your Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]