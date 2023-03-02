package com.atguigu.mvc.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2023/3/1 23:36
 */
@Component
public class MultiRequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("--------MultiRequestInterceptor-------preHandle-----------");
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        return false;//拦截状态
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("--------MultiRequestInterceptor-------postHandle-----------");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("--------MultiRequestInterceptor-------afterCompletion-----------");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
