package com.myself.springboot.servletinit;

import com.myself.logger.LoggerUtil;
import org.springframework.util.ReflectionUtils;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 功能描述: ConsumerServletContainerInitializer
 * 此方法不会执行了，springboot中内嵌tomcat不支持
 * @author linqin.zxl
 * @date 2021/4/28
 */
@HandlesTypes(ConsumerInitializer.class)
public class ConsumerServletContainerInitializer implements ServletContainerInitializer {

    List<ConsumerInitializer> initializers = Collections.emptyList();

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        LoggerUtil.info(ctx.getServerInfo());
        for (Class<?> aClass : c) {
            if (aClass.isInterface() && !Modifier.isAbstract(aClass.getModifiers())
                && ConsumerInitializer.class.isAssignableFrom(aClass)){
                try {
                    initializers.add((ConsumerInitializer)ReflectionUtils.accessibleConstructor(aClass).newInstance());
                } catch (Throwable e) {
                   LoggerUtil.error("initializer consumer servlet container error:"+e
                   .getMessage());
                }
            }
        }
        for (ConsumerInitializer initializer : initializers) {
            initializer.onStart(ctx);
        }
    }
}
