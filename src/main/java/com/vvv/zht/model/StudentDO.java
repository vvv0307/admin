package com.vvv.zht.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
public class StudentDO {
    Integer id;

    String name;

    Integer age;

    String school;

    String location;

    String workCity;

    String desiredPosition;

    String skill;

    String major;

    String account;

    String password;

    String phone;

    Date createTime;
}
