package com.lzb.movie.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzb.movie.entity.Movie;
import com.lzb.movie.mapper.MovieMapper;
import com.lzb.movie.service.MovieService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bingo
 * @since 2018-10-24
 */
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

}
