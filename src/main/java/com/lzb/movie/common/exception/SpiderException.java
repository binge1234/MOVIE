package com.lzb.movie.common.exception;


/**
 * @author 志彬
 * 针对爬取过程的自定义异常
 */
public class SpiderException extends Exception{
	
      private String target;//异常对象
      
      private String message;//异常信息
      
      public SpiderException(String target, String message) {
    	  this.target = target;
    	  this.message = message;
      }

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
      
      
}
