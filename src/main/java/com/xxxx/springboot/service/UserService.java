package com.xxxx.springboot.service;

import com.xxxx.springboot.untils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
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

    public User queryByUserId(int userId) {
        return userDao.queryById(userId);

    }

    public void saveUser(User user) {
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()), "密码不能为空");
        AssertUtil.isTrue(null != userDao.queryUserByUserName(user.getUserName()), "用户已经存在");
        AssertUtil.isTrue(userDao.save(user) < 1, "用户添加失败");
    }

    public void updateUser(User user) {
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()), "密码不能为空");
        AssertUtil.isTrue(null == userDao.queryById(user.getId()), "用户不存在");
        AssertUtil.isTrue(userDao.update(user) < 1, "用户更新失败");
        //用户名唯一校验
        User temp = userDao.queryUserByUserName(user.getUserName());
        AssertUtil.isTrue(null != temp && !temp.getId().equals(user.getId()), "用户已经存在");
        AssertUtil.isTrue(userDao.update(user) < 1, "用户更新失败");


    }

    public void delete(Integer userId) {
        AssertUtil.isTrue(null != userId || null == userDao.queryById(userId), "该用户不存在");
        AssertUtil.isTrue(userDao.delete(userId) < 1, "用户删除失败");

    }

}
