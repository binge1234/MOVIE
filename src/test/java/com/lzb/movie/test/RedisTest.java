package com.lzb.movie.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
     @Autowired
    RedisTemplate redisTemplate;
     
     
     @Test
     public void add() {
    	 System.out.println("1111");
    	 redisTemplate.opsForValue().set("123","hello");
    	 String s = (String)redisTemplate.opsForValue().get("123");
    	 System.out.println(s);
     }
}
