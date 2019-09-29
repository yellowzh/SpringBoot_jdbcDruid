package com.lnsf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = "com.lnsf")
@EnableAsync //开启异步调用
@MapperScan("com.lnsf.dao")
public class druidStartTest {
    public static void main(String[] args){
        SpringApplication.run(druidStartTest.class);
    }
}
