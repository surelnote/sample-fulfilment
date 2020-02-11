package com.nuri.lguplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.nuri.lguplus.repository.mybatis")
public class FulfilmentApplication {

    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(FulfilmentApplication.class, args);
    }
}

