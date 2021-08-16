package com.xxxx.springboot.service;

import com.xxxx.springboot.StartApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author QJJ
 * @Date 2021-08-16 23:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class TestUserService {
    private Logger log = LoggerFactory.getLogger(TestUserService.class);
    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        userService.queryByUserId(10);
        log.info("用户记录{}",userService.queryByUserId(1));
    }

    @Test
    public void test02(){
        userService.queryByUserId(10);
        log.info("用户记录{}",userService.queryUserByUserName("swsw"));
    }

    @Before
    public void before() {
        log.info("单元测试开始");
    }



    @After
    public void after() {
        log.info("单元测试结束");
    }
}
