package com.studentproject.student_management.controller;

import com.studentproject.student_management.model.Student;
import com.studentproject.student_management.model.StudentCourseDTO;
import com.studentproject.student_management.repository.StudentRepository;
import com.studentproject.student_management.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}/courses")
    public List<StudentCourseDTO> getMyCourses(@PathVariable String id) {
        return studentCourseRepository.findCoursesByStudentId(id);
    }
}
