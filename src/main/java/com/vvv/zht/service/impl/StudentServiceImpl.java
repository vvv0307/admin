package com.vvv.zht.service.impl;

import com.vvv.zht.dao.StudentMapper;
import com.vvv.zht.model.StudentDO;
import com.vvv.zht.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;


    @Override
    public Map addStudent(String name, int age, String school, String location, String workCity, String desiredPosition, String skill, String major, String phone) {
        String uuid = UUID.randomUUID().toString();
        String account = uuid.substring(0,16);
        String password = uuid.substring(16,32);
        StudentDO studentDO = new StudentDO();
        studentDO.setAccount(account);
        studentDO.setPassword(password);
        studentDO.setName(name);
        studentDO.setAge(age);
        studentDO.setSchool(school);
        studentDO.setWorkCity(workCity);
        studentDO.setLocation(location);
        studentDO.setDesiredPosition(desiredPosition);
        studentDO.setSkill(skill);
        studentDO.setMajor(major);
        studentDO.setPhone(phone);
        studentMapper.addStudent(studentDO);
        Map map = new HashMap(2);
        map.put("account",account);
        map.put("password",password);
        return map;
    }

    @Override
    public StudentDO selectStudentById(int id) {
        return studentMapper.selectStudentById(id);
    }

    @Override
    public List<StudentDO> selectStudentByName(String name) {
        return studentMapper.selectStudentByName(name);
    }

    @Override
    public List<StudentDO> selectStudents(int page,int size) {
        return studentMapper.selectStudent(page,size);
    }

    @Override
    public StudentDO selectStudentByAccount(String account) {
        return studentMapper.selectStudentByAccount(account);
    }

    @Override
    public int UpdateStudentByAccount(String account, String password) {
        return studentMapper.updatePasswordByAccount(account,password);
    }

    @Override
    public int deleteStudentById(int id) {
        return studentMapper.deleteStudentById(id);
    }
}
