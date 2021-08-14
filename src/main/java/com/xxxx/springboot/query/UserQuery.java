package com.xxxx.springboot.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author QJJ
 * @Date 2021-08-10 23:23
 */
@ApiModel(description = "用户模块条件查询")
public class UserQuery {
    @ApiModelProperty(value = "分页码",example = "1")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "每页大小",example = "10")
    private Integer pageSize = 10;
    @ApiModelProperty(value = "用户名字")
    private String userName;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
