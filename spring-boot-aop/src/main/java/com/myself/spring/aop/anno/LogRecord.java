package com.myself.spring.aop.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述: LogRecord
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogRecord {
    String businessType() default "";
    String subBusinessType() default "";
    String description() default "";
}
