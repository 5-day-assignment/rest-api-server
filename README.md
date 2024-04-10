# A 5 day assignment: User Management

- [X] Use Java to write a **User Management** REST API Server. Basic CRUD: `GET/POST "/users"`, `GET/PUT/DELETE "/users/{id}"`. `User` model properties: `username`, `password`, `givenName`, `familyName`, `address`.
- [X] Use Python to write a Web Client that will consume REST API Server: `findAllUsers`, `createNewUser`, `findUserById`, `updateUserById`, `deleteUserById`.
- [X] Create a Docker image for the REST API Server.
- [ ] Rethink the best way for sending passwords.
- [X] Use OpenAPI Specification to create the server and the clients.
- [X] Link OAS (Swagger) UI on server for quick API testing.
- [ ] Use PostgreSQL for User Management database.
- [ ] Containerize all projects with Docker.
- [ ] Create a basic Flutter mobile app with only `login` and `welcome` views, the latter displaying the user's full name.

##### Links to all projects
- [REST API Server][rest-api-server] - Java 22, Spring Boot 3.2.4
- [Web Client][web-client] - Python 3.12.2
- [Mobile Client][mobile-client] - Flutter

[rest-api-server]: https://github.com/5-day-assignment/rest-api-server "Scroll down to getting started"
[web-client]: https://github.com/5-day-assignment/web-client "Go to Web Client repository"
[mobile-client]: https://github.com/5-day-assignment/mobile-client "Go to Mobile Client repository"

## Getting Started

In your preferred terminal `cd` into whatever folder you use for projects, then clone all three projects:
```shell
git clone https://github.com/5-day-assignment/rest-api-server.git
git clone https://github.com/5-day-assignment/web-client.git
git clone https://github.com/5-day-assignment/mobile-client.git
```

## Project: REST API Server

After starting the server, in [development](#development) or [docker](#docker) way, you can test the API in Postman using the [provided collection][postman-collection-file-link], or by visiting the [SwaggerUI URL][openapi-link].

*Note: Postman collection has pre- and post-scripts for the `POST /users` endpoint, so the last-created user's `id` is stored in variables for further processing, and so the `username` (which has a UNIQUE constraint in the database) is randomly generated, avoiding conflicts.*

[postman-collection-file-link]: ./user_management.postman_collection.json
[openapi-link]: http://localhost:8080/swagger-ui/index.html

### Development

```shell
cd rest-api-server
mvn spring-boot:run
```

If everything compiled successfully, the server is running at `http://localhost:8080`.

### Docker

Create the JAR file created in ` \target\ ` with
```shell
mvn clean package
```
And make sure its filename completely matches the on in the ` \Dockerfile `.

From root (` \ `) build the image and run the container with
```shell
docker build -t user-management-java-server .
docker run -p 8080:8080 user-management-java-server
```
