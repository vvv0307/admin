package com.vvv.zht.service.impl;

import com.vvv.zht.dao.PositionMapper;
import com.vvv.zht.model.PositionDO;
import com.vvv.zht.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;
    @Override
    public int addPosition(PositionDO positionDO) {
        return positionMapper.addPosition(positionDO);
    }

    @Override
    public PositionDO selectPositionById(int id) {
        return positionMapper.selectPositionById(id);
    }

    @Override
    public List<PositionDO> selectPositionByEnterpriseId(int id) {
        return positionMapper.selectPositionByEnterpriseId(id);
    }

    @Override
    public List<PositionDO> selectPositions(int page, int size) {
        return positionMapper.selectPositions(page,size);
    }

    @Override
    public int deletePositionById(int id) {
        return positionMapper.deletePositionById(id);
    }

    @Override
    public int deletePositionsByEnterpriseId(int enterpriseId) {
        return positionMapper.deletePositionByEnterpriseId(enterpriseId);
    }

    @Override
    public List<PositionDO> selectPositionsByStudentId(int id) {
        return positionMapper.selectPositionsByStudentId(id);
    }


}
