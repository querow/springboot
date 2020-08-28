package com.zy.springboottest.modules.test.controller;

import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.common.vo.SearchVo;
import com.zy.springboottest.modules.test.entity.Student;
import com.zy.springboottest.modules.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/student",consumes = "application/json")
    public Result<Student> insertStudent(@RequestBody Student student){
        return studentService.insertStudent(student);
    }
    @GetMapping(value="/student/{studentId}")
    public Student getStudentByStudentId(@PathVariable int studentId){
        return studentService.getStudentByStudentId(studentId);
    }
    @PostMapping(value = "/students", consumes = "application/json")
    public Page<Student> getStudentsBySearchVo(@RequestBody SearchVo searchVo){
        return studentService.getStudentsBySearchVo(searchVo);
    }
    @GetMapping("/students")
    public List<Student> findByStudentName(@RequestParam String studentName,
                                           @RequestParam(required = false,defaultValue = "0") int cardId){
        return studentService.findByStudentName(studentName,cardId);
    }
}
