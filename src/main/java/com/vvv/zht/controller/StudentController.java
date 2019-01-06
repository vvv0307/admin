package com.vvv.zht.controller;


import com.vvv.zht.exception.ResponseExceptions.ResponseNotOkExcetpion;
import com.vvv.zht.model.PositionDO;
import com.vvv.zht.model.StudentDO;
import com.vvv.zht.model.StudentPositionVO;
import com.vvv.zht.service.PositionService;
import com.vvv.zht.service.StudentSendService;
import com.vvv.zht.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentSendService studentSendService;
    @Autowired
    private PositionService positionService;


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


    @GetMapping("/admin/student")
    public ResponseEntity SelectStudentById(@RequestParam("id") int id){
        StudentDO studentDO = studentService.selectStudentById(id);
        if(studentDO == null){
            throw new InvalidParameterException("id not exist");
        }
        return ResponseEntity.ok(studentDO);
    }

    @GetMapping("admin/student/name")
    public ResponseEntity SelectStudentByName(@RequestParam("name") String name){
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

    @PostMapping("/admin/student/password/update")
    public ResponseEntity UpdatePasswordByAccount(@RequestParam("account") String account,
                                                  @RequestParam("password") String password){
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            throw new ResponseNotOkExcetpion("参数不能为空");
        }
        StudentDO studentDO = studentService.selectStudentByAccount(account);
        if(studentDO == null){
            throw new ResponseNotOkExcetpion("账号不存在，请检查后重新输入");
        }
        Map map = new HashMap(1);
        map.put("success",studentService.UpdateStudentByAccount(account,password));
        return ResponseEntity.ok(map);
    }

    @DeleteMapping("/admin/student/delete")
    public ResponseEntity deleteStudentById(@RequestParam("id") int id){
        int flag = studentService.deleteStudentById(id);
        if(flag <= 0){
            throw new ResponseNotOkExcetpion("delete student fail");
        }
        Map map = new HashMap(1);
        map.put("success",true);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/admin/student/positions")
    public ResponseEntity selectPositionSendByStudentId(@RequestParam("studentId") int studentId){
        List<Integer> list = studentSendService.selectPositionIdsByStudentId(studentId);
        logger.info("ids list = {}",list);
        List<StudentPositionVO> positionlist = new ArrayList<>();
        for(Integer id: list){
            PositionDO positionDO = positionService.selectPositionById(id);
            logger.info("id = {},positionDO = {}",id,positionDO);
            StudentPositionVO vo = new StudentPositionVO();
            vo.setPositionDO(positionDO);
            positionlist.add(vo);
        }
        return ResponseEntity.ok(positionlist);
    }

}
