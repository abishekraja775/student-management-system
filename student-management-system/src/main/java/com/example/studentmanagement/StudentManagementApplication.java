package com.example.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Student Management System application.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
        System.out.println("✅ Student Management System is running!");
        System.out.println("🌐 API Base URL : http://localhost:8080/api/students");
        System.out.println("📖 Swagger UI   : http://localhost:8080/swagger-ui.html");
    }
}
