package com.studentproject.student_management.controller;

import com.studentproject.student_management.model.Course;
import com.studentproject.student_management.model.StudentCourse;
import com.studentproject.student_management.repository.CourseRepository;
import com.studentproject.student_management.repository.StudentCourseRepository;
import com.studentproject.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/search")
    public List<Course> search(@RequestParam String name) {
        return courseRepository.findByCourseNameContainingIgnoreCase(name);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> payload) {
        String studentId = (String) payload.get("studentId");
        Long courseId = Long.valueOf(payload.get("courseId").toString());

        if (studentCourseRepository.existsByStudentIdAndCourseCourseId(studentId, courseId)) {
            return ResponseEntity.status(400).body("{\"message\": \"כבר רשום לקורס\"}");
        }

        StudentCourse registration = new StudentCourse();

        registration.setStudent(studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found")));
        registration.setCourse(courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found")));

        registration.setRegistrationDate(LocalDate.now());

        StudentCourse saved = studentCourseRepository.save(registration);
        return ResponseEntity.ok(saved);
    }

    @Transactional
    @DeleteMapping("/unregister")
    public void unregister(@RequestParam String studentId, @RequestParam Long courseId) {
        studentCourseRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }
}

