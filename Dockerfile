# 1️⃣ Start from official OpenJDK 17 image
FROM eclipse-temurin:17-jdk-alpine

# 2️⃣ Set workdir inside container
WORKDIR /app

# 3️⃣ Copy the built JAR from target
# Make sure you run `mvn clean package` before building the image
COPY target/prompt-service-0.0.1.jar app.jar

# 4️⃣ Expose port your Spring Boot app runs on
EXPOSE 8080

# 5️⃣ Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]