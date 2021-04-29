package com.myself.springboot.beanconfig;

import com.myself.springboot.bean.Sister;
import com.myself.springboot.bean.Sister2;
import com.myself.springboot.springproxy.ConsumerAbstractAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述: CommonBeanConfig
 *
 * @author linqin.zxl
 * @date 2021/4/29
 */
@Configuration
public class CommonBeanConfig {

    @Bean(name = "Sister")
    public Sister sister(){
        return new Sister();
    }

    @Bean(name = "Sister2")
    public Sister sister2(){
        return new Sister2();
    }

    @Bean
    public ConsumerAbstractAutoProxyCreator consumerAbstractAutoProxyCreator(){
        ConsumerAbstractAutoProxyCreator consumerAbstractAutoProxyCreator = new ConsumerAbstractAutoProxyCreator();
        consumerAbstractAutoProxyCreator.setInterceptorNames(INTERCEPTOR_NAME);
        return consumerAbstractAutoProxyCreator;
    }

    private static final String INTERCEPTOR_NAME = "consumerMethodInterceptor";

}
