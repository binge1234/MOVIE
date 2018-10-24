package com.lzb.movie.common.constant;

public class SpiderDict {
	
      public static final String New_URL = "http://www.ygdy8.com/html/gndy/dyzz/list_23_1.html";
      
      public static final String NewUrl_REGIX = "(http://www\\.ygdy8\\.com/html/(\\w+)/(\\w+)/(\\d+)/(\\d+)\\.html)";
      
      public static final String NewList_REGIX = "//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]";
      
      public static final String NextText1_REGIX = "//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[7]/text()";
      
      public static final String NextUrl1_REGIX = "//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[7]/@href";
      
      public static final String NextText2_REGIX = "//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[9]/text()";
      
      public static final String NextUrl2_REGIX = "//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[9]/@href";
      
      public static final String MovieContent_REGIX = "//*[@id=\"Zoom\"]/span";
      
      
}
