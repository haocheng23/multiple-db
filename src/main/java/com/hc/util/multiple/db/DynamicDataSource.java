package com.hc.util.multiple.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: haocheng
 * @Date: 2019-10-08 11:46
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    public static final ThreadLocal<String> dynamicHolder = new ThreadLocal();

    public DynamicDataSource() {
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dynamicHolder.get();
    }

    public static void setDataSource(String datasource) {
        dynamicHolder.set(datasource);
    }

    public static void reset() {
        dynamicHolder.remove();
    }


}
