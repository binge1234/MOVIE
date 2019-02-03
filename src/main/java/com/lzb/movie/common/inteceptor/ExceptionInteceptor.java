package com.lzb.movie.common.inteceptor;

import com.alibaba.fastjson.JSONObject;
import com.lzb.movie.common.enums.CommonEnum;
import com.lzb.movie.common.result.ReturnResult;
import com.lzb.movie.util.EmptyUtil;
import com.lzb.movie.util.PrintUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
*
* @desc 异常统一处理拦截器
* */
public class ExceptionInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","*");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ReturnResult returnResult = null;
        if(!EmptyUtil.isNotEmpty(ex)){
            response.setContentType("text/html;charset=UTF-8");
            returnResult = new ReturnResult(CommonEnum.SYSTEM_EXCEPTION.getCode(),CommonEnum.SYSTEM_EXCEPTION.getMessage());
            PrintUtil.print(JSONObject.toJSON(returnResult),response);
          }
    }
}
