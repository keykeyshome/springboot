package com.xxxx.springboot.dao;

import com.xxxx.springboot.vo.User;


public interface UserDao {
    User queryUserByUserName(String userName);
}
