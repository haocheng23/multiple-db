package com.hc.multiple.db.util.paging;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页查询相关工具类
 *
 * @Author: haocheng
 * @Date: 2019-10-10 15:52
 */
public class PageUtils {

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest   分页请求对象
     * @param list  查询结果
     * @return
     */
    public static PageInfo<?> getPageInfo(PageRequest pageRequest, List list){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
//        （排序字段 空格 排序方式）（注意：都是数据库中的字段，不是实体pojo的）
//        String orderBy = "sort asc";
//        String orderBy = "sort asc,sort2 desc";
//        PageHelper.startPage(pageNum, pageSize, orderBy);
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(list);
    }


    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageRequest   分页请求
     * @param pageInfo  分页信息
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }



}
