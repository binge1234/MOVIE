package com.lzb.movie.spider;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;

import javax.mail.Flags.Flag;

import org.apache.log4j.helpers.FileWatchdog;
import org.springframework.stereotype.Component;

import com.lzb.movie.entity.Movie;
import com.lzb.movie.util.FileUtil;
import com.lzb.movie.util.ReUtil;
import com.lzb.movie.util.StringTool;

import ch.qos.logback.core.pattern.color.MagentaCompositeConverter;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

@Component
public class MovieProcessor implements PageProcessor {

	private Site site = Site.me().setCharset("GB2312").setRetryTimes(3).setSleepTime(100);
	private static final String URL_POST = "(http://www\\.ygdy8\\.com/html/(\\w+)/(\\w+)/(\\d+)/(\\d+)\\.html)";
    private static final String Next = "下一页";
//    private static File file = new File("H:\\movie.txt");
//    private static int Flag = 1; 
//    private FileWriter writer ;
    
	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
       List<String> topList = page.getHtml()
        .xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]")
        .links()
        .regex(URL_POST)
        .all();
       page.addTargetRequests(topList);
       
       String pageUrl = null;
       
       if(page.getHtml()
     		    .xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[7]/text()")
		        .get() != null && page.getHtml()
      		    .xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[7]/text()")
		        .get().equals(Next)) {//
       	pageUrl =  page.getHtml()
          		      .xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[7]/@href")
   		          .get();
       	 page.addTargetRequest(pageUrl);
       	
       }
       
       if(page.getHtml()
    		    .xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[9]/text()")
		        .get() != null && page.getHtml()
     		    .xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[9]/text()")
		        .get().equals(Next)) {//
      	pageUrl =  page.getHtml()
         		      .xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[9]/@href")
  		          .get();
      	 page.addTargetRequest(pageUrl);
      	
      }
       
       Selectable content = page.getHtml().xpath("//*[@id=\"Zoom\"]/span");
       
       if(page.getUrl().regex(URL_POST).match() || page.getUrl().regex(URL_POST).match()) {
           //远程页面获取的数据
    	   String[] cntAry = StringTool.clearBlank(ReUtil.get("(年　　代).*(<strong>)", StringTool.clearBlank(content.toString()),0)).split("<br>◎");
           String postUrl = page.getUrl().toString().replace("http://www.ygdy8.com/html/","");  
    	   String ChineseTitle = "";
    	   String EnglishTitle = "";
           String time = "";
           String place = "";
           String category = "";
           String director = "";
           String star = "";
           String description = "";

           for (int i=0; i<cntAry.length; i++){
        	   
               if (cntAry[i].indexOf("译　　名") == 0){
                   EnglishTitle = StringTool.clearBlank(cntAry[i].replace("译　　名",""));
               }
               
               if (cntAry[i].indexOf("片　　名") == 0){
                   ChineseTitle = StringTool.clearBlank(cntAry[i].replace("片　　名",""));
               }
        	   
               if (cntAry[i].indexOf("年　　代") == 0){
                   time = StringTool.clearBlank(cntAry[i].replace("年　　代",""));
               }
               if (cntAry[i].indexOf("产　　地") == 0){
                   place = StringTool.clearBlank(cntAry[i].replace("产　　地",""));
               }
               if (cntAry[i].indexOf("类　　别") == 0){
                   category = StringTool.clearBlank(cntAry[i].replace("类　　别",""));
               }
               if (cntAry[i].indexOf("导　　演") == 0){
                   director = StringTool.clearBlank(cntAry[i].replace("导　　演",""));
               }
               if (cntAry[i].indexOf("主　　演") == 0){
                   star = StringTool.clearBlank(cntAry[i].replace("主　　演",""));
               }
               if (cntAry[i].indexOf("简　　介") == 0){
                   description = StringTool.clearBlank(cntAry[i].replace("简　　介","").replace("<strong>", ""));
               }
           }
                                      ////*[@id="header"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/ul/table[2]/tbody/tr[2]/td[2]/b/a
           //String title = StringTool.clearBlank(page.getHtml().xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[1]/h1/font/text()").toString());
           
           //图片地址和下载地址单独算出
           String topImgUrl = StringTool.clearBlank(content.css("img", "src").toString());
           String downPath = StringTool.clearBlank(content.css("a","href").toString());
           
           Movie movie = new Movie();//将电影数据存入数据库中
           movie.setImgUrl(topImgUrl);
           movie.setDownpath(downPath);
           movie.setChinesetitle(ChineseTitle);
           movie.setEnglishtitle(EnglishTitle);
           movie.setPlace(place);
           movie.setTime(time);
           movie.setCategory(category);
           movie.setDirector(director);
           movie.setStar(star);
           movie.setDescription(description);
           movie.setPostUrl(postUrl);
           
           if (StringTool.isBlank(downPath)){
               page.setSkip(true);
           }else {
               page.putField("movie", movie);
           }
           
       }
	}
	
//    public static void main(String[] args) {
//        long startTime, endTime;
//        System.out.println("开始爬取...");
//        startTime = System.currentTimeMillis();//https://www.cnblogs.com/
//        Spider.create(new MovieProcessor()).addUrl("http://www.ygdy8.com/html/gndy/dyzz/list_23_1.html").thread(3).run();
//        endTime = System.currentTimeMillis();
//        
//    }

}
