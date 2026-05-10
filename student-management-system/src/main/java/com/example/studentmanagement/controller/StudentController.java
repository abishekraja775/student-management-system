package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Student REST Controller - handles all HTTP requests for student operations.
 *
 * @RestController  = @Controller + @ResponseBody (auto-converts to JSON)
 * @RequestMapping  = base URL prefix for all endpoints in this class
 * @CrossOrigin     = allows requests from any frontend (e.g. React, Angular)
 *
 * Flow: HTTP Request → Controller → Service → Repository → Database
 */
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
@Tag(name = "Student Management", description = "APIs for managing student records")
public class StudentController {

    // ---- Dependency Injection via Constructor (best practice) ----
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ================================================================
    // POST /api/students - Add a new student
    // ================================================================

    /**
     * Creates a new student record.
     * @Valid triggers validation annotations defined in Student entity.
     * Returns 201 CREATED status on success.
     */
    @PostMapping
    @Operation(summary = "Add a new student", description = "Creates a new student record in the database")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED); // 201
    }

    // ================================================================
    // GET /api/students - Get all students
    // ================================================================

    /**
     * Retrieves all students from the database.
     * Supports optional query params: ?department=ECE or ?sortByCgpa=true
     * Returns 200 OK status.
     */
    @GetMapping
    @Operation(summary = "Get all students", description = "Returns a list of all students. Filter by department or sort by CGPA using query params.")
    public ResponseEntity<List<Student>> getAllStudents(
            @RequestParam(required = false) String department,
            @RequestParam(required = false, defaultValue = "false") boolean sortByCgpa) {

        List<Student> students;

        if (department != null && !department.isEmpty()) {
            // Filter by department: GET /api/students?department=ECE
            students = studentService.getStudentsByDepartment(department);
        } else if (sortByCgpa) {
            // Sort by CGPA: GET /api/students?sortByCgpa=true
            students = studentService.getStudentsSortedByCgpa();
        } else {
            // Get all students: GET /api/students
            students = studentService.getAllStudents();
        }

        return new ResponseEntity<>(students, HttpStatus.OK); // 200
    }

    // ================================================================
    // GET /api/students/{id} - Get student by ID
    // ================================================================

    /**
     * Retrieves a specific student by their ID.
     * Returns 404 Not Found if student doesn't exist.
     * Returns 200 OK on success.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get student by ID", description = "Returns a single student by their unique ID")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK); // 200
    }

    // ================================================================
    // PUT /api/students/{id} - Update student
    // ================================================================

    /**
     * Updates an existing student's information.
     * Returns 404 Not Found if student doesn't exist.
     * Returns 200 OK with updated student on success.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a student", description = "Updates all fields of an existing student by ID")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody Student studentDetails) {

        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK); // 200
    }

    // ================================================================
    // DELETE /api/students/{id} - Delete student
    // ================================================================

    /**
     * Deletes a student by their ID.
     * Returns 404 Not Found if student doesn't exist.
     * Returns 200 OK with confirmation message on success.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a student", description = "Deletes a student record from the database by ID")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student with ID " + id + " deleted successfully.", HttpStatus.OK); // 200
    }
}
