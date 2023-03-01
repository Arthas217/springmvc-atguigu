package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2023/3/1 22:14
 */
@Controller
public class InterceptorController {

    @RequestMapping(value = "/testInterceptor")
    public String testInterceptor(){
        return "target";
    }
}
