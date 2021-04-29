package com.myself.springboot.springproxy;

import com.myself.logger.LoggerUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * 功能描述: ConsumerMethodInterceptor
 *
 * @author linqin.zxl
 * @date 2021/4/29
 */
@Component
public class ConsumerMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
        LoggerUtil.info("MethodInterceptor invoked .........................."+invocation.getMethod().getName());
        return invocation.proceed();
    }
}
