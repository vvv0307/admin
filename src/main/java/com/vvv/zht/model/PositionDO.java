package com.vvv.zht.model;

import lombok.Data;

import java.sql.Date;


@Data
public class PositionDO {

    Integer id;

    Integer enterpriseId;

    String jobInfo;

    String salary;

    String requirement;

    Date createTime;

}
