package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.UserDao;
import com.atguigu.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 会游泳的蚂蚁
 * @Description: RESTFUL风格 用户的CRUD
 * http://localhost:8080/springmvc_01_war/restfulTest
 * @Date 2023/2/18 22:49
 */
@Controller
public class UserRestfulController {



    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String queryAllUser() {
        System.out.println("查询所有用户信息-----------");
        return "target";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String queryUserById(@PathVariable("id") Integer id) {
        System.out.println("根据id=" + id + "查询用户信息----------");
        return "target";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(User user) {
        System.out.println("添加用户信息-----------" + user);
        return "target";
    }


    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String modifyUser(User user) {
        System.out.println("修改用户信息-----------" + user);
        return "target";
    }




    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user2", method = RequestMethod.GET)
    public ModelAndView queryAllUser2() {
        ModelAndView modelAndView = new ModelAndView();
        Collection<User> allUser = userDao.getAll();
//        List<User> allUser = userDao.getAll().stream().collect(Collectors.toList());
        modelAndView.addObject("allUser",allUser);
        modelAndView.setViewName("userlist");
        return modelAndView;
    }
}
