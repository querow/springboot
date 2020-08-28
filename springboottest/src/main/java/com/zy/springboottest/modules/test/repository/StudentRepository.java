package com.zy.springboottest.modules.test.repository;

import com.zy.springboottest.modules.test.entity.Student;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByStudentName(String studentName);

    @Query(value="select s from Student s where s.studentName = :studentName and s.studentCard.cardId = :cardId")
    List<Student> getStudentByParam(@Param("studentName") String studentName, @Param("cardId") int cardId);
}
