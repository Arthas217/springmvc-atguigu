package com.atguigu.mvc.controller;

import com.atguigu.mvc.model.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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


    /**
     * sevlet api方式响应浏览器数据
     * @param response
     * @throws IOException
     */
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello response");
        return;
    }


    /**
     * String类型作为方法的返回值直接响应浏览器数据，而不是作为视图名称而解析
     * @return
     * @throws IOException
     */
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody () throws IOException {
       return "success";
    }


    /**
     * json是JavaScript里的一个数据格式
     * json类型：json对象{}---实体类、map  ，json数组[]-----list
     * xml也是一种一个数据交互格式，一般用来做配置
     */

    /**
     * User对象是否可以作为方法的返回值直接响应浏览器数据
     * 答案不行浏览器只能识别文本，可以用json数据交互的格式
     * springmvc解决方式 1、json依赖 2、配置开启mvc注解驱动 + 方法上加@ResponseBody + 方法返回值为对象
     * 那么java对象自动转为为json格式的字符串
     * @return
     * @throws IOException
     */
    @RequestMapping("/testResponseBody2")
    @ResponseBody
    public User testResponseBody2() throws IOException {
        return new User(1,"vampire","123","男","23","1@qq.com");
    }


    /**
     * springmvc处理ajax页面，不刷新与服务器交互，服务端不能通过转发、重定向，只能通过响应浏览器数据
     * 注意需要mvn package
     * ajax页面不跳转的情况下与服务器进行数据交换的例子
     */
    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println(username+" "+password);
        return "hello,axios";
    }

}
