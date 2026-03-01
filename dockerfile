# Use official Maven image with JDK 21
FROM maven:3.9.6-eclipse-temurin-21

# Set working directory inside container
WORKDIR /app

# Copy project files
COPY . .

# Run tests
CMD ["mvn", "clean", "test"]