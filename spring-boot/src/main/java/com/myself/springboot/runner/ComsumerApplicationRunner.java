package com.myself.springboot.runner;

import com.myself.logger.LoggerUtil;
import com.myself.springboot.bean.Brother;
import com.myself.springboot.bean.Mother;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 功能描述: ComsumerApplicationRunner
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
@Component
public class ComsumerApplicationRunner implements ApplicationRunner , BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Mother mother = beanFactory.getBean(Mother.class);
        LoggerUtil.info(mother.getClass().getCanonicalName());
        Brother brother = beanFactory.getBean(Brother.class);
        LoggerUtil.info(brother.getName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
