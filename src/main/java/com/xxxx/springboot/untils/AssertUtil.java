package com.xxxx.springboot.untils;

import com.xxxx.springboot.exceptions.ParamException;

/**
 * @Author QJJ
 * @Date 2021-08-10 23:57
 */
public class AssertUtil {
    public static void isTrue(Boolean flag, String msg) {
        if (flag) {
            throw new ParamException(msg);
        }
    }
}
