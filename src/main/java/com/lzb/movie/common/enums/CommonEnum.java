package com.lzb.movie.common.enums;
/*
*
* @desc用来定义公共的异常
* */
public enum CommonEnum {

    SYSTEM_EXCEPTION(500,"系统繁忙，请稍后重试"),
    SESSION_OVER(501,"登陆超时");

    private Integer code;

    private String message;

    CommonEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
