package com.vvv.zht.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentSendMapper {

    @Insert("insert into student_sending_info(student_id,enterprise_id,status) values" +
            "(#{studentId},#{enterpriseId},0)")
    int addStudentSend(@Param("enterpriseId") int enterpriseId,
                       @Param("studentId") int studentId);

    @Update("update student_sending_info set status = 1 where id = #{id}")
    int updateStatusById(int id);
}
