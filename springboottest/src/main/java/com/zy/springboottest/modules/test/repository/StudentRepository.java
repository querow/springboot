package com.zy.springboottest.modules.test.repository;

import com.zy.springboottest.modules.test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
