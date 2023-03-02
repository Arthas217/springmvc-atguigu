package com.bj.hh.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 创建初始化类，代替web.xml
 * 1、容器在类路径下（classpath）查找实现ServletContainerInitializer接口的类，如果找到就用它来配置servlet容器
 * 2、spring提供了1中接口实现类SpringServletContainerInitializer，
 *    onStartup方法所需要的参数就通过@HandlesTypes注解传入WebApplicationInitializer
 * 3、抽象类AbstractAnnotationConfigDispatcherServletInitializer基础实现WebApplicationInitializer接口
 * 4、继承AbstractAnnotationConfigDispatcherServletInitializer并将其部署到servlet容器时，容器自动发现，并用它来配置servlet上下文
 * @Date 2023/3/2 22:42
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 指定spring的配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 指定springmvc的配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 指定DispatcherServlet的映射规则url-pattern
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置过滤器,注册过滤器
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceRequestEncoding(true);
        HiddenHttpMethodFilter hiddenFilter = new HiddenHttpMethodFilter();
        return new Filter[]{encodingFilter,hiddenFilter};
    }
}
