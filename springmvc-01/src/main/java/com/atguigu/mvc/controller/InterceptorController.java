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

    /**
     * 请求路径中**表示一层或多层路径的请求
     * http://localhost:8080/springmvc_01_war/testInterceptor
     * http://localhost:8080/springmvc_01_war/a/testInterceptor
     * @return
     */
    @RequestMapping(value = "/**/testInterceptor")
    public String testInterceptor(){
        return "target";
    }
}
