package com.myself.springboot.generic;

import org.springframework.core.GenericTypeResolver;

/**
 * 功能描述: BaseGeneric
 *
 * @author linqin.zxl
 * @date 2021/5/10
 */
public abstract class BaseGeneric<T> {

    private Class<?> genericClass = GenericTypeResolver.resolveTypeArgument(this.getClass(), BaseGeneric.class);

    public Class<?> getGenericClass(){
      return genericClass;
    }
}
