package com.xxxx.springboot.exceptions;

/**
 * @Author QJJ
 * @Date 2021-08-11 0:00
 */
public class ParamException extends RuntimeException {
    private Integer code = 300;
    private String msg = "参数异常";

    public ParamException(Integer code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public ParamException(Integer code) {
        this.code = code;
    }


    public ParamException(String msg) {
        super(msg);
        this.msg = msg;

    }

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
}
