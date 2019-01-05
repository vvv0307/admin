package com.vvv.zht.dao;

import com.vvv.zht.model.PositionDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PositionMapper {


    @Insert("insert into position_info (enterprise_id,job_info,salary,requirement,create_time)" +
            "values(#{positionDO.enterpriseId},#{positionDO.jobInfo},#{positionDO.salary},#{positionDO.requirement}," +
            "NOW())")
    int addPosition(@Param("positionDO") PositionDO positionDO);

    @Select("select *from position_info where id = #{id}")
    PositionDO selectPositionById(@Param("id") int id);


    @Select("select * from position_info where enterprise_id = #{enterpriseId}")
    List<PositionDO> selectPositionByEnterpriseId(@Param("enterpriseId") int enterpriseId);

    @Select("select * from position_info limit #{page},#{size}")
    List<PositionDO> selectPositions(@Param("page") int page,
                                     @Param("size") int size);

    @Select("select * from student_sending_info where student_id = #{studentId}")
    List<PositionDO> selectPositionsByStudentId(@Param("studentId") int studentId);

    @Delete("delete from position_info where id = #{id}")
    int deletePositionById(@Param("id") int id);

    @Delete("delete from position_info where enterprise_id = #{enterpriseId}")
    int deletePositionByEnterpriseId(@Param("enterpriseId") int enterpriseId);

}
