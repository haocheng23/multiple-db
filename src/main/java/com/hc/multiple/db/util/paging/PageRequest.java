package com.hc.multiple.db.util.paging;

import lombok.Data;

/**
 * 分页查询请求封装类
 *
 * @Author: haocheng
 * @Date: 2019-10-10 15:48
 */
@Data
public class PageRequest {

    /**
     * 当前页码
     */
    private int pageNum;

    /**
     * 每页数量
     */
    private int pageSize;


}
