package com.lzb.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzb.movie.entity.Movie;
import com.lzb.movie.mapper.MovieMapper;
import com.lzb.movie.service.SpiderService;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class SpiderServiceImpl extends ServiceImpl<MovieMapper, Movie> implements SpiderService,Pipeline{
	@Autowired
	private MovieMapper movieMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Object object =  resultItems.get("movie");
        if (object != null){
            try{
                movieMapper.insert((Movie)object);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
