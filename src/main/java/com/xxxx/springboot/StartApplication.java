package com.xxxx.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author QJJ
 * @Date 2021-08-08 0:02
 */
@SpringBootApplication
//@MapperScan("com.xxxx.springboot.dao")
@EnableCaching
public class StartApplication {
    private static Logger logger = LoggerFactory.getLogger(StartApplication.class);

    public static void main(String[] args) {
//        logger.info("Springboot 启动");
        SpringApplication.run(StartApplication.class);
//启动不打印图标
        /*SpringApplication springApplication = new SpringApplication(StartApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);*/
    }
}
