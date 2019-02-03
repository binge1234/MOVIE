package com.lzb.movie.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.lzb.movie.util.MailUtil;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
    @Autowired
    private MailUtil mailUtil;
 
    @Test
    public void testSimpleMail() throws Exception {
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", 123);
            map.put("name","lizhibin"+i);

            mailUtil.sendSimpleMail("1127832473@qq.com", "test simple mail", " hello this is simple mail");
        }
    }
}
