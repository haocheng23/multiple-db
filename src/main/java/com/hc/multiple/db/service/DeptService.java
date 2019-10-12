package com.hc.multiple.db.service;

import com.hc.multiple.db.util.DataSource;
import com.hc.multiple.db.dao.DeptDao;
import com.hc.multiple.db.model.Dept;
import com.hc.multiple.db.model.DeptExample;
import com.hc.multiple.db.util.paging.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: haocheng
 * @Date: 2019-10-12 13:56
 */
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


    public List<Dept> get4Page(PageRequest pageRequest) {
        List<Dept> deptList = deptDao.get4Page();
        return deptList;
    }

}
