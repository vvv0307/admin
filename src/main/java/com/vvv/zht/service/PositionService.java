package com.vvv.zht.service;


import com.vvv.zht.model.PositionDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PositionService {

    int addPosition(PositionDO positionDO);

    PositionDO selectPositionById(int id);

    List<PositionDO> selectPositionByEnterpriseId(int id);

    List<PositionDO> selectPositions(int page,int size);

    int deletePositionById(int id);

    int deletePositionsByEnterpriseId(int enterpriseId);

    List<PositionDO> selectPositionsByStudentId(int id);

}
