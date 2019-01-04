package com.vvv.zht.dao;


import com.vvv.zht.model.EnterpriseDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EnterpriseMapper {

    @Insert("insert into enterprise_info (enterprise_name,introduction,location,account,password,phone,email,create_time) " +
            "values(#{enterpriseDO.enterpriseName},#{enterpriseDO.introduction},#{enterpriseDO.location},#{enterpriseDO.account}," +
            "#{enterpriseDO.password},#{enterpriseDO.phone},#{enterpriseDO.email},DATE())")
    int addEnterprise(EnterpriseDO enterpriseDO);

    @Select("select * from enterprise_info where id = #{id}")
    EnterpriseDO selectEnterpriseById(@Param("id") int id);

    @Select("select * from enterprise_info where enterprise_name = #{name}")
    List<EnterpriseDO> selectEnterpriseByName(@Param("name") String name);
}
