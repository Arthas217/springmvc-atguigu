package com.atguigu.mvc.controller;

import com.atguigu.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 注入控制器组件到ioc容器
 * 1、注解@Controller+扫描方式component-scan
 * 2、bean标签---xml方式
 * @Date 2023/2/10 13:05
 */
@Controller
public class HelloController {

    /**
     * 对首页的访问
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        //设置视图名称
        return "index";
    }

    /**
     * 超链接跳转到指定页面
     *
     * @return
     */
    @RequestMapping("/hello")
    public String HelloWorld() {
        return "target";
    }


    /**
     * post表单提交
     *
     * @return
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String form() {
        return "target";
    }


    /**
     * params使用
     *
     * @return
     */
    @RequestMapping(value = "/params", params = {"username", "password=123"})
    public String params() {
        return "target";
    }


    /**
     * headers使用
     *
     * @return
     */
    @RequestMapping(value = "/params2", params = {"username", "password=123"}, headers = "Host=localhost:8080")
    public String params2() {
        return "target";
    }


    /**
     * ant风格
     *
     * @return
     */
//    @RequestMapping(value = "/ant/a?a")
//    @RequestMapping(value = "/ant/a*a")
    @RequestMapping(value = "/ant/**")
    public String ant() {
        return "target";
    }


    @RequestMapping(value = "/testPath/{id}")
    public String testPath(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "target";
    }

    @RequestMapping(value = "/requestHeader")
    public String testPath(@RequestHeader("Host") String host) {
        System.out.println(host);
        return "target";
    }

    @RequestMapping(value = "/testHttpServletRequest")
    public String testHttpServletRequest(HttpServletRequest  httpServletRequest,
                                         @CookieValue(value = "JSESSIONID") String JSESSIONID){
        //浏览器第一次访问时，JSESSIONID为null、6FED810F452BE372B1C7339D1344EF31
        //浏览器第二次访问时  JSESSIONID为6FED810F452BE372B1C7339D1344EF31、6FED810F452BE372B1C7339D1344EF31
        System.out.println(JSESSIONID);
        HttpSession session = httpServletRequest.getSession();
        System.out.println(session.getId());
        return "target";
    }


    /**
     * 请求参数为POJO
     * 表单请求get乱码问题 tomcat配置文件中，添加URIEncoding= "UTF-8"
     * 表单请求post乱码问题 要比DispatcherServlet执行时间更早的组件（监听-执行一次、过滤），来处理设置编码
     * @param user
     * @return
     */
    @RequestMapping(value = "/testPOJO")
    public String testPath(User user) {
        System.out.println(user);
        return "target";
    }


    //域对象共享 4种 request、session（浏览器开-关）、application（servletcontext 服务器开-关）、page（jsp页面）

    /**
     * 使用ServletAPI向request域对象 共享数据
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/testHttpServletAPI")
    public String testHttpServletAPI(HttpServletRequest  httpServletRequest){
        httpServletRequest.setAttribute("testScope","hello servletAPI");
        //共享的数据转发到target.html页面
        return "target";
    }

}
