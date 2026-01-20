package com.studentproject.student_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // מזהה רשומה אוטומטי

    private String studentId; // ת"ז של הסטודנט
    private Long courseId;    // מספר הקורס
    private Integer grade;    // ציון (יכול להיות null אם הקורס לא הסתיים)
    private LocalDate registrationDate; // תאריך רישום
}
