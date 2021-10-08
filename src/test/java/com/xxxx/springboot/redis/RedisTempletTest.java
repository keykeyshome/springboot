package com.xxxx.springboot.redis;


import com.xxxx.springboot.StartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class RedisTempletTest {
    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void Test1(){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("name","sw");

    }

}
