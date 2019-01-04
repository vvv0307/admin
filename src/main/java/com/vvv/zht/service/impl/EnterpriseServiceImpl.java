package com.vvv.zht.service.impl;

import com.vvv.zht.dao.EnterpriseMapper;
import com.vvv.zht.model.EnterpriseDO;
import com.vvv.zht.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public int addEnterprise(EnterpriseDO enterpriseDO) {
        return enterpriseMapper.addEnterprise(enterpriseDO);
    }
}
