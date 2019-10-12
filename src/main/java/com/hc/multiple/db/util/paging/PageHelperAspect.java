package com.hc.multiple.db.util.paging;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Aop处理PageHelper分页的模板代码
 *
 * @Author: haocheng
 * @Date: 2019-10-11 09:17
 */
@Aspect
@Component
@Slf4j
public class PageHelperAspect {


    @Pointcut("execution(public * com.hc.multiple.db.service.*.*Page(..))")
    public void serviceFindFunction(){}

    @Around("serviceFindFunction()")
    public Object serviceImplAop(ProceedingJoinPoint point) throws Throwable {
        log.info("进入PageHelper AOP");
        Object[] args = point.getArgs();
        PageRequest page = (PageRequest) args[0];

        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());

        log.info("分页方法---[{}]---开始执行...", point.getSignature().getName());
        Object object = point.proceed();
        log.info("分页方法---[{}]---执行结束...", point.getSignature().getName());

        if (object instanceof List){
            List objList = (List) object;
            //创建分页信息
            PageInfo pageInfo = new PageInfo<>(objList);
            //封装分页结果
            PageResult pageResult = new PageResult(pageInfo.getTotal(), objList);
            return Arrays.asList(pageResult);
        }
        return object;
    }
}
