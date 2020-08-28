package com.zy.springboottest.modules.test.service.impl;

import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.common.vo.SearchVo;
import com.zy.springboottest.modules.test.entity.Student;
import com.zy.springboottest.modules.test.repository.StudentRepository;
import com.zy.springboottest.modules.test.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Student getStudentByStudentId(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Page<Student> getStudentsBySearchVo(SearchVo searchVo) {

        String orderBy = StringUtils.isBlank(searchVo.getOrderBy())?"studentId":searchVo.getOrderBy();
        Sort.Direction direction = StringUtils.isBlank(searchVo.getSort())||"asc".equalsIgnoreCase(searchVo.getSort())?
                Sort.Direction.ASC:Sort.Direction.DESC;
        Sort sort = new Sort(direction,orderBy);

        Pageable pageable = PageRequest.of(searchVo.getCurrentPage()-1,searchVo.getPageSize(),sort);

        Student student = new Student();
        student.setStudentName(searchVo.getKeyWord());
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("studentName",match->match.contains())
                .withIgnorePaths("studentId");
        Example<Student> example = Example.of(student,matcher);


        return studentRepository.findAll(example,pageable);
    }

    @Override
    public List<Student> findByStudentName(String studentName,int cardId) {
        List<Student> students = null;
        if(cardId>0){
            students = studentRepository.getStudentByParam(studentName,cardId);
        }else {
            students =Optional
                    .ofNullable(studentRepository.findByStudentName(studentName))
                    .orElse(Collections.emptyList());
        }
        return students;
    }
}
