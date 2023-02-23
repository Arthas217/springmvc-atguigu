package com.atguigu.mvc.dao;

import com.atguigu.mvc.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2023/2/19 11:08
 */
@Component
public class UserDao {

    private static Map<Integer, User> employees;


    static {
        employees = new HashMap<>();
        employees.put(1001, new User(1001,"1001", "E-AA", "男","01", "aa@163.com"));
        employees.put(1002, new User(1002,"1002", "E-BB","男", "02", "bb@163.com"));
        employees.put(1003, new User(1003,"1003", "E-CC","男", "03", "cc@163.com"));
        employees.put(1004, new User(1004,"1004", "E-DD","男", "04", "dd@163.com"));
        employees.put(1005, new User(1005,"1005", "E-EE", "女","05", "ee@163.com"));
    }

    private static Integer initId = 1006;

    public void save(User user) {
        if (user.getId() == null) {
            user.setId(initId++);
        }

        employees.put(user.getId(), user);
    }

    public List<User> getAllUser() {
        return null;
    }

    public Collection<User> getAll() {
        return employees.values();
    }

    public User get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
