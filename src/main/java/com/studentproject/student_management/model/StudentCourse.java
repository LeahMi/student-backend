package com.studentproject.student_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student_courses")
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Integer grade;
    private LocalDate registrationDate;

    public StudentCourse(Student student, Course course, LocalDate registrationDate) {
        this.student = student;
        this.course = course;
        this.registrationDate = registrationDate;
    }
}
