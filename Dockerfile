# Use a base image with JDK
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/myapp-1.0.jar /app/myapp.jar

# Expose the port your app will run on
EXPOSE 8080

# Command to run your application
ENTRYPOINT ["java", "-jar", "myapp.jar"]
