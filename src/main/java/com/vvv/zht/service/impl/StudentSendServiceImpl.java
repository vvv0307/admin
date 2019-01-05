package com.vvv.zht.service.impl;

import com.vvv.zht.dao.StudentSendMapper;
import com.vvv.zht.model.StudentSendingInfo;
import com.vvv.zht.service.StudentSendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentSendServiceImpl implements StudentSendService {

    @Resource
    private StudentSendMapper studentSendMapper;

    @Override
    public int addStudentSendInfo(int studentId, int positionId) {
        return studentSendMapper.addStudentSend(positionId,studentId);
    }

    @Override
    public int updateStatusById(int id) {
        return studentSendMapper.updateStatusById(id);
    }

    @Override
    public List<Integer> selectPositionIdsByStudentId(int studentId) {
        return studentSendMapper.selectPositionIdsByStudentId(studentId);
    }

    @Override
    public int selectStudentCountByPositionId(int positionId) {
        return studentSendMapper.selectStudentCountByPositionId(positionId);
    }

    @Override
    public List<Integer> selectStudentIdsByPositionId(int positionId) {
        return studentSendMapper.selectPositionIdsByStudentId(positionId);
    }

    @Override
    public List<StudentSendingInfo> selectStudentByPositionId(int positionId) {
        return studentSendMapper.selectSendInfoByPositionId(positionId);
    }
}
