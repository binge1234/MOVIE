package com.lzb.movie.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lzb.movie.entity.User;
import com.lzb.movie.service.UserService;
import com.lzb.movie.service.impl.UserServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService = new UserServiceImpl();
    
    @Test
    public void testUser() {
    	User user = new User();
    	user.setActiveFlag(0);
    	user.setLoginFlag(1);
    	user.setEmail("123@.com");
    	user.setUsername("tom");
    	userService.insert(user);
    	System.out.println("插入成功");
    }
}
