# User Service - Multi-Ticket Booking Application

## Overview

The **User Service** is a microservice in the multi-ticket booking platform. It manages all user-related functions like registration, login, profile access, and profile updates. Built with **Spring Boot**, it uses **MariaDB** for persistent storage and registers itself with an **Eureka server** for service discovery in a microservices architecture.

---

## Features

- **User Registration:** Create a new user with validations for unique phone, user ID, and email.
- **Login:** Authenticate with user ID and password, returning clear success/failure responses.
- **Profile Fetching:** Get user details by user ID.
- **Profile Update:** Update user profile fields, ensuring new values remain unique where required.
- **RESTful API:** JSON request and response format.
- **Logging & Monitoring:** Uses SLF4J for operation logs, Micrometer for endpoint timing.
- **Eureka Integration:** Registers and operates as a discoverable service.
- **Thorough Testing:** Business logic is covered by JUnit and Mockito-based unit tests.

---

## Technology Stack

| Component         | Details                                    |
|-------------------|--------------------------------------------|
| Framework         | Spring Boot                                |
| Database          | MariaDB (via Spring Data JPA/Hibernate)    |
| Service Discovery | Netflix Eureka                             |
| Logging           | SLF4J / log4j2                             |
| Monitoring        | Micrometer                                 |
| API Style         | RESTful (JSON)                             |
| Unit Testing      | JUnit 5, Mockito                           |

---

## Configuration

Main settings in `application.yml`:

- **Port:** 8080
- **Database:** Connects to MariaDB instance on AWS RDS
- **JPA:** Schema auto-update enabled
- **Eureka:** Registers with discovery server
- **Logging:** File output at `logs/userservice.log`
- **Management Endpoints:** All exposed for monitoring

---

## Data Models

### UserEntity

- `uId` (int): Internal primary key
- `userId` (String): Unique login/user handle
- `userFirstName`, `userLastName` (String): Names
- `phone` (String): Unique phone number
- `email` (String): Unique email
- `country`, `state`, `district` (String): Location info
- `pwd` (String): User password (plain text; should encrypt for production)

### UserEntityDto

A data transfer object mirroring UserEntity for API and service-layer communication.

---

## REST API Endpoints

| HTTP   | Endpoint              | Description                     | Request Body      | Response                    |
|--------|-----------------------|---------------------------------|-------------------|-----------------------------|
| POST   | `/user/add`           | Register a new user             | UserEntityDto     | Status JSON                 |
| POST   | `/user/login`         | User login (ID + pwd)           | UserEntityDto     | Status JSON                 |
| GET    | `/user/logout`        | Simulated logout                | -                 | Status JSON                 |
| GET    | `/user/details/{id}`  | Fetch details by userId         | -                 | User details or status JSON |
| PUT    | `/user/update/{id}`   | Update user (partial allowed)   | UserEntityDto     | Status JSON                 |

---

## Business Logic Details

- **Registration:** Requires unique phone, user ID, and email. All fields except location must be present. Returns a status JSON indicating completion or error.
- **Login:** Validates existence of user ID and password match. Returns clear status or error.
- **Profile Fetching:** Looks up user by user ID. Returns details or not-found status.
- **Profile Update:** Accepts partial data (non-null fields updated). Checks for uniqueness before applying changes.
- **Error Handling:** Returns specific status messages for all rejections, including duplicate values or missing fields.

---

## Testing

- **Unit Tests:** Written using JUnit 5 and Mockito (see `UserServiceTest.java`[^1]), covering:
  - User details retrieval (existence/non-existence)
  - Login (success/failure, wrong password)
  - User registration (duplicate checks, fields missing)
  - Profile updates (partial/full, duplicate value rejection)

- **Integration Test:** App context load is smoke-tested (`UserServiceApplicationTests.java`[^2]).

---

## Running the Service

**Prerequisites:**

- Java 11+
- MariaDB instance running (use values as in `application.yml`[^4])
- Eureka server (default expected at `http://localhost:8761/eureka/`)

**Steps:**

1. Clone the repository.
2. Update `application.yml` if your database/Eureka details differ.
3. Build the project:
```

mvn clean install

```
4. Start the application:
```

mvn spring-boot:run

```
5. Service will be available at `http://localhost:8080/` by default and show up in Eureka.

---

## File Structure Highlights

| File/Class                | Purpose                                   |
|---------------------------|-------------------------------------------|
| UserEntity & UserEntityDto| Data persistence & transfer models       |
| UserRepository            | JPA interface for DB operations          |
| UserService               | Business logic, validation, workflows    |
| UserController            | REST endpoint definitions                |
| UserServiceTest           | Unit tests for service                   |
| application.yml           | Central configuration (port, DB, Eureka) |
| log4j2.xml                | Logging configuration                    |
| pom.xml                   | Dependency management                    |

---

## Notes

- **Passwords:** Currently stored as plain text; add encryption before production.
- **Authentication:** No JWT/session, "logout" is mock only.
- **Error Messaging:** All API errors and rejections are returned as clear status JSON.
- **Microservices:** This module is designed to slot into a larger distributed ecosystem.

---

## Contact

For further info or help with integration, raise an issue in the repo or contact the maintainer.

```

<div style="text-align: center">⁂</div>

[^1]: UserServiceTest.java

[^2]: UserServiceApplicationTests.java

[^3]: application.yml

[^4]: log4j2.xml

[^5]: UserServiceApplication.java

[^6]: UserService.java

[^7]: UserRepository.java

[^8]: UserEntity.java

[^9]: UserEntityDto.java

[^10]: UserController.java

[^11]: pom.xml

