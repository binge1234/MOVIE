package com.lzb.movie.controller;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lzb.movie.common.base.BaseController;
import com.lzb.movie.config.KaptchaConfig;
import com.lzb.movie.util.SpringContextHolder;
 
@Controller
public class IndexController extends BaseController{
	@Autowired
	private DefaultKaptcha defaultKaptcha;
 
    @RequestMapping("/register")
    public String hello() {
        return "front/user/register";
    }
    
    @RequestMapping("/index")
    public String hello1() {
        return "front/user/index";
    }
    
    @RequestMapping("/getKaptcha")
    public void getKaptcha() throws IOException {
	 	byte[] captchaChallengeAsJpeg = null;  
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();  
        try {  
        //生产验证码字符串并保存到session中
        String createText = defaultKaptcha.createText();
        request.getSession().setAttribute("vrifyCode", createText);
        //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
         BufferedImage challenge = defaultKaptcha.createImage(createText);
        ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {  
            response.sendError(HttpServletResponse.SC_NOT_FOUND);  
            return;  
        } 
  
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();  
        response.setHeader("Cache-Control", "no-store");  
        response.setHeader("Pragma", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
        ServletOutputStream responseOutputStream =  
                response.getOutputStream();  
        responseOutputStream.write(captchaChallengeAsJpeg);  
        responseOutputStream.flush();  
        responseOutputStream.close(); 
    }
    
    
    
 
}