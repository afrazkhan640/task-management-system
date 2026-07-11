# 📝 Task Management System
A secure RESTful Task Management System built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **Hibernate (JPA)**, and **MySQL**.

## Overview
The Task Management System is a backend REST API that enables users to securely manage their daily tasks. The application follows a layered architecture and demonstrates industry-standard backend development practices including authentication, authorization, validation, exception handling, and database integration.

This project was developed to strengthen backend development concepts using the Spring ecosystem and to simulate a real-world RESTful application.

##Features
- User Registration & Login
- JWT-based Authentication & Authorization
- Secure REST APIs
- Task CRUD Operations
- Pagination & Sorting
- Bean Validation
- Global Exception Handling
- DTO-based Request & Response Handling
- Hibernate (JPA) with MySQL
- Layered Architecture (Controller → Service → Repository)

## 🛠️Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate (JPA)

### Database
- MySQL

### Authentication
- JWT (JSON Web Token)

### Build Tool
- Maven

### API Testing
- Postman

### IDE
- Eclipse IDE

## 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
│   ├── request
│   └── response
├── security
├── exception
├── mapper
├── enums
```

## 🔐 Authentication Flow
The application uses JWT (JSON Web Token) for secure authentication and authorization.

```text
Client
   │
   ▼
Register / Login
   │
   ▼
Spring Security
   │
   ▼
Authentication Manager
   │
   ▼
UserDetailsService
   │
   ▼
JWT Generated
   │
   ▼
Client stores Token
   │
   ▼
Authorization: Bearer <JWT>
   │
   ▼
JwtAuthenticationFilter
   │
   ▼
Protected REST APIs
```


## 📌 REST API Endpoints

### Authentication APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Authenticate user and generate JWT |

### Task APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/task` | Create a new task |
| GET | `/task` | Get all tasks (Paginated) |
| GET | `/task/{id}` | Get task by ID |
| PUT | `/task/{id}` | Update task |
| DELETE | `/task/{id}` | Delete task |

### Task Workflow APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| PATCH | `/task/start/{id}` | Change task status to **IN_PROGRESS** |
| PATCH | `/task/complete/{id}` | Change task status to **COMPLETED** |


## ▶️ How to Run
1. Clone the repository.
```bash
git clone https://github.com/afrazkhan640/task-management-system.git
```

2. Configure MySQL database in application.properties.

3. Create the required database.

4. Run the application using Maven or your preferred IDE.

5. Access the APIs using Postman or Swagger UI.

## 🚀 Future Enhancements
- Role-Based Authorization
- Docker Support
- Unit Testing
- AI-based Task Suggestions

## 👨‍💻 Author
**MD Afraz Khan**
- LinkedIn: https://www.linkedin.com/in/afraz-khan-9288a0325
- GitHub: https://github.com/afrazkhan640
