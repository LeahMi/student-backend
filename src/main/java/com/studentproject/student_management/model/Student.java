package com.studentproject.student_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
