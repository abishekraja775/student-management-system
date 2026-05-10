# 🎓 Student Management System

A clean, beginner-friendly **REST API** built with **Spring Boot** and **PostgreSQL** that performs full CRUD operations on student records — designed for learning and fresher placement portfolios.

---

## 🚀 Live Demo

> Run locally at: `http://localhost:8080/api/students`
> Swagger UI: `http://localhost:8080/swagger-ui.html`

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

## ✅ Features

- ➕ Add a new student
- 📋 Get all students
- 🔍 Get student by ID
- ✏️ Update student details
- 🗑️ Delete a student
- 🔎 Filter students by department
- 📊 Sort students by CGPA (highest first)
- 🛡️ Input validation with proper error messages
- ❌ Custom 404 / 400 / 500 error responses
- 📖 Swagger UI for browser-based API testing

---

## 🌐 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/students` | Add a new student |
| `GET` | `/api/students` | Get all students |
| `GET` | `/api/students/{id}` | Get student by ID |
| `PUT` | `/api/students/{id}` | Update student |
| `DELETE` | `/api/students/{id}` | Delete student |
| `GET` | `/api/students?department=ECE` | Filter by department |
| `GET` | `/api/students?sortByCgpa=true` | Sort by CGPA |

---

## 📦 Student Fields

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

## 🗄️ Database Setup

1. Install **PostgreSQL**
2. Open pgAdmin → create a database named `studentdb`
3. Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=postgres
spring.datasource.password=your_password
```

> ✅ Hibernate auto-creates the `students` table on first run

---

## ▶️ How to Run

### Prerequisites
- Java 17+
- Maven
- PostgreSQL running locally

### Steps

```bash
# Clone the repository
git clone https://github.com/abishekraja775/student-management-system.git

# Navigate into the project
cd student-management-system

# Run the application
mvn spring-boot:run
```

Or open in **IntelliJ IDEA** → right-click `StudentManagementApplication.java` → **Run**

---

## 🧪 Testing with Postman

1. Import `StudentManagement.postman_collection.json` into Postman
2. 11 pre-built requests are ready to use
3. Start with **"1. Add Student (POST)"** and hit Send

---

## 🏗️ Project Structure

```
src/main/java/com/example/studentmanagement/
│
├── controller/
│     └── StudentController.java       ← Handles HTTP requests
│
├── service/
│     └── StudentService.java          ← Business logic
│
├── repository/
│     └── StudentRepository.java       ← Database operations
│
├── entity/
│     └── Student.java                 ← Student table mapping
│
├── exception/
│     ├── ResourceNotFoundException.java
│     └── GlobalExceptionHandler.java
│
└── StudentManagementApplication.java  ← Main entry point
```

---

## 📊 HTTP Status Codes

| Code | Meaning |
|------|---------|
| `200 OK` | Success |
| `201 Created` | Student added |
| `400 Bad Request` | Validation failed |
| `404 Not Found` | Student not found |
| `500 Internal Server Error` | Unexpected error |

---

## 👨‍💻 Author

**Abishek Raja**
- GitHub: [@abishekraja775](https://github.com/abishekraja775)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
