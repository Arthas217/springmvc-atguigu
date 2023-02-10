package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author 会游泳的蚂蚁
 * @Description:  注入控制器组件到ioc容器
 * 1、注解@Controller+扫描方式component-scan
 * 2、bean标签---xml方式
 * @Date 2023/2/10 13:05
 */
@Controller
public class HelloController {

    /**
     * 对首页的访问
     * @return
     */
    @RequestMapping("/")
    public String index() {
        //设置视图名称
        return "index";
    }

    /**
     * 超链接跳转到指定页面
     * @return
     */
    @RequestMapping("/hello")
    public String HelloWorld() {
        return "target";
    }


    /**
     * post 表单提交
     * @return
     */
    @RequestMapping(value = "/form" ,method = RequestMethod.POST)
    public String form() {
        return "target";
    }


    /**
     * params注解使用
     * @return
     */
    @RequestMapping(value = "/params" , params = {"username","password=123"})
    public String params() {
        return "target";
    }
}
