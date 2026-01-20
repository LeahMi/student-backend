package com.studentproject.student_management.controller;

import com.studentproject.student_management.model.Course;
import com.studentproject.student_management.model.StudentCourse;
import com.studentproject.student_management.repository.CourseRepository;
import com.studentproject.student_management.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    // חיפוש קורסים
    @GetMapping("/search")
    public List<Course> search(@RequestParam String name) {
        return courseRepository.findByCourseNameContainingIgnoreCase(name);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody StudentCourse registration) {
        // בדיקה אם כבר רשום
        if (studentCourseRepository.existsByStudentIdAndCourseId(registration.getStudentId(), registration.getCourseId())) {
            return ResponseEntity.status(400).body("{\"message\": \"כבר רשום לקורס\"}");
        }

        registration.setRegistrationDate(LocalDate.now());
        StudentCourse saved = studentCourseRepository.save(registration);
        return ResponseEntity.ok(saved); // מחזיר את האובייקט שנשמר כ-JSON
    }



    // ביטול רישום (רק אם הקורס לא התחיל - הבדיקה הלוגית תהיה כאן או ב-Front)
    @Transactional
    @DeleteMapping("/unregister")
    public void unregister(@RequestParam String studentId, @RequestParam Long courseId) {
        studentCourseRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }
}

