package com.zy.springboottest.modules.test.service;

import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.test.entity.Student;

public interface StudentService {
    Result<Student> insertStudent(Student student);
}
