package com.vvv.zht.service.impl;

import com.vvv.zht.dao.EnterpriseMapper;
import com.vvv.zht.model.EnterpriseDO;
import com.vvv.zht.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public int addEnterprise(EnterpriseDO enterpriseDO) {
        return enterpriseMapper.addEnterprise(enterpriseDO);
    }

    @Override
    public EnterpriseDO selectEnterpriseById(int id) {
        return enterpriseMapper.selectEnterpriseById(id);
    }

    @Override
    public List<EnterpriseDO> selectEnterpriseByName(String name) {
        return enterpriseMapper.selectEnterpriseByName(name);
    }

    @Override
    public List<EnterpriseDO> selectEnterprise(int page, int size) {
        return enterpriseMapper.selectEnterprise(page,size);
    }

    @Override
    public EnterpriseDO selectEnterpriseByAccount(String account) {
        return selectEnterpriseByAccount(account);
    }

    @Override
    public int updatePasswordByAccount(String account,String password) {
        return enterpriseMapper.upatePasswordByAccount(account,password);
    }

    @Override
    public int deleteEnterpriseById(int id) {
        return enterpriseMapper.deleteEnterpriseById(id);
    }
}
