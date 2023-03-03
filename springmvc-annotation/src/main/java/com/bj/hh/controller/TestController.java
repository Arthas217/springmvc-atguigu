package com.bj.hh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2023/3/3 00:27
 */
@Controller
public class TestController {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }


    @RequestMapping(value = "/exception")
    public String exception(){
        System.out.println(1/0);
        return "hello";
    }
}
