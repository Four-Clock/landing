package com.myself.springboot.web.args;

import com.myself.springboot.anno.Permission;
import com.myself.springboot.web.interceptor.ConsumerInterceptor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 功能描述: ConsumerHandlerMethodArgumentResolver
 * 解析自定义参数解析器 supportsParameter 方法正常只会执行一次，会进行缓存
 * @author linqin.zxl
 * @date 2021/4/28
 */
@Component
public class ConsumerHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String PARAMETER_NAME = "deptList";
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (null!=parameter.getMethodAnnotation(Permission.class)
                && PARAMETER_NAME.equals(parameter.getParameterName())){
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return webRequest.getAttribute(ConsumerInterceptor.LOCAL_DEPT_DATA_LIST, RequestAttributes.SCOPE_REQUEST);
    }
}
