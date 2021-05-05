package com.myself.springboot.anno;

import com.myself.springboot.condit.OnPropertyCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述: PropertyOnCondition
 *
 * @author linqin.zxl
 * @date 2021/5/5
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnPropertyCondition.class)
public @interface PropertyOnCondition {
    String name() default "";
}
