package com.lzb.movie.test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import com.lzb.movie.entity.User;
import com.lzb.movie.service.UserService;
import com.lzb.movie.service.impl.UserServiceImpl;
import com.lzb.movie.util.MailUtil;
import com.lzb.movie.util.MapTool;
import com.lzb.movie.util.SpringContextHolder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService = new UserServiceImpl();
    @Autowired
    MailUtil mailutil;
    @Test
    public void testUser() {
    	User user = new User();
    	user.setActiveFlag(true);
    	user.setLoginFlag(true);
    	user.setEmail("1127832473@qq.com");
    	user.setUsername("tom");
    	user.setClent(true);
    	user.setPassword("123");
        
    	try {
			Map<String,Object> map =MapTool.convertBean(user);
			mailutil.sendTemplateMail( map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
//    @Test
//    public void pathTest() {
//    	String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//
//    			
//    	System.out.println(path);
//    }
}
