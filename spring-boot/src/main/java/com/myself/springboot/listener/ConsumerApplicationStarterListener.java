package com.myself.springboot.listener;

import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 功能描述: ConsumerApplicationStarterListener
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
public class ConsumerApplicationStarterListener implements ApplicationListener<ApplicationContextInitializedEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent event) {
        event.getApplicationContext().getBeanFactory();
    }
}
