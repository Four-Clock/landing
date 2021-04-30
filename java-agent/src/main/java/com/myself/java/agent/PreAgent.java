package com.myself.java.agent;


import java.lang.instrument.Instrumentation;

/**
 * 功能描述: PreAgent
 * 在主方法main启动之前调用
 * 执行方式：java -javaagent:/Users/zxl/workspace/work/study/code/landing/java-agent/target/java-agent-1.0-SNAPSHOT.jar=你好 -jar /Users/zxl/workspace/work/study/code/landing/spring-boot/target/spring-boot-1.0-SNAPSHOT.jar
 * @author linqin.zxl
 * @date 2021/4/29
 */
public class PreAgent {

    public static void premain(String args, Instrumentation instrumentation){
        System.out.println("****args******："+args);
        Class[] allLoadedClasses = instrumentation.getAllLoadedClasses();
        for (Class loadClass : allLoadedClasses) {
            System.out.println("loadClass is:"+loadClass.getCanonicalName());
        }
    }
}
