# Multi-Ticket Booking Application – Project Overview

This project is a comprehensive **multi-service ticket booking platform** enabling booking and management of Tickets for different modes—Bus, Train, Hotel, and more—built as a distributed microservices ecosystem. Each major capability is implemented as a dedicated microservice, adhering to a modular, scalable, and cloud-friendly architecture.

## System Architecture

- **Microservices**: Independent Spring Boot services for each business domain (User, Bus, Train, Hotel, Order).
- **Service Discovery**: Netflix Eureka server used for dynamic discovery and routing of services.
- **API Gateway**: Centralized entry point providing a unified API, routing requests to underlying microservices.
- **Data Storage**: Each service manages its own database schema (commonly MariaDB via Spring Data JPA/Hibernate).
- **Observability**: Logging (log4j2/SLF4J), health and metrics (Micrometer), and central log access patterns built in.
- **Testing**: Extensive use of JUnit, Mockito for unit and integration testing across all services.


## Services Overview

| Service | Purpose | Technology Stack |
| :-- | :-- | :-- |
| User Service | Manages users (registration, auth, profile, uniqueness) | Spring Boot, MariaDB, Eureka, SLF4J, Micrometer |
| Bus Service | Handles bus-related catalog, seat management, search, and booking | Spring Boot, MariaDB, Eureka |
| Train Service | Manages train catalog, schedules, seat logistics, and booking | Spring Boot, MariaDB, Eureka |
| Hotel Service | Books hotels, handles room availability, and manages hotel partner inventory | Spring Boot, MariaDB, Eureka |
| Order Service | Co-ordinates multi-modal bookings, payments, order status, transaction history | Spring Boot, MariaDB, Eureka |
| Gateway API | Aggregates all microservice endpoints and applies API security/routing policies | Spring Cloud Gateway, Eureka |
| Service Registry | Microservices discovery and registration for load balancing/failover | Spring Cloud Netflix Eureka |

## Key Features (by Service)

### User Service

- **Registration \& Auth**: Secure sign-up with uniqueness checks (phone/email/userId).
- **Profile Management**: Supports updates and partial updates, uniqueness revalidated.
- **REST API**: All endpoints JSON-encoded; errors returned consistently; extensive unit/integration tests.
- **Observation**: Logs all actions, exposes metrics, integrates with Eureka for discovery.


### Bus/Train/Hotel Service

- **Catalog Management**: CRUD APIs for buses/trains/hotels, including schedules, seat/room details.
- **Booking Workflow**: Manages seat/room availability, processes reservations with transaction safety.
- **Search**: Endpoints for discovering available buses/trains/hotels for a given location/date/query.


### Order Service

- **Order Orchestration**: Coordinates booking requests across transportation/hotel services.
- **Transaction Management**: Ensures atomicity/rollback for multi-step bookings.
- **Booking History**: Central source for a user's booking records and order statuses.


### Gateway API

- **Unified Access**: Routes external API requests to relevant microservices.
- **Security/Policies**: Centralizes authentication, rate-limiting, CORS, and API documentation.


### Service Registry (Eureka)

- **Discovery**: Microservices register/deregister for fault tolerance and horizontal scaling.
- **Load Balancing**: Dynamically routes requests across multiple instances.


## Core Technologies

- Spring Boot, Spring Data JPA, Spring Cloud Netflix (Eureka, Gateway)
- MariaDB (databases for each service)
- Logging: SLF4J/log4j2
- Monitoring: Micrometer
- Build: Maven
- Testing: JUnit 5, Mockito
- REST API: JSON over HTTP


## Running the Project

**Requirements:**

- Java 11+, Maven, MariaDB instances, Eureka server.

**Steps:**

1. Clone this repository.
2. Set up (or use provided) MariaDB and Eureka server. Update `application.yml` files in each service as needed.
3. Build all services:

```
mvn clean install
```

4. Start each service:

```
mvn spring-boot:run
```

5. Service endpoints default to standard ports (e.g., 8080+) and register with Eureka at `http://localhost:8761/eureka/`.
6. Use an API gateway as the single entry-point for all requests.

## Notable Project Characteristics

- **Microservice First:** Each domain is autonomous—can be developed, tested, and deployed independently.
- **Observability:** Extensive logging and monitoring for easy troubleshooting.
- **Error Handling:** Consistent JSON error/status responses throughout all services.
- **Security:** While base code demonstrates plain-text password storage, it is noted as a **must-fix** before production (enable password encryption).
- **Extensibility:** Designed so new service types (e.g., Flight, Cab) can be plugged in with minimal changes to core architecture.


## Contribution

Raise GitHub issues for integration help, bug reports, or feature requests. Contributors are welcome!

## Contact

Refer to service-level READMEs or raise a GitHub issue for contact with the project maintainer.