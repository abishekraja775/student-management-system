package com.example.studentmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * Student Entity - maps to the "students" table in PostgreSQL.
 * Lombok annotations eliminate boilerplate getters/setters/constructors.
 */
@Entity
@Table(name = "students")
@Data                   // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor      // Generates no-args constructor (required by JPA)
@AllArgsConstructor     // Generates all-args constructor
@Builder                // Enables builder pattern: Student.builder().name("Abishek").build()
public class Student {

    // ---- Primary Key ----
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---- Student Fields with Validation ----

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Department is required")
    @Column(nullable = false)
    private String department;

    @NotBlank(message = "Phone number is required")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 digits")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull(message = "CGPA is required")
    @DecimalMin(value = "0.0", message = "CGPA cannot be less than 0.0")
    @DecimalMax(value = "10.0", message = "CGPA cannot be more than 10.0")
    private Double cgpa;
}
