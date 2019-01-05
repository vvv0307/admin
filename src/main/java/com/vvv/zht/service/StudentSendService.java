package com.vvv.zht.service;


import com.vvv.zht.dao.StudentSendMapper;
import com.vvv.zht.model.StudentSendingInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface StudentSendService {
    int addStudentSendInfo(int studentId,int positionId);

    int updateStatusById(int id);

    List<Integer> selectPositionIdsByStudentId(int studentId);

    int selectStudentCountByPositionId(int positionId);

    List<Integer> selectStudentIdsByPositionId(int positionId);

    List<StudentSendingInfo> selectStudentByPositionId(int positionId);
}
