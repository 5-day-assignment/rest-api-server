#
# docker build -t user-management-java-server .
# docker run -p 8080:8080 user-management-java-server
#
FROM openjdk:22-jdk-slim
WORKDIR /usr/src/app
COPY ./target/rest-api-server-0.0.1-SNAPSHOT.jar /usr/src/app/rest-api-server.jar
ENTRYPOINT ["java", "-jar", "rest-api-server.jar"]
