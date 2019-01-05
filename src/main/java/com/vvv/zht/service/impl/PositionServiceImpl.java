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
}
