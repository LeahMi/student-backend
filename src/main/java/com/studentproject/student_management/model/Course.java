package com.studentproject.student_management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Course {
    @Id
    private Long courseId;
    private String courseName;
    private int academicYear;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentCourse> registrations;
}
