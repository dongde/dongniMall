package com.dongni.dongnimall;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.dongni.dongnimall.dao")
@ComponentScan(basePackages = {"com.dongni.dongnimall","org.n3r.idworker"})
public class DongniMallApplication {
    private static final Logger logger = LoggerFactory.getLogger(DongniMallApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DongniMallApplication.class, args);
    }
}
