package com.vvv.zht.model;

import lombok.Data;

@Data
public class EnterpriseDO {
    Integer id;
    String enterpriseName;
    String introduction;
    String location;
    String account;
    String password;
    String phone;
    String email;
    String createTime;
}
