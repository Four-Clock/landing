package com.myself.springboot.springproxy;

import com.myself.springboot.anno.AdviceRegisterIn;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: ConsumerAbstractAutoProxyCreator
 * 自定义实现动态代理机制
 * @author linqin.zxl
 * @date 2021/4/29
 */
public class ConsumerAbstractAutoProxyCreator extends AbstractAutoProxyCreator {

    private List<String> beanNames = new ArrayList<>();

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) throws BeansException {

        AdviceRegisterIn adviceRegisterIn = AnnotationUtils.getAnnotation(beanClass, AdviceRegisterIn.class);
        if (null==adviceRegisterIn){
            return AbstractAutoProxyCreator.DO_NOT_PROXY;
        }
        if (!beanNames.contains(beanName)){
            beanNames.add(beanName);
        }
        return AbstractAutoProxyCreator.PROXY_WITHOUT_ADDITIONAL_INTERCEPTORS;
    }

    public List<String> getBeanNames(){
        return this.beanNames;
    }
}
