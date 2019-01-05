package com.vvv.zht.controller;


import com.vvv.zht.Exception.ResponseExceptions.CommonException;
import com.vvv.zht.Exception.ResponseExceptions.ResponseNotOkExcetpion;
import com.vvv.zht.model.EnterpriseDO;
import com.vvv.zht.model.StudentDO;
import com.vvv.zht.service.EnterpriseService;
import com.vvv.zht.service.StudentSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private StudentSendService studentSendService;

    @PostMapping("/admin/enterprise/add")
    public ResponseEntity addEnterprise(@RequestParam("enterpriseName") String enterpriseName,
                                        @RequestParam("introduction") String introduction,
                                        @RequestParam("location") String location,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("email") String email){
        EnterpriseDO enterpriseDO = new EnterpriseDO();
        String uuid = UUID.randomUUID().toString();
        String account = uuid.substring(0,15);
        String password = uuid.substring(16,31);
        enterpriseDO.setAccount(account);
        enterpriseDO.setPassword(password);
        enterpriseDO.setLocation(location);
        enterpriseDO.setEnterpriseName(enterpriseName);
        enterpriseDO.setEmail(email);
        enterpriseDO.setIntroduction(introduction);
        enterpriseDO.setPhone(phone);
        enterpriseService.addEnterprise(enterpriseDO);
        Map map = new HashMap(2);
        map.put("account",account);
        map.put("password",password);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/admin/enterprise/{id:\\d+}")
    public ResponseEntity selectEnterpriseById(@PathVariable("id") int id){
        return ResponseEntity.ok(enterpriseService.selectEnterpriseById(id));
    }

    @GetMapping("/admin/enterprise/{name}")
    public ResponseEntity selectEnterpriseByName(@PathVariable("name") String name){
        return ResponseEntity.ok(enterpriseService.selectEnterpriseByName(name));
    }

    @GetMapping("/admin/enterprise")
    public ResponseEntity selectEnterprise(@RequestParam("page") int page,
                                           @RequestParam("size") int size){

        //TODO need param check
        page = (page - 1)*size;
        return ResponseEntity.ok(enterpriseService.selectEnterprise(page,size));
    }


    @PostMapping("/admin/enterprise/update")
    public ResponseEntity updatePasswordByAccount(@RequestParam("account") String account,
                                                  @RequestParam("password") String password){
        int flag = enterpriseService.updatePasswordByAccount(account,password);
        if(flag<=0){
            throw new ResponseNotOkExcetpion("update password fail");
        }
        Map map = new HashMap(1);
        map.put("success",true);
        return ResponseEntity.ok(map);
    }

    @PostMapping("/admin/enterprise/pass")
    public ResponseEntity updateStatusById(@RequestParam("id") int id){
        int flag = studentSendService.updateStatusById(id);
        if(flag<=0){
            throw new ResponseNotOkExcetpion("pass fail");
        }
        Map map = new HashMap(1);
        map.put("success",true);
        return ResponseEntity.ok(map);
    }

}
