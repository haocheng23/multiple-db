package com.hc.util.multiple.db.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.hc.util.multiple.db.DynamicDataSource;
import com.hc.util.multiple.db.DynamicDataSourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: haocheng
 * @Date: 2019-10-08 14:15
 */
@Configuration
public class DynamicDataSourceConfig {
    private static final String SPRING_DATASOURCE = "spring.datasource";
    private static final String CUSTOM_DATASOURCE = "custom.datasource";
    private static final String CUSTOM_DATASOURCE_NAMES = "names";
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public DynamicDataSourceConfig() {
    }

    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource(Environment env) {
        DynamicDataSource ds = new DynamicDataSource();
        DataSource defaultDataSource = this.initDefaultDataSource(env);
        ds.setDefaultTargetDataSource(defaultDataSource);
        Map<Object, Object> targetDataSources = this.initCustomDataSource(env);
        targetDataSources.put("default", defaultDataSource);
        ds.setTargetDataSources(targetDataSources);
        return ds;
    }


    /**
     * 初始化默认数据源
     *
     * @param env
     * @return
     */
    private DataSource initDefaultDataSource(Environment env) {
        String ds =  SPRING_DATASOURCE + ".";
        String url = env.getProperty(ds + URL);
        String username = env.getProperty(ds + USERNAME);
        String password = env.getProperty(ds + PASSWORD);
        return this.createDataSource(url, username, password);
    }


    /**
     * 初始化配置的数据源
     *
     * @param env
     * @return
     */
    private Map<Object, Object> initCustomDataSource(Environment env) {
        String prefix = env.getProperty(CUSTOM_DATASOURCE + "." + CUSTOM_DATASOURCE_NAMES);
        Map<Object, Object> targetDataSources = new HashMap();
        if (prefix != null) {
            String[] var4 = prefix.split(",");
            int var5 = var4.length;

            for(int i = 0; i < var5; ++i) {
                String name = var4[i];
                String ds = CUSTOM_DATASOURCE + "." + name + ".";
                String url = env.getProperty(ds + URL);
                String username = env.getProperty(ds + USERNAME);
                String password = env.getProperty(ds + PASSWORD);
                targetDataSources.put(name, this.createDataSource(url, username, password));
            }
        }

        return targetDataSources;
    }


    private DataSource createDataSource(String url, String username, String password) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


}
