package com.myself.springboot.web.interceptor;

import com.myself.springboot.anno.Permission;
import com.myself.springboot.dto.DeptDto;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: ConsumerInterpector
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
@Component
public class ConsumerInterceptor implements HandlerInterceptor {

    private List<DeptDto> localDeptDataList = new ArrayList<>();

    public static final String LOCAL_DEPT_DATA_LIST = "localDeptDataList";

    @PostConstruct
    public void init(){
        DeptDto deptDto_1 = new DeptDto("部门一",1,"无描述");
        DeptDto deptDto_2 = new DeptDto("部门二",2,"无描述");
        DeptDto deptDto_3 = new DeptDto("部门三",3,"无描述");
        DeptDto deptDto_4 = new DeptDto("部门四",4,"无描述");
        localDeptDataList.add(deptDto_1);
        localDeptDataList.add(deptDto_2);
        localDeptDataList.add(deptDto_3);
        localDeptDataList.add(deptDto_4);
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (HandlerMethod.class.isAssignableFrom(handler.getClass())){
            HandlerMethod handlerMethod =  (HandlerMethod)handler;
            Permission permission = handlerMethod.getMethodAnnotation(Permission.class);
            if (null!=permission){
                request.setAttribute(LOCAL_DEPT_DATA_LIST,localDeptDataList);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}