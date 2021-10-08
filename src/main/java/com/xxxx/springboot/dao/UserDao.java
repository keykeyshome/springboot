package com.xxxx.springboot.dao;

import com.xxxx.springboot.query.UserQuery;
import com.xxxx.springboot.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/*1: 在Dao接口类上使用@Mapper，再通过xxxMapepr.xml里面的namespace接口地址，会动态生成这个dao接口的实现类对象并注入到spring容器中.但是在service接口中@Autowired时会出现红色波浪线提示找不到此Bean
2: @Repository声明一个dao接口的Bean，与启动类上的@MapperScan(“包名地址”)一起使用,也是动态生成Dao的Bean并且自动注入Spring容器中.
        总结使用：

@Mapper可单独使用，但是会有报错不影响正常运行
@Repository与@MapperScan一起使用.
@Mapper与@Repository一起使用

        */
//@Repository
@Mapper
public interface UserDao {
    User queryUserByUserName(String userName);

    User queryById(Integer id);

    int save(User user);

    int update(User user);

    int delete(Integer id);

    List<User> selectByParams(UserQuery userQuery);
}
