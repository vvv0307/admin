package com.vvv.zht.controller;


import com.vvv.zht.model.StudentDO;
import com.vvv.zht.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/admin/student")
    public ResponseEntity<?> addStudent(@RequestParam("name") String name,
                                        @RequestParam("age") int age,
                                        @RequestParam("school") String school,
                                        @RequestParam("location") String location,
                                        @RequestParam("workCity") String workCity,
                                        @RequestParam("desiredPosition") String desiredPosition,
                                        @RequestParam("skill") String skill,
                                        @RequestParam("major") String major,
                                        @RequestParam("phone") String phone){
        // TODO: 2018/12/28 加参数判空
        return ResponseEntity.ok(studentService.addStudent(name,age,school,location,workCity,desiredPosition,skill,major,phone));
    }


    @GetMapping("/admin/student/{id:\\d+}")
    public ResponseEntity SelectStudentById(@PathVariable("id") int id){
        StudentDO studentDO = studentService.selectStudentById(id);
        if(studentDO == null){
            throw new InvalidParameterException("id not exist");
        }
        return ResponseEntity.ok(studentDO);
    }

    @GetMapping("admin/student/{name}")
    public ResponseEntity SelectStudentByName(@PathVariable("name") String name){
        if(StringUtils.isEmpty(name)){
            throw new InvalidParameterException("parameter can't be empty");
        }
        List<StudentDO> list = studentService.selectStudentByName(name);
        if(list == null){
            throw new InvalidParameterException("name not exist");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/admin/students")
    public ResponseEntity SelectStudents(@RequestParam(value = "page",defaultValue = "0") int page,
                                         @RequestParam(value = "size",defaultValue = "20") int size){
        //计算数据库offset
        page = (page - 1)*size;
        List<StudentDO> list = studentService.selectStudents(page,size);
        return ResponseEntity.ok(list);

    }
}
