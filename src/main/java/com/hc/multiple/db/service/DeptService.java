package com.hc.multiple.db.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.multiple.db.util.DataSource;
import com.hc.multiple.db.dao.DeptDao;
import com.hc.multiple.db.model.Dept;
import com.hc.multiple.db.model.DeptExample;
import com.hc.multiple.db.util.paging.PageRequest;
import com.hc.multiple.db.util.paging.PageResult;
import com.hc.multiple.db.util.paging.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public PageResult get4Page(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();

        List<Dept> deptList;
        try {
            PageHelper.startPage(pageNum, pageSize);
            deptList = deptDao.get4Page();
        } finally {
            PageHelper.clearPage();
        }
        PageInfo<Dept> pageInfo = new PageInfo<>(deptList);
        return PageUtils.getPageResult(pageRequest, pageInfo);
    }

}
