package com.vvv.zht.service;


import com.vvv.zht.dao.StudentSendMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public interface StudentSendService {
    int addStudentSendInfo(int studentId,int enterpriseId);

    int updateStatusById(int id);
}
