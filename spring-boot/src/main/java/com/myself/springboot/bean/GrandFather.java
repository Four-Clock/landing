package com.myself.springboot.bean;

import com.myself.springboot.anno.AdviceRegisterIn;
import com.myself.springboot.anno.PropertyOnCondition;
import org.springframework.stereotype.Component;

/**
 * 功能描述: GrandFather
 *
 * @author linqin.zxl
 * @date 2021/4/29
 */
@AdviceRegisterIn
@Component
@PropertyOnCondition(name = "property")
public class GrandFather extends Person {

    public String say(){
        return "hello";
    }
}
