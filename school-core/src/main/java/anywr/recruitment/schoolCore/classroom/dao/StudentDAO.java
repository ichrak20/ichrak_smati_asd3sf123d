package anywr.recruitment.schoolCore.classroom.dao;

import anywr.recruitment.schoolCore.classroom.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends JpaRepository<Student, Long> {


    @Query("SELECT s FROM Student s INNER JOIN s.classroom c  On s.classroom = c " +
            "where c.name LIKE %:className%")
    Page<Student> findByClassName(String className, Pageable pageable);

    @Query("SELECT s FROM Student s INNER JOIN s.classroom c  On s.classroom = c INNER JOIN c.teacher t  On c.teacher = t " +
            "where CONCAT(t.firstName, ' ', t.lastName) LIKE %:fullName%")
    Page<Student> findByTeacherFullName(String fullName, Pageable pageable);

    @Query("SELECT s FROM Student s INNER JOIN s.classroom c  On s.classroom = c INNER JOIN c.teacher t  On c.teacher = t " +
            "where c.name LIKE %:className% AND CONCAT(t.firstName, ' ', t.lastName) LIKE %:fullName%")
    Page<Student> findByClassNameOrTeacherFullName(String className, String fullName, Pageable pageable);
    }
