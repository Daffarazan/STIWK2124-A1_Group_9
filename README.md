#GROUP NAME & MEMBERS (Group 9).
-MUHAMMAD DAFFA RAZAN WIJAYA (303026)
-HAKIM ATHIR EMIRIO (290862)
-AZHAR LUTHFI MAULANA (3030246) 
-PASCAL ADIWIDYA (296650)


# ARL Backend - Assignment 1 (STIWK2124)

# Accessible Reading List (ARL) - Backend API 📚

## 📖 Project Overview
This project is the Backend RESTful API for the **Accessible Reading List (ARL)** application, developed as part of Assignment 1. It provides a robust, secure, and paginated backend service to manage a catalog of books using a Client-Server architecture.

## 🛠️ Technology Stack
*   **Framework:** Java Spring Boot (v3.x)
*   **Security:** Spring Security (Basic Authentication)
*   **Database:** H2 In-Memory Database / MySQL (Configured via `application.properties`)
*   **Build Tool:** Maven

## ✨ Key Features (Grading Criteria Highlight)
1.  **CRUD Operations:** Full Create, Read, Update, and Delete functionalities for the Book entity.
2.  **Spring Security Integration:** 
    *   **Public Access:** Viewing the book list (`GET` requests) is open to the public.
    *   **Protected Access:** Modifying data (`POST`, `PUT`, `DELETE` requests) requires strict Basic Authentication.
3.  **Pagination & Sorting:** Implemented pagination for retrieving books (e.g., `?page=0&size=10`) to optimize payload size.
4.  **CORS Configuration:** Fully configured to accept cross-origin requests from the Angular Frontend running on `http://localhost:4200`.

---

## 🚀 Setup & Installation Guide

Follow these exact steps to run the application locally without any errors.

### Prerequisites
*   Java Development Kit (JDK) 17 or higher installed.
*   Port `8080` must be available on your machine.

### Step-by-Step Execution
1.  **Extract the Project:** Unzip the project folder and open it in your preferred IDE (VS Code, IntelliJ IDEA, or Eclipse).
2.  **Open Terminal:** Open the integrated terminal within the root directory of the project.
3.  **Run the Application:** Use the Maven Wrapper to build and run the project automatically (no global Maven installation required).
    *   *For Windows:*
        ```bash
        .\mvnw.cmd spring-boot:run
        ```
    *   *For macOS/Linux:*
        ```bash
        ./mvnw spring-boot:run
        ```
4.  **Wait for Initialization:** The server is successfully running when you see the log: 
    `Started [ApplicationName] in X seconds (process running for X)`.
    The Backend API is now live at: `http://localhost:8080`

---

## 🔐 Authentication Credentials
To test the protected endpoints (Add, Edit, Delete), please use the following Basic Authentication credentials configured in the system:

*   **Username:** `admin` *(Change this if your actual username is different)*
*   **Password:** `password` *(Change this if your actual password is different)*

---

## 📡 API Endpoints Documentation

Here is the list of available endpoints for testing via Postman, cURL, or the Frontend interface.

| HTTP Method | Endpoint Path | Authentication | Description |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/books` | 🟢 Public | Retrieves a paginated list of all books. (Default: page 0, size 10) |
| **GET** | `/api/books/{id}` | 🟢 Public | Retrieves details of a specific book by its ID. |
| **POST** | `/api/books` | 🔴 Required | Adds a new book to the catalog. |
| **PUT** | `/api/books/{id}` | 🔴 Required | Updates an existing book's information by its ID. |
| **DELETE**| `/api/books/{id}` | 🔴 Required | Removes a book from the catalog by its ID. |

### Sample JSON Payload (For POST / PUT)
When sending a request to add or update a book, ensure the `Content-Type` is set to `application/json`.
```json
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "isbn": "9780743273565"
}
   ```bash
   ./mvnw.cmd spring-boot:run
