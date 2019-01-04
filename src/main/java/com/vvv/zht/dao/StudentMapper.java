package com.vvv.zht.dao;


import com.vvv.zht.model.StudentDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("insert into student_info(name,age,school,location,work_city,desired_position,skill,major,account,password,phone,create_time) " +
            "values(#{studentDo.name},#{studentDo.age},#{studentDo.school},#{studentDo.location},#{studentDo.workCity},#{studentDo.desiredPOsition}," +
            "#{studentDo.skill},#{studentDo.major},#{studentDo.account},#{studentDo.password},#{studentDo.phone},DATE())")
    void addStudent(StudentDO studentDo);


    @Select("select * from student_info where id = #{id}")
    StudentDO selectStudentById(@Param("id") int id);

    @Select("select *from student_info where name = #{name}")
    List<StudentDO> selectStudentByName(@Param("name") String name);

    @Select("select *from student_info limit #{page},#{size}")
    List<StudentDO> selectStudent(@Param("page") int page,
                                  @Param("size") int size);

    @Select("select * from student_info where account = #{account}")
    StudentDO selectStudentByAccount(@Param("account") String account);

    @Update("update student_info set password = #{password} where account = #{account}")
    int updatePasswordByAccount(@Param("account") String account,
                                @Param("password") String password);
}
