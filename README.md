# Student Manager

A Java training project demonstrating two approaches to building a Student Management application.

## Project Versions

### 1. Spring Boot REST API (`main`)
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

### 2. Plain Java + JDBC (`task-1`)
- Java
- JDBC
- PostgreSQL

## REST API Endpoints

Base URL: `/api/students`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| POST | `/api/students` | Create a student |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |

## Database Configuration

The application connects to a PostgreSQL database named `training_db`.

## Running the Application

Run `StudentManagerApiApplication.java` from your IDE.

The API runs at:

`http://localhost:8080`

