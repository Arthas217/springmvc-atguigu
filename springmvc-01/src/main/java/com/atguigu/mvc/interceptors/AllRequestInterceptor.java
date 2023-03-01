package com.atguigu.mvc.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 拦截器用于拦截控制器方法的执行；
 * 需要实现HandlerInterceptor；
 * springmvc拦截器必须在配置文件中进行配置
 * @Date 2023/3/1 22:25
 */
@Component
public class AllRequestInterceptor implements HandlerInterceptor {
    /**
     * 控制器方法执行之前执行，返回值标识是否拦截或方形，true放行 false拦截即不调用控制器方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("--------FirstInterceptor-------preHandle-----------");
        return HandlerInterceptor.super.preHandle(request, response, handler);
//        return false;
    }

    /**
     * 控制器方法执行之后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("--------FirstInterceptor-------postHandle-----------");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 处理完视图和模型数据，渲染视图完毕之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("--------FirstInterceptor-------afterCompletion-----------");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
