package com.vvv.zht.service;

import com.vvv.zht.model.StudentDO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface StudentService {

    /**
     * 添加学生信息
     * @param name
     * @param age
     * @param school
     * @param location
     * @param workCity
     * @param desiredPosition
     * @param skill
     * @param major
     * @param phone
     * @return
     */
    Map addStudent(String name, int age, String school, String location, String workCity, String desiredPosition, String skill, String major, String phone);

    /**
     * 根据id查学生信息
     * @param id
     * @return
     */
    StudentDO selectStudentById(int id);

    /**
     * 根据名字查学生信息
     * @param name
     * @return
     */
    List<StudentDO> selectStudentByName(String name);

    /**
     * 分页查询全部学生信息
     * @param page
     * @param size
     * @return
     */
    List<StudentDO> selectStudents(int page,int size);
}
