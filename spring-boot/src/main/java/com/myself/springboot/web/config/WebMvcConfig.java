package com.myself.springboot.web.config;

import com.myself.springboot.web.args.ConsumerHandlerMethodArgumentResolver;
import com.myself.springboot.web.interceptor.ConsumerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * 功能描述: WebMvcConfig
 * Mvc 主配置类
 * @author linqin.zxl
 * @date 2021/4/28
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ConsumerInterceptor consumerInterceptor;

    @Autowired
    private ConsumerHandlerMethodArgumentResolver consumerHandlerMethodArgumentResolver;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(consumerInterceptor);
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(consumerHandlerMethodArgumentResolver);
    }
}
