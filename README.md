# A 5 day assignment

## Assignment

- [X] Use Java to write a **User Management** REST API Server. Basic CRUD: `GET/POST "/users"`, `GET/PUT/DELETE "/users/{id}"`. `User` model properties: `username`, `password`, `givenName`, `familyName`, `address`.
- [ ] Use Python to wrote a Web Client, that will consume REST API Server: `findAllUsers`, `createNewUser`, `findUserById`, `updateUserById`, `deleteUserById`.
- [ ] Create a Docker image for the REST API Server.
- [ ] Rethink the best way for sending passwords.
- [ ] Use OpenAPI Specification to create the server and the clients.
- [ ] Link OAS (Swagger) UI on server for quick API testing.
- [ ] Use PostgreSQL for User Management database.
- [ ] Create a Docker image for each remaining project.
- [ ] Create a basic Flutter mobile app with only a `login` and `welcome` views, the latter displaying the user's full name.

## Projects

- [REST API Server][rest-api-server-docs] - Java 22, Spring Boot 3.2.4
- [Web Client][web-client-docs] - Python 3.12.2
- [Mobile Client][mobile-client-docs] - Flutter

[rest-api-server-docs]: #getting-started "Scroll down to getting started"
[web-client-docs]: #todo "Go to Web Client repository"
[mobile-client-docs]: #todo "Go to Mobile Client repository"

## TODO

## Getting Started

```shell
git clone ...
mvn clean install
mvn spring-boot:run
```
