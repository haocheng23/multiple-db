package com.hc.util.multiple.db.mapper;

import com.hc.util.multiple.db.model.Dept;
import com.hc.util.multiple.db.model.DeptExample;
import java.util.List;

public interface DeptMapper {
    long countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);
}