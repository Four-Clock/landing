package com.myself.springboot.servletinit;

import javax.servlet.ServletContext;

/**
 * 功能描述: ConsumerInitializer
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
public interface ConsumerInitializer {

     void onStart(ServletContext servletContext);
}
