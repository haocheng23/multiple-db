package com.hc.multiple.db.util.paging;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询请求封装类
 *
 * @Author: haocheng
 * @Date: 2019-10-10 15:48
 */
@Data
public class PageRequest implements Serializable {

    /**
     * 当前页码
     */
    private int pageNum = 1;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    /**
     * 排序的字段及顺序
     */
    private String orderBy;



}
