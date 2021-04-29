package com.myself.springboot.runner;

import com.myself.logger.LoggerUtil;
import com.myself.springboot.bean.GrandFather;
import com.myself.springboot.bean.Sister;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class ConsumerApplicationRunner implements ApplicationRunner , BeanFactoryAware {

    private BeanFactory beanFactory;


    @Autowired
    @Qualifier(value = "Sister")
    private Sister sister;

    @Autowired
    private GrandFather grandFather;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LoggerUtil.info(grandFather.say());
        grandFather.eat();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
