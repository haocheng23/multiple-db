package com.hc.multiple.db.mapper;

import com.hc.multiple.db.model.Dept;
import com.hc.multiple.db.model.DeptExample;
import com.hc.multiple.db.util.paging.PageRequest;

import java.util.List;

public interface DeptMapper {
    long countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);

    /**
     * 分页查询
     * @return
     */
    List<Dept> get4Page();
}