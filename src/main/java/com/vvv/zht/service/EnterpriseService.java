package com.vvv.zht.service;

import com.vvv.zht.model.EnterpriseDO;
import org.springframework.stereotype.Service;

@Service
public interface EnterpriseService {
    int addEnterprise(EnterpriseDO enterpriseDO);
}
