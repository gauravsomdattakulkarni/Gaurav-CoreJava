# Use OpenJDK as the base image
FROM openjdk:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host machine to the container
COPY target/rest-demo.jar app.jar

# Expose the application port (e.g., 8080 for Spring Boot)
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
