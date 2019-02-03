package com.lzb.movie.common.result;


import java.io.Serializable;

/*
*
* 和前端接口交互的返回结果类
* */
public class ReturnResult implements Serializable {
    private Integer code;//状态码
    private String message;//提示信息
    private Object data;//返回数据

    public ReturnResult (Integer code){
        this.code = code;
    }

    public ReturnResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public ReturnResult(Integer code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
