# FinTrack API 📈

**FinTrack** is a professional RESTful API designed for personal investment and portfolio management. Built with the latest Java ecosystem, it provides a robust infrastructure for tracking diverse asset classes (Stocks, Cryptocurrencies, etc.), offering users a real-time, calculated view of their investment distribution.

---

## 🚀 Core Features

* **Multi-User Asset Management**: Securely link investments to specific user profiles using a relational database model.
* **Portfolio Analytics**: Real-time calculation of total portfolio value and asset type distribution using **Java Streams**.
* **Global Exception Handling**: Centralized error management via `@ControllerAdvice` to provide consistent, professional JSON responses (400, 404, 500) and prevent internal data leakage.
* **Strict Validation**: Server-side data integrity enforced through **Jakarta Bean Validation** to prevent malformed data.
* **Scalable Architecture**: Clean 3-tier implementation (Controller-Service-Repository) ensuring high maintainability and testability.

## 🛠 Tech Stack

* **Language**: Java 25 (Bleeding edge)
* **Framework**: Spring Boot 4.0.1
* **Persistence**: Spring Data JPA / Hibernate
* **Database**: PostgreSQL
* **Tooling**: Lombok, Maven, Jakarta Validation

## 🏗 Database Architecture

The API utilizes a **One-to-Many** relationship between the `User` and `Asset` entities.

* **Bidirectional Mapping**: Managed via `@JsonManagedReference` and `@JsonBackReference` to ensure clean JSON serialization and prevent infinite recursion loops.
* **Data Integrity**: Unique constraints enforced at the database level to prevent duplicate tickers per user.



## 🚦 Getting Started

### Prerequisites
* **JDK 25**
* **Maven 3.9+**
* **PostgreSQL**

### Installation

1.  **Clone the repository**:
    ```bash
    git clone [https://github.com/your-username/fintrack-api.git](https://github.com/your-username/fintrack-api.git)
    ```

2.  **Configure the database**:
    Update `src/main/resources/application.properties` with your credentials:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/fintrack
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Run the application**:
    ```bash
    ./mvnw spring-boot:run
    ```

## 🔗 Key Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/users` | Create a new user profile |
| **POST** | `/api/users/{id}/assets` | Add an asset to a specific user |
| **GET** | `/api/users/{id}/assets/summary` | Get financial summary & distribution |