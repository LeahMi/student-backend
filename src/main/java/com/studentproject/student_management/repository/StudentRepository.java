package com.studentproject.student_management.repository;

import com.studentproject.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByIdAndPassword(String id, String password);
}
