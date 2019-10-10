package com.hc.multiple.db;

import com.hc.multiple.db.util.DynamicDataSourceAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DynamicDataSourceAspect.class})
@MapperScan("com.hc.multiple.db.mapper")
public class MultipleDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDbApplication.class, args);
    }

}
