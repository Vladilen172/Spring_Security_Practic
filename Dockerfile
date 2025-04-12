FROM openjdk:23-ea-slim
COPY . /app
WORKDIR /app
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/social_network-0.0.1-SNAPSHOT.jar"]
