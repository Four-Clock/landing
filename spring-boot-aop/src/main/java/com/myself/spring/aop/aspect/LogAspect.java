package com.myself.spring.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.myself.logger.LoggerUtil;
import com.myself.spring.aop.anno.LogRecord;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述: LogAspect
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
@Configuration
@Aspect
public class LogAspect {


    @Pointcut(value = "@annotation(logRecord)",argNames = "logRecord")
    public void logRecordPointcut(LogRecord logRecord){
    }

    @Around(value = "logRecordPointcut(logRecord)")
    public Object beforeLog(ProceedingJoinPoint joinPoint, LogRecord logRecord){
        MethodSignature methodSignature=  (MethodSignature)joinPoint.getSignature();
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("start record log >>>>>>>>>>>>>>>>>>>>>>>>\n");
        logBuilder.append("businessType:"+logRecord.businessType()+"******************\n");
        logBuilder.append("subBusinessType:"+logRecord.subBusinessType()+"******************\n");
        logBuilder.append("description:"+logRecord.description()+"******************");
        logBuilder.append("methodName:"+methodSignature.getMethod().getName()+"******************\n");
        Object[] args = joinPoint.getArgs();
        logBuilder.append("args:"+ JSON.toJSONString(args) +"******************\n");
        logBuilder.append("methodName:"+methodSignature.getMethod()+"******************\n");
        Object result = null;
        try {
            result = joinPoint.proceed(args);
            logBuilder.append("result:"+JSON.toJSONString(result)+"******************");
            LoggerUtil.info(logBuilder.toString());
            return result;
        }catch (Throwable ex){
            LoggerUtil.error(ex.getMessage());
        }
        return result;
    }

}
