# Student Management System - Backend 

This is the core REST API for the Student & Course Management System. The project is built using **Spring Boot** and provides a robust backend service for the Angular frontend.

## Tech Stack
- **Java 17+**
- **Spring Boot 3.4+**
- **Spring Data JPA** (Database management)
- **MySQL** (Relational database)
- **Maven** (Dependency management)
- **Lombok** (For cleaner code)
- **Hibernate 7.x**

## ✨ Features
- Full **CRUD** operations for Students (Create, Read, Update, Delete).
- Course management and student enrollment logic.
- **CORS Configured**: Enabled for `http://localhost:4200` to allow seamless integration with the Angular frontend.
- **Security**: Custom security filters for API access.
- Server-side data validation.

## 🛠 Local Setup & Installation

### 1. Prerequisites
- **Java JDK 17** or higher installed.
- **MySQL Server** installed and running.
- **Maven** installed.

### 2. Database Setup
Create a new database in your MySQL instance:
```sql
CREATE DATABASE student_system;
