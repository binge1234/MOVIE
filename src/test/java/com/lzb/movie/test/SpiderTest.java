package com.lzb.movie.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lzb.movie.service.SpiderService;
import com.lzb.movie.spider.MovieProcessor;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiderTest {
      
	@Autowired
	SpiderService spiderService;
	
	
	
	@Test
	public void test() {
        Spider spider =  Spider.create(new MovieProcessor());
        spider.addUrl("http://www.ygdy8.com/html/gndy/dyzz/list_23_1.html")
                .addPipeline((Pipeline)spiderService)
                .thread(1)
                .start();
	}
}
