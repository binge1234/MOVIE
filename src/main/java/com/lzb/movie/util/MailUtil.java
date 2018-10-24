package com.lzb.movie.util;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lzb.movie.entity.User;

/**
 * @author 志彬
 *
 */
/**
 * @author 志彬
 *
 */

@Configuration
public class MailUtil {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	  @Autowired
	    private JavaMailSender mailSender;
     
	  @Autowired
	  private TemplateEngine templateEngine;
	 
	    @Value("${mail.fromMail.addr}")
	    private String from;
	 
	    
	    public void sendSimpleMail(String to, String subject, String content) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setFrom(from);
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(content);
	        System.out.println(from+"-----------------------");
	        try {
	            mailSender.send(message);
	            System.out.println("发送成功");
	           
	        } catch (Exception e) {
	            
	        }
	 
	    }
	    public void sendHtmlMail(String to, String subject, String content) {
	        MimeMessage message = mailSender.createMimeMessage();
	     
	        try {
	            //true表示需要创建一个multipart message
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
	            helper.setFrom(from);
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(content, true);
	     
	            mailSender.send(message);
	            logger.info("html邮件发送成功");
	        } catch (MessagingException e) {
	            logger.error("发送html邮件时发生异常！", e);
	        }
	    }
	    
         //自定义发送邮件模板
	    public void sendTemplateMail(Map params) {
	    	Context context = new Context();
	    	String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
	    	context.setVariable("username", params.get("username"));
	    	context.setVariable("createDate", params.get("createDate"));
	    	context.setVariable("id", params.get("id"));
	    	String to = (String)params.get("email");
	    	String emailContent = templateEngine.process("emailTemplate", context);
	    	sendHtmlMail(to,"欢迎注册电影天堂",emailContent);
	    	System.out.println("发送成功");
	    }
}
