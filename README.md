# Student Management System - Backend 

This is the core REST API for the Student & Course Management System, built with **Spring Boot 4+** and **Java 21**. The system is fully containerized and optimized for 2026 deployment standards.

---

## 🐳 Docker Setup (Recommended)

The backend is configured to run in a Dockerized environment. This is the fastest way to get the system up and running with all dependencies.

### 1. Build and Run with Docker Compose

If you have a `docker-compose.yml` file in the root directory, simply run:

docker-compose up --build

---

### 2. Manual Docker Build

To build only the backend image:

docker build -t student-backend .

---

## 🛠 Local Development (Without Docker)

### 1. Prerequisites

- Java JDK 17 or higher  
- MySQL Server 8.x  
- Maven installed  

---

### 2. Database Configuration

Create a database named `student_system` in your MySQL instance.  
Then, update `src/main/resources/application.properties` with your credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/student_system  
spring.datasource.username=your_username  
spring.datasource.password=your_password  
spring.jpa.hibernate.ddl-auto=update  

---

### 3. Run the Application

Run the following command in the project root:

mvn spring-boot:run

The API will be available at:  
http://localhost:8080

---

## 🔌 API & Connection Settings

### CORS Configuration

The backend is pre-configured to allow requests from the Angular frontend:

- Allowed Origin: http://localhost:4200  
- Method Support: GET, POST, PUT, DELETE, OPTIONS  
- Security: Spring Security is configured to allow these cross-origin requests  

---

## ✅ Key Features

- Student CRUD: Full management of student records  
- Course Management: Enrollment and course-student associations  
- Data Validation: Server-side input validation using Hibernate Validator  
- Clean Architecture: Modular and easy to maintain  

---

## 📚 Tech Stack

- Framework: Spring Boot 4
- Language: Java 21
- Database: MySQL 8  
- ORM: Hibernate 7  
- Project Management: Maven  
- Utilities: Lombok, Docker  
