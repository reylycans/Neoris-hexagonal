FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD "./target/neoris-0.0.1-SNAPSHOT.jar" "app.jar"
ENTRYPOINT ["java","-jar","app.jar"]