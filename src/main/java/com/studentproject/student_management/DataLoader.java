package com.studentproject.student_management;

import com.studentproject.student_management.model.Course;
import com.studentproject.student_management.model.Student;
import com.studentproject.student_management.repository.CourseRepository;
import com.studentproject.student_management.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public DataLoader(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepository = studentRepo;
        this.courseRepository = courseRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Student s = new Student();
        s.setId("207919341");
        s.setPassword("pass123");
        s.setFirstName("ישראל");
        s.setLastName("ישראלי");
        s.setEmail("test@test.com");
        studentRepository.save(s);

        Course c1 = new Course();
        c1.setCourseId(101L);
        c1.setCourseName("Java Programming");
        c1.setAcademicYear(2026);
        c1.setStartDate(LocalDate.of(2026, 3, 1));
        c1.setEndDate(LocalDate.of(2026, 6, 1));
        courseRepository.save(c1);

        Course c2 = new Course();
        c2.setCourseId(102L);
        c2.setCourseName("Angular Web Development");
        c2.setAcademicYear(2026);
        c2.setStartDate(LocalDate.of(2026, 2, 1));
        c2.setEndDate(LocalDate.of(2026, 5, 1));
        courseRepository.save(c2);

        Course c3 = new Course();
        c3.setCourseId(103L);
        c3.setCourseName("React Web Development");
        c3.setAcademicYear(2026);
        c3.setStartDate(LocalDate.of(2026, 2, 3));
        c3.setEndDate(LocalDate.of(2026, 4, 3));
        courseRepository.save(c3);
        System.out.println("נתוני בדיקה נטענו בהצלחה!");
    }
}
