package com.lzb.movie.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Configuration
public class MailUtil {
	  @Autowired
	    private JavaMailSender mailSender;
	 
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
}
