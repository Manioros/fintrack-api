# FinTrack API 📈

## Overview
**FinTrack** is a professional RESTful API designed for personal investment and portfolio management. The primary goal of this project is to provide a robust infrastructure for tracking various asset classes (Stocks, Cryptocurrencies, etc.), offering users a clear and accurate view of their investment distribution in real-time.

## Core Features
* **Asset Tracking**: Comprehensive management and monitoring of different investment types.
* **Scalable Architecture**: Implementation based on the 3-tier architecture pattern (Controller-Service-Repository) to ensure maintainability, testability, and professional standards.
* **Data Integrity**: Powered by PostgreSQL to provide secure and reliable storage for financial data.
* **Request Validation**: Strict server-side validation using Jakarta Constraints to prevent malformed data (e.g., negative balances or empty names).
* **Global Exception Handling**: Centralized error management using `@ControllerAdvice` to provide consistent and secure JSON error responses.

## Tech Stack
* **Backend**: Java 25, Spring Boot 3
* **Persistence**: Spring Data JPA, Hibernate
* **Validation**: Jakarta Bean Validation
* **Database**: PostgreSQL
* **Tooling**: Lombok, Maven, IntelliJ IDEA