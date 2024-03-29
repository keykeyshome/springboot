package com.xxxx.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.xxxx.springboot.exceptions.ParamException;
import com.xxxx.springboot.model.ResultInfo;
import com.xxxx.springboot.query.UserQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.xxxx.springboot.service.UserService;
import com.xxxx.springboot.vo.User;

import javax.validation.Valid;

@RestController
@Api(tags = "用户管理模块")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user/uname/{userName}")
    @ApiOperation(value = "用户模块-根据用户名查询用户")
    @ApiImplicitParam(name = "userName",value = "查询参数",required = true,paramType = "path")
    public User queryUserByUserName(@PathVariable String userName) {
        return userService.queryUserByUserName(userName);
    }

    @GetMapping("user/{userId}")
    @ApiOperation(value = "用户模块-根据用户ID询用户")
    @ApiImplicitParam(name = "userId",value = "查询参数",required = true,paramType = "path")
    public User queryUserByUserId(@PathVariable Integer userId) {
        return userService.queryByUserId(userId);
    }

    @PutMapping("user")

    @ApiOperation(value = "用户模块-添加用户")
    @ApiImplicitParam(name = "user",value = "用户实体类",required = true,dataType = "User")
    public ResultInfo saveUser(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();
        //添加全局异常处理后可以不用捕捉异常

     /*   try {
            userService.saveUser(user);

        } catch (ParamException paramException) {
            resultInfo.setCode(paramException.getCode());
            resultInfo.setMsg(paramException.getMsg());

        } catch (Exception e) {

            resultInfo.setCode(300);
            resultInfo.setMsg(e.getMessage());
        }*/
        userService.saveUser(user);

        return resultInfo;
    }


    @PostMapping(value = "user", produces = "application/json; charset=utf-8")
    @ApiOperation(value = "用户模块-更新用户")
    @ApiImplicitParam(name = "user",value = "用户实体类",required = true,dataType = "User")
    public ResultInfo updateUser(@RequestBody @Valid User user) {
        ResultInfo resultInfo = new ResultInfo();
        //添加全局异常处理后可以不用捕捉异常
       /* try {
            userService.updateUser(user);

        } catch (ParamException paramException) {
            resultInfo.setCode(paramException.getCode());
            resultInfo.setMsg(paramException.getMsg());

        } catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg("用户更新失败");
        }*/
        userService.updateUser(user);

        return resultInfo;
    }

    @DeleteMapping("user/{id}")
    @ApiOperation(value = "用户模块-用户删除")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "path")
    public ResultInfo updateUser(@PathVariable Integer id) {
        ResultInfo resultInfo = new ResultInfo();
        //添加全局异常处理后可以不用捕捉异常

      /*  try {
            userService.delete(id);

        } catch (ParamException paramException) {
            resultInfo.setCode(paramException.getCode());
            resultInfo.setMsg(paramException.getMsg());

        } catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg(e.getMessage());
        }*/
        userService.delete(id);
        return resultInfo;
    }

    @GetMapping("user/list")
    @ApiOperation(value = "用户模块-用户列表查询")
    public PageInfo<User> queryUserByParams(UserQuery userQuery){
        return userService.queryByParams(userQuery);
    }

}
