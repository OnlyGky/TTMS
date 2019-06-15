package com.springboot.richttms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value = "com.springboot.richttms.mapper")
//开启事务支持
@EnableTransactionManagement
//@ComponentScan("com.springboot.richttms.service")
public class RichttmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RichttmsApplication.class, args);
        System.out.println("启动成功");
    }
}
