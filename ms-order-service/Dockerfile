# Start with a base image containing Java runtime (mine java 8)
FROM openjdk:8u212-jdk-slim
# Add the application's jar to the container
ADD target/ms-order-service-0.0.1-SNAPSHOT.jar ms-order-service.jar
# Run the jar file 
ENTRYPOINT ["java","-jar","ms-order-service.jar"]