package com.lzb.movie.common.base;

import java.beans.PropertyEditorSupport;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;


public class BaseController {
	   protected final Logger log = LoggerFactory.getLogger(this.getClass());

	    @Autowired
	    protected HttpServletRequest request;

	    @Autowired
	    protected HttpServletResponse response;

	    @Autowired
	    protected HttpSession session;

	    @Autowired
	    protected ServletContext application;

	    /**
	     * 初始化数据绑定
	     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
	     * 2. 将字段中Date类型转换为String类型
	     */
	    @InitBinder
	    protected void initBinder(WebDataBinder binder) {
	        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
	        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
	            @Override
	            public void setAsText(String text) {
	                setValue(text == null ? null : text.trim());
	            }

	            @Override
	            public String getAsText() {
	                Object value = getValue();
	                return value != null ? value.toString() : "";
	            }
	        });

	    }


	    /**
	     * 系统异常处理
	     *
	     * @param e
	     * @return
	     */
	    @ExceptionHandler(Exception.class)
	    public ModelAndView handleException(Exception e) {
	        log.error("-->系统发生异常", e);
	        ModelAndView model = new ModelAndView();
	        model.addObject("message", e.getMessage());
	        model.setViewName("error");
	        return model;
	    }

	    private Boolean isJson(HttpServletRequest request){
	        String header = request.getHeader("content-type");
	        return header != null && header.contains("json");
	    }

	    protected String getPara(String param){
	        String value = request.getParameter(param);
	        if (null != value && !value.isEmpty()) {
	            try {
	                return URLDecoder.decode(value.replaceAll("%", "%25"), "UTF-8").trim();
	            } catch (UnsupportedEncodingException e) {
	                LoggerFactory.getLogger(BaseController.class).error("decode异常：" + value);
	                return value;
	            }
	        }
	        return value;
	    }

}
