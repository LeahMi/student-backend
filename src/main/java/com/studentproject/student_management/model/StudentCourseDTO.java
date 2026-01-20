package com.studentproject.student_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentCourseDTO {
    private Long courseId;
    private String courseName;
    private Integer grade;
    private LocalDate startDate;
    private LocalDate endDate;
}
