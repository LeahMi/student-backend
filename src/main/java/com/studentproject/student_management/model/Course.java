package com.studentproject.student_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Course {
    @Id
    private Long courseId;
    private String courseName;
    private int academicYear;
    private LocalDate startDate;
    private LocalDate endDate;

    @Data
    @AllArgsConstructor
    public static class StudentCourseDTO {
        private Long courseId;
        private String courseName;
        private Integer grade;
        private LocalDate startDate;
        private LocalDate endDate;
    }
}
