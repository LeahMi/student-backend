# Student Management System - Backend 

This is the core REST API for the Student & Course Management System. The project is built using **Spring Boot** and provides a robust backend service for the Angular frontend.

## 🛠 Tech Stack
- **Java 17+**
- **Spring Boot 3.4+**
- **Spring Data JPA** (Database management)
- **MySQL** (Relational database)
- **Maven** (Dependency management)
- **Lombok** (For cleaner code)
- **Hibernate 7.x**

## Features
- Full **CRUD** operations for Students (Create, Read, Update, Delete).
- Course management and student enrollment logic.
- **CORS** configuration for seamless Frontend-Backend integration.
- Server-side data validation.
- Clean and modular architecture.

## Local Setup & Installation

### 1. Prerequisites
- **Java JDK 17** or higher installed.
- **MySQL Server** installed and running.
- **Maven** installed (or use the included Maven Wrapper).

### 2. Database Setup
Create a new database in your MySQL instance:
```sql
CREATE DATABASE student_system;
