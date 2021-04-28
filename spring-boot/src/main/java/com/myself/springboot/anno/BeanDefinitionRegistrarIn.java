package com.myself.springboot.anno;

import com.myself.springboot.imports.ConsumerImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述: BeanDefinitionRegistrarIn
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(ConsumerImportBeanDefinitionRegistrar.class)
public @interface BeanDefinitionRegistrarIn {
}
