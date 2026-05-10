# 🎓 Student Management System

A beginner-friendly, interview-ready **Spring Boot REST API** for managing student records with full CRUD operations, validation, and Swagger documentation.

---

## 🌟 Project Overview

This project demonstrates a clean, layered backend architecture using:
- **Spring Boot** for rapid REST API development
- **PostgreSQL** for persistent storage
- **JPA/Hibernate** for ORM database mapping
- **Validation** for clean input handling
- **Swagger UI** for interactive API documentation

---

## 🧱 Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3.2.0 |
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Build Tool | Maven |
| Code Simplification | Lombok |
| Validation | Spring Boot Validation |
| API Docs | SpringDoc OpenAPI (Swagger) |
| Testing | Postman |

---

## 🏗️ Project Structure

```
src/main/java/com/example/studentmanagement/
│
├── controller/
│     └── StudentController.java       ← Handles HTTP requests
│
├── service/
│     └── StudentService.java          ← Business logic layer
│
├── repository/
│     └── StudentRepository.java       ← Database operations (JPA)
│
├── entity/
│     └── Student.java                 ← Student table mapping
│
├── exception/
│     ├── ResourceNotFoundException.java   ← Custom 404 exception
│     └── GlobalExceptionHandler.java      ← Centralized error handling
│
└── StudentManagementApplication.java  ← Main entry point
```

---

## ✅ Features

- ➕ Add a new student
- 📋 Get all students
- 🔍 Get student by ID
- ✏️ Update student information
- 🗑️ Delete a student
- 🔎 Search students by department
- 📊 Sort students by CGPA
- 🛡️ Input validation (email, CGPA range, required fields)
- ❌ Custom error responses (404, 400, 500)
- 📖 Swagger UI for interactive API testing

---

## 🗄️ Database Setup

### Step 1: Install PostgreSQL
Download and install PostgreSQL from https://www.postgresql.org/download/

### Step 2: Create the Database

Open **pgAdmin** or **psql** and run:

```sql
CREATE DATABASE studentdb;
```

### Step 3: Configure Credentials

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=postgres
spring.datasource.password=your_actual_password
```

> ✅ Hibernate will **auto-create** the `students` table on first run (`spring.jpa.hibernate.ddl-auto=update`)

---

## 🚀 How to Run

### Prerequisites
- Java 17+
- Maven 3.6+
- PostgreSQL running locally

### Steps

1. **Clone or open the project in IntelliJ IDEA**

2. **Update `application.properties`** with your PostgreSQL password

3. **Run the application:**
   - In IntelliJ: Right-click `StudentManagementApplication.java` → **Run**
   - Or via terminal:
     ```bash
     mvn spring-boot:run
     ```

4. **Verify it's running** — you should see:
   ```
   ✅ Student Management System is running!
   🌐 API Base URL : http://localhost:8080/api/students
   📖 Swagger UI   : http://localhost:8080/swagger-ui.html
   ```

---

## 🌐 API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| `POST` | `/api/students` | Add a new student |
| `GET` | `/api/students` | Get all students |
| `GET` | `/api/students/{id}` | Get student by ID |
| `PUT` | `/api/students/{id}` | Update student |
| `DELETE` | `/api/students/{id}` | Delete student |
| `GET` | `/api/students?department=ECE` | Filter by department |
| `GET` | `/api/students?sortByCgpa=true` | Sort by CGPA (desc) |

---

## 🧪 Sample API Requests

### 1. Add Student — `POST /api/students`

**Request Body:**
```json
{
  "name": "Abishek",
  "email": "abishek@gmail.com",
  "department": "ECE",
  "phoneNumber": "9876543210",
  "cgpa": 8.37
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "Abishek",
  "email": "abishek@gmail.com",
  "department": "ECE",
  "phoneNumber": "9876543210",
  "cgpa": 8.37
}
```

---

### 2. Get All Students — `GET /api/students`

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Abishek",
    "email": "abishek@gmail.com",
    "department": "ECE",
    "phoneNumber": "9876543210",
    "cgpa": 8.37
  },
  {
    "id": 2,
    "name": "Priya",
    "email": "priya@gmail.com",
    "department": "CSE",
    "phoneNumber": "9123456780",
    "cgpa": 9.1
  }
]
```

---

### 3. Get Student By ID — `GET /api/students/1`

**Response (200 OK):**
```json
{
  "id": 1,
  "name": "Abishek",
  "email": "abishek@gmail.com",
  "department": "ECE",
  "phoneNumber": "9876543210",
  "cgpa": 8.37
}
```

**Response if not found (404 Not Found):**
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Student not found with ID: 99"
}
```

---

### 4. Update Student — `PUT /api/students/1`

**Request Body:**
```json
{
  "name": "Abishek Kumar",
  "email": "abishek.kumar@gmail.com",
  "department": "ECE",
  "phoneNumber": "9876543210",
  "cgpa": 8.75
}
```

**Response (200 OK):**
```json
{
  "id": 1,
  "name": "Abishek Kumar",
  "email": "abishek.kumar@gmail.com",
  "department": "ECE",
  "phoneNumber": "9876543210",
  "cgpa": 8.75
}
```

---

### 5. Delete Student — `DELETE /api/students/1`

**Response (200 OK):**
```
Student with ID 1 deleted successfully.
```

---

## 📖 Swagger UI

After starting the application, visit:

```
http://localhost:8080/swagger-ui.html
```

You'll get an interactive page where you can test all APIs directly in the browser — no Postman needed!

---

## 🧪 Postman Testing Guide

1. Open Postman and create a new Collection: **"Student Management API"**
2. Import the `StudentManagement.postman_collection.json` file from this project
3. Or create requests manually using the endpoints above
4. Set base URL: `http://localhost:8080`

### Postman Tips
- Set **Content-Type: application/json** header for POST/PUT requests
- Use **Body → raw → JSON** for request bodies
- Check the **Status Code** and **Response Body** after each request

---

## 🏷️ HTTP Status Codes Used

| Code | Meaning | When |
|------|---------|------|
| `200 OK` | Success | GET, PUT, DELETE |
| `201 Created` | Resource created | POST |
| `400 Bad Request` | Validation failed | Invalid input |
| `404 Not Found` | Resource missing | Student ID not found |
| `500 Internal Server Error` | Server error | Unexpected issues |

---

## 👨‍💻 Author

**Abishek** — Built as part of the Nokia 5G Course backend project.

This project demonstrates industry-standard practices suitable for fresher interviews at companies like TCS, Infosys, Wipro, and more.
