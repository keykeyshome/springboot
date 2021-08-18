package com.xxxx.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.springboot.query.UserQuery;
import com.xxxx.springboot.untils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.xxxx.springboot.dao.UserDao;
import com.xxxx.springboot.vo.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Cacheable(value = "users", key = "#userName")
    public User queryUserByUserName(String userName) {
        return userDao.queryUserByUserName(userName);

    }

    @Cacheable(value = "users", key = "#userId")
    public User queryByUserId(int userId) {
        return userDao.queryById(userId);

    }

    public void saveUser(User user) {
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()), "密码不能为空");
        AssertUtil.isTrue(null != userDao.queryUserByUserName(user.getUserName()), "用户已经存在");
        AssertUtil.isTrue(userDao.save(user) < 1, "用户添加失败");
    }

    @CacheEvict(value = "users", key = "#user.id")
    public void updateUser(User user) {
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()), "密码不能为空");
        AssertUtil.isTrue(null == userDao.queryById(user.getId()), "用户不存在");
        //用户名唯一校验
        User temp = userDao.queryUserByUserName(user.getUserName());
        AssertUtil.isTrue(null != temp && !(temp.getId().equals(user.getId())), "用户已经存在");
        AssertUtil.isTrue(userDao.update(user) < 1, "用户更新失败");


    }

    @CacheEvict(value = "users", allEntries = true)
    public void delete(Integer userId) {
        AssertUtil.isTrue(null == userId || null == userDao.queryById(userId), "该用户不存在");
        AssertUtil.isTrue(userDao.delete(userId) < 1, "用户删除失败");

    }

    @Cacheable(value = "users", key = "#userQuery.userName+'-'+#userQuery.pageNum+'-'+#userQuery.pageSize")
    public PageInfo<User> queryByParams(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        List<User> users = userDao.selectByParams(userQuery);
        return new PageInfo<User>(users);

    }

}
