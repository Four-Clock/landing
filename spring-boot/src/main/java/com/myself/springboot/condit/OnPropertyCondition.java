package com.myself.springboot.condit;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 功能描述: OnPropertyCondition
 *
 * @author linqin.zxl
 * @date 2021/5/5
 */
public class OnPropertyCondition  implements Condition {

    private String propertiesKey = "consumer.condition";
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (context.getEnvironment().containsProperty(propertiesKey)){
            return true;
        }
        return false;
    }
}
