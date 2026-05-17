# ARL Backend - Assignment 1 (STIWK2124)

This is the backend implementation for the Accessible Reading List (ARL) web application, built using **Spring Boot** and **MySQL**.

## Features
- **CRUD Operations**: Add, List, Update, and Delete books.
- **Search & Pagination**: Support for searching titles/authors and paginated results.
- **Security**: Basic Authentication enabled.
- **Validation**: Input validation for book entries.

## Tech Stack
- **Framework**: Spring Boot 3
- **Database**: MySQL (XAMPP)
- **Security**: Spring Security (Basic Auth)

## Setup Instructions

### 1. Database Setup
1. Open XAMPP and start **MySQL**.
2. Go to `localhost/phpmyadmin` and create a database named `arl_db`.
3. Import the `schema.sql` file provided in this repository to create the `books` table.

### 2. Run the Application
1. Open the project in VS Code.
2. Ensure your JDK 17 is installed.
3. Run the application via terminal:
   ```bash
   ./mvnw.cmd spring-boot:run