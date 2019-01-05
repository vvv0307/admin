package com.vvv.zht.controller;


import com.vvv.zht.Exception.ResponseExceptions.ResponseNotOkExcetpion;
import com.vvv.zht.model.PositionDO;
import com.vvv.zht.service.PositionService;
import com.vvv.zht.service.StudentSendService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private StudentSendService studentSendService;


    @PostMapping("/admin/position/add")
    public ResponseEntity addPosition(@RequestParam("enterpriseId") int enterpriseId,
                                      @RequestParam("jobInfo") String jobInfo,
                                      @RequestParam("salary") String salary,
                                      @RequestParam("requirement") String requirement){
        //TODO need param check
        PositionDO positionDO = new PositionDO();
        positionDO.setEnterpriseId(enterpriseId);
        positionDO.setJobInfo(jobInfo);
        positionDO.setRequirement(requirement);
        positionDO.setSalary(salary);
        int flag = positionService.addPosition(positionDO);
        if(flag<=0){
            throw new ResponseNotOkExcetpion("add position fail");
        }
        Map map = new HashMap(1);
        map.put("success",true);
        return ResponseEntity.ok(map);
    }


    @GetMapping("/admin/position")
    public ResponseEntity selectPositionById(@RequestParam("id") int id){
        return ResponseEntity.ok(positionService.selectPositionById(id));
    }

    @GetMapping("/admin/positions")
    public ResponseEntity selectPositionByEnterpriseId(@RequestParam("enterpriseId") int enterpriseId){
        return ResponseEntity.ok(positionService.selectPositionByEnterpriseId(enterpriseId));
    }

    @PostMapping("/admin/position/send")
    public ResponseEntity studentSend(@RequestParam("studentId") int studentId,
                                      @RequestParam("enterpriseId") int enterpriseId){
        //TODO need param check
        int flag = studentSendService.addStudentSendInfo(studentId,enterpriseId);
        if(flag<=0){
            throw  new ResponseNotOkExcetpion("toudi shibai");
        }
        Map map = new HashMap(1);
        map.put("success",true);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/admin/positions/all")
    public ResponseEntity selectPositions(@RequestParam("page") int page,
                                          @RequestParam("size") int size){

        //TODO param check
        List<PositionDO> list = positionService.selectPositions((page-1)*size,size);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/admin/positions/studentId")
    public ResponseEntity selectPositionsByStudentId(@RequestParam("studentId") int studentId){
        return ResponseEntity.ok(positionService.selectPositionsByStudentId(studentId));
    }

    @DeleteMapping("/admin/position/delete")
    public ResponseEntity deletePositionById(@RequestParam("id") int id){
        int flag = positionService.deletePositionById(id);
        if(flag <= 0){
            throw new ResponseNotOkExcetpion("delete position by id fail");
        }
        Map map = new HashMap(1);
        map.put("success",true);
        return ResponseEntity.ok(map);
    }

    @DeleteMapping("/admin/positions/delete")
    public ResponseEntity deletePositionsByEnterpriseId(@RequestParam("enterpriseId") int enterpriseId){
        int flag = positionService.deletePositionsByEnterpriseId(enterpriseId);
        if(flag <= 0){
            throw new ResponseNotOkExcetpion("delete fail");
        }
        Map map = new HashMap(1);
        map.put("success",true);
        return ResponseEntity.ok(map);
    }
}
