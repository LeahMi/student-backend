package com.studentproject.student_management.repository;

import com.studentproject.student_management.model.StudentCourse;
import com.studentproject.student_management.model.StudentCourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying; // חשוב!
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional; // חשוב!
import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    @Transactional // מבטיח שהמחיקה תתבצע כפעולה אחת
    @Modifying    // מודיע ל-Spring שזו פעולת עדכון/מחיקה ולא שליפה
    void deleteByStudentIdAndCourseId(String studentId, Long courseId);

    @Query("SELECT new com.studentproject.student_management.model.StudentCourseDTO(" +
            "c.courseId, c.courseName, sc.grade, c.startDate, c.endDate) " +
            "FROM StudentCourse sc " +
            "JOIN Course c ON sc.courseId = c.courseId " + // JOIN מפורש
            "WHERE sc.studentId = :studentId")
    List<StudentCourseDTO> findCoursesByStudentId(@Param("studentId") String studentId);



    boolean existsByStudentIdAndCourseId(String studentId, Long courseId);
}


