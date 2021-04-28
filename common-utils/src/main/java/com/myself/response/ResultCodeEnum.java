package com.myself.response;

/**
 * 功能描述: ResultCodeEnum
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
public enum  ResultCodeEnum {

    SERVER_ERROR(500,"server error"),
    SUCCESS(200,"success");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public Integer getCode(){
        return this.code;
    }

}
