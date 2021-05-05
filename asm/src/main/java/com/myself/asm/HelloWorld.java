package com.myself.asm;

import javax.annotation.Resource;

/**
 * 功能描述: Helloworld
 *
 * @author linqin.zxl
 * @date 2021/5/3
 */
@Resource
public class HelloWorld {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello(){
        try {
            Thread.sleep(2*1000);
        }catch (Exception ex){

        }
    }
}
