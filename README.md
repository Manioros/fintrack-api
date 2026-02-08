# FinTrack API 🚀
Fintech REST API for personal portfolio management and investment tracking.

## Tech Stack
* **Java 21** (Amazon Corretto)
* **Spring Boot 3.4.2**
* **Spring Data JPA**
* **PostgreSQL**
* **SpringDoc OpenAPI (Swagger UI)**
* **Lombok & Jakarta Validation**

## Features (In Progress)
* **User Management**: Create and manage user profiles.
* **Asset Tracking**: Add, delete, and list assets per user.
* **Portfolio Summary**: Real-time summary of user investments.
* **Global Exception Handling**: Standardized API error responses.

## Getting Started
### Prerequisites
* JDK 21
* Maven
* PostgreSQL instance

### Running the application
1. Clone the repository.
2. Update `application.properties` with your database credentials.
3. Run `./mvnw spring-boot:run`

### API Documentation
Once the app is running, you can access the Swagger UI at:
`http://localhost:8080/swagger-ui/index.html`