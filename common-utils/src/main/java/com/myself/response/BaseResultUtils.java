package com.myself.response;

/**
 * 功能描述: BaseResultUtils
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
public class BaseResultUtils {

    public static BaseResult DEFAULT_SUCCESS = BaseResult.success();

    public static BaseResult DEFAULT_FAILED = BaseResult.failed();


    public static BaseResult success(Object data){
        return BaseResult.success(data);
    }

    public static BaseResult failed(ResultCodeEnum resultCodeEnum){
        return BaseResult.failed(resultCodeEnum);
    }

}
