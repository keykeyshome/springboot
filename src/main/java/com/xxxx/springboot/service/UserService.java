package com.xxxx.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxxx.springboot.dao.UserDao;
import com.xxxx.springboot.vo.User;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User queryUserByUserName(String userName) {
        return userDao.queryUserByUserName(userName);

    }
}
