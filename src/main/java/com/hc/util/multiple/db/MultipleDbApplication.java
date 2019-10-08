package com.hc.util.multiple.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DynamicDataSourceAspect.class})
@MapperScan("com.hc.util.multiple.db.mapper")
public class MultipleDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDbApplication.class, args);
    }

}
