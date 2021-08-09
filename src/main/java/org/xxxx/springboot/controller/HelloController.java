package org.xxxx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author QJJ
 * @Date 2021-08-07 23:58
 */

@Controller
public class HelloController {
    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello springboot";
    }
}
