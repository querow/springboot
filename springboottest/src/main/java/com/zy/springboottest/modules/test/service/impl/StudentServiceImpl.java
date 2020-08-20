package com.zy.springboottest.modules.test.service.impl;

import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.test.entity.Student;
import com.zy.springboottest.modules.test.repository.StudentRepository;
import com.zy.springboottest.modules.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    @Transactional
    public Result<Student> insertStudent(Student student) {
        student.setCreateDate(LocalDateTime.now());
        studentRepository.saveAndFlush(student);
        return new Result<>(Result.ResultStatus.SUCCESS.status,"insert sucess",student);
    }
}
