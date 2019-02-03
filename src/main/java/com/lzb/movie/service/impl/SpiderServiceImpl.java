package com.lzb.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzb.movie.entity.Movie;
import com.lzb.movie.mapper.MovieMapper;
import com.lzb.movie.service.SpiderService;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;


@Service
public class SpiderServiceImpl extends ServiceImpl<MovieMapper, Movie> implements SpiderService,Pipeline{


	
//	@Autowired
//	private RedisUtil redisUtil;
	
	public static final String key = "movie";

    @Override
    public void process(ResultItems resultItems, Task task) {
        Object object =  resultItems.get("movie");
        if (object != null){
            try{
               Movie movie = (Movie)object;
               String url = movie.getPosturl();
               String suffix_url = movie.getPosturl().substring(url.length()-10, url.length());//获取url上能够唯一确定电影的数字。           
               Double score = Double.valueOf(suffix_url);
//               redisUtil.zAdd(key,movie,score);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
