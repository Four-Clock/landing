package com.myself.response;

import lombok.Data;

/**
 * 功能描述: BaseResult
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
@Data
public class BaseResult <T> {
    private T data;
    private String message;
    private Integer code;

    private BaseResult(String message,Integer code){
        this.message = message;
        this.code = code;
    }

    private BaseResult(String message,Integer code,T data){
        this.message = message;
        this.code = code;
        this.data = data;
    }



    static BaseResult success(){
        return new BaseResult(ResultCodeEnum.SUCCESS.getMessage(),ResultCodeEnum.SUCCESS.getCode());
    }

    static <T> BaseResult success(T data){
        return new BaseResult(ResultCodeEnum.SUCCESS.getMessage(),ResultCodeEnum.SUCCESS.getCode(),data);
    }

    static BaseResult failed(){
        return new BaseResult(ResultCodeEnum.SERVER_ERROR.getMessage(),ResultCodeEnum.SERVER_ERROR.getCode());
    }

    static BaseResult failed(ResultCodeEnum resultCodeEnum){
        return new BaseResult(resultCodeEnum.getMessage(),resultCodeEnum.getCode());
    }
}
