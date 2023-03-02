package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 异常控制器
 * @Date 2023/3/2 18:09
 */
@Controller
public class ExceptionController {

    /**
     * 基于配置的异常处理器方式
     * @return
     */
    @RequestMapping(value = "/testExceptionHandler")
    public String testExceptionHandler() {
        System.out.println(1 / 0);
        return "target";
    }
}
