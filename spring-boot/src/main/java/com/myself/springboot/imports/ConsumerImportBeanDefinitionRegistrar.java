package com.myself.springboot.imports;

import com.alibaba.fastjson.JSON;
import com.myself.logger.LoggerUtil;
import com.myself.springboot.bean.Brother;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 功能描述: ConsumerImportBeanDefinitionRegistrar
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
public class ConsumerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Brother.class);
        beanDefinitionBuilder.addPropertyValue("name","张三");
        beanDefinitionBuilder.addPropertyValue("hobby",new String[]{"篮球","足球"});
        beanDefinitionBuilder.setInitMethodName("init");
        registry.registerBeanDefinition("brother",beanDefinitionBuilder.getBeanDefinition());
        LoggerUtil.info("registry Brother success***************");
    }
}
