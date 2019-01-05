package com.vvv.zht.dao;


import com.vvv.zht.model.StudentSendingInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentSendMapper {

    @Insert("insert into student_sending_info(student_id,position_id,status) values" +
            "(#{studentId},#{positionId},0)")
    int addStudentSend(@Param("positionId") int positionId,
                       @Param("studentId") int studentId);

    @Update("update student_sending_info set status = 1 where id = #{id}")
    int updateStatusById(int id);

    @Select("select position_id from student_sending_info where student_id = #{studentId}")
    List<Integer> selectPositionIdsByStudentId(@Param("studentId") int studentId);

    @Select("select count(student_id) from student_sending_info where position_id = #{positionId}")
    int selectStudentCountByPositionId(@Param("positionId") int positionId);

    @Select("select student_id from student_sending_info where position_id = #{positionId}")
    List<Integer> selectStudentIdByPositionId(@Param("positionId") int positionId);

    @Select("select * from student_sending_info where position_id = #{positionId}")
    List<StudentSendingInfo> selectSendInfoByPositionId(@Param("positionId") int positionId);
}
