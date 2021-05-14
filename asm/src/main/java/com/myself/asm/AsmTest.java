package com.myself.asm;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 功能描述: AsmTest
 * 测试动态加载jar
 * @author linqin.zxl
 * @date 2021/5/8
 */
public class AsmTest {


    public static void main(String[] args) throws Throwable {

        URLClassLoader contextClassLoader = (URLClassLoader)Thread.currentThread().getContextClassLoader();

        Method method = contextClassLoader.getClass().getSuperclass().getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        URL url = new URL("file:/Users/zxl/.m2/repository/mysql/mysql-connector-java/8.0.22/mysql-connector-java-8.0.22.jar");
        method.invoke(contextClassLoader,url);
        Class<?> aClass = Class.forName("com.mysql.cj.util.Util");
        Method getJVMVersion = aClass.getMethod("getJVMVersion");
        Object invoke = getJVMVersion.invoke(aClass.newInstance());
        System.out.println(invoke);
    }
}
