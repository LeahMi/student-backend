package com.studentproject.student_management.controller;

import com.studentproject.student_management.model.Student;
import com.studentproject.student_management.repository.StudentRepository;
import com.studentproject.student_management.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Student loginDetails) {

        Optional<Student> studentOpt = studentRepository.findById(loginDetails.getId());

        if (studentOpt.isEmpty()) {
            return ResponseEntity.status(401).body("{\"message\": \"תעודת זהות אינה קיימת במערכת\"}");
        }

        Student student = studentOpt.get();

        if (!student.getPassword().equals(loginDetails.getPassword())) {
            return ResponseEntity.status(401).body("{\"message\": \"סיסמה שגויה, נסה שנית\"}");
        }

        String token = jwtService.generateToken(student.getId());
        Map<String, Object> response = new HashMap<>();
        response.put("student", student);
        response.put("token", token);

        return ResponseEntity.ok(response);
    }


}
