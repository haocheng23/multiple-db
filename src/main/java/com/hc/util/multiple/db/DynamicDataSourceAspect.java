package com.hc.util.multiple.db;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: haocheng
 * @Date: 2019-10-08 14:13
 */
@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Component
@Slf4j
public class DynamicDataSourceAspect {

    public DynamicDataSourceAspect() {
    }

    @Before("@annotation(ds)")
    public void change(JoinPoint point, DataSource ds) {
        log.debug("Use DataSource : {} -----> {}", ds.value(), point.getSignature());
        DynamicDataSource.setDataSource(ds.value());
        String s = DynamicDataSource.dynamicHolder.get();
        log.debug(s);
    }

    @After("@annotation(ds)")
    public void clear(JoinPoint point, DataSource ds) {
        log.debug("Revert DataSource : {} -----> {}", ds.value(), point.getSignature());
        DynamicDataSource.reset();

        String s = DynamicDataSource.dynamicHolder.get();
        log.debug(s);
    }
}
