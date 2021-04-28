package com.myself.springboot.enable;

import com.myself.springboot.anno.BeanDefinitionRegistrarIn;
import com.myself.springboot.imports.ConsumerSelectorImporter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 功能描述: EnableRegisterIn
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
@Import(ConsumerSelectorImporter.class)
@Configuration
@BeanDefinitionRegistrarIn
public class EnableRegisterIn {
}
