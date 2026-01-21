package com.studentproject.student_management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Student {
    @Id
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentCourse> registrations;
}
