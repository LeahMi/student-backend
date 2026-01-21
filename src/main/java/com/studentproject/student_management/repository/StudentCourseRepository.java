package com.studentproject.student_management.repository;

import com.studentproject.student_management.model.StudentCourse;
import com.studentproject.student_management.model.StudentCourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    boolean existsByStudentIdAndCourseCourseId(String studentId, Long courseId);
    @Transactional
    @Modifying
    @Query("DELETE FROM StudentCourse sc WHERE sc.student.id = :studentId AND sc.course.courseId = :courseId")
    void deleteByStudentIdAndCourseId(@Param("studentId") String studentId, @Param("courseId") Long courseId);

    @Query("SELECT new com.studentproject.student_management.model.StudentCourseDTO(" +
            "sc.course.courseId, sc.course.courseName, sc.grade, sc.course.startDate, sc.course.endDate) " +
            "FROM StudentCourse sc " +
            "WHERE sc.student.id = :studentId")
    List<StudentCourseDTO> findCoursesByStudentId(@Param("studentId") String studentId);
}
