package com.vvv.zht.controller;


import com.vvv.zht.exception.ResponseExceptions.ResponseNotOkExcetpion;
import com.vvv.zht.model.EnterpriseDO;
import com.vvv.zht.model.StudentDO;
import com.vvv.zht.service.EnterpriseService;
import com.vvv.zht.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/admin/login")
    public ResponseEntity login(@RequestParam("account") String account,
                                @RequestParam("password") String password,
                                @RequestParam("role") int role) {
        if (role == 1) {
            StudentDO studentDO = studentService.selectStudentByAccount(account);
            if (studentDO == null) {
                throw new ResponseNotOkExcetpion("account not exist");
            }
            if (!password.equals(studentDO.getPassword())) {
                throw new ResponseNotOkExcetpion("password error");
            }
            return ResponseEntity.ok("success");
        } else if (role == 2) {
            EnterpriseDO enterpriseDO = enterpriseService.selectEnterpriseByAccount(account);
            if (enterpriseDO == null) {
                throw new ResponseNotOkExcetpion("account not exist");
            }
            if (!password.equals(enterpriseDO.getPassword())) {
                throw new ResponseNotOkExcetpion("password error");
            }
            return ResponseEntity.ok("success");
        } else if (role == 3) {
            return ResponseEntity.ok("success");
        }else{
            throw new ResponseNotOkExcetpion("role error");
        }
    }
}
