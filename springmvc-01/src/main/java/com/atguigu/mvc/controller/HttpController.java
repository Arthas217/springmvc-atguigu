package com.atguigu.mvc.controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2023/2/23 23:44
 */
@Controller
public class HttpController {

    @RequestMapping(value = "/requestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println(requestBody);
        return "target";
    }



    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("requestHeader:"+requestEntity.getHeaders());
        System.out.println("requestBody:"+requestEntity.getBody());
        return "target";
    }

}
