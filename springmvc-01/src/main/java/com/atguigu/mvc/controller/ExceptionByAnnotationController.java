package com.atguigu.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author 会游泳的蚂蚁
 * @Description: springmvc自动检测到异常就处理
 * 基于注解的异常处理器  @ControllerAdvice + @ExceptionHandler
 * @Date 2023/3/2 18:35
 */
@ControllerAdvice
public class ExceptionByAnnotationController {

    /**
     * 基于注解的异常处理器的方式
     * @return
     */
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String testAnnotationException(Exception exception, Model model) {
        model.addAttribute("ex",exception);
        System.out.println("--------------ExceptionByAnnotationController--------------");
        return "error";
    }
}
