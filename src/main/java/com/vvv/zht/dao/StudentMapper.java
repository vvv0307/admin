package com.vvv.zht.dao;


import com.vvv.zht.model.StudentDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("insert into student_info(name,age,school,location,work_city,desired_position,skill,major,account,password,phone) " +
            "values(#{studentDo.name},#{studentDo.age},#{studentDo.school},#{studentDo.location},#{studentDo.workCity},#{studentDo.desiredPOsition}," +
            "#{studentDo.skill},#{studentDo.major},#{studentDo.account},#{studentDo.password},#{studentDo.phone})")
    void addStudent(StudentDO studentDo);


    @Select("select * from student_info where id = #{id}")
    StudentDO selectStudentById(@Param("id") int id);

    @Select("select *from student_info where name = #{name}")
    List<StudentDO> selectStudentByName(@Param("name") String name);

    @Select("select *from student_info limit #{page},#{size}")
    List<StudentDO> selectStudent(@Param("page") int page,
                                  @Param("size") int size);
}
