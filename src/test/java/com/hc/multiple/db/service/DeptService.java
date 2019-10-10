package com.hc.multiple.db.service;

import com.hc.multiple.db.util.DataSource;
import com.hc.multiple.db.dao.DeptDao;
import com.hc.multiple.db.model.Dept;
import com.hc.multiple.db.model.DeptExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeptService {

    @Resource
    private DeptDao deptDao;


    public Dept getDept(){
        DeptExample example = new DeptExample();
        example.createCriteria().andLeaderEqualTo("1006");
        return deptDao.getDept(example);
    }


    @DataSource("ds1")
    public Dept getDept1(){
        DeptExample example = new DeptExample();
        example.createCriteria().andLeaderEqualTo("1006");
        return deptDao.getDept(example);
    }


    @DataSource("ds2")
    public Dept getDept2(){
        DeptExample example = new DeptExample();
        example.createCriteria().andLeaderEqualTo("1006");
        return deptDao.getDept(example);
    }

}
