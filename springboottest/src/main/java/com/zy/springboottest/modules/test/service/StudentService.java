package com.zy.springboottest.modules.test.service;

import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.common.vo.SearchVo;
import com.zy.springboottest.modules.test.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Result<Student> insertStudent(Student student);

    Student getStudentByStudentId(int studentId);

    Page<Student> getStudentsBySearchVo(SearchVo searchVo);

    List<Student> findByStudentName(String studentName,int cardId);
}
