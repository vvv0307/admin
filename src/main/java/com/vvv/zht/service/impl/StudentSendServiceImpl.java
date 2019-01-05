package com.vvv.zht.service.impl;

import com.vvv.zht.dao.StudentSendMapper;
import com.vvv.zht.service.StudentSendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentSendServiceImpl implements StudentSendService {

    @Resource
    private StudentSendMapper studentSendMapper;

    @Override
    public int addStudentSendInfo(int studentId, int enterpriseId) {
        return studentSendMapper.addStudentSend(enterpriseId,studentId);
    }

    @Override
    public int updateStatusById(int id) {
        return studentSendMapper.updateStatusById(id);
    }
}
