# FinTrack API 🚀
Fintech REST API for personal portfolio management and investment tracking.

## Tech Stack
* **Java 21** (Amazon Corretto)
* **Spring Boot 3.4.2**
* **Spring Data JPA**
* **PostgreSQL**
* **Docker & Docker Compose (Containerization)**
* **SpringDoc OpenAPI (Swagger UI)**
* **Lombok & Jakarta Validation**

## Features (In Progress)
* **User Management**: Create and manage user profiles.
* **Asset Tracking**: Add, delete, and list assets per user.
* **Portfolio Summary**: Real-time summary of user investments.
* **Global Exception Handling**: Standardized API error responses.

## Getting Started
### Prerequisites
* **Docker Desktop** (Recommended)
* JDK 21
* Maven
* PostgreSQL instance

### Running the application
#### Option 1: Using Docker (Fastest) 🐳
1. Clone the repository.
2. Ensure Docker Desktop is running.
3. Run the following command in the root folder:
   ```bash
   docker-compose up --build
   
#### Option 2: Manual Setup
1. Clone the repository.
2. Update `application.properties` with your database credentials.
3. Run `./mvnw spring-boot:run`

### API Documentation
Once the app is running, you can access the Swagger UI at:
`http://localhost:8080/swagger-ui/index.html`