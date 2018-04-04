package com.lxy.account;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * springboot 入口
 *
 * @author liuxingyue
 * @date 2018-04-04
 */
@SpringBootApplication
@MapperScan("com.lxy.account.mapper")
public class Application {

    /**
     * springboot 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

