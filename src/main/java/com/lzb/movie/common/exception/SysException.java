package com.lzb.movie.common.exception;



/**
 * @author 志彬
 * 针对数据库增删改查的自定义异常
 */
public class SysException extends Exception{
	 private String operate; //异常操作
     private String message; //异常信息
     
     public SysException(String operate,String message) {
    	 this.operate = operate;
    	 this.message = message;
     } 
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
     
     
}
