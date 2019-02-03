package com.lzb.movie.common.enums;

public enum BussinessEnum {

    USER_LOGIN_FAIL(403,"用户民或者密码错误"),
    USER_LOGIN_SUCCESS(200,"登录成功"),
    EXIT_SUCCESS(200,"退出成功"),
    EXIT_FAIL(500,"退出失败");

    private Integer code;

    private String message;



    BussinessEnum(Integer code,String message){
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
