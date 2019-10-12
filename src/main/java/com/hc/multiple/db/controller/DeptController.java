package com.hc.multiple.db.controller;

import com.hc.multiple.db.service.DeptService;
import com.hc.multiple.db.model.Dept;
import com.hc.multiple.db.util.paging.PageRequest;
import com.hc.multiple.db.util.paging.PageResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {

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


    @PostMapping("/get4Page")
    public List<Dept> get4Page(@RequestBody PageRequest pageRequest){
        return deptService.get4Page(pageRequest);
    }
}
