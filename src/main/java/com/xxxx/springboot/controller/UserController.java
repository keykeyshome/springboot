package com.xxxx.springboot.controller;

import com.xxxx.springboot.exceptions.ParamException;
import com.xxxx.springboot.model.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xxxx.springboot.service.UserService;
import com.xxxx.springboot.vo.User;

@RestController
@Api(tags = "用户管理模块")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user/uname/{userName}")
    @ApiOperation(value = "用户模块-根据用户名查询用户",notes = "参数在路径上")
    public User queryUserByUserName(@PathVariable String userName) {
        return userService.queryUserByUserName(userName);
    }

    @GetMapping("user/{userId}")
    public User queryUserByUserId(@PathVariable Integer userId) {
        return userService.queryByUserId(userId);
    }

    @PutMapping("user")
    public ResultInfo saveUser(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.saveUser(user);

        } catch (ParamException paramException) {
            resultInfo.setCode(paramException.getCode());
            resultInfo.setMsg(paramException.getMsg());

        } catch (Exception e) {

            resultInfo.setCode(300);
            resultInfo.setMsg(e.getMessage());
        }
        return resultInfo;
    }


    @PostMapping("user")
    public ResultInfo updateUser(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.updateUser(user);

        } catch (ParamException paramException) {
            resultInfo.setCode(paramException.getCode());
            resultInfo.setMsg(paramException.getMsg());

        } catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg("用户更新失败");
        }
        return resultInfo;
    }

    @DeleteMapping("user/{id}")
    public ResultInfo updateUser(@PathVariable Integer id) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.delete(id);

        } catch (ParamException paramException) {
            resultInfo.setCode(paramException.getCode());
            resultInfo.setMsg(paramException.getMsg());

        } catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg("用户删除失败");
        }
        return resultInfo;
    }

}
