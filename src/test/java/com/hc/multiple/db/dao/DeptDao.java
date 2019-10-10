package com.hc.multiple.db.dao;

import com.hc.multiple.db.model.Dept;
import com.hc.multiple.db.model.DeptExample;
import com.hc.multiple.db.mapper.DeptMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DeptDao {
    @Resource
    private DeptMapper mapper;

    public Dept getDept(DeptExample example){
        List<Dept> depts = mapper.selectByExample(example);
        return depts.get(0);
    }
}
