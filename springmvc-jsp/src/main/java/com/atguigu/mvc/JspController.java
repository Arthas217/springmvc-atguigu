package com.atguigu.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2023/2/18 21:34
 */
@Controller
public class JspController {

    @RequestMapping(value = "/jspSuccess")
    public String jspSuccess(){
        // 视图解析器添加前缀和后缀
        return "success";
    }

}
