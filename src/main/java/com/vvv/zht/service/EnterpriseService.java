package com.vvv.zht.service;

import com.vvv.zht.model.EnterpriseDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnterpriseService {
    int addEnterprise(EnterpriseDO enterpriseDO);

    EnterpriseDO selectEnterpriseById(int id);

    List<EnterpriseDO> selectEnterpriseByName(String name);

    List<EnterpriseDO> selectEnterprise(int page,int size);

    EnterpriseDO selectEnterpriseByAccount(String account);

    int updatePasswordByAccount(String account,String password);
}
