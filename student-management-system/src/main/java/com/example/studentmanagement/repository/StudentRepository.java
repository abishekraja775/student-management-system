package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Student Repository - handles all database operations for Student entity.
 *
 * JpaRepository<Student, Long> provides built-in methods:
 *   - save()       → INSERT or UPDATE
 *   - findById()   → SELECT by ID
 *   - findAll()    → SELECT all
 *   - deleteById() → DELETE by ID
 *   - existsById() → Check existence
 *
 * No implementation needed - Spring Data JPA generates it automatically!
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Find all students belonging to a specific department.
     * Spring Data JPA auto-generates the query from method name.
     * SQL equivalent: SELECT * FROM students WHERE department = ?
     *
     * @param department - the department to search by (e.g. "ECE", "CSE")
     * @return list of students in that department
     */
    List<Student> findByDepartment(String department);

    /**
     * Find all students sorted by CGPA in descending order.
     * SQL equivalent: SELECT * FROM students ORDER BY cgpa DESC
     *
     * @return list of students sorted by CGPA (highest first)
     */
    List<Student> findAllByOrderByCgpaDesc();
}
