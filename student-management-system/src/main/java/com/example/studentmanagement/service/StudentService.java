package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.exception.ResourceNotFoundException;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Student Service Layer - contains all business logic.
 *
 * The Service layer sits between Controller and Repository.
 * Controller → Service → Repository → Database
 *
 * Uses constructor injection (best practice over @Autowired field injection).
 */
@Service
public class StudentService {

    // ---- Dependency Injection via Constructor ----
    private final StudentRepository studentRepository;

    // Constructor injection - Spring automatically injects StudentRepository
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // ================================================================
    // CREATE - Add a new student
    // ================================================================

    /**
     * Saves a new student to the database.
     *
     * @param student - student object from the request body
     * @return the saved student with auto-generated ID
     */
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // ================================================================
    // READ - Get students
    // ================================================================

    /**
     * Retrieves all students from the database.
     *
     * @return list of all students
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Retrieves a student by their ID.
     * Throws ResourceNotFoundException (404) if student is not found.
     *
     * @param id - the student's ID
     * @return the student if found
     */
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student not found with ID: " + id));
    }

    /**
     * Retrieves all students filtered by department.
     *
     * @param department - department name (e.g. "ECE", "CSE")
     * @return list of students in that department
     */
    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }

    /**
     * Retrieves all students sorted by CGPA in descending order.
     *
     * @return list of students sorted from highest to lowest CGPA
     */
    public List<Student> getStudentsSortedByCgpa() {
        return studentRepository.findAllByOrderByCgpaDesc();
    }

    // ================================================================
    // UPDATE - Modify existing student
    // ================================================================

    /**
     * Updates an existing student's information.
     * First checks if the student exists, then updates all fields.
     *
     * @param id             - the ID of the student to update
     * @param studentDetails - the new student data from the request body
     * @return the updated student
     */
    public Student updateStudent(Long id, Student studentDetails) {

        // Step 1: Fetch the existing student (throws 404 if not found)
        Student existingStudent = getStudentById(id);

        // Step 2: Update all fields with new values
        existingStudent.setName(studentDetails.getName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setDepartment(studentDetails.getDepartment());
        existingStudent.setPhoneNumber(studentDetails.getPhoneNumber());
        existingStudent.setCgpa(studentDetails.getCgpa());

        // Step 3: Save and return the updated student
        return studentRepository.save(existingStudent);
    }

    // ================================================================
    // DELETE - Remove a student
    // ================================================================

    /**
     * Deletes a student by their ID.
     * First checks if the student exists, then deletes them.
     *
     * @param id - the ID of the student to delete
     */
    public void deleteStudent(Long id) {

        // Verify student exists before deletion (throws 404 if not found)
        Student student = getStudentById(id);

        studentRepository.delete(student);
    }
}
