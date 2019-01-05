package com.vvv.zht.dao;

import com.vvv.zht.model.PositionDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PositionMapper {


    @Insert("insert into position_info (enterprise_id,job_info,salary,requirement,create_time)" +
            "values(#{positionDO.enterpriseId},#{positionDO.jobInfo},#{positionDO.salary},#{positionDO.requirement}," +
            "DATE())")
    int addPosition(@Param("positionDO") PositionDO positionDO);

    @Select("select *from position_info where id = #{id}")
    PositionDO selectPositionById(@Param("id") int id);


    @Select("select * from position_info where enterprise_id = #{enterpriseId}")
    List<PositionDO> selectPositionByEnterpriseId(@Param("enterpriseId") int enterpriseId);
}
