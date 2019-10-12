package com.hc.multiple.db.util.paging;

import lombok.Data;

import java.util.List;

/**
 * 分页查询结果封装类
 *
 * @Author: haocheng
 * @Date: 2019-10-10 15:50
 */
@Data
public class PageResult<T> {

//    当前页码
//    private int pageNum;

//    每页数量
//    private int pageSize;

//    页码总数
//    private int totalPages;

    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 数据集
     */
    private List<T> content;

    public PageResult(){
    }

    public PageResult(Long totalSize, List<T> content) {
        this.totalSize = totalSize;
        this.content = content;
    }

}
