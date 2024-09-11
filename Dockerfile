# Use the official OpenJDK as a parent image
FROM maven:latest as build

# Set the working directory in the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Package the application using Maven
RUN mvn clean package -DskipTests

# Use a base image with just the JRE to run the application
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port that the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]