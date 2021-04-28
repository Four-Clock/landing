package com.myself.spring.aop.controller;

import com.myself.response.BaseResult;
import com.myself.response.BaseResultUtils;
import com.myself.spring.aop.anno.LogRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述: IndexController
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
@RestController
@RequestMapping("/aop")
public class IndexController {

    @RequestMapping("/index")
    @LogRecord(businessType = "商品",subBusinessType = "列表")
    public BaseResult index(String name){
        return BaseResultUtils.success(name);
    }

    @RequestMapping("/index1")
    public BaseResult index1(HttpServletRequest servletRequest){
        String name = servletRequest.getParameter("name");
        return BaseResultUtils.success(name);
    }

    @RequestMapping("/hello")
    @LogRecord(businessType = "订单",subBusinessType = "列表")
    public BaseResult hello(HttpServletRequest servletRequest){
        String name = servletRequest.getParameter("name");
        return BaseResultUtils.success(name);
    }

}
