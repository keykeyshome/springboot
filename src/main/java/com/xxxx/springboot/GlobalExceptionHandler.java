package com.xxxx.springboot;

import com.xxxx.springboot.exceptions.ParamException;
import com.xxxx.springboot.model.ResultInfo;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author QJJ
 * @Date 2021-08-19 1:13
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = ParamException.class)
    @ResponseBody
    public ResultInfo resoverException(ParamException e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(e.getCode());
        resultInfo.setMsg(e.getMsg());

        return resultInfo;
    }

    //参数绑定异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultInfo resoverBindException(MethodArgumentNotValidException e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(8888);
        resultInfo.setMsg(e.getBindingResult().getFieldError().getDefaultMessage());

        return resultInfo;
    }

    @ExceptionHandler
    @ResponseBody
    public ResultInfo resoverException(Exception e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(9999);
        resultInfo.setMsg("操作失败全局异常捕获");

        //没有 @ExceptionHandler(value = ParamException.class) 之前在全局内部判断
        /*   if (e instanceof ParamException) {
            ParamException pe = (ParamException) e;
            resultInfo.setCode(pe.getCode());
            resultInfo.setMsg(pe.getMsg());
        }*/

        return resultInfo;
    }
}
