package com.lzb.movie.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lzb.movie.service.SpiderService;
import com.lzb.movie.spider.MovieProcessor;

import groovy.util.logging.Log4j;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;

//@Log4j
//@Component
//public class SpiderTask {
//	   @Autowired
//	    private SpiderService spiderService;
//
//	    //@Scheduled(cron = "2/30 * * ? * *")
//	    private void task(){
//	        Spider spider =  Spider.create(new MovieProcessor());
//	        spider.addUrl("http://www.ygdy8.com/html/gndy/dyzz/list_23_1.html")
//	                .addPipeline((Pipeline)spiderService)
//	                .thread(1)
//	                .start();
//	    }
//	    
////	    public static void main(String[] args) {
////	        Spider spider =  Spider.create(new MovieProcessor());
////	        spider.addUrl("http://www.ygdy8.com/html/gndy/dyzz/list_23_1.html")
////	                .addPipeline(spiderService)
////	                .thread(1)
////	                .start();	    	
////	    	
////	    }
//
//}
