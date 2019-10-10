package com.hc.multiple.db.controller;

import com.hc.multiple.db.service.DeptService;
import com.hc.multiple.db.model.Dept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private DeptService deptService;


    @GetMapping("/getDept")
    public Dept getDept(){
        return deptService.getDept();
    }

    @GetMapping("/getDept1")
    public Dept getDept1(){
        return deptService.getDept1();
    }

    @GetMapping("/getDept2")
    public Dept getDept2(){
        return deptService.getDept2();
    }

}
