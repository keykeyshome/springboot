package com.xxxx.springboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author QJJ
 * @Date 2021-08-11 0:39
 */
@ApiModel(description = "响应-model信息")
public class ResultInfo {
    @ApiModelProperty(value = "响应代码",example = "200")
    private Integer code = 200;
    @ApiModelProperty(value = "响应消息结果")
    private String msg = "操作成功";
    @ApiModelProperty(value = "响应具体结果消息")
    private Object result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
