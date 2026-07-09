FROM eclipse-temurin:21.0.11_10-jdk-noble
WORKDIR /app/
COPY target/*.jar app.jar
EXPOSE 8761
CMD java -jar app.jar