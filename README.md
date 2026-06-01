# 📚 Accessible Reading List (ARL) - Backend API

**Course:** STIWK2124 - Assignment 1

### 👥 Group 9 Members
* **MUHAMMAD DAFFA RAZAN WIJAYA** (303026)
* **HAKIM ATHIR EMIRIO** (290862)
* **AZHAR LUTHFI MAULANA** (3030246) 
* **PASCAL ADIWIDYA** (296650)
* **THO TRACY** (289820)

---

## 📖 Project Overview
This project is the Backend RESTful API for the **Accessible Reading List (ARL)** application. It provides a robust, secure, and paginated backend service to manage a catalog of books using a standard Client-Server architecture.

## 🛠️ Technology Stack
* **Framework:** Java Spring Boot (v3.x)
* **Security:** Spring Security (Basic Authentication)
* **Database:** H2 In-Memory Database (No external database setup required)
* **Build Tool:** Maven

## ✨ Key Features Developed
1.  **Complete CRUD Operations:** Full Create, Read, Update, and Delete functionalities.
2.  **Spring Security Integration:** * **Public Access:** Viewing and searching the book list (`GET` requests) are open to the public.
    * **Protected Access:** Modifying data (`POST`, `PUT`, `DELETE` requests) strictly requires Basic Authentication.
3.  **Pagination & Search:** Implemented pagination for retrieving books (e.g., `?page=0&size=5`) and a search parameter (`?q=keyword`) to optimize data retrieval.
4.  **CORS Configuration:** Fully configured to accept cross-origin requests from the Angular Frontend (`http://localhost:4200`).

---

## 📂 Code Structure Guide (For Evaluation)
To assist with the code review, here is where the core logic resides within the `src/main/java/...` directory:
* `/controller` $\rightarrow$ Contains `BookController.java` handling all REST endpoints and HTTP mapping.
* `/model` $\rightarrow$ Contains `Book.java` defining the database entity structure.
* `/repository` $\rightarrow$ Contains `BookRepository.java` handling database queries, pagination, and search logic.
* `/service` $\rightarrow$ Contains business logic bridging the controller and repository.
* `/config` $\rightarrow$ Contains `SecurityConfig.java` handling CORS policies and route protection.

---

## 🚀 Setup & Installation Guide

Follow these exact steps to run the application locally without any errors.

### Prerequisites
* Java Development Kit (JDK) 17 or higher installed.
* Port `8080` must be available.

### Step-by-Step Execution
1.  **Extract the Project:** Unzip the project folder and open it in your preferred IDE (VS Code, IntelliJ IDEA, or Eclipse).
2.  **Open Terminal:** Open the integrated terminal within the root directory of the project.
3.  **Run the Application:** Use the Maven Wrapper to build and run the project automatically.
    * *For Windows Command Prompt / PowerShell:*
        ```bash
        .\mvnw.cmd spring-boot:run
        ```
    * *For macOS / Linux (Git Bash):*
        ```bash
        ./mvnw spring-boot:run
        ```
4.  **Initialization:** The server is successfully running when you see the log output: `Started [ApplicationName] in X seconds`.
    * The API is now live at: `http://localhost:8080`

---

## 🧪 Lecturer's Evaluation Walkthrough

We recommend using **Postman** or **Insomnia** to test the API endpoints.

### 1. Authentication Credentials
To test the protected endpoints (Create, Update, Delete), configure **Basic Auth** in your testing tool with the following credentials:
* **Username:** `admin`
* **Password:** `password`

### 2. API Endpoints Dictionary

Here are the endpoints constructed for this project:

| HTTP Method | Endpoint Path | Auth Required | Description |
| :--- | :--- | :--- | :--- |
| **POST** | `/api/books` | 🔴 Yes | Creates a new book in the catalog. |
| **GET** | `/api/books?page=0&size=5` | 🟢 No | Retrieves a paginated list of all books. |
| **GET** | `/api/books?q=java` | 🟢 No | Searches the catalog for books matching the keyword. |
| **GET** | `/api/books/{id}` | 🟢 No | Retrieves details of a specific book by its ID. |
| **PUT** | `/api/books/{id}` | 🔴 Yes | Updates an existing book's information by ID. |
| **DELETE**| `/api/books/{id}` | 🔴 Yes | Removes a book from the catalog by ID. |

### 3. Sample JSON Payload (For POST / PUT Testing)
When sending a request to add or update a book, ensure the `Content-Type` header is set to `application/json` and include the body below:

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884"
}
