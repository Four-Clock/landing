package com.myself.java.agent;

import com.myself.logger.LoggerUtil;

import java.lang.instrument.Instrumentation;

/**
 * 功能描述: AfterAgent
 * 在主方法执行后调用
 * @author linqin.zxl
 * @date 2021/4/29
 */
public class AfterAgent {

    public static void afterAgent(String args, Instrumentation instrumentation){
        LoggerUtil.info("****args******："+args);
        Class[] allLoadedClasses = instrumentation.getAllLoadedClasses();
        for (Class loadClass : allLoadedClasses) {
            LoggerUtil.info("loadClass is:"+loadClass.getCanonicalName());
        }
    }
}
