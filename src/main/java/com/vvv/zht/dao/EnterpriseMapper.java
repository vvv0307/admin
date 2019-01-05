package com.vvv.zht.dao;


import com.vvv.zht.model.EnterpriseDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnterpriseMapper {

    @Insert("insert into enterprise_info (enterprise_name,introduction,location,account,password,phone,email,create_time) " +
            "values(#{enterpriseDO.enterpriseName},#{enterpriseDO.introduction},#{enterpriseDO.location},#{enterpriseDO.account}," +
            "#{enterpriseDO.password},#{enterpriseDO.phone},#{enterpriseDO.email},NOW())")
    int addEnterprise(@Param("enterpriseDO") EnterpriseDO enterpriseDO);

    @Select("select * from enterprise_info where id = #{id}")
    EnterpriseDO selectEnterpriseById(@Param("id") int id);

    @Select("select * from enterprise_info where enterprise_name = #{name}")
    List<EnterpriseDO> selectEnterpriseByName(@Param("name") String name);

    @Select("select * from enterprise_info limit #{page},#{size}")
    List<EnterpriseDO> selectEnterprise(@Param("page") int page,
                                        @Param("size") int size);

    @Select("select * from enterprise_info where account = #{account}")
    EnterpriseDO selectEnterpriseByAccount(@Param("account") String account);


    @Update("update enterprise_info set password = #{password} where account = #{account}")
    int upatePasswordByAccount(@Param("account") String account,
                               @Param("password") String password);


    @Delete("delete from enterprise_info where id = #{id}")
    int deleteEnterpriseById(@Param("id") int id);

}
