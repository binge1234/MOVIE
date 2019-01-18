package com.lzb.movie.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lzb.movie.util.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
     @Autowired
     RedisUtil redisUtil;
     
     
     @Test
     public void add() {
    	 System.out.println("1111");
    	 redisUtil.set("124","hello");
    	 String s = (String)redisUtil.get("123");
    	 System.out.println(s);
     }
}
