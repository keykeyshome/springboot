package com.xxxx.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxxx.springboot.StartApplication;
import com.xxxx.springboot.vo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sun.nio.cs.UTF_32;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author QJJ
 * @Date 2021-08-17 0:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
@AutoConfigureMockMvc
public class TestUserController {
    private Logger log = LoggerFactory.getLogger(TestUserController.class);
    @Resource
    private MockMvc mockMvc;

    @Before
    public void before() {
        log.info("单元测试开始");
    }

    @Test
    public void test01() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/uname/admin"))
                .andExpect(status().isOk())
                .andReturn();
        log.info("响应状态{}", mvcResult.getResponse().getStatus());
        log.info("响应内容{}", mvcResult.getResponse().getContentAsString());

    }

    //mock mvc 记得添加application/json; charset=utf-8 在mapping上，.andReturn()是返回整个mvcresult
    @Test
    public void test02() throws Exception {
        User u = new User();
        u.setId(4);
        u.setUserName("heisi");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(u)))
                .andExpect(status().isOk())
                .andReturn();
        log.info("响应内容{}", mvcResult.getResponse().getContentAsString());


    }

    @After
    public void after() {
        log.info("单元测试结束");
    }


}
