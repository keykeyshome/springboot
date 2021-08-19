package com.xxxx.springboot.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(description = "用户实体对象")
public class User implements Serializable {
    @ApiModelProperty(value = "用户id主键")
    private Integer id;
    @NotBlank(message = "用户名不可以为空")
    @ApiModelProperty(value = "用户名字")
    private String userName;
    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "用户密码不可以为空")
    @Length(min = 6, max = 10, message = "密码长度至少6位但不超过10位")
    private String userPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
