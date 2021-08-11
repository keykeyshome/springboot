package com.xxxx.springboot.dao;

import com.xxxx.springboot.query.UserQuery;
import com.xxxx.springboot.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User queryUserByUserName(String userName);

    User queryById(Integer id);

    int save(User user);

    int update(User user);

    int delete(Integer id);

    List<User> selectByParams(UserQuery userQuery);
}
