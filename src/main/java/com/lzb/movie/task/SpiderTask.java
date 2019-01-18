package com.lzb.movie.task;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lzb.movie.entity.Movie;
import com.lzb.movie.service.SpiderService;
import com.lzb.movie.spider.MovieProcessor;
import com.lzb.movie.util.RedisUtil;

import groovy.util.logging.Log4j;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;

@Log4j
@Component
public class SpiderTask {
	   @Autowired
	    private SpiderService spiderService;
	   
	   @Autowired
	   private RedisUtil redisUtil;

//	    @Scheduled(cron = "0 0 24 * * *")
//	    private void crawlTask(){//每天晚上24点开始爬取电影资源存进redis中，并且将结果发送到管理员的邮箱。
//	        Spider spider =  Spider.create(new MovieProcessor());
//	        spider.addUrl("http://www.ygdy8.com/html/gndy/dyzz/list_23_1.html")
//	                .addPipeline((Pipeline)spiderService)
//	                .thread(3)
//	                .start();
//	    }
//	    
//	    @Scheduled(cron = "0 0 3 * * *")
//	    private void asyncTask() {//采用异步的方式将电影资源存进数据库持久化，并且将结果发送到管理员邮箱
//	    	Set<Object> movies = redisUtil.zRange("movie", 0, -1);
//	    	for(Object object:movies) {
//	    		Movie movie = (Movie)object;
//	    		spiderService.insert(movie);
//	    	}
//	    }
//	    
	    
	    
	   
//	    @Scheduled(cron = "*/2 * * * * *")
//	    private void task(){
//	       System.out.println("halo");
//	    }
//	    
//	    public static void main(String[] args) {
//	        Spider spider =  Spider.create(new MovieProcessor());
//	        spider.addUrl("http://www.ygdy8.com/html/gndy/dyzz/list_23_1.html")
//	                .addPipeline(spiderService)
//	                .thread(1)
//	                .start();	    	
//	    	
//	    }

}
