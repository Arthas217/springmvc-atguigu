package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * 转发 ： 浏览器请求一次，转发跳转一次（服务器内部处理）
 *        地址栏还是第一次的请求地址。
 *        可以获得请求域中的数据。
 *        能访问到WEB-INF中的资源
 *        不能跨域
 * 重定向： 浏览器请求二次
 *        地址栏是第二次请求地址，
 *        不能获取请求域数据，所以获取不到第一次请求域中的数据，
 *        不能访问到WEB-INF中的资源（安全性只能同通过服务器内部访问）
 *        可以跨域
 * @Date 2023/2/18 12:18
 */
@Controller
public class ViewCtroller {
    //sprigmvc视图种类很多
    //如果项目中没有引入ThymeleafView，那么默认视图是InternalResourceView，其他JSP页面中使用java时用到JstlView

    /**
     * 例子的入口
     * http://localhost:8080/springmvc_01_war/view
     * @return
     */
    @RequestMapping(value = "/view")
    public String testTView(){
        //ThymeleafView---转发
        return "view";
    }


    @RequestMapping(value = "/testThymeleafView")
    public String testThymeleafView(){
        //ThymeleafView--转发
        return "target";
    }


    @RequestMapping(value = "/testForward")
    public String testForward(){
        //InternalResourceView--转发视图需要加forward前缀
        //ThymeleafView视图--在转发到实际请求路径
        //不能直接forward:xx.html页面方式
        //对于forward方式转发这种可以省略，因为ThymeleafView可以用转发方式
        return "forward:/testThymeleafView";
    }

    @RequestMapping(value = "/testRedirect")
    public String testRedirect(){
        //RedirectView---重定向视图
        //对于重定向方式转发这种不能省略，请求业务处理成功后需要重定向到别的请求页面
        //不能访问到WEB-INF中的资源--重定向不到某页面(/target)
        //重定向到/路径，而不是WEB-INF中的资源
        return "redirect:/testThymeleafView";
    }

}
